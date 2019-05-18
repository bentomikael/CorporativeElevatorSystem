package br.ufsc.ine5605.corporative_elevator_system.screen;

import java.util.ArrayList;
import java.util.Scanner;

public class ScreenView implements IMessages{
    
    //<editor-fold defaultstate="collapsed" desc="Declaração de variaveis">
    
    private boolean logoutRequest;
    private boolean valid;
    private int option;
    private Scanner key; // entrada de dados
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
   
    public ScreenView() {
        //<editor-fold defaultstate="collapsed" desc="Instancias">
        logoutRequest = false;
        key = new Scanner(System.in);
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
    
    
    /**
     * Recebe uma String,garante que contem apenas numeros e converte para int.
     * entra em loop até um valor correto ser inserido.
     * @param maxValue maior numero de entrada permitido
     * @return retorna inteiro positivo, se retornar -1 indica logout.
    */
    private int inputInt(int maxValue){
        String toInt ;
        mToExit();
        do{ 
            toInt = key.nextLine();

            if(toInt.equals("")){
                valid = false;
                mInvalidOption();
            }else if(!toInt.equals("00")){
           
                try{
                     option = Integer.valueOf(toInt);  //converte para int
                     valid=true;
                }catch(NumberFormatException e){
                    valid=false;
                    mInvalidCode();
                }

                // verifica se esta no limite indicado. se limite = 0,limite infinito
                if(valid == true && maxValue != 0 && option > maxValue){ 
                    valid = false;
                    mInvalidOption();
                }
            }else{
                valid = true;
                option = -1;
            }
        }while(!valid);
        
        return option;
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
            loginScreen.login();
            valid = true;
            code = inputInt(0);
            
            if(code <= 999 || code > 9999){
                valid = false;
                mInvalidCode();
            }
            else if(!allCodes.contains(code)){
                valid = false;
                mNotFound();
            }
        }while(!valid);
        return code;
    }
    
    public int home(int actualUserLevel){
        
        if(actualUserLevel >= 3) { 
            homeScreen.homeScreen(true);
            option = inputInt(2);
        }else{
            homeScreen.homeScreen(false);
            option = inputInt(1);
        }
        
        if(option == -1)
            logoutRequest = true;
        else if(option == 0){
            mInvalidOption();
            home(actualUserLevel);
        }
        
        return option;
    }

    public int floor(int actualUserLevel) {
    
        floorScreen.floorOptions();
        mAccessLevelOptions(actualUserLevel,"Floor");
        option = inputInt(actualUserLevel);

        if(option == -1)
            logoutRequest = true;
  
        return option;
    } 

    public int administrativeOptions() {
        admScreen.administrativeOptions();
        option = inputInt(5); 
        
        if(option == -1)
            logoutRequest = true;
        else if(option == 0){
            mInvalidOption();
            administrativeOptions();
        }
         
        return option;
    }
    
    //<editor-fold defaultstate="collapsed" desc="Adicionar funcionario">
    public String addEmployeeName(){
        
        String name;
        do{ 
            valid = true;
            addScreen.addEmployeeeScreen();
            name = key.nextLine();
            
            //verifica se contem apenas letras
            valid = name.matches("[A-Z a-z Çç]{"+name.length()+"}");
            
            if(name.equals("00")){
                logoutRequest = true;
                valid = true;
            }
            
            if(valid == false)
                mInvalidName();
            
        }while(!valid);
         
        return name;
    }
    
    public int addEmployeeAge(){
        
        inputScreen.inputAge();
        option = inputInt(0);
        
        if(option == -1)
            logoutRequest = true;
        
        return option;
    }
    
    public int addEmployeeGender(){
        
            inputScreen.inputGender();
            option = inputInt(1);
            
            if(option == -1)
                logoutRequest = true;

        return option;  
    }
    
    public int addEmployeeCode(ArrayList codesArray){ 
        int code ;
        
        do{
            valid = true;
            inputScreen.inputCode();
            code = inputInt(0);
            
            if(code == -1)
                logoutRequest = true;
            else if(codesArray.contains(code)){
                valid = false;
                mAlreadyRegistered();
            }else if(code <= 999 || code > 9999){
                mInvalidCode();
                valid = false;
            }
        }while(!valid);
        
        return code;
    }
    
