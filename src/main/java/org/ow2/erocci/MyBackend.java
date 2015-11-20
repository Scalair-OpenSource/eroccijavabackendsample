package org.ow2.erocci;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.freedesktop.DBus;
import org.freedesktop.dbus.UInt32;
import org.freedesktop.dbus.Variant;
import org.ow2.erocci.backend.Pair;
import org.ow2.erocci.backend.Quad;
import org.ow2.erocci.backend.Struct1;
import org.ow2.erocci.backend.Struct2;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by petitpre on 23/10/15.
 */
public class MyBackend implements org.ow2.erocci.backend.core, DBus.Properties {

    private static final Logger LOG = Logger.getLogger(MyBackend.class.getName());


    public void Init(Map<String, Variant> opts) {
        LOG.info("Init opts:" + opts);
    }

    public void Terminate() {
        LOG.info("terminate");
    }


    public String SaveResource(String id, String kind, List<String> mixins, Map<String, Variant> attributes, String owner) {
        LOG.info("SaveResource id:" + id + " kind:" + kind + " mixins:" + mixins + " attributes:" + attributes + " owner:" + owner);
        return null;
    }

    public String SaveLink(String id, String kind, List<String> mixins, String src, String target, Map<String, Variant> attributes, String owner) {
        LOG.info("SaveLink " + " id:" + id + " kind:" + kind + " mixins:" + mixins + " src:" + src + " target:" + target + " attributes:" + attributes + " owner:" + owner);
        return null;
    }

    public Map<String, Variant> Update(String id, Map<String, Variant> attributes) {
        LOG.info("Update " + " id:" + id + " attributes:" + attributes);
        return null;
    }

    public void SaveMixin(String id, List<String> entities) {
        LOG.info("SaveMixin " + " id:" + id + " entities:" + entities);
    }

    public void UpdateMixin(String id, List<String> entities) {
        LOG.info("UpdateMixin " + " id:" + id + " entities:" + entities);
    }

    public List<Struct1> Find(String id) {
        LOG.info("Find " + " id:" + id);
        return null;
    }

    public Quad<String, String, List<String>, Map<String, Variant>> Load(Variant opaque_id) {
        LOG.info("Load " + " opaque_id:" + opaque_id);
        return null;
    }

    public Pair<Variant, UInt32> List(String id, Map<String, Variant> filters) {
        LOG.info("List" + " id:" + id + " filters:" + filters);
        return null;
    }

    public List<Struct2> Next(Variant opaque_id, UInt32 start, UInt32 items) {
        LOG.info("Next" + " opaque_id:" + opaque_id + " start:" + start + " items:" + items);
        return null;
    }

    public void Delete(String id) {
        LOG.info("Delete" + " id:" + id);

    }

    public boolean isRemote() {
        LOG.info("isRemote");
        return false;
    }

    @Override
    public <A> A Get(String interface_name, String property_name) {
        try {
            LOG.info("Get " + interface_name + " " + property_name);
            if ("schema".equals(property_name)) {
                final String s = Resources.toString(Resources.getResource("occi_core.xml"), Charsets.UTF_8);
                return (A) s;
            }
            return null;
        } catch (IOException ex) {
            LOG.log(Level.WARNING, ex.getMessage(), ex);
            throw new RuntimeException(ex);
        }
    }

    @Override
    public <A> void Set(String interface_name, String property_name, A value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Map<String, Variant> GetAll(String interface_name) {
        return new HashMap<String, Variant>();
    }
}
