package org.ow2.erocci;

import org.apache.commons.io.IOUtils;
import org.freedesktop.DBus;
import org.freedesktop.dbus.UInt32;
import org.freedesktop.dbus.Variant;
import org.ow2.erocci.backend.Pair;
import org.ow2.erocci.backend.Quad;
import org.ow2.erocci.backend.Struct1;
import org.ow2.erocci.backend.Struct2;
import org.ow2.erocci.model.Entity;
import org.ow2.erocci.model.OcciConstants;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by petitpre on 23/10/15.
 */
public class MyBackend implements org.ow2.erocci.backend.core, DBus.Properties {

    private static final Logger LOG = Logger.getLogger(MyBackend.class.getName());


    public static byte NODE_ENTITY = 0;
    private Logger logger = Logger.getLogger(this.getClass().getName());

    private Map<String, Entity> entities = new HashMap<String, Entity>();

    @Override
    public <A> A Get(String interfaceName, String property) {
        if ("schema".equalsIgnoreCase(property)) {
            try (InputStream in = getClass().getClassLoader().getResourceAsStream("schema.xml")) {
                return (A) IOUtils.toString(in);
            } catch (IOException e) {
                LOG.log(Level.WARNING, e.getMessage(), e);
                return null;
            }
        }
        return null;
    }

    @Override
    public Map<String, Variant> GetAll(String interface_name) {
        logger.info("GetAll invoked");
        return new HashMap<String, Variant>();
    }

    @Override
    public <A> void Set(String arg0, String arg1, A arg2) {
        logger.info("Set invoked");
    }

    @Override
    public boolean isRemote() {
        logger.info("isRemote invoked");
        return false;
    }

    @Override
    public void Init(Map<String, Variant> opts) {
        logger.info("Init invoked");
    }

    @Override
    public void Terminate() {
        logger.info("Terminate invoked");
    }

    /**
     * Record version 1 of a resource (overwrite mode: use Update instead).
     * If resources already exist with the same id, they will be lost.
     *
     * @param id
     * @param kind
     * @param mixins
     * @param attributes
     * @param owner
     * @return
     */
    @Override
    public String SaveResource(String id, String kind,
                               java.util.List<String> mixins, Map<String, Variant> attributes,
                               String owner) {
        logger.info("SaveResource invoked");

        // 1st version of a resource, with serial no = 1
        entities.put(id, new Entity(id, OcciConstants.TYPE_RESOURCE,
                kind, mixins, Utils.convertVariantMap(attributes), owner, 1));
        return id;
    }

    /**
     * Record version 1 of a link (overwrite mode: use Update instead).
     * If links already exist with the same id, they will be lost.
     *
     * @param id
     * @param kind
     * @param mixins
     * @param src
     * @param target
     * @param attributes
     * @param owner
     * @return
     */
    @Override
    public String SaveLink(String id, String kind,
                           java.util.List<String> mixins, String src, String target,
                           Map<String, Variant> attributes, String owner) {
        logger.info("SaveLink invoked");

        // 1st version of a link, with serial no = 1
        Entity link = new Entity(id, OcciConstants.TYPE_LINK,
                kind, mixins, Utils.convertVariantMap(attributes), owner, 1);
        Entity source = entities.get(src);
        link.setSource(source);
        link.setTarget(entities.get(target));

        source.getLinks().add(link);
        entities.put(id, link);

        return id;
    }

    /**
     * Update an entity
     *
     * @param id
     * @param attributes
     */
    @Override
    public Map<String, Variant> Update(String id,
                                       Map<String, Variant> attributes) {
        logger.info("Update invoked");
        return null;
    }

    @Override
    public void SaveMixin(String id, java.util.List<String> entities) {
        logger.info("SaveMixin invoked");
        for (String entityId : entities) {
            Entity entity = this.entities.get(entityId);
            if (!entity.getMixins().contains(id)) entity.getMixins().add(id);
            entity.incrementSerial();
        }
    }

    @Override
    public void UpdateMixin(String id, java.util.List<String> entities) {
        logger.info("UpdateMixin invoked");
        // TODO Why should it be different from SaveMixin ??
        SaveMixin(id, entities);
    }

    @Override
    //TODO unclear why this one returns a list of Struct...
    public java.util.List<Struct1> Find(String id) {
        logger.info("Find invoked with id=" + id);

        List<Struct1> ret = new LinkedList<Struct1>();
        Entity entity = entities.get(id);
        if (entity != null) {
            ret.add(new Struct1(NODE_ENTITY,
                    new Variant<String>(id), entity.getOwner(), new UInt32(entity.getSerial())));
        }
        return ret;
    }

    @Override
    public Quad<String, String, java.util.List<String>, Map<String, Variant>> Load(
            Variant opaque_id) {
        logger.info("Load invoked with opaque_id=" + opaque_id);
        // TODO What is opaque_id ??
        Entity entity = entities.get(opaque_id);
        return new Quad(entity.getId(),
                entity.getKind(), entity.getMixins(), entity.getAttributes());
    }

    /**
     * Get an iterator for a collection: then use Next() to iterate (the List call
     * initiates an iterator for subsequent Next() calls).
     * @param id
     * @param filters
     * @return Pair, where Variant<String> is the iterator ID for Next() method, and
     * UInt32 the iterator's serial num (eg. for caching).
     */
    @Override
    public Pair<Variant, UInt32> List(String id, Map<String, Variant> filters) {
        logger.info("List invoked with id=" + id);
        String collectionName = "collection" + Utils.getUniqueInt();

        return new Pair<Variant, UInt32>(
                new Variant<String>(collectionName),
                new UInt32(Utils.getUniqueInt()));
    }

    @Override
    public java.util.List<Struct2> Next(Variant opaque_id, UInt32 start,
                                        UInt32 items) {
        logger.info("Next invoked with opaque_id=" + opaque_id + ", start=" + start + ", items=" + items);
        // TODO Auto-generated method stub
        return new LinkedList<Struct2>();
    }

    @Override
    public void Delete(String id) {
        logger.info("Delete invoked");

        Entity removed = entities.remove(id);
        // Remove all links that point to removed entity
        for (Entity e : removed.getLinkedFrom()) {
            Delete(e.getId()); // Warning recursive call
        }
    }
}