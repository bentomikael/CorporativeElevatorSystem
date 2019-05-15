package br.ufsc.ine5605.CorporativeElevatorSystem.Controller;

import br.ufsc.ine5605.CorporativeElevatorSystem.Screen.AddEmployeeScreen;
import br.ufsc.ine5605.CorporativeElevatorSystem.Screen.AdministrativeOptionsScreen;
import br.ufsc.ine5605.CorporativeElevatorSystem.Screen.ChangeEmployeeScreen;
import br.ufsc.ine5605.CorporativeElevatorSystem.Screen.DelEmployeeScreen;
import br.ufsc.ine5605.CorporativeElevatorSystem.Screen.EmployeeListScreen;
import br.ufsc.ine5605.CorporativeElevatorSystem.Screen.FloorScreen;
import br.ufsc.ine5605.CorporativeElevatorSystem.Screen.HomeScreen;
import br.ufsc.ine5605.CorporativeElevatorSystem.Screen.InputScreen;
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
    private InputScreen inputScreen;
    
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
        inputScreen = new InputScreen();
        
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
    
    public int login(ArrayList allCodes){
        logoutRequest = false;
        int code;
     
        do{
            valid = true;
            code = loginScreen.login();
            if(code <= 999 ){
                valid = false;
                loginScreen.mInvalidCode();
            }
            else if(!allCodes.contains(code)){
                valid = false;
                loginScreen.mNotFound();
            }
        }while(!valid);
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
        do{
            option = floorScreen.floorOptions(actualUserLevel,currentFloor);
            if(option == currentFloor)
                floorScreen.mInvalidOption();
        }while(option == currentFloor);
        
        switch(option){
            case -1:
                logoutRequest = true;
                break;
            case 0:
                System.out.println("YOU OUT OF THE FLOOR"); 
                System.out.println("BYE BYE, SEE YOU LATER");
                
                break;
            default:
                System.out.println("\n YOU WENT TO FLOOR " + option+ "\n\n\n");
        }
       
        return option;
    } 

    public int administrativeOptions() {
        option = admScreen.administrativeOptions();
        if(option == -1)
            logoutRequest = true;
        else if(option == 0){
            homeScreen.mInvalidOption();
            administrativeOptions();
        }
         
        return option;
    }
    
    //<editor-fold defaultstate="collapsed" desc="Adicionar funcionario">
    public String addEmployeeName(){
        
        String name;
        do{ 
            valid = true;
            name = addScreen.addEmployeeeScreen();
            
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
        
        option = inputScreen.inputAge();
        if(option == -1)
            logoutRequest = true;
        
        return option;
    }
    public int addEmployeeGender(){
        
        do{
            valid = true;
            option = inputScreen.inputGender();
            
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
            code = inputScreen.inputCode();
            
            if(code == -1)
                logoutRequest = true;
            else if(codesArray.contains(code)){
                valid = false;
                changeScreen.mAlreadyRegistered();
            }else if(code <= 999 && code > 9999){
                addScreen.mInvalidCode();
                valid = false;
            }
        }while(!valid);
        
        return code;
    }
    public int addEmployeeOccupation(int actualUserLevel){  
        
        int level = inputScreen.inputOccupation(actualUserLevel);
        
        switch(level){
            case -1:
                logoutRequest = true;
                break;
            case 0:
                addScreen.mInvalidOption();
                addEmployeeOccupation(actualUserLevel);
                break;
            default:
                System.out.println("\n --NEW EMPLOYEE REGISTERED SUCCESSFULL--\n");
                break;
        }
        return level;
    }

//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Remover funcionario">
    public int delEmployeeCode(ArrayList codesArray){
        int code;
        delScreen.delEmployeeScreen();
        do{
            valid = true;
            code = inputScreen.inputCode();
            if(code == -1)
                logoutRequest = true;
            else if(code <= 999 && code > 9999){
                    delScreen.mInvalidCode();
                    valid = false;
                }
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
            option = inputScreen.inputConfirmation(userToDelName);
        
        if(option == 0){
            delScreen.mCanceled();
            logoutRequest = true;
        }
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
            code = changeScreen.changeEmployeeScreen();
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
        int level = inputScreen.inputOccupation(actualUserLevel); 
        switch(level){
            case -1:
                logoutRequest = true;
                break;
            case 0:
                addScreen.mInvalidOption();
                addEmployeeOccupation(actualUserLevel);
                break;
            default:
                System.out.println("\n --EMPLOYEE CHANGED SECCESSFULL-- \n");
                break;
        }
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
    
    //<editor-fold defaultstate="collapsed" desc="Obter Relatorios">
    public int reportScreen(int actualUserLevel){
        option = repScreen.reportScreen();
        
        switch(option){
            case 0:
                repScreen.mInvalidOption();
                reportScreen(actualUserLevel);
                break;
            case -1:
                logoutRequest = true;
                break;
        }
        
        return option;
    }
    public int reportScreenFloor(){
        option = inputScreen.inputFloor();
        if(option == -1)
            logoutRequest = true;
        
        return option;
    }
    public int reportScreenCode(){
        option = inputScreen.inputCode();
         if(option == -1)
            logoutRequest = true;
        
        return option;
    }
    public int reportScreenDay(){
        option = inputScreen.inputDay();
        if(option == -1)
            logoutRequest = true;
        
        return option;
    }
    public int reportScreenOccupation(){
        option = inputScreen.inputOccupation(5);// 5 para exivbir todos
        if(option == -1)
            logoutRequest = true;
        
        return option;
        
    }
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Listar Funcionarios">
    public int employeesList(){
        option = listScreen.employeeListOptions();
        if(option == -1)
            logoutRequest = true;
        
        return option;
    }  
    public int employeeListOccupation(){
        do{
            option = inputScreen.inputOccupation(5);

            if(option == 0)
                listScreen.mInvalidOption();
            
        }while(option == 0);
        
        return option;
    }
    public int employeeListFloor(){
        do{
            option = inputScreen.inputFloor();

            if(option == 0)
                listScreen.mInvalidOption();
        }while(option == 0);
        
        return option;
    }
    
//</editor-fold>
   
    
    
}
