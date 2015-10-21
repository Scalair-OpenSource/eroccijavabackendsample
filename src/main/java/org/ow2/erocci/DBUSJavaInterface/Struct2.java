package org.ow2.erocci.DBUSJavaInterface;
import org.freedesktop.dbus.Position;
import org.freedesktop.dbus.Struct;
import org.freedesktop.dbus.Variant;
public final class Struct2 extends Struct
{
   @Position(0)
   public final Variant a;
   @Position(1)
   public final String b;
   @Position(2)
   public final String c;
  public Struct2(Variant a, String b, String c)
  {
   this.a = a;
   this.b = b;
   this.c = c;
  }
}