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
            System.out.println("\n\n\n\n--LOGOUT SUCCESSFULL--");
        return logoutRequest;
    }
    
    public int login(){
        logoutRequest = false;
        int code;
        do{
            code = loginScreen.login();
            if(code == 0)
                loginScreen.mNotFound();
        }while(code == 0);
        return code;
    }
    
    public int home(int actualUserLevel){
        option = homeScreen.homeScreen(actualUserLevel);
        
        if(option == -1)
            logoutRequest = true;
        else if(option == 0){
            homeScreen.mInvalidOption();
            home(actualUserLevel);
        }
        
        return option;
    }

    public int floor(int actualUserLevel,int currentFloor) {
        option = floorScreen.floorOptions(actualUserLevel,currentFloor);
        if(option == -1)
           logoutRequest = true;
        else if(option == 0){
                System.out.println("YOU OUT OF THE FLOOR"); 
                System.out.println("BYE BYE, SEE YOU LATER");
            }else
                System.out.println("\n YOU WENT TO FLOOR " + option+ "\n\n\n");
       
        return option;
    }

    public int administrativeOptions() {
        option = admScreen.administrativeOptions();
        if(option == -1)
            logoutRequest = true;
         
        return option;
    }
    
    //<editor-fold defaultstate="collapsed" desc="Adicionar funcionario">
    public String addEmployeeName(){
        
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
                System.out.println("\n--INVALID NAME! TRY AGAIN--\n");
            
        }while(!valid);
         
        return name;
    }
    public int addEmployeeAge(){
        
        option = addScreen.inputAge();
        if(option == -1)
            logoutRequest = true;
        
        return option;
    }
    public int addEmployeeGender(){
        
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
    public int addEmployeeCode(ArrayList codesArray){ 
        int code ;
        
        do{
            valid = true;
            code = addScreen.inputCode();
            
            if(code == -1)
                logoutRequest = true;
            else if(codesArray.contains(code)){
                valid = false;
                changeScreen.mAlreadyRegistered();
            }
            
        }while(!valid);
        
        return code;
    }// retornado codigo == genero
    public int addEmployeeOccupation(int actualUserLevel){  
        
        int level = addScreen.inputOccupation(actualUserLevel);
        if(level == -1)
            logoutRequest = true;
        else
            System.out.println("\n --NEW EMPLOYEE REGISTERED SUCCESSFULL--\n");
        
        return level;
    }

//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Remover funcionario">
    public int delEmployeeCode(ArrayList codesArray){
        int code;
        do{
            valid = true;
            code = delScreen.inputCode();
            if(code == -1)
                logoutRequest = true;
            else if(!codesArray.contains(code)){
                valid = false;
                changeScreen.mNotFound();
            }
        }while(!valid);
        return code;
    }
    public int delEmployeeConfirmation(int actualUserLevel,int userToDelLevel,String userToDelName){
        
        if(actualUserLevel <= userToDelLevel){
            delScreen.mDontHavePermision();
            logoutRequest = true;
            standBy();   
        }else
            option = delScreen.inputConfirmation(userToDelName);
        
        if(option == 0)
            delScreen.mCanceled();
        else
            System.out.println("\n--EMPLOYEE REMOVED SUCCESSFULL--\n");
        
        return option;
    }
    
//</editor-fold> 
    
    //<editor-fold defaultstate="collapsed" desc="Alterar cargo de funcionario">
    public int changeEmployeeCode(int actualUserCode,ArrayList codesArray){
        int code;
        int level;
        do{
            valid = true;
            code = changeScreen.inputCode();
            if(code == -1)
                logoutRequest = true;
            else
                if(!codesArray.contains(code)){
                    valid = false;
                    changeScreen.mNotFound();
                }else if(code == actualUserCode){
                    valid = false;
                    System.out.println("\n --YOU CAN'T CHANGE YOURS OWN ACCESS LEVEL--");
                } 
            
        }while(!valid);
        
        return code;
    }
    public int changeEmployeeOccupation(int actualUserLevel){
        int level = changeScreen.inputOccupation(actualUserLevel); 
        if(level == -1)
            logoutRequest = true;
        else
            System.out.println("\n --EMPLOYEE CHANGED SECCESSFULL-- \n");
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
    
//</editor-fold> //personalizar mensagem, opçoes de cargo 
    
    
    public void report(){}
    
    //<editor-fold defaultstate="collapsed" desc="Listar Funcionarios">
    public int employeesList(){
        option = listScreen.employeeListOptions();
        if(option == -1)
            logoutRequest = true;
        
        return option;
    }  
    public int employeeListOccupation(){
        do{
            option = listScreen.inputLevel();

            if(option == 0)
                listScreen.mInvalidOption();
            
        }while(option == 0);
        
        return option;
    }
    public int employeeListFloor(){
        do{
            option = listScreen.inputFloor();

            if(option == 0)
                listScreen.mInvalidOption();
        }while(option == 0);
        
        return option;
    }
    
//</editor-fold>
   
    
    
}
