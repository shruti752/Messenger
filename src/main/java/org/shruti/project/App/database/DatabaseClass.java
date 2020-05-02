package org.shruti.project.App.database;

import org.shruti.project.App.messenger.model.Message;
import org.shruti.project.App.messenger.model.Profile;

import java.util.HashMap;
import java.util.Map;

public class DatabaseClass {
    private static Map<Long, Message> message = new HashMap<>();
    private static Map<String, Profile> profile = new HashMap<>();

    public static Map<Long,Message> getMessage(){
        return message;
    }
    public static Map<String,Profile> getProfile(){
        return  profile;
    }
}
