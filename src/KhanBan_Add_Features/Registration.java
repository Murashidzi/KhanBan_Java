package KhanBan_Add_Features;

import javax.swing.JOptionPane;

public class Registration {
    private static String name;
    private static String surname;
    private static String userName;
    private static String password;

    

 
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
        
        TaskInformation task = new TaskInformation();
               
        setName(JOptionPane.showInputDialog("Enter your first name") );
        
        setSurname(JOptionPane.showInputDialog("Enter your surname"));
        
        setUserName(JOptionPane.showInputDialog("Enter your username"));
        
        loginObj.checkUserName(getUserName()); // make sure the username meets the requirements
        
        setPassword(JOptionPane.showInputDialog("Enter your password"));
                

        loginObj.checkPasswordComplexity(password); // make sure the password meets the requirements
        
        
        /*Pass the username and password to the method and then print out the messages returned by the methods*/
        JOptionPane.showMessageDialog(null, loginObj.registerUser( getPassword(), getUserName() ));
        
        //Store the boolean value returned by loginUser() in the regStatus varible.
        boolean regStatus = loginObj.loginUser(getPassword(), getUserName(), loginObj.checkUserName(getUserName()) ,loginObj.checkPasswordComplexity(password));
        
        task.welcomeAndChooseOption(regStatus);
    }
   
}
