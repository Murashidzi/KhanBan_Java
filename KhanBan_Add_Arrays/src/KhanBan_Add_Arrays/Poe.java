package KhanBan_Add_Arrays;

import javax.swing.JOptionPane;

public class Poe {
      
    static String devNames; 
    static String search; 
    static String t_name; 
        
    static int option = 0; 
    static String choice = "";
 
    static int size = TaskDetails.getNumberOfTasks();
    
    static String[] developerNames = new String[size];
    static String[] taskNames = new String[size];
    static String[] taskIDs = new String[size];
    static String[] taskStatuses =new String[size];
    static int[] taskDurations = new int[size];
    
    public static void getArrays(String developerName[], String taskName[], String taskID[], String[] status, int duration[]){
        System.arraycopy(developerName, 0, developerNames, 0, size);
        System.arraycopy(taskName, 0, taskNames, 0, size);
        System.arraycopy(taskID, 0, taskIDs, 0, size);
        System.arraycopy(status, 0, taskStatuses, 0, size);
        System.arraycopy(duration, 0, taskDurations, 0, size);

    }
    
    /*
         Allow the user to perform different operations on the task details
    */
    public static void manipulateArrays(){
        
        do{
            choice = JOptionPane.showInputDialog("Enter\n"
                    + "a -> To view the list of all tasks with the status of done\n"
                    + "b -> To view the name of the developer whose task takes the longest to complete\n"
                    + "c -> To search for a Task\n"
                    + "d -> To view the list of tasks assigned to a developer\n"
                    + "e -> To delete a task\n"
                    + "f -> To get a report of all the captured Tasks\n"
                    + "q -> To Quit");
            
            switch(choice){
                case "a": // the user gets the list of doneTask tasks if they select a
                    JOptionPane.showMessageDialog(null, doneTasks(taskStatuses) );
                    break;
                case "b":
                    JOptionPane.showMessageDialog(null, longestTask(taskDurations) );
                    break;
                case "c":
                    search = JOptionPane.showInputDialog("Enter the name of the task to be searched");
                    JOptionPane.showMessageDialog(null, searchTask(search) );
                    break;
                case "d":
                    devNames = JOptionPane.showInputDialog("Enter developer full names");
                    JOptionPane.showMessageDialog(null, developerTasks(devNames) );
                    break;
                case "e":
                    t_name = JOptionPane.showInputDialog("Enter the name of the task to be deleted");
                   JOptionPane.showMessageDialog(null,deleteTask(t_name) );
                    break;
                case "f":
                    displayReport();
                    break;
                case "q":
                    choice = "q";
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid input");
                    
            }
            
        }while(!choice.equalsIgnoreCase("q"));

        
    }
    /* this methods searches for the tasks with the status Done and if found, the task together
        with the task name and durations are stored in the doneTask variable and later displayed
    */
    public static String doneTasks( String stats[]){
        String doneTask = "";
        for(int i = 0; i < size; i++){
            if(taskDurations[i] == 0 && taskStatuses[i] == null){
                doneTask = "Task Was Deleted!!!!";
            }
            else if(stats[i].equals("Done")){
                doneTask = (developerNames[i]+", "
                        +taskNames[i]+ ", "
                        +taskDurations[i]);
            i = size; //terminate the loop
            }
        }
        
        return doneTask;

    }
    
    /* this method searches for the largest number in the taskDuration array and displays it together with the developerNames
    assigned to the task.
    */
    public static String longestTask(int[] drtns){
        String longest = ""; 
        int maximum;
        
        maximum = drtns[0];
        int position = 0; // this variable will hold the location of the largest number in the taskDurations array
        // this loop finds the largest value in the taskDurations array and stores it in the maximum variable
        for(int i = 0; i < size; i++){
            
            if(drtns[i] > maximum){
                maximum = drtns[i];
                position = i;
            }                        
        }
        
         longest = (developerNames[position]+ ", " + maximum);
         
         return longest;
        
    }
    
    /*
     This method allows a user to search for a Task using the task name
    */
    public static String searchTask(String searching){
        String taskFound = "";
        searching = search;
        for(int i = 0; i < size; i++){
            if(taskDurations[i] == 0 && taskNames[i] == null){
                taskFound = "Task Was Deleted";
            }
            
            else if(taskNames[i].equals(searching)){
                taskFound = (taskNames[i] + ", " + developerNames[i] +", "+ taskStatuses[i]);
                i = size; // this line will terminate the loop when a developer name is found
                
            }
            else{
                taskFound = "Task not found";
            }
        }
        
        return taskFound;

    }
    
    /*
        This method allows the user to search for all the tasks assigned to  particular developer
    */
    public static String developerTasks(String developer){
        String dev_tasks = "";
        developer = devNames;
        for(int i = 0; i < size; i++){
            
            if(taskDurations[i] == 0 && developerNames[i] == null){
                developer = "Developer Was Deleted";
                dev_tasks = developer;
            }

            
            else if(developerNames[i].equals(developer)){
               dev_tasks = (taskNames[i] + ", " + taskStatuses[i]);
               i = size; // this line will terminate the loop when a developer name is found
            }
            else{
                dev_tasks = "Developer name not found";
            }
        }
        
        return dev_tasks;

    }
    /*
     If the user enters a task that is in the array, the task will be deleted along with all the details related to it.
    */
    public static String deleteTask(String taskToDelete){
        String taskDeleted = "";
        taskToDelete = t_name;
        int deleteIndex; // this variable will hold the name of the task to be deleted
        /*
            The loop looks for the task to be deleted, and if the task is found, its index is noted and everything at that
            index is removed from the parallel arrays.
        */
        for(int i = 0; i < size; i++){

            if(taskDurations[i] == 0 && taskNames[i]== null){
                taskDeleted = "Not found";
            }

            
            else if(taskNames[i].equals(taskToDelete)){
               deleteIndex = i;
               
               taskDeleted = ("Entry " + taskNames[i] + " successfully deleted.");

                taskDurations[deleteIndex] = 0; 
                taskStatuses[deleteIndex] = null; 
                developerNames[deleteIndex] = null; // set the last element to the defauls value
                taskIDs[deleteIndex] = null; // set the last element to the defauls value
                taskNames[deleteIndex] = null; // set the last element to the defauls value
               
               
               i = size + 1; // terminate the loop
            }
            else{
                taskDeleted = "Task not found";
            }
                         
        }
        
        
        return taskDeleted;
    }
    public static void displayReport(){
        String report;
        for(int i = 0; i < size; i++){
            if( (!"".equals(taskNames[i]) ) && (taskDurations[i] != 0) ){
                report = (taskNames[i] + "\n"
                        +developerNames[i]+ "\n"
                        + taskIDs[i] + "\n"
                        + taskStatuses[i] +"\n"
                        + taskDurations[i] + "\n");
            }
            else{
                continue;
            }
            JOptionPane.showMessageDialog(null, report);
        }
    }
    
}
