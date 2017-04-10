/*
 * TODO: Change me
 */
package services;

import entities.InjuryEnum;
import java.io.InputStream;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Andrew
 * When run locally to test installation, if configured properly, should be accessible through
 * http://localhost:8080/MSAppAPI/API/HelloWorld
 */
@Path("/HelloWorld")
public class HelloWorldService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelloWorldService
     */
    public HelloWorldService() {
    }

    /**
     * Retrieves representation of an instance of services.HelloWorldService
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {
        //TODO return proper representation object
        return "Hello world.";
    }

    
    @Path("/Post")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String test(InputStream data, @QueryParam("mode") String mode){
        InjuryEnum injEnum;
        injEnum = InjuryEnum.valueOf(mode.toUpperCase());
        Boolean bool;
        
        if(injEnum.equals(InjuryEnum.HEAD)){
            bool = true;
        }
        else{
            bool = false;
        }
        return "Hello world " + bool;
    }
}
