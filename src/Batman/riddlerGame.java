package Batman;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;


public class riddlerGame {

	/*
	 * public static void main(String[] args) { // TODO Auto-generated method stub
	 * 
	 * }
	 */

    Scanner keyboard = new Scanner(System.in);

    static final String answer1 = "candle";
    static final String answer2 = "echo";
    static final String answer3 = "footsteps";
    static final String RIDDLE1 = "<html><boady>Gotham City Bank fell under the sinister control <br>of the enigmatic mastermind, the Riddler!</body></html>";
    static final String RIDDLE2 = "<html><boady>I speak without a mouth and hear without ears. I have no body, but I come alive with the wind. What am I?</body></html>";
    static final String RIDDLE3 = "<html><boady>The more you take, the more you leave behind. What am I?</body></html>"; 
    
    
    String intro(){
    	
    String intro = "<html><body>Gotham City Bank fell under the sinister control of the enigmatic mastermind, the Riddler! " + 
                   "Batman arrives to stop the Riddler and his evil plans The Riddler locked 3 floors with a riddle, solve the riddle if " +
                   "answered incorrectly 3 times, Bomb goes of!!! Help Batman solve the riddles to stop the Riddler and save Gotham City!";

        return intro;
    }
    
    public Map<Integer, String> getRiddlesData()
    {
    	Map<Integer, String> RiddlesData = new HashMap<Integer, String>();
    	RiddlesData.put(1, RIDDLE1);
    	RiddlesData.put(2, RIDDLE2);
    	RiddlesData.put(3, RIDDLE3);
    	
    	return RiddlesData;
    }
    
    public Map<Integer, String> levelOne(String riddleAnswer)
    {
    	Map<Integer, String> RiddleData = new HashMap<Integer, String>();
    	
            if(riddleAnswer.equalsIgnoreCase(answer1))
            {
                RiddleData.put(1, "Great Job!! one step closer to beating the Riddler!");
               
            } else 
            {
            	RiddleData.put(-1, "BOOM!!! BOOM!!! You Lose");
            }
           
        return RiddleData;
    }
    
    public Map<Integer, String> levelTwo(String riddleAnswer)
    {
    	Map<Integer, String> RiddleData = new HashMap<Integer, String>();
    	
            if(riddleAnswer.equalsIgnoreCase(answer2))
            {
                RiddleData.put(2, "Correct!! one step closer to stopping the Riddler");
               
            } else 
            {
            	RiddleData.put(-1, "BOOM!!! BOOM!!! You Lose");
            }
           
        return RiddleData;
    }
    
    public Map<Integer, String> levelThree(String riddleAnswer)
    {
    	Map<Integer, String> RiddleData = new HashMap<Integer, String>();
    	
            if(riddleAnswer.equalsIgnoreCase(answer3))
            {
                RiddleData.put(3, "The more you take, the more you leave behind. What am I?");
               
            } else 
            {
            	RiddleData.put(-1, "BOOM!!! BOOM!!! You Lose");
            }
           
        return RiddleData;
    }
    
}