    public int addEmployeeOccupation(int actualUserLevel){  
        
        inputScreen.inputOccupation();
        mAccessLevelOptions(actualUserLevel-1,"");
        int level = inputInt(actualUserLevel-1);
        
        switch(level){
            case -1:
                logoutRequest = true;
                break;
            case 0:
                mInvalidOption();
                addEmployeeOccupation(actualUserLevel);
                break;
            default:
                System.out.println("\n ##NEW EMPLOYEE REGISTERED SUCCESSFULL## \n");
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
            inputScreen.inputCode();
            code = inputInt(0);
            
            if(code == -1)
                logoutRequest = true;
            else if(code <= 999 || code > 9999){
                    mInvalidCode();
                    valid = false;
                }
                else if(!codesArray.contains(code)){
                        valid = false;
                        mNotFound();
                    }
        }while(!valid);
        
        return code;
    }
    
    public int delEmployeeConfirmation(int actualUserLevel,int userToDelLevel,String userToDelName){
        
        if(actualUserLevel <= userToDelLevel){
            mDontHavePermision();
            logoutRequest = true;
            mStandBy();   
        }else{
            inputScreen.inputConfirmation(userToDelName);
            option = inputInt(1);
        
            if(option == 0 || option == -1)
                logoutRequest = true;
            else
                System.out.println("\n ##EMPLOYEE REMOVED SUCCESSFULL## \n");  
        }
        return option;
    } 
    
//</editor-fold> 
    
    //<editor-fold defaultstate="collapsed" desc="Alterar cargo de funcionario">
    public int changeEmployeeCode(int actualUserCode,ArrayList codesArray){
        int code;
        
        do{
            valid = true;
            changeScreen.changeEmployeeScreen();
            inputScreen.inputCode();
            code = inputInt(0);
            
            if(code == -1)
                logoutRequest = true;
            else if(!codesArray.contains(code)){
                    valid = false;
                    mNotFound();
                }else if(code == actualUserCode){
                    valid = false;
                    mChangeSelf();
                } 
                
            
        }while(!valid);
        
        return code;
    }
    
    public int changeEmployeeOccupation(int actualUserLevel){
        
        inputScreen.inputOccupation(); 
        mAccessLevelOptions(actualUserLevel-1,"");
        int level = inputInt(actualUserLevel-1);
        
        switch(level){
            case -1:
                logoutRequest = true;
                break;
            case 0:
                mInvalidOption();
                addEmployeeOccupation(actualUserLevel);
                break;
            default:
                System.out.println("\n ##EMPLOYEE CHANGED SECCESSFULL## \n");
                break;
        }
        
        return level;
    }
    
    public boolean checkAuthorization(int actualUserLevel,int userToChangeLevel){
        valid = true;
        
        if(actualUserLevel <= userToChangeLevel){
            valid = false;
            mDontHavePermision();
            logoutRequest = true;
        }
        
        return valid;   
    }
    
//</editor-fold> 
    
    //<editor-fold defaultstate="collapsed" desc="Obter Relatorios">
    public int reportScreen(int actualUserLevel){
        repScreen.reportScreen();
        option = inputInt(7);    

        switch(option){
            case 0:
                mInvalidOption();
                reportScreen(actualUserLevel);
                break;
            case -1:
                logoutRequest = true;
                break;
        }
        
        return option;
    }
    
    public int reportScreenFloor(){
        inputScreen.inputFloor();
        option = inputInt(5);
        
        if(option == -1)
            logoutRequest = true;
        
        return option;
    }
    
    public int reportScreenCode(ArrayList allCodes){
        int code;
        inputScreen.inputCode();
        do{
            valid = true;
            code = inputInt(0);
            
            if(code <= 999 || code > 9999){
                valid = false;
                mInvalidCode();
            }
            else if(!allCodes.contains(code)){
                valid = false;
                mNotFound();
            }
            if(option == -1)
                logoutRequest = true;
        }while(!valid);
        
        return option;
    }
    
