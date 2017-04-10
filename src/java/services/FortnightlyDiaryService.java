/*
 * TODO: Change me
 */
package services;

import entities.InjuryEnum;
import java.io.InputStream;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Andrew
 * TODO:? Could potentially want to break this up in to different services if the whole
 * class gets too messy as is.
 */
@Path("/Fortnight")
public class FortnightlyDiaryService {
    
    
    //<editor-fold desc="Injury functionality.">
    /**
     * Method to allow a user to alter their injuries for a given fortnight.
     * POST, /Fortnight/Injuries?bodypart=[bodypart]
     * 
     * Expected JSON input:
     * {
     *      "AuthToken":"authtoken",
     *      "DiaryID":"diaryID",
     *      "Injuries":[
     *                      {"Type":"Bruise",       "Incidents":"incidents"},
     *                      {"Type":"Cut",          "Incidents":"incidents"},
     *                      {"Type":"Sprain",       "Incidents":"incidents"},
     *                      {"Type":"Dislocation",  "Incidents":"incidents"},
     *                      {"Type":"BrokenBone",   "Incidents":"incidents"}
     *                  ]
     * }
     * @param data
     * @param bodyPart
     * @return 
     */
    @Path("/Injuries")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response setInjuries(InputStream data, @QueryParam("bodypart") String bodyPart){
        Boolean badInput = false;
        //Extract bodyPart and convert to injury enum.
        InjuryEnum injEnum;
        try{            
            injEnum = InjuryEnum.valueOf(bodyPart.toUpperCase());
        }
        catch (Exception ex){
            return Response.status(400).entity("Bad request: Validate that bodyPart matches head, arm, leg or body.").build();
        }
        
        //Validate AuthToken
        
        //If bad token deny request.
        
        //If good, extract ID, grant user fresh token and proceed.
        
        //Check if Injury set exists for diary ID
        
        //If so, alter based on user's provided data
        
        //If not, insert based on user's provided data
        
        //If successful, inform user of success
        
        //If unsuccessful, inform user of failure.
        
        return Response.status(400).entity("Method not yet implemented.").build();
    }
    
    /**
     * Method to allow a user to view their injury data for a given fortnight.
     * POST, /Fortnight/InjuryData?bodypart=[bodypart]
     * 
     * Expected JSON input:
     * {
     *      "AuthToken":"authtoken",
     *      "DiaryID":"diaryID"
     * }
     * 
     * @param data
     * @return 
     */
    @Path("/InjuryData")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInjuries(InputStream data, @QueryParam("bodypart") String bodyPart){
        Boolean badInput = false;
        //Extract bodyPart and convert to injury enum.
        InjuryEnum injEnum = null;
        try{            
            injEnum = InjuryEnum.valueOf(bodyPart.toUpperCase());
        }
        catch (Exception ex){
            return Response.status(400).entity("Bad request: Validate that bodyPart matches head, arm, leg or body.").build();
        }
        
        return Response.status(400).entity("Method not yet implemented.").build();
    }
    
    //</editor-fold>
    
    //<editor-fold desc="Med Service functionality">
    /**
     * Method to allow a user to alter their Med Service incidents for a given fortnight.
     * POST, /Fortnight/MedService
     * 
     * Expected JSON input:
     * {
     *      "AuthToken":"authtoken",
     *      "DiaryID":"diaryID",
     *      "Nurse":"nursevisits",
     *      "GP":"GPvisits",
     *      "Specialist":   [
     *                          {"SpecialistType":"Type", "Visits":"visits"},
     *                          {"SpecialistType":"Type", "Visits":"visits"}
     *                      ]
     *      "AandE":"AandEvisits",
     *      "Hospital":"hospitalvisits",
     *      "HospitalStays":[ "staylength", "staylength"...]
     *      "Other":    [
     *                          {"Who":"who", "Visits":"visits"},
     *                          {"Who":"who", "Visits":"visits"}
     *                  ]
     * }
     *      
     * @param data
     * @return 
     */
    @Path("/MedService")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response setMedService(InputStream data){
        return Response.status(400).entity("Not yet implemented.").build();
    }
    
    /**
     * Method to allow a user to view their Med Service data for a given fortnight.
     * POST, /Fortnight/MedServiceData
     * 
     * Expected JSON input:
     * {
     *      "AuthToken":"authtoken",
     *      "DiaryID":"diaryID"
     * }
     * 
     * @param data
     * @return 
     */
    @Path("/MedServiceData")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMedService(InputStream data){
        return Response.status(400).entity("Not yet implemented.").build();
    }
    //</editor-fold>
    
