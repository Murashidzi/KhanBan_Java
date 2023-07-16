
package KhanBan_Add_Arrays;

import javax.swing.JOptionPane;

public class TaskDetails {
    Task task = new Task();
    
    // arrays
    String[] developer;
    String[] taskNames;
    String[] taskIDs;
    String[] taskStatuses;
    int[] taskDurations;

    
    
    
    //These variables will hold details of the task as they are provided by the user.
    private static String taskName ; 
    private static int chosenOption;
    private static int numberOfTasks;
    private static int taskDuration;
    
    private static int taskNumber; // this variable will hold the number of each task
    private static String taskDescription; // the task description entered by the user will be stored here
    private static String developerNames; // this variable will take the name and surname of the programmer
    private static String taskStatus; // This will hold one of three options; To Do, Doing or Done
    
    static int totalHours = 0; // this variable will hold the total number of hours
    static String taskDetails;

    // set and return the name of the task
    public void setTaskName(String name){
        taskName = name;
    }
    public String getTaskName(){
        return taskName;
    }
    
    // store the number selected by the user from the numeric options
    public int getChosenOPtion(){
        return chosenOption;
    }

    // set and return the number of tasks the user wishes to enter
    public void setNumberOfTasks(int number){
        numberOfTasks = number;
    }
    public static int getNumberOfTasks(){
        return numberOfTasks;
    }
    
    // set and return the estimated duration of each task
    public void setTaskDuration(int duration){
        taskDuration = duration;
    }
    public int getTaskDuration(){
        return taskDuration;
    }
    
    //set and return a description of each chapter
    public void setTaskDescription(String description){
        taskDescription = description;
    }
    public String getTaskDescription(){
        return taskDescription;
    }
    
     // if the task description is longer than 50 words, the user will be given a warning and a chance to re-enter it.
    public void DescriptionStatus(){
        while(!(task.checkTaskDescription(getTaskDescription())) ){
            JOptionPane.showMessageDialog(null,"Please enter a task description of not more than 50 characters");
            setTaskDescription(JOptionPane.showInputDialog("Please enter a task description"));
        }
       
        JOptionPane.showMessageDialog(null, "Task Successfully captured.");
    }

    
    // set and return the full names of the developer assigned to a task
    public void setDeveloperNames(String names){
        developerNames = names;
    }
    public String getDeveloperNames(){
        return developerNames;
    }
    
    
    /*
    The following method checks if the user managed to login and if they did, will present them
    with an option Menu
    */
    public int welcomeAndChooseOption(boolean login){
    
        //The user only gets a welcome message and the option Menu if they successfully registered.
        if(login){
            JOptionPane.showMessageDialog(null, "Welcome to EasyKanban\n");
            
            // the do-while loop will only stop if the user selects three from the numeric menu
            do{
                chosenOption = Integer.parseInt(JOptionPane.showInputDialog(
                        
                        "PLEASE SELECT AN OPTION\n"
                        + "Option 1) Add tasks\n"
                        + "Option 2) Show Report\n"
                        + "Option 3) Quit"));

                switch(chosenOption){
                    
                case 1: // if the user chooses 1, they will be allowed to add tasks.
                    addTasks(); 
                    break;
                case 2: 
                     /*
                    Pass the five parallel arrays to the manipulateArrays method.
                    */
                    if (developer != null){
                        Poe.getArrays(developer, taskNames, taskIDs, taskStatuses, taskDurations);
                        Poe.manipulateArrays();
                    }
                    // The user can only view a report after they have populated the arrays
                    else{
                        JOptionPane.showMessageDialog(null,"Add tasks to view a report!!");
                    }
                    
                    break;
                case 3: // this is the option that terminates the loop => 3 is the sentinel value
                    chosenOption = 3;
                    break;
                
                }
            }
            while(chosenOption != 3);
            
        }
        return chosenOption;
    }

    
    //set and return the number of the current task
    public void setNumberOfCurrentTask(int taskNumber){
        this.taskNumber = taskNumber;
    }            
    public int getNumberOfCurrentTask(){
        return taskNumber;
    }
    
       /*
    The user is given three options from which to pick the status of their task.
    */
    public void setTaskStatus(){
        int option = Integer.parseInt(JOptionPane.showInputDialog("Please choose the Status of this task from the three options.\n"
                + "1) To Do\n"
                + "2) Doing\n"
                + "3) Done"));
        switch(option){
            case 1:
                taskStatus = "To Do";
                break;
            case 2:
                taskStatus = "Doing";
                break;
            case 3:
                taskStatus = "Done";
                break;
            default:
                taskStatus = "Invalid selection!! Please pick an option from the number from 1 to 3";
        }
    }
    
    public String getTaskStatus(){
        return taskStatus;
    }

    
    public void addTasks(){
    
        /*  start by asking the user how many tasks they wish to implement.
        */

        try {
            setNumberOfTasks(Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks you want to add")) );
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Number of tasks should be an integer!!");
        }
        
                 /*
            The following parralel arrays all use the number of tasks as their size and they will be populated as 
            the user enters task details.
         */
        developer = new String[getNumberOfTasks()];
        taskNames = new String[getNumberOfTasks()];
        taskIDs = new String[getNumberOfTasks()];
        taskStatuses =new String[getNumberOfTasks()];
        taskDurations = new int[getNumberOfTasks()];


        for(int i = 0; i < getNumberOfTasks() ; i++){
         //Call all the othe setters

            setTaskStatus();
            setNumberOfCurrentTask(i);
            setTaskName(JOptionPane.showInputDialog("Enter task name "));
            try {
                setTaskDuration(Integer.parseInt(JOptionPane.showInputDialog("Enter the duration of this task")));
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null,"Task duration should be an integere");
        }
            
            
            setDeveloperNames(JOptionPane.showInputDialog("Please enter the developer's first name and surname"));
            setTaskDescription(JOptionPane.showInputDialog("Please enter a task description"));
            DescriptionStatus();
            
            developer[i] = getDeveloperNames();
            taskNames[i] = getTaskName();
            taskIDs[i] = task.createTaskID(getDeveloperNames(), getTaskName(), getNumberOfCurrentTask());
            taskStatuses[i] = getTaskStatus();
            taskDurations[i] = getTaskDuration();                        

            
            // This method prints out the Details of the task
            JOptionPane.showMessageDialog(null, task.printTaskDetails(getTaskStatus(), getDeveloperNames(), getNumberOfCurrentTask(), getTaskName(), getTaskDescription(), getTaskDuration()));

            //the following line calculates the total number of hours needed to complete all tasks.
            totalHours = totalHours + getTaskDuration();


        }
    //Print out the total number of hours needed to complete all the entered tasks.
    JOptionPane.showMessageDialog(null,"You need " +totalHours+" hours to complete these tasks.");

        
    }
    
    
}