    public int reportScreenDay(){
        inputScreen.inputDay();
        option = inputInt(31);

        if(option == -1)
            logoutRequest = true;
        
        return option;
    }
    
    public int reportScreenMonth(){
        inputScreen.inputMonth();
        option = inputInt(12);
        
        if(option == -1)
            logoutRequest = true;
        
        return option;
    }
    
    public int reportScreenHour(){
        inputScreen.inputHour();
        option = inputInt(23);
        
        if(option == -1)
            logoutRequest = true;
        
        return option;
        
    }
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Listar Funcionarios">
    public int employeesList(){
        listScreen.employeeListOptions();
        option = inputInt(4);
        if(option == 0){
            mInvalidOption();
            employeesList();
        }
        if(option == -1)
            logoutRequest = true;
        
        return option;
    }  
    
    public int employeeListOccupation(){
        do{          
            mAccessLevelOptions(5,"");
            inputScreen.inputOccupation();
            option = inputInt(5);
            
            if(option == 0)
                mInvalidOption();
            
            if(option == -1)
                logoutRequest = true;
            
        }while(option == 0);
        
        return option;
    }
    
    public int employeeListFloor(){
        
        mAccessLevelOptions(5, "Floor");
        inputScreen.inputFloor();
        option = inputInt(5);
        
        if(option == -1)
            logoutRequest = true;
        
        return option;
    }
    
//</editor-fold>
       
    //<editor-fold defaultstate="collapsed" desc="Mensagens">
        
    @Override
    public void mInvalidOption() {
        System.out.println("\n ***INVALID OPTION! TRY AGAIN*** \n\n");
    }
     
    @Override
    public void mInvalidCode(){
        System.out.println("\n ***INVALID CODE! THE CODE CONTAINS 4 NUMBERS*** \n\n\n");
    }
    
    @Override
    public void mInvalidName(){
        System.out.println("\n ***INVALID NAME! TRY AGAIN***\n");

    }
     
    @Override
    public void mDontHavePermision() {
        System.out.println("\n ***YOU DONT HAVE PERMISSION TO EXECUTE THIS OPERATION***");
         System.out.println("DISCONNECTING...\n\n\n");
    }
     
    @Override
    public void mAlreadyRegistered() {
        System.out.println("\n ***CODE ALREADY REGISTERED***\n\n\n");
    }
     
    @Override
    public void mNotFound() {
        System.out.println("\n ***USER NOT FOUND***\n\n\n");
    }
    
    @Override
    public void mChangeSelf(){
       System.out.println("\n ***YOU CAN'T CHANGE YOURS OWN ACCESS LEVEL***\n\n\n");
    }
     
    @Override
    public void mAccessLevelOptions(int actualUserLevel, String text){
        System.out.println("Chose One Option: ");
        
        if(text.equals("Floor"))
            System.out.println("0 - Ground Floor / Exit");
        
        if(actualUserLevel>= 1)
            System.out.println("1 - Simple Employee "+ text);
        if(actualUserLevel >= 2 )
            System.out.println("2 - Manager "+ text);
        if(actualUserLevel >= 3 )
            System.out.println("3 - Administrative "+text);
        if(actualUserLevel >= 4 )
            System.out.println("4 - Executive "+text);
        if(actualUserLevel == 5 )
            System.out.println("5 - CEO "+text);  
    }
    
    @Override
    public void mWentInFloor(int floor){
        System.out.println("\n ##YOU WENT TO FLOOR " +floor+ "##\n\n\n");
    }
    
    @Override
    public void mLeavingFloor(){
        System.out.println("##BYE BYE, SEE YOU LATER##\n\n\n");
    }
    
    //Fica esperando o usuario para prosseguir, semelhante a função 'pause'
    @Override
    public void mStandBy(){
        System.out.println("\n Press enter to continue...");
        key.nextLine();
    } 
    
    @Override
    public void mToExit() {
        System.out.println(" 00 - TO CANCEL AND LOGOUT  \n\n");
    }
    
//</editor-fold>
    

    
}
