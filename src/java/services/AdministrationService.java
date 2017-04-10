/*
 * TODO: Change me
 */
package services;

import controllers.DatabaseController;
import controllers.ProgrammeController;
import entities.Programme;
import java.io.InputStream;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonException;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utilities.SQLQuery;

/**
 *
 * @author Andrew
 */
@Path("/Admin")
public class AdministrationService {
    ProgrammeController pc = new ProgrammeController();
    
    /**
     * A simple method for testing if our service is online.
     * -> GET /API/Admin/Health
     * If true is returned, we will have configured our service properly.
     * @return 
     */
    @GET
    @Path("/Health")
    public Boolean getHealthy(){
        return true;
    }
    
    
    /**
     * Create user.
     */
    
    /**
     * Create programmes.
     */
    @POST
    @Path("/Programme/Create/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertProgrammes(InputStream data){
        Programme programme = new Programme();
        
        try{
        JsonObject obj = Json.createObjectBuilder().build();
        JsonReader reader = Json.createReader(data);
        obj = reader.readObject();
        reader.close();
        
        programme.setProgrammeID(Integer.valueOf(obj.get("Programme_ID").toString()));
        programme.setName(obj.get("Name").toString());
        programme.setWeeks(Integer.valueOf(obj.get("Weeks").toString()));
        programme.setCapacity(Integer.valueOf(obj.get("Capacity").toString()));
        programme.setManager (Integer.valueOf(obj.get("Manager_ID").toString()));

        pc.CreateProgramme(programme);
          
        }catch(JsonException e){
            e.printStackTrace();
        }        
       
    }
    
    /**
     * Assign users to programmes
     */
    
    
    /**
     * @param managerID
     * @return 
     * View Programmes
     */
    @GET
    @Path("/Programmes")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllProgrammes(String managerID)
    {
        ProgrammeController pc = new ProgrammeController();
        JsonArray programmes = pc.ViewAllProgrammes(managerID);
        
        return programmes.toString();
    }
    /**
     * View a report
     */
    
    
    /**
     * Administrative functionality is as follows:
     *  *   CRUD functionality for users.
     *  *   TODO: Think of more.
     */
}
