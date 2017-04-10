/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author adickinson
 */
public class DailyDiary {
    public int dayNumber; //1-14
    public int falls;
    public int grievousFalls;
    
    public DailyDiary(){
        this.dayNumber = 0;
        this.falls = 0;
        this.grievousFalls = 0;
    }
    
    public DailyDiary(int dayNumber, int falls, int grievousFalls){
        this.dayNumber = dayNumber;
        this.falls = falls;
        this.grievousFalls = grievousFalls;
    }
    
    //<editor-fold desc="Getters and setters.">
    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public int getFalls() {
        return falls;
    }

    public void setFalls(int falls) {
        this.falls = falls;
    }

    public int getGrievousFalls() {
        return grievousFalls;
    }

    public void setGrievousFalls(int grievousFalls) {
        this.grievousFalls = grievousFalls;
    }
    //</editor-fold>
    
    //<editor-fold desc="Methods to alter a user's total number of falls.">
    //Falls
    public int tallyFalls(int increase){
        this.falls += increase;
        return falls;
    }
    
    //Grievous falls
    public int tallyGrievousFalls(int increase){
        this.grievousFalls += increase;
        
        //Validation to ensure that falls is never exceeded by the number of grievous falls
        if(grievousFalls > falls){
            grievousFalls = falls;
        }
        
        return grievousFalls;
    }
    
    //</editor-fold>
}
