package br.ufsc.ine5605.CorporativeElevatorSystem;

import br.ufsc.ine5605.CorporativeElevatorSystem.Screen.AddEmployeeScreen;
import br.ufsc.ine5605.CorporativeElevatorSystem.Screen.AdministrativeOptionsScreen;
import br.ufsc.ine5605.CorporativeElevatorSystem.Screen.ChangeEmployeeScreen;
import br.ufsc.ine5605.CorporativeElevatorSystem.Screen.DelEmployeeScreen;
import br.ufsc.ine5605.CorporativeElevatorSystem.Screen.EmployeeListScreen;
import br.ufsc.ine5605.CorporativeElevatorSystem.Screen.FloorScreen;
import br.ufsc.ine5605.CorporativeElevatorSystem.Screen.HomeScreen;
import br.ufsc.ine5605.CorporativeElevatorSystem.Screen.LoginScreen;
import br.ufsc.ine5605.CorporativeElevatorSystem.Screen.ReportScreen;
import java.util.ArrayList;

public class ScreenControl {
    
    //<editor-fold defaultstate="collapsed" desc="Declaração de variaveis">
    
    private boolean logoutRequest;
    private boolean valid;
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
        int code;
        do{
            code = loginScreen.LoginScreen();
            if(code == 0)
                loginScreen.mNotFound();
        }while(code == 0);
        return code;
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
    
    //<editor-fold defaultstate="collapsed" desc="Adicionar funcionario">
    public String addEmployeeScreenName(){
        
        String name;
        do{ 
            valid = true;
            name = addScreen.inputName();
            
            //verifica se contem apenas letras
            valid = name.matches("[A-Z a-z Çç]{"+name.length()+"}");
            
            if(name.equals("00")){
                logoutRequest = true;
                valid = true;
            }                
            if(valid == false)
                addScreen.mInvalidName();
            
        }while(!valid);
         
        return name;
    }
    public int addEmployeeScreenAge(){
        
        option = addScreen.inputAge();
        if(option == -1)
            logoutRequest = true;
        
        return option;
    }
    public int addEmployeeScreenGender(){
        
        do{
            valid = true;
            option = addScreen.inputGender();
            
            if(option == -1)
                logoutRequest = true;

            if(option == 0){
                addScreen.mInvalidOption();
                valid = false;
            }
        
        }while(!valid);
        
        return option;  
    }
    public int addEmployeeScreenCode(ArrayList codesArray){ 
        int code ;
        
        do{
            valid = true;
            code = addScreen.inputCode();
            
            if(code == -1)
                logoutRequest = true;
            else if(codesArray.contains(code))
                valid = false;
                changeScreen.mAlreadyRegistered();
            
        }while(!valid);
        
        return option;
    }
    public int addEmployeeScreenLevel(int actualUserLevel){  
        int level = addScreen.inputOccupation(actualUserLevel);
        if(level == -1)
            logoutRequest = true;
        else
            addScreen.mSuccessAdd();
        return level;
    }

//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Remover funcionario">
    public int delEmployeeCodeScreen(ArrayList codesArray){
        int code;
        do{
            valid = true;
            code = delScreen.inputCodeScreen();
            if(code == -1)
                logoutRequest = true;
            else if(!codesArray.contains(code)){
                valid = false;
                changeScreen.mNotFound();
            }
        }while(!valid);
        return code;
    }
    public int delEmployeeConfirmationScreen(int actualUserLevel,int userToDelLevel,String userToDelName){
        
        if(actualUserLevel <= userToDelLevel){
            delScreen.mDontHavePermision();
            logoutRequest = true;
            standBy();   
        }else
            option = delScreen.inputConfirmationScreen(userToDelName);
        
        if(option == 0){
            logoutRequest = true;
           delScreen.mCanceled();
        }
        else
            delScreen.mSuccessDel();
        
        return option;
    }
    
//</editor-fold> 
    
    //<editor-fold defaultstate="collapsed" desc="Alterar cargo de funcionario">
    public int changeEmployeeScreenCode(int actualUserCode,ArrayList codesArray){
        int code;
        int level;
        do{
            valid = true;
            code = changeScreen.inputCodeScreen();
            if(code == -1)
                logoutRequest = true;
            else
                if(!codesArray.contains(code)){
                    valid = false;
                    changeScreen.mNotFound();
                }else if(code == actualUserCode){
                    valid = false;
                    changeScreen.mChangeSelfErro();            
                } 
            
        }while(!valid);
        
        return code;
    }
    public int changeEmployeeScreenLevel(int actualUserLevel){
        int level = changeScreen.inputOccupationOScreen(actualUserLevel); 
        if(level == -1)
            logoutRequest = true;
        else
            changeScreen.mSuccessChange();
        return level;
    }
    public boolean checkAuthorization(int actualUserLevel,int userToChangeLevel){
        valid = true;
        if(actualUserLevel <= userToChangeLevel){
            valid = false;
            changeScreen.mDontHavePermision();
            logoutRequest = true;
        }
        return valid;
    }
    
//</editor-fold> 
    
    
    public void reportScreen(){}
    
    //<editor-fold defaultstate="collapsed" desc="Listar Funcionarios">
    public int employeesListScreen(){
        option = listScreen.employeeListScreen();
        if(option == -1)
            logoutRequest = true;
        
        return option;
    }  
    public int employeeListScreenLevel(){
        do{
            option = listScreen.inputLevel();

            if(option == 0)
                listScreen.mInvalidOption();
            
        }while(option == 0);
        
        return option;
    }
    public int employeeListScreenFloor(){
        do{
            option = listScreen.inputFloor();

            if(option == 0)
                listScreen.mInvalidOption();
        }while(option == 0);
        
        return option;
    }
    
//</editor-fold>
   
    
    
}
