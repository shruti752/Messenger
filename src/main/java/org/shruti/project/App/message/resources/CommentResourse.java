package org.shruti.project.App.message.resources;

import org.shruti.project.App.messenger.model.Comment;
import org.shruti.project.App.service.CommentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResourse {
    private CommentService commentService  = new CommentService();
    @GET
    public String Test(){
        return "new sub resourses";
    }

    @GET
    @Path("/{commentId}")
    public String test2(@PathParam("messageId") long messageID ,@PathParam("commentId") long commentID){
        return "Method to return commrnt ID" + commentID + " method to return message ID" + messageID;
    }

    @GET
     public List<Comment> getAllComments(@PathParam("messageId") long  messageId){
        return commentService.getAllComments(messageId);
    }

    @POST
    public Comment addComments(@PathParam("messageId") long  messageId , Comment comment){
         return commentService.addComment(messageId,comment);
    }
    @PUT
    @Path("/{commentId}")
    public Comment updateComments(@PathParam("messageId") long  messageId,@PathParam("commentId") long id , Comment comment){
        comment.setId(id);
        return commentService.updateComment(messageId,comment);
    }

    @DELETE
    @Path("/{commentId}")
    public void deleteComments(@PathParam("messageId") long  messageId,@PathParam("commentId") long commentId ){
        commentService.removeComment(messageId,commentId);
    }

    @GET
    @Path("/{commentId}")
    public Comment getMessage(@PathParam("messageId") long  messageId,@PathParam("commentId") long commentId){
        return commentService.getComment(messageId,commentId);
    }


}