    //<editor-fold desc="Grounded functionality">
    /**
     * Method to allow a user to alter their Grounded incidents for a given fortnight.
     * POST, /Fortnight/Grounded
     * 
     * Expected JSON input:
     * {
     *      "AuthToken":"authtoken",
     *      "DiaryID":"diaryID",
     *      "TenThirty":"tenthirty",
     *      "ThirtySixty":"thirtysixty",
     *      "SixtyPlus":"sixtyplus"
     * }
     *      
     * @param data
     * @return 
     */
    @Path("/Grounded")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response setGrounded(InputStream data){
        return Response.status(400).entity("Not yet implemented.").build();
    }
    
    /**
     * Method to allow a user to view their Grounded data for a given fortnight.
     * POST, /Fortnight/GroundedData
     * 
     * Expected JSON input:
     * {
     *      "AuthToken":"authtoken",
     *      "DiaryID":"diaryID"
     * }
     * 
     * @param data
     * @return 
     */
    @Path("/GroundedData")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGrounded(InputStream data){
        return Response.status(400).entity("Not yet implemented.").build();
    }
    //</editor-fold>
    
    //<editor-fold desc="Assistance required functionality">
    /**
     * Method to allow a user to alter their Assistance required incidents for a given fortnight.
     * POST, /Fortnight/Assistance
     * 
     * Expected JSON input:
     * {
     *      "AuthToken":"authtoken",
     *      "DiaryID":"diaryID",
     *      "Family":"family",
     *      "Friend":"friend",
     *      "HealthcarePro":"healthcarepro"
     * }
     *      
     * @param data
     * @return 
     */
    @Path("/Assistance")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response setAssistance(InputStream data){
        return Response.status(400).entity("Not yet implemented.").build();
    }
    
    /**
     * Method to allow a user to view their Assistance required data for a given fortnight.
     * POST, /Fortnight/AssistanceData
     * 
     * Expected JSON input:
     * {
     *      "AuthToken":"authtoken",
     *      "DiaryID":"diaryID"
     * }
     * 
     * @param data
     * @return 
     */
    @Path("/AssistanceData")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAssistance(InputStream data){
        return Response.status(400).entity("Not yet implemented.").build();
    }
    //</editor-fold>
    
    //<editor-fold desc="Degradation functionality">
    /**
     * Method to allow a user to alter their Degradation incidents for a given fortnight.
     * POST, /Fortnight/Degradation
     * 
     * Expected JSON input:
     * {
     *      "AuthToken":"authtoken",
     *      "DiaryID":"diaryID",
     *      "Incidents":    [
     *                          {"Problem":"problem", "Severity":"severity", "Duration":"duration"},
     *                          {"Problem":"problem", "Severity":"severity", "Duration":"duration"},
     *                          {"Problem":"problem", "Severity":"severity", "Duration":"duration"}
     *                      ]
     * }
     *      
     * @param data
     * @return 
     */
    @Path("/Degradation")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response setDegradation(InputStream data){
        return Response.status(400).entity("Not yet implemented.").build();
    }
    
    /**
     * Method to allow a user to view their Degradation data for a given fortnight.
     * POST, /Fortnight/DegradationData
     * 
     * Expected JSON input:
     * {
     *      "AuthToken":"authtoken",
     *      "DiaryID":"diaryID"
     * }
     * 
     * @param data
     * @return 
     */
    @Path("/DegradationData")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDegradation(InputStream data){
        return Response.status(400).entity("Not yet implemented.").build();
    }
    //</editor-fold>
    
    //<editor-fold desc="Relapse functionality">
    /**
     * Method to allow a user to alter their Relapse incidents for a given fortnight.
     * POST, /Fortnight/Relapse
     * 
     * Expected JSON input:
     * {
     *      "AuthToken":"authtoken",
     *      "DiaryID":"diaryID",
     *      "Incidents":    [
     *                          {"Onset":"onset", "Duration":"duration", "Symptoms":"symptoms", "Consulted":"consulted", "Treatment":"treatment"},
     *                          {"Onset":"onset", "Duration":"duration", "Symptoms":"symptoms", "Consulted":"consulted", "Treatment":"treatment"},
     *                          {"Onset":"onset", "Duration":"duration", "Symptoms":"symptoms", "Consulted":"consulted", "Treatment":"treatment"}
     *                      ]
     * }
     *      
     * @param data
     * @return 
     */
    @Path("/Relapse")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response setRelapse(InputStream data){
        return Response.status(400).entity("Not yet implemented.").build();
    }
    
    /**
     * Method to allow a user to view their Relapse data for a given fortnight.
     * POST, /Fortnight/RelapseData
     * 
     * Expected JSON input:
     * {
     *      "AuthToken":"authtoken",
     *      "DiaryID":"diaryID"
     * }
     * 
     * @param data
     * @return 
     */
    @Path("/RelapseData")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRelapse(InputStream data){
        return Response.status(400).entity("Not yet implemented.").build();
    }
    //</editor-fold>
}
