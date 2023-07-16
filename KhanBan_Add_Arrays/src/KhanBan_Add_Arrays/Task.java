
package KhanBan_Add_Arrays;


public class Task {
    
    // This method returns true if the task description has less than 51 characters and returns false otherwise
    public static boolean checkTaskDescription(String description){
        final int DESCRIPTION_LENGTH = 50;
        if(description.length() <= DESCRIPTION_LENGTH){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static String createTaskID(String developerNames, String taskName, int taskNumber){
        
        /*
            The following loop iterate through the programers names.
            When a white space is encountered, it is assumed that the first name has ended and the program
            will count back three steps from the whitespace and then create a substring from that position to
            the letter just before the whitespace.
        The last three letters of the programer's first name are going to be stored in the following variable
        */
        String lastThreeLetters = "";
        String id; // this variable will hold the task id
        char ch; // this variable will hold each and every letter of the programmer's name as it is getting iterated through
        
        for(int i = 0; i < developerNames.length(); i++){
            
            ch = developerNames.charAt(i);
            
            if(Character.isWhitespace(ch)){
                lastThreeLetters = developerNames.substring(i-3, i);
            }
        }
       
        // the automatically generated taskID will be stored in the id variable
        
        id =  taskName.substring(0, 2) + ":" + taskNumber +
        ":" + lastThreeLetters;
   
        // Task id is then converted to upercase as per the question paper and returned by the createTaskID method
        return id.toUpperCase();
    }
    
        /*
    The following method returns all the datails of a particular task.
    */
    public static String printTaskDetails(String taskStatus, String developerNames, int currentTask, String taskName, String taskDescrip, int duration){
        return ("Task status:  " +taskStatus) + "\n" + ( "Developer names:  " + developerNames) + "\n" +  
                ("Task number:  "+ currentTask) + "\n" + ("Task name:  " + taskName) + "\n" +
                ("Descritption:  " + taskDescrip) + "\n" + ("Task ID:  "+createTaskID(developerNames, taskName, currentTask) ) + "\n" + ("Duration:  "+duration);
    }
    
    //this method returns the number of hours needed to complete all the tasks
    public static int returnTotalHours( int totalHours){
        
        return totalHours;
    }


    
}
