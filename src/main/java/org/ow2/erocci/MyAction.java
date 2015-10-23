package org.ow2.erocci;

import org.freedesktop.dbus.Variant;

import java.util.Map;

/**
 * Created by petitpre on 23/10/15.
 */
public class MyAction implements org.ow2.erocci.action {

    public boolean isRemote() {
        return false;
    }


    public void Action(String id, String action_id, Map<String, Variant> attributes) {
        System.out.println("action " + id + " " + action_id);
    }
}
