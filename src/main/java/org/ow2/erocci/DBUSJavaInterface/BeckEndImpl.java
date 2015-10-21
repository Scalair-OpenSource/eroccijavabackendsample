package org.ow2.erocci.DBUSJavaInterface;

import java.util.Map;

import org.freedesktop.dbus.UInt32;
import org.freedesktop.dbus.Variant;

public class BeckEndImpl implements backend{

	public boolean isRemote() {
		// TODO Auto-generated method stub
		return true;
	}

	public Quad<String, String, java.util.List<String>, Map<String, Variant>> Load(Variant id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String SaveResource(String id, String kind, java.util.List<String> mixins, Map<String, Variant> attributes,
			String owner) {
		// TODO Auto-generated method stub
		return null;
	}

	public Variant List(String id, Map<String, Variant> _filters) {
		// TODO Auto-generated method stub
		return null;
	}

	public void Terminate() {
		// TODO Auto-generated method stub
		
	}

	public Map<String, Variant> Update(String id, Map<String, Variant> attributes) {
		// TODO Auto-generated method stub
		return null;
	}

	public java.util.List<Struct1> Next(Variant iter, UInt32 start, UInt32 items) {
		// TODO Auto-generated method stub
		return null;
	}

	public void Init(Map<String, Variant> opts) {
		// TODO Auto-generated method stub
		
	}

	public String SaveLink(String id, String kind, java.util.List<String> mixins, String src, String target,
			Map<String, Variant> attributes, String owner) {
		// TODO Auto-generated method stub
		return null;
	}

	public void SaveMixin(String id, java.util.List<String> entities) {
		// TODO Auto-generated method stub
		
	}

	public void UpdateMixin(String id, java.util.List<String> entities) {
		// TODO Auto-generated method stub
		
	}

	public java.util.List<Struct2> Find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void Delete(String id) {
		// TODO Auto-generated method stub
		
	}

}
