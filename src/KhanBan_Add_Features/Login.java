package KhanBan_Add_Features;

import javax.swing.JOptionPane;

public class Login {
    
    String passMessage;
    String nameMessage;
   
    /*Make sure the username contains an underscore and is not longer than 5 letters*/
    public boolean checkUserName(String userName){
        return userName.contains("_") && userName.length() <= 5;
    }

    /*Make sure the password is; 8 characters long, contains an uppercase, a number and a special character*/
    public boolean checkPasswordComplexity(String password){
        
        boolean isPasswordOkay = false;
        boolean hasNumber = false;
        boolean hasCapitalLetter = false;
        boolean hasCharracter = false;
        char current;
        
        // the loop only executes if the password meets the length constraint
        if (password.length() >= 8){ 
            for (int i =0; i < password.length(); i++){
                current = password.charAt(i);

                if(Character.isDigit(current)){
                    hasNumber = true;
                }
                else if(Character.isUpperCase(current)){
                    hasCapitalLetter = true;
                }
                else if (!(Character.isLetterOrDigit(current))){
                    hasCharracter = true;
                }
            }
        }    
            
        if(hasNumber && hasCapitalLetter && hasCharracter){
            isPasswordOkay = true;
        }
        return isPasswordOkay;
        
    }

    /*The method takes a password and a username as arguments.
    If it then returns a message that is determined by whether the password and username meet the entry requirements.
    */
    public String registerUser(String pass, String name){
        if (checkPasswordComplexity(pass)){
            passMessage = "Password successfully captured.";
        }
        else{
            passMessage = "Password not formatted correctly.";
        }
        
        if (checkUserName(name)){
            nameMessage = "User name successfully captured.";
        }
        else{
            nameMessage = "Username is not correctly formatted, please ensure that your username contains an underscore and is no 5 characters in length";
        }
        
        return (nameMessage+ "\n" + passMessage);
    }

    
    public boolean loginUser(String pass, String usrname, boolean checkName, boolean checkPassword){
        
        boolean logged = false;
        if(checkName && checkPassword) { //only run in the user successfully registered
                      
            String username = JOptionPane.showInputDialog("Enter the username you used to register");
            
            String password = JOptionPane.showInputDialog("Enter the password you used to register");
            
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
    String usrname = "kyl_1";
    String passwrd = "Ch&&sec@ke99!";
}


