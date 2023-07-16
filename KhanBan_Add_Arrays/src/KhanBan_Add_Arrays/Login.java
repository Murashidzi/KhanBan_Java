package KhanBan_Add_Arrays;

import javax.swing.JOptionPane;

public class Login {
    String passMessage = "Password not formatted correctly.";
    String nameMessage = "Username is not correctly formatted, please ensure that your "
                    + "username contains an underscore and is no 5 characters in length";
   
    /*The method will take a user name as an argument and check to see if the username contains an underscore and is not longer than 5 letters*/
    public boolean checkUserName(String userName){
        return userName.contains("_") && userName.length() <= 5;
    }

    /*The method take a password as an argument chekc if it is at least 8 characters long, contains an upercase, a number and a special character*/
    public boolean checkPasswordComplexity(String password){
        
        boolean passwordOkay = false;
        boolean hasNumber = false;
        boolean hasCap = false;
        boolean hasChar = false;
        char current;
        
        // the loop only executes if the password meets the length constraint
        if (password.length() >= 8){ 
            for (int i =0; i < password.length(); i++){
                current = password.charAt(i);

                if(Character.isDigit(current)){
                    hasNumber = true;
                }
                else if(Character.isUpperCase(current)){
                    hasCap = true;
                }
                else if (!(Character.isLetterOrDigit(current))){
                    hasChar = true;
                }
            }
        }    
            
        if(hasNumber && hasCap && hasChar){
            passwordOkay = true;
        }
        return passwordOkay;
        
    }

    /*The method takes a password and a username as arguments.
    If it then returns a message that is determined by whether the password and username meet the entry requirements.
    */
    public String registerUser(String pass, String name){
        if (checkPasswordComplexity(pass)){
            passMessage = "Password successfully captured.";
        }
        if (checkUserName(name)){
            nameMessage = "User name successfully captured.";
        }
        return (nameMessage+ "\n" + passMessage);
    }

    
    public boolean loginUser(String pass, String usrname, boolean checkName, boolean checkPassword){
        
        boolean logged = false;
        if(checkName && checkPassword) { //only run in the user successfully registered
                      
            String username = JOptionPane.showInputDialog("Please enter the username you provided earlier");
            
            String password = JOptionPane.showInputDialog("Please enter the password you entered earlier");
            
            if (password.equals(pass) && username.equals(usrname)  ){
                logged = true;
            }
        }
        return logged;
    }
    
    
    public String returnLoginStatus(boolean regStatus, String name, String surname){
        String message;
        message = "Username or password incorrect, please try again";
        
        if (regStatus){
            message = "Welcome, " + name + " " + surname + ", it is great to see you again.";
        }
        return message;
    }
    // test data
    String u_name = "kyl_1";
    String pass = "Ch&&sec@ke99!";
}


