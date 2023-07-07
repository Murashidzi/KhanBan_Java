
package KhanBan_Login;

import java.util.Scanner;

public class Login {
    String passMessage;
    String nameMessage;
   
    /*Make sure the user name contains an underscore and is not more than 5 letters in length*/
    public boolean checkUserName(String userName){
        return userName.contains("_") && userName.length() <= 5;
    }

    /*Make sure the password is at least 8 characters long, contains an upercase, a number and a special character*/
    public boolean checkPasswordComplexity(String password){
        
        boolean passwordOkay = false;
        boolean hasNumber = false;
        boolean hasCap = false;
        boolean hasChar = false;
        char current;
        
        // the loop only executes if the password meets the length constraint.
        //That way, only the other 3 password constraints have to be checked
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
     It then returns a message that is determined by whether the password and username meet the entry requirements.
    */
    public String registerUser(String pass, String name){
        if (checkPasswordComplexity(pass)){
            passMessage = "Password successfully captured.";
        }
        else{
            passMessage = "Password is not correctly formatted, please ensure that the password contains at least 8 \n" +
                            "characters, a capital letter, a number and a special character";
        }
        
        if (checkUserName(name)){
            nameMessage = "User name successfully captured.";
        }
        else{
            nameMessage = "Username is not correctly formatted, please ensure that your "
                    + "username contains an underscore and is no 5 characters in length";
        }
        
        
        return (nameMessage+ "\n" + passMessage);
    }

    
    public boolean loginUser(String pass, String usrname, boolean checkName, boolean checkPassword){
        
        boolean logged = false;
        if(checkName && checkPassword) { //only run in the user successfully registered

            Scanner in = new Scanner(System.in);
            System.out.println("");
            System.out.println("              LOGIN  ");            
            System.out.print("Please enter the username you entered earlier: ");
            String username = in.nextLine();
            System.out.print("Please enter the password you entered earlier: ");
            String password = in.nextLine();
            
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
}


