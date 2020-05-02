package org.shruti.project.App.message.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InjectDemoResource {
    @GET
    @Path("annotations")
    public String getPramsUsingAnnotations(@MatrixParam("param") String matrixParam,
                                           @HeaderParam("autoSessionId") String header,
                                           @CookieParam("name") String cookie)
    {
        return "matrix param : " + matrixParam + " Header param :" + header;
    }

    public String getPramsUsingContext(@Context UriInfo uriInfo,
                                       @Context HttpHeaders headers)
    {
        String path = uriInfo.getAbsolutePath().toString();
        String cookies  = headers.getCookies().toString();
        return "path :" + path + "cookies :" + cookies;
    }


}
