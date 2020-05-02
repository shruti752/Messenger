package org.shruti.project.App.service;

import org.shruti.project.App.database.DatabaseClass;
import org.shruti.project.App.messenger.model.Message;
import org.shruti.project.App.messenger.model.Profile;

import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProfileServices {
    private Map<String, Profile> profiles = DatabaseClass.getProfile();

    public ProfileServices(){
        profiles.put("shruti",new Profile(1L,"shruti","shruti","shikha"));
    }
    public List<Profile> getAllProfile(){
        return new ArrayList<>(profiles.values());
    }
    public Profile getProfile(String profileName){
        return profiles.get(profileName);
    }

    public Profile addProfile(Profile profile){
        profile.setId(profiles.size() + 1);
        profiles.put(profile.getProfileName() ,profile);
        return profile;
    }

    public Profile updateProfile(Profile profile){
       if(profile.getId() <= 0){
           return null;
       }
       profiles.put(profile.getProfileName(),profile);
       return profile;
    }
    public Profile removeProfile(String profileName){
        return profiles.remove(profileName);
    }


}
