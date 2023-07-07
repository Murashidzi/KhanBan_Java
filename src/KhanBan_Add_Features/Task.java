package KhanBan_Add_Features;

public class Task {
        // This method returns true if the task description does not exceed 50 characters.
    public static boolean checkTaskDescription(String description){
        if(description.length() <= 50){
            return true;
        }
        else{
            return false;
        }
    }
    //Create the task ID using the task name, the developer first name and the task number
    public static String createTaskID(String developer_names, String task_name, int task_number){
        
        String lastThreeLetters = "";
        String id; // this variable will hold the task id
        char ch; // this variable will hold each and every letter of the programmer's name as it is getting iterated through
        
        for(int i = 0; i < developer_names.length(); i++){
            
            ch = developer_names.charAt(i);
            
            if(Character.isWhitespace(ch)){
                lastThreeLetters = developer_names.substring(i-3, i);
            }
        }
       
        // the automatically generated taskID will be stored in the id variable
        
        id =  task_name.substring(0, 2) + ":" + task_number +
        ":" + lastThreeLetters;
   
        // Task id is then converted to upercase as per the question paper and returned by the createTaskID method
        return id.toUpperCase();
    }
    
        /*
    The following method returns all the datails of a particular task.
    */
    public static String printTaskDetails(String task_status, String developer_names, int current_task, String task_name, String task_description, int duration){
        return "Task Status: " + task_status + "\n" +
                "Developer Names: " + developer_names + "\n" +  
                "Task Number: " + current_task + "\n" +
                "Task Name: " + task_name + "\n" +
                "Task Description: "+ task_description + "\n" + 
                "Task ID: " + createTaskID(developer_names, task_name, current_task) + "\n" +
                "Task Duration: " + duration;
    }
    
    //this method returns the number of hours needed to complete all the tasks
    public static int returnTotalHours( int total_hours){
        
        return total_hours;
    }

}
