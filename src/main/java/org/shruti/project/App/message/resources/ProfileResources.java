package org.shruti.project.App.message.resources;

import org.shruti.project.App.messenger.model.Profile;
import org.shruti.project.App.service.ProfileServices;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResources {

    private ProfileServices profileServices = new ProfileServices();

    @GET
    public List<Profile> getProfiles(){
       return profileServices.getAllProfile();
    }

   @POST
    public Profile addProfiles(Profile profile){
        return profileServices.addProfile(profile);
   }

   @GET
    @Path("/{profileName}")
    public Profile getProfile(@PathParam("profileName") String profileName){
        return profileServices.getProfile(profileName);
   }

   @PUT
    @Path("/{profileName}")
    public Profile updateProfile(@PathParam("profileName") String profileName,Profile profile){
          profile.setProfileName(profileName);
          return profileServices.updateProfile(profile);
   }

   @DELETE
    @Path("/{profileName}")
    public void deleteProfile(@PathParam("profileName") String profileName){
        profileServices.removeProfile(profileName);
   }
}
