package org.ow2.erocci.DBUSJavaInterface;
import java.util.List;
import java.util.Map;
import org.freedesktop.dbus.DBusInterface;
import org.freedesktop.dbus.UInt32;
import org.freedesktop.dbus.Variant;
public interface backend extends DBusInterface
{

  public Quad<String, String, List<String>, Map<String,Variant>> Load(Variant id);
  public String SaveResource(String id, String kind, List<String> mixins, Map<String,Variant> attributes, String owner);
  public Variant List(String id, Map<String,Variant> _filters);
  public void Terminate();
  public Map<String,Variant> Update(String id, Map<String,Variant> attributes);
  public List<Struct1> Next(Variant iter, UInt32 start, UInt32 items);
  public void Init(Map<String,Variant> opts);
  public String SaveLink(String id, String kind, List<String> mixins, String src, String target, Map<String,Variant> attributes, String owner);
  public void SaveMixin(String id, List<String> entities);
  public void UpdateMixin(String id, List<String> entities);
  public List<Struct2> Find(String id);
  public void Delete(String id);

}