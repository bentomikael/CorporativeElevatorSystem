package CorporativeElevatorSystem;

import CorporativeElevatorSystem.Screen.AddEmployeeScreen;
import CorporativeElevatorSystem.Screen.AdministrativeOptionsScreen;
import CorporativeElevatorSystem.Screen.ChangeEmployeeScreen;
import CorporativeElevatorSystem.Screen.DelEmployeeScreen;
import CorporativeElevatorSystem.Screen.EmployeeListScreen;
import CorporativeElevatorSystem.Screen.FloorScreen;
import CorporativeElevatorSystem.Screen.HomeScreen;
import CorporativeElevatorSystem.Screen.LoginScreen;
import CorporativeElevatorSystem.Screen.ReportScreen;
import java.util.ArrayList;

public class ScreenControl {
    
    //<editor-fold defaultstate="collapsed" desc="Declaração de variaveis">
    
    private boolean logoutRequest;
    private int option;
    private HomeScreen homeScreen;
    private LoginScreen loginScreen;
    private FloorScreen floorScreen;
    private AdministrativeOptionsScreen admScreen;
    private ReportScreen repScreen;
    private AddEmployeeScreen addScreen;
    private DelEmployeeScreen delScreen;
    private ChangeEmployeeScreen changeScreen;
    private EmployeeListScreen listScreen;
    
//</editor-fold>
   
    public ScreenControl() {
        //<editor-fold defaultstate="collapsed" desc="Instancias">
        logoutRequest = false;
        homeScreen = new HomeScreen();
        loginScreen = new LoginScreen();
        floorScreen = new FloorScreen();
        admScreen = new AdministrativeOptionsScreen();
        repScreen = new ReportScreen();
        addScreen = new AddEmployeeScreen();
        delScreen = new DelEmployeeScreen();
        changeScreen = new ChangeEmployeeScreen();
        listScreen = new EmployeeListScreen(); 
//</editor-fold>
        
    }
    public void standBy(){
        homeScreen.standBy();
    }
    
    public boolean getLogoutRequest(){
        if(logoutRequest)
           homeScreen.mLogout();
        return logoutRequest;
    }
    
    public int login(){
        logoutRequest = false;
        return loginScreen.LoginScreen();
    }
    
    public int home(int actualUserLevel){
        option = homeScreen.homeScreen(actualUserLevel);
        if(option == -1)
            logoutRequest = true;
        
        return option;
    }

    public int floorScreen(int actualUserLevel,int currentFloor) {
        option = floorScreen.floorScreen(actualUserLevel,currentFloor);
         if(option == -1)
            logoutRequest = true;
         
        return option;
    }

    public int administrativeOptionsScreen() {
        option = admScreen.administrativeOptionsScreen();
        if(option == -1)
            logoutRequest = true;
         
        return option;
    }
    
    public void addEmployeeScreen(){}
    public void removeEmployeeScreen(){}
    
    public int changeEmployeeScreenCode(int actualUserCode,ArrayList codesArray){
        int code;
        int level;
        boolean valid;
        do{
            valid = true;
            code = changeScreen.inputCodeScreen();
            if(code == actualUserCode){
                valid = false;
               changeScreen.mChangeSelfErro();
            }else if(!codesArray.contains(code)){
                valid = false;
                changeScreen.mNotFound();
            }else if(code == -1)
                logoutRequest = true;
            
        }while(!valid);
        
        return code;
    }
    public int changeEmployeeScreenLevel(int actualUserLevel){
        int level = changeScreen.inputOccupationOScreen(actualUserLevel); 
        if(level == -1)
            logoutRequest = true;
        return level;
    }
    
    public void reportScreen(){}
    public int employeesListScreen(){
        option = listScreen.employeeListScreen();
        if(option == -1)
            logoutRequest = true;
        
        return option;
    }  
    
    
}
