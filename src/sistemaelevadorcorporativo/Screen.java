package sistemaelevadorcorporativo;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class Screen {
    private Scanner key;// entrada de dados 
    private ElevatorControl control;
    private int option; //variável auxiliar para selecionar opções 
    
    public Screen(){
        key = new Scanner(System.in);
        control = new ElevatorControl();
    }
    
    /**
     * Recebe uma String,garante que contem apenas numeros e converte para int.
     * repete o metodo até um valor correto ser inserido.
     * Trata maioria dos erros do programa
     * return option
    * @param maxValue maior numero de entrada permitido
    */
    private int inputInt(int maxValue){
        String toInt; 
        boolean valid;
        System.out.println("00 - TO CANCEL ACTION AND GO TO LOGIN SCREEN / LOGOUT");
        do{
            toInt = JOptionPane.showInputDialog("Input Only Numbers \n");
//            toInt = key.nextLine();
        
            if(toInt.equals("00")){   // 00 volta para a tela de login 
                logout();
            } 
        
           if(control.stringToInt(toInt) != 0) {   // verifica se a String contem apenas numeros
                option = Integer.parseInt(toInt);  //converte para int
                valid = true;
            }else
                valid = false;
           
           // verifica se esta no limite indicado. se limite = 0,limite infinito
           if(valid == true && option > maxValue && maxValue != 0){ 
               valid = false;
               System.out.println("INVALID OPTION, TRY AGAIN");
           }
        }while(!valid);
        
        return option;
  }
    
   /**
    * Loga armazenando o usuario em control.atualUser
    */
    public void login(){
        System.out.println("--------LOGIN WITH YOU EMPLOYEE CARD / CODE--------");
        inputInt(0);
        
        if(control.getEmployeeWithCode(option) == null){ // se não encontrar o funcionário reinicia o método 
            System.out.println("EMPLOYEE NOT FOUND, TRY AGAIN");
            login();
        }else
            control.setActualUser(option);
        home();        
    }
    private void logout(){
        login();
    }

    
    //<editor-fold defaultstate="collapsed" desc="Telas do programa">
    // tela inicial
    private void home(){
        System.out.println("--------WELCOME TO ELEVATOR SYSTEM 1.0--------");
        System.out.println("Chose one option:");
        System.out.println("1- Go to Floor");
        //verifica se o usuario tem autorização administrativa ou +, se nao tiver, nem mostra a opção
        if(control.getActualUser().getAccessLevelNumber()>= 3 )       
            System.out.println("2- Administrative Options");        
      
        do{
            inputInt(2);
            
            // verifica se o usuario digitou '2' sem ter autorização
            if(option == 2 && control.getActualUser().getAccessLevelNumber() < 3){
                option = 0;
                System.out.println("INVALID OPTION, TRY AGAIN");
            }
        }while(option == 0 );
        
        switch(option){
            case 1:
                floorScreen();
                break;
            case 2:  
                administrativeScreen();
                break;
        }
        
    }
    
    //incompleto
    private void floorScreen(){
        System.out.println("--------CHOOSE THE FLOOR--------");
        System.out.println("Chose one option:");
        
        //exibe somente opções em que o funcionario tem autorização
        if(control.getActualUser().getCurrentFloor() != 0)
            System.out.println("0 - Get of the Floor");
        if(control.getActualUser().getAccessLevelNumber()>= 0)    
            System.out.println("1 - First Floor");
        if(control.getActualUser().getAccessLevelNumber()>= 1)
            System.out.println("2 - Employee Floor");
        if(control.getActualUser().getAccessLevelNumber() >= 2)
            System.out.println("3 - Manager Floor");
        if(control.getActualUser().getAccessLevelNumber() >= 3)
            System.out.println("4 - Administrative Floor");
        if(control.getActualUser().getAccessLevelNumber() >= 4)
            System.out.println("5 - Executive Floor");
        if(control.getActualUser().getAccessLevelNumber() >= 5)
            System.out.println("6 - CEO Floor");  
       
        // só aceita andar que tenha autorização
        inputInt(control.getActualUser().getAccessLevelNumber() + 1);

        switch(option){
            case 0:
                if(control.getActualUser().getCurrentFloor() != 0){
                control.exitOfFloor(control.getActualUser());
                System.out.println("BYE, SEE YOU LATER");
                logout();
                }else{
                    System.out.println("YOU NEED BE IN ONE FLOOR TO GET OF");
                floorScreen();
                }
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            }
    }
        
    //tela de opçoes administrativas
    private void administrativeScreen(){
        System.out.println("--------ADMINISTRATIVE SESION--------");
        System.out.println("Chose one option:");
        System.out.println("1 - Register New Employee");
        System.out.println("2 - Remove Employee");
        System.out.println("3 - Change Access Level of one employee");
        System.out.println("4 - Reports");
        System.out.println("5 - List of Employees");
        inputInt(5);
    
        switch(option){
            case 1:
                newEmployeeScreen();
                break;
            case 2:
                deleteEmployeeScreen();
                break;
            case 3:
                changeAccessLevelScreen();
                break;
            case 4:
                reportScreen();
                break;      
            case 5:
                listScreen();
                break;
            }
        
    }
    
    //incompleto
    private void reportScreen(){
        System.out.println("--------GET REPORTS OF SYSTEM--------");
        System.out.println("Chose one option:");
        System.out.println("1 - History of Floor");
        System.out.println("2 - History of Employee");
        System.out.println("3 - History of Day");
        System.out.println("4 - History of registered employees");
        System.out.println("5 - History of removed employees");
        inputInt(5);
        
        switch(option){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            }
        
    }

    //Tela para adicionar funcionario
    private void newEmployeeScreen(){        
        String name = "";
        int age = 0;
        People.Gender gender = null;
        int code = 0;
        Employee.Occupation level = null;
        boolean valid;
       
        // recebe nome
        System.out.println("-------RESGISTER NEW EMPLOYEE-------");
        System.out.println("00 - TO CANCEL ACTION AND GO TO HOME / LOGOUT");
        System.out.println("Name:");
       
        do{ 
            name = key.nextLine();
            if(name.equals("00")){
                logout();
            }            
                //verifica se contem apenas letras
                valid = name.matches("[A-Z a-z Çç]{"+name.length()+"}");

            if(valid == false)
                System.out.println("INVALID NAME, TRY AGAIN");
        
        }while(!valid);
        
        // recebe idade
        System.out.println("Age:");
        age = inputInt(0);
        
        //recebe genero
        System.out.println("Gender: \n"+ "1 to Male \n2 to Female");
        
            do{ inputInt(2);
                System.out.println("INVALID NUMBER");
            }while(option == 0) ; 
            
            if(option == 1)
                gender = People.Gender.MALE;
            else if(option == 2)
                gender = People.Gender.FEMALE;
        
        //recebe codigo
        System.out.println("Code Access:");
        do{          
            code = inputInt(0);
            
            //verifica se ja existe 
            if(control.getEmployeeWithCode(code) != null){    
               System.out.println("EMPLOYEE ALREADY REGISTERED,TRY OTHER CODE ");
               valid = false;
            }
        }while(!valid);
            
        // recebe o nivel de acesso
        System.out.println("level Access:");
        int n = 0;
        
        //mostra somente cargos que esse usuario pode criar
        for(Employee.Occupation o: Employee.Occupation.values()){ 
            
            if(control.getActualUser().getAccessLevelNumber()<= o.accessLevel)
                break;
            System.out.println(n+ " - " + o);
            n++;
        }
        do{
            level.setAccessLevel(inputInt(5));
            
            if(level.accessLevel >= control.getActualUser().getAccessLevelNumber()){
                valid = false;
                System.out.println("YOU CANT CREATE A NEW EMPLOYEE WITH ACCESS LEVEL BIGGER OR EQUAL YOURS");
            }
            else 
                valid = true;
        }while(!valid);
        
        control.registerNewEmployee(code,level,name,age,gender);
        logout();
    }
    
    //tela para apagar funcionario
    private void deleteEmployeeScreen(){
        System.out.println("--------REMOVE EMPLOYEE--------");
        System.out.println("Code of Employee to remove");
        inputInt(0);
        
        // verifica se existe
        if(control.getEmployeeWithCode(option) != null) 
            //verifica se nivel é menor que usuario atual
            if(control.getEmployeeWithCode(option).getAccessLevelNumber() >=
               control.getActualUser().getAccessLevelNumber()){
                System.out.println("ACCESS DANIED");
                System.out.println("YOU DONT HAVE AUTHORIZATION TO DELETE THIS EMPLOYEE");
                deleteEmployeeScreen();
        }else{
            control.removeOneEmployeeWithCode(option);
        }
        logout();
        
    }
    
    //tela para alterar nivel de acesso de um funcionario
    private void changeAccessLevelScreen(){
        int userCode ;
          
        Employee.Occupation access = Employee.Occupation.VISITOR; // valor genérico
        
        System.out.println("--------CHANGE ACCESS LEVEL OF EMPLOYEE--------");
        System.out.println("Code Of Employee To Change Access Level:");

        userCode = inputInt(0);
        
        //verifica se não é o propio codigo e se nao achou usuario
        if(control.getActualUser().getCodeAccess() == userCode) {
           System.out.println("YOU CANT CHANGE YOUR OWN ACCESS LEVEL");
           changeAccessLevelScreen();
        }else if(control.getEmployeeWithCode(userCode) == null){ 
            System.out.println("Employee Not Found");
            changeAccessLevelScreen();
        }
        
        System.out.println("New Access Level For This User:");
        
        access.setAccessLevel(inputInt(5));
        
        if(control.getActualUser().getAccessLevelNumber()<=
           control.getEmployeeWithCode(userCode).getAccessLevelNumber()){
            System.out.println("ACCESS DANIED");
            System.out.println("YOU DONT HAVE AUTHORIZATION TO CHANGE THIS EMPLOYEE"); 
            changeAccessLevelScreen();
        }else{
            control.changeAccessLevel(userCode, access );
        }
        logout();
    
    }

    //tela de lista de funcionarios
    private void listScreen() {
        System.out.println("--------LISTS OF EMPLOYEES--------");
        System.out.println("1 - All Employees");
        System.out.println("2 - Employees Per Access Level");
        System.out.println("3 - Employees Per Floor");
        System.out.println("4 - Employees In Work");
        inputInt(4);
        
        switch(option){
            case 1:
                control.outputListNames(control.getAllEmployees());
                break;
            case 2:
                System.out.println("Enter Level Number");
                inputInt(5);
                control.outputListNames(control.getEmployeesListPerLevelAccess(option));
                break;
            case 3:
                System.out.println("Enter Floor Number");
                inputInt(5);
                control.outputListNames(control.getEmployeePerFloor(option));
                break;
            case 4:
                control.outputListNames(control.getEmployeesInWork());
                break;
        }

    }
//</editor-fold>
    
   
}
