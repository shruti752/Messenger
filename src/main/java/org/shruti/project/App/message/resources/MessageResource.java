package org.shruti.project.App.message.resources;

import org.shruti.project.App.messenger.model.Message;
import org.shruti.project.App.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path("/messages")
public class MessageResource {
    MessageService messageService = new MessageService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessages(@BeanParam MessageFilterBean filterBean)
    {
        if(filterBean.getYear() >0){
            return messageService.getAllMessageForYear(filterBean.getYear());
        }
        if(filterBean.getStart() >0 && filterBean.getSize() > 0 ){
            return messageService.getAllMeassgesForPaginated(filterBean.getStart(),filterBean.getSize());
        }
        return  messageService.getAllMessages();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Message addMessage(Message message){
        return messageService.addMessage(message);
    }

    @PUT
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Message updateMessage(@PathParam("messageId") long id,Message message){
       return messageService.updateMessage(message);
    }

    @DELETE
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteMessage(@PathParam("messageId") long id){
        messageService.removeMessage(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON )
    @Path("/{messageId}")
   /* public String test(@PathParam ("messageId") String messageId){
        return "Got path param " + messageId;
    }*/
   public Message getMessage(@PathParam("messageId") long id , @Context UriInfo uriInfo){
        Message message = messageService.getMessage(id);
        message.addLink(getUriForSelf(uriInfo, message),"self");
        message.addLink(getUriForPeofile(uriInfo, message),"self");
        return message;

    }

    private String getUriForPeofile(UriInfo uriInfo, Message message) {
        URI uri =  uriInfo.getBaseUriBuilder()
                .path(ProfileResources.class)
                .path(message.getAuthor())
                .build();
                return uri.toString();

    }

    private String getUriForSelf(@Context UriInfo uriInfo, Message message) {
        String  uri =  uriInfo.getBaseUriBuilder()
                    .path(MessageResource.class)
                    .path(Long.toString(message.getId()))
                    .build()
                    .toString();
        return uri;
    }

    @Path("/{messages}/comments")
    public CommentResourse getCommentResource(){
       return new CommentResourse();
    }
}
