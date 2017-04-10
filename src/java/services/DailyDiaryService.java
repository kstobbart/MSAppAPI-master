/*
 * TODO: Change me
 */
package services;

import java.io.InputStream;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author Andrew
 */
@Path("/DailyDiary")
public class DailyDiaryService {
    
    /**
     * Required functionality.
     * User provides a day number, as well as their number of falls and grievous 
     * falls for that day.
     * 
     * Allow users to view previous diary data:
     * For a day, range of days.
     */
    
    /**
     * Method to alter the number of grievous falls for a given date.
     * User provides a day number and a fortnightly diary ID. Checks to see if user should be allowed
     * to access this diary entry, and if so extracts diary data from DB.
     * Alters this data based on user's provided data for falls, and stores in DB.
     * 
     * Expected input data format will need to match:
     * {
     *      "AuthToken":"authtoken",
     *      "DiaryID":"diaryID",
     *      "Falls":[
     *                  {"Day":"day", "Falls":"falls"},
     *                  {"Day":"day", "Falls":"falls"}
     *              ]
     * }
     * @param data
     * @return 
     */
    @Path("/Falls")
    @POST
    public Response setFalls(InputStream data){
        return Response.status(400).entity("Not yet implemented.").build();
    }
    
    /**
     * Method to alter the number of grievous falls for a given date.
     * User provides a day number and a fortnightly diary ID. Checks to see if user should be allowed
     * to access this diary entry, and if so extracts diary data from DB.
     * Alters this data based on user's provided data for grievous falls, and stores in DB.
     * 
     * Expected input data format will need to match:
     * {
     *      "AuthToken":"authtoken",
     *      "DiaryID":"diaryID",
     *      "GrievousFalls":[
     *                  {"Day":"day", "Falls":"falls"},
     *                  {"Day":"day", "Falls":"falls"}
     *              ]
     * }
     * @param data
     * @return 
     */
    @Path("/GrievousFalls")
    @POST
    public Response setGrievousFalls(InputStream data){
        return Response.status(400).entity("Not yet implemented.").build();
    }
    
    /**
     * Returns a user's fall data for a single day.
     * 
     * Expected input data format will need to match:
     * {
     *      "AuthToken":"authtoken",
     *      "DiaryID":"diaryID",
     *      "Day":"day"
     * }
     * @param data
     * @return 
     */
    @Path("/FallDataSingle")
    @POST
    public Response getFallDataSingle(InputStream data){
        return Response.status(400).entity("Not yet implemented.").build();
    }
    
    /**
     * Returns a user's fall data for a fortnight period.
     * 
     * Expected input data format will need to match:
     * {
     *      "AuthToken":"authtoken",
     *      "DiaryID":"diaryID"
     * }
     * 
     * @param data
     * @return 
     */
    @Path("/FallDataFortnight")
    @POST
    public Response getFallDataFortnight(InputStream data){
        return Response.status(400).entity("Not yet implemented.").build();
    }
}
