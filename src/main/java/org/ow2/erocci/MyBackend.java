package org.ow2.erocci;

import org.freedesktop.dbus.UInt32;
import org.freedesktop.dbus.Variant;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by petitpre on 23/10/15.
 */
public class MyBackend implements org.ow2.erocci.backend {

    private static final Logger LOG = Logger.getLogger(MyBackend.class.getName());

    public void Init(Map<String, Variant> opts) {
        LOG.fine("Init opts:" + opts);
    }

    public void Terminate() {
        LOG.fine("Terminate");
    }

    public String SaveResource(String id, String kind, List<String> mixins, Map<String, Variant> attributes, String owner) {
        LOG.fine("SaveResource id:" + id + " kind:" + kind + " mixins:" + mixins + " attributes:" + attributes + " owner:" + owner);
        return null;
    }

    public String SaveLink(String id, String kind, List<String> mixins, String src, String target, Map<String, Variant> attributes, String owner) {
        LOG.fine("SaveLink " + " id:" + id + " kind:" + kind + " mixins:" + mixins + " src:" + src + " target:" + target + " attributes:" + attributes + " owner:" + owner);
        return null;
    }

    public Map<String, Variant> Update(String id, Map<String, Variant> attributes) {
        LOG.fine("Update " + " id:" + id + " attributes:" + attributes);
        return null;
    }

    public void SaveMixin(String id, List<String> entities) {
        LOG.fine("SaveMixin " + " id:" + id + " entities:" + entities);
    }

    public void UpdateMixin(String id, List<String> entities) {
        LOG.fine("UpdateMixin " + " id:" + id + " entities:" + entities);
    }

    public List<Struct1> Find(String id) {
        LOG.fine("Find " + " id:" + id);
        return null;
    }

    public Quad<String, String, List<String>, Map<String, Variant>> Load(Variant opaque_id) {
        LOG.fine("Load " + " opaque_id:" + opaque_id);
        return null;
    }

    public Pair<Variant, UInt32> List(String id, Map<String, Variant> filters) {
        LOG.fine("List" + " id:" + id + " filters:" + filters);
        return null;
    }

    public List<Struct2> Next(Variant opaque_id, UInt32 start, UInt32 items) {
        LOG.fine("Next" + " opaque_id:" + opaque_id + " start:" + start + " items:" + items);
        return null;
    }

    public void Delete(String id) {
        LOG.fine("Delete" + " id:" + id);

    }

    public boolean isRemote() {
        LOG.fine("isRemote");
        return false;
    }
}
