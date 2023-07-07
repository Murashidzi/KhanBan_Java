
package KhanBan_Add_Features;

import javax.swing.JOptionPane;


public class TaskInformation {
    Task task = new Task();
    // variables to store the task details provided by the user.
    private static int number_Of_Tasks;
    private static int task_Duration;
    private static int task_Number; 
    private static String task_Name ; 
    private static int chosen_Option;
    private static String task_Description; 
    private static String developer_Names; 
    private static String task_Status;   
    static int total_Hours = 0; 


    // set and return the name of the task
    public void setTask_Name(String name){
        task_Name = name;
    }
    public String getTask_Name(){
        return task_Name;
    }
    
    // get the number selected by the user from the numeric options
    public int getChosenOPtion(){
        return chosen_Option;
    }

    // set and return the number of tasks the user wishes to enter
    public void setNumber_Of_Tasks(int number){
        number_Of_Tasks = number;
    }
    public int getNumber_Of_Tasks(){
        return number_Of_Tasks;
    }
    
    // set and return the estimated duration of each task
    public void setTask_Duration(int duration){
        task_Duration = duration;
    }
    public int getTask_Duration(){
        return task_Duration;
    }
    
    //set and return a description of each chapter
    public void setTask_Description(String description){
        task_Description = description;
    }
    public String getTask_Description(){
        return task_Description;
    }
    
     // The user will be given a warning and a chance to re-enter the task description if it is longer than 50 words.
    public void DescriptionStatus(){
        while(!(task.checkTaskDescription(getTask_Description())) ){
            JOptionPane.showMessageDialog(null,"Enter a task description of not more than 50 characters");
            setTask_Description(JOptionPane.showInputDialog("Enter a task description"));
        }
       
        JOptionPane.showMessageDialog(null, "Task Successfully captured.");
    }

    
    // set and return the full names of the developer assigned to a task
    public void setDeveloper_Names(String names){
        developer_Names = names;
    }
    public String getDeveloper_Names(){
        return developer_Names;
    }
    
    
    
    public int welcomeAndChooseOption(boolean login){  
    /*
        Only welcomed the user to KanBan  if they logged in successfully.
    */    
        if(login){
            JOptionPane.showMessageDialog(null, "Welcome to EasyKanban\n");
            
            // the loop will only stop if the user enters 3
            do{
                chosen_Option = Integer.parseInt(JOptionPane.showInputDialog(
                        
                        "PLEASE SELECT AN OPTION\n"
                        + "Option 1) Add tasks\n"
                        + "Option 2) Show Report\n"
                        + "Option 3) Quit"));

                switch(chosen_Option){
                    
                case 1: // if the user chooses 1, they will be allowed to add tasks.
                    addTasks(); 
                    break;
                case 2: // this option tells the user the feature is still in development
                    JOptionPane.showMessageDialog(null, "Coming soon");
                    break;
                case 3: // this is the option that terminates the loop
                    chosen_Option = 3;
                    break;
                
                }
            }
            while(chosen_Option != 3);
            
        }
        return chosen_Option;
    }

    
    //set and return the number of the current task
    public void setNumberOfCurrentTask(int task_number){
        this.task_Number = task_number;
    }            
    public int getNumberOfCurrentTask(){
        return task_Number;
    }
    
    /*
    Allow the user to choose the status of their task
    */
    public void setTaskStatus(){
        int option = Integer.parseInt(JOptionPane.showInputDialog("Choose task status.\n"
                + "1) To Do\n"
                + "2) Doing\n"
                + "3) Done"));
        switch(option){
            case 1:
                task_Status = "To Do";
                break;
            case 2:
                task_Status = "Doing";
                break;
            case 3:
                task_Status = "Done";
                break;
            default:
                task_Status = "Invalid selection! Choose a number between 1 and 3";
        }
    }
    
    public String getTask_Status(){
        return task_Status;
    }

    
    public void addTasks(){
    
        /*  get the number of tasks from the user and use it to control the loop that allows the user to add tasks
        */

        setNumber_Of_Tasks(Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you want to add?")) );

        for(int i = 0; i < getNumber_Of_Tasks() ; i++){
         //Call all the othe setters

            setTaskStatus();
            setNumberOfCurrentTask(i);
            setTask_Name(JOptionPane.showInputDialog("Enter the task name "));
            setTask_Duration(Integer.parseInt(JOptionPane.showInputDialog("Enter the task duration")));
            
            
            setDeveloper_Names(JOptionPane.showInputDialog("Enter the developer's first name and surname"));
            setTask_Description(JOptionPane.showInputDialog("Enter a task description"));
            DescriptionStatus();
            
            // Print out the Details of the task
            JOptionPane.showMessageDialog(null, task.printTaskDetails(getTask_Status(), getDeveloper_Names(), getNumberOfCurrentTask(), getTask_Name(), getTask_Description(), getTask_Duration()));

            //Calculate the total number of hours needed to complete tasks.
            total_Hours = total_Hours + getTask_Duration();


        }
        //Print out the total number of hours needed to complete all tasks.
    JOptionPane.showMessageDialog(null,"These tasks require " +total_Hours+" hours to complete.");

        
    }

}
