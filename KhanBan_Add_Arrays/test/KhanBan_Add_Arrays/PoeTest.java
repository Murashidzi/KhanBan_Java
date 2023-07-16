
package KhanBan_Add_Arrays;

import KhanBan_Add_Arrays.Poe;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.Test;


public class PoeTest {
    Poe poe = new Poe();

    int[] durations = {5, 8, 2, 11};
    String[] tasks = {"Create Login", "Create Add Features", "Create Reports", "Add Arrays"};
    String[] statuses = {"To Do", "Doing", "Done", "To Do"};
    String[] names = {"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberhoizer"};
    String[] Ids = {"CR:0:IKE", "CR:1:ARD", "CR:2:THA", "AD:3:NDA"};
    
    
    
    public PoeTest() {
        poe.getArrays(names, tasks , Ids, statuses, durations);
    }

    @Test
    public void testManipulateArrays() {
        
    }

    @Test
    public void testDoneTasks() {
        String actual = poe.doneTasks(statuses);
        poe.getArrays(names, tasks , Ids, statuses, durations);
        String expected = "Samantha Paulson, Create Reports, 2";
        
    }


    @Test
    public void testSearchTask() {
        String actual = poe.searchTask("Create Reports");
        String expected = "Create Login, Mike Smith, To Do";
        
    }

    @Test
    public void testDeveloperTasks() {
        String actual = poe.developerTasks("Samantha Paulson");
        String expected = "Create Reports, Done";
        
    }

    @Test
    public void testDeleteTask() {
        String actual = poe.deleteTask("Create Reports");
        String expected = "Entry Create Reports successfully deleted.";
        
    }

    @Test
    public void testDisplayReport() {
    }

    @Test
    public void testGetArrays() {
    }

    @Test
    public void testLongestTask() {
    }
    
}
