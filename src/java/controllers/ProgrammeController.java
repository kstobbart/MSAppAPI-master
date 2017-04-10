/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Programme;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import utilities.SQLQuery;

/**
 *
 * @author kstobbart
 */
public class ProgrammeController {
    
    public DatabaseController db = new DatabaseController();
    
    /**
     * Physio creates a programme object with name, duration, capacity and 
     * selects a manager id from the existing physios. 
     * 
     * Create programme method builds and submits an INSERT query to add the new
     * programme into the programme table.
     * 
     * @param programme 
     * 
     */
    public void CreateProgramme(Programme programme){
        boolean successful = false;
        String SQLquery = "INSERT INTO [dbo].[Programme]\n" +
"           ([Name]\n" +
"           ,[Duration]\n" +
"           ,[Capacity]\n" +
"           ,[Manager_ID])\n" +
"     VALUES (?,?,?,?)";
        
        SQLQuery insertQuery = new SQLQuery();
        insertQuery.setParameterlessQuery(SQLquery);
        String weeks = String.valueOf(programme.getWeeks());
        String capacity = String.valueOf(programme.getCapacity());
        String managerID = String.valueOf(programme.getManager());
        
        String[] params = {programme.getName(),weeks,capacity,managerID};
        insertQuery.setQueryParams(params);
        
        if(programme.getName().length() > 0){
            successful = db.submitQuery(insertQuery, 0).succesful;
        }
        
    }
    
    
    public JsonArray ViewAllProgrammes(String managerID){
        ArrayList<Object[]> programmeList = new ArrayList<>();
        SQLQuery retrieveProgrammes = new SQLQuery();

        JsonArray results;
        
        String selectQuery = "SELECT * FROM [dbo].[Programme]";
        if(managerID.length() > 0){
            selectQuery += " WHERE (Manager_ID) = (?)";
            String[] params = {managerID};
            retrieveProgrammes.setQueryParams(params);
        }
                
        retrieveProgrammes.setParameterlessQuery(selectQuery);
        
        programmeList = db.submitQuery(retrieveProgrammes, 5).getResults();
        
        //Convert to Programme Object
        List<Programme> programmes = new ArrayList<>();
        for(Object[] o: programmeList){
            Programme p = new Programme();
            p.setProgrammeID((Integer)o[0]);
            p.setName((String) o[1]);
            p.setWeeks((Integer) o[2]);
            p.setCapacity((Integer) o[3]);
            p.setManager((Integer)o[4]);

            programmes.add(p);
        }
        
        //Convert to JSON
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for(Programme p: programmes){
            JsonObject obj = Json.createObjectBuilder()
                    .add("ProgrammeID", p.getProgrammeID())
                    .add("Name",p.getName())
                    .add("Capacity", p.getCapacity())
                    .add("Duration",p.getWeeks())
                    .add("ManagerID",p.getManager())
                    .build();
            
            builder.add(obj);
        
        }            
        results = builder.build();
        
        return results;
    }
    
}
