package KhanBan_Add_Arrays;

import KhanBan_Add_Arrays.Login;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LoginTest {
    Login login = new Login();
    
    public LoginTest() {
    }

    @Test
    public void testCheckUserName() {
        assertTrue(login.checkUserName("kyl_1"));
        assertFalse(login.checkUserName("kyle!!!!!!!"));

        
        boolean expected = true;
        boolean actual = login.checkUserName("kyl_1");
        
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckPasswordComplexity() {
        
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
        assertFalse(login.checkPasswordComplexity("password"));

        
        boolean expected = true;
        boolean actual = login.checkPasswordComplexity("Ch&&sec@ke99!");
        
        assertEquals(expected, actual);
    }

    @Test
    public void testRegisterUser() {
        // test with correct input
        String expected = "User name successfully captured." + "\n" + "Password successfully captured.";
        String actual = login.registerUser("Ch&&sec@ke99!", "kyl_1");
        
        assertEquals(expected, actual);
        
        // test with incorrect input
        
        expected = "Username is not correctly formatted, please ensure that your "
                    + "username contains an underscore and is no 5 characters in length";
        actual = login.registerUser("ch&&sec@ke99!", "kyl_11");
    }

/*    @Test
    public void testLoginUser() {
        assertTrue(login.loginUser("Ch&&sec@ke99!", "kyl_1", login.checkUserName("kyl_1"), login.checkPasswordComplexity("Ch&&sec@ke99!")));
        assertFalse(login.loginUser("ch&&sec@ke99!", "kyl!!!", login.checkUserName("kyl!!!"), login.checkPasswordComplexity("ch&&sec@ke99!")));
    } */   
   
    @Test
    public void testReturnLoginStatus() {
        // with incorrect data
        String expected = "Username or password incorrect, please try again";
        String actual = login.returnLoginStatus(false, "Thomas", "Murashidzi");
        assertEquals(expected, actual);
        
        // with correct data
        expected = "Welcome, Thomas Murashidzi, it is great to see you again.";
        actual = login.returnLoginStatus(true, "Thomas", "Murashidzi");
        assertEquals(expected, actual);
        
    }
}
