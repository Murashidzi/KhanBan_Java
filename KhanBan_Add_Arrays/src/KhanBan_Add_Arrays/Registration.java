package KhanBan_Add_Arrays;

import javax.swing.JOptionPane;

public class Registration {
    private static String userName;
    private static String password;
    private static String name;
    private static String surname;
    

    //set and get the username
    public static void setUserName(String name){               
        userName = name;
    }
    public static String getUserName(){
        return userName;
    }
    //set and get the password
    public static void setPassword(String pass){
        password = pass;
    }
    public static String getPassword(){
        return password;
    }
    //set and get the user's name
    public static void setName(String nam){
        name = nam;
    }
    public static String getName(){
        return name;
    }
    
    //set and get the user's surname
    public static void setSurname(String srname){
        surname = srname;
    }
    public static String getSurname(){
        return surname;
    }
    
    public static void main(String[] args) {
        
        Login loginObj = new Login();
        
        TaskDetails task = new TaskDetails();
               
        setName(JOptionPane.showInputDialog("Please enter your first name") );
        
        setSurname(JOptionPane.showInputDialog("Enter your surname"));
        
        setUserName(JOptionPane.showInputDialog("Enter your username"));
        
        loginObj.checkUserName(getUserName()); // ensure the username meets the requirements
        
        setPassword(JOptionPane.showInputDialog("Enter your password"));
                

        loginObj.checkPasswordComplexity(password); // ensure the password meets the requirements
        
        
        /*Pass the username and password to the method and then print out the messages returned by the method*/
        JOptionPane.showMessageDialog(null, loginObj.registerUser( getPassword(), getUserName() ));
        
        //Store the boolean value returned by loginUser() in the regStatus varible.
        boolean regStatus = loginObj.loginUser(getPassword(), getUserName(), loginObj.checkUserName(getUserName()) ,loginObj.checkPasswordComplexity(password));
        
        task.welcomeAndChooseOption(regStatus);
    }
   
}
