package KhanBan_Login;

import java.util.Scanner;


public class Registration {
    private static String userName;
    private static String password;
    private static String name;
    private static String surname;
    

    
    public static void setUserName(String name){               
        userName = name;
    }
    
    public static String getUserName(){
        return userName;
    }
    
    public static void setPassword(String pass){
        password = pass;
    }
    
    public static String getPassword(){
        return password;
    }
    
    public static void setName(String nam){
        name = nam;
    }
    
    public static String getName(){
        return name;
    }
    
    public static void setSurname(String srname){
        surname = srname;
    }
    
    public static String getSurname(){
        return surname;
    }
    
    public static void main(String[] args) {
        
        Login loginObj = new Login();
                       
     /*Prompt the user for the required input and then pass the input directly to the methods that use it*/   
        Scanner in = new Scanner(System.in);
        System.out.println(" **           REGISTRATION  ");
        
        System.out.print("Enter your first name: ");
        setName(in.nextLine());
        
        System.out.print("Enter your surname: ");
        setSurname(in.nextLine());
        
        
        System.out.print("Enter your username: ");
        setUserName(in.nextLine());
        
        loginObj.checkUserName(getUserName()); // ensure the uer name meets the requirements
        
        System.out.print("Enter your password: ");
        setPassword(in.nextLine());
                

        loginObj.checkPasswordComplexity(password); // ensure the password meets the requirements
        
        
        /*Pass the username and password to the method and then print out the messages returned by the method*/
        System.out.println( loginObj.registerUser( getPassword(), getUserName() ));
        
        //Store the boolean value returned by loginUser() in the regStatus varible.
        boolean regStatus = loginObj.loginUser(getPassword(), getUserName(), loginObj.checkUserName(getUserName()) ,loginObj.checkPasswordComplexity(password));
        
        System.out.println(loginObj.returnLoginStatus(regStatus, getName(), getSurname()));
    }
   
}
