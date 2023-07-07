
package KhanBan_Add_Features;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.Test;


public class TaskTest {
    Task task = new Task();
    public TaskTest() {
    }

    
    @Test
    public void testCheckTaskDescription() {
        boolean actual = task.checkTaskDescription("Create Login to authenticate users");
        boolean expected = true;
        assertEquals(expected, actual, "Task successfully captured");
        
        assertTrue(task.checkTaskDescription("Create Login to authenticate users"));
        assertFalse(task.checkTaskDescription("Create a Login to authenticate users and check if their passwords are complex enough"));
    }

    @Test
    public void testCreateTaskID() {
        String actual = task.createTaskID("Robyn Harrison", "Add Task Feature", 1);
        String expected = "AD:1:BYN";
        
        assertEquals(expected, actual);
    }

/*    @Test
    public void testPrintTaskDetails() {
        String expected = "Task Status: " + "Done" + "\n" +
                "Developer Names: " + "Thomas Murashidzi" + "\n" +  
                "Task Number: " + 1 + "\n" +
                "Task Name: " + "Coding" + "\n" +
                "Task Description: "+ "Telling the computer what to do" + "\n" + 
                "Task ID: " + "NG:1:MAS" + "\n" +
                "Task Duration: " + 32;
        
        String actual = task.printTaskDetails("Done", "Thomas Murashidzi", 1, "Coding", "Telling the computer what to do", 32);
        
        assertEquals(expected, actual); 

    }*/
    
    @Test
    public void testReturnTotalHours() {
        int expected = 12;
        int actual = task.returnTotalHours(12);
        assertEquals(expected, actual);
    }
    
}
