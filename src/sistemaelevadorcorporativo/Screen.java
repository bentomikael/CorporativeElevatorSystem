package sistemaelevadorcorporativo;

import java.util.Scanner;

/**
 *
 * @author Mikael
 */
public class Screen {
    private Scanner key;
    private ElevatorControl control;
    private Employee actualUser;
    private int option;
    
    //variaveis de controle
    private String toInt; 
    private boolean valid;

    
    public Screen(){
        key = new Scanner(System.in);
        control = new ElevatorControl();
        actualUser = control.registerNewEmployee(999,Occupation.CEO,"TESTER",20,Gender.MALE); //TESTE, apagar depois
    }
    
    //loga no sistema
    public Employee login(){
        System.out.println("--------LOGIN WITH YOU EMPLOYEE CARD / CODE--------");
        toInt = key.nextLine();
         
        if(control.stringToInt(toInt) != 0) 
            option = control.stringToInt(toInt); //converte String para Int e armazena 
        else
            login();
        
        if(control.getEmployeeWithCode(option) == null){
            System.out.println("EMPLOYEE NOT FOUND, TRY AGAIN");
            login();
        }else
            actualUser = control.getEmployeeWithCode(option);
        home();
        return control.getEmployeeWithCode(option);
        
    }
    
    // tela inicial
    private void home(){
        System.out.println("--------WELCOME TO ELEVATOR SYSTEM 1.0--------");
        System.out.println("Chose one option:");
        System.out.println("1- Go to Floor");
        //verifica se o usuario tem autorização administrativa ou +, se nao tiver, nem mostra a opção
        if(actualUser.getLevelAccessNumber()>= 3 )       
            System.out.println("2- Administrative Options");        

        do{
            toInt = key.nextLine(); 
            if(control.stringToInt(toInt) != 0) 
                option = control.stringToInt(toInt); //converte String para Int e armazena 
            else
                home();
        switch(option){
            case 1:
                floorScreenFront();
                break;
            case 2:  
                if(actualUser.getLevelAccessNumber()>= 3)
                    administrativeScreen();
                    break;
            default:
                System.out.println("INVALID OPTION, TRY AGAIN");
        }
        }while(option != 1 && option != 2);
    }
    
    //tela de opçoes administrativas
    private void administrativeScreen(){
        System.out.println("--------ADMINISTRATIVE SESION--------");
        System.out.println("Chose one option:");
        System.out.println("1 - Register New Employee");
        System.out.println("2 - Remove Employee");
        System.out.println("3 - Change Access Level of one employee");
        System.out.println("4 - Reports");
        System.out.println("0 - Back To Home");
                
        toInt = key.nextLine(); 
        if(control.stringToInt(toInt) != 0 && control.stringToInt(toInt) < 5) 
            option = control.stringToInt(toInt); //converte String para Int e armazena 
        else{
            System.out.println("INVALID OPTION, TRY AGAIN");
            administrativeScreen();
        }
    
        switch(option){
            case 0:
                home();
                break;
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
            }
        
    }
    
    //exibe somente as opções de acordo com o nivel de acesso
    private void floorScreenFront(){
        System.out.println("--------CHOOSE THE FLOOR--------");
        System.out.println("Chose one option:");
        
        if(actualUser.getCurrentFloor() != 0)
            System.out.println("0 - Get of the Floor");
        if(actualUser.getLevelAccessNumber() >= 0)    
            System.out.println("1 - First Floor");
        if(actualUser.getLevelAccessNumber() >= 1)
            System.out.println("2 - Employee Floor");
        if(actualUser.getLevelAccessNumber() >= 2)
            System.out.println("3 - Manager Floor");
        if(actualUser.getLevelAccessNumber() >= 3)
            System.out.println("4 - Administrative Floor");
        if(actualUser.getLevelAccessNumber() >= 4)
            System.out.println("5 - Executive Floor");
        if(actualUser.getLevelAccessNumber() >= 5)
            System.out.println("6 - CEO Floor");  
       
        System.out.println("7 - Back to Home / logout");
        floorScreenBack();
            
  
    }
    
    private void floorScreenBack(){
        option = key.nextInt();
        key.nextLine();
        
        valid = false;
        do{                   
            String erro = "INVALID OPTION, TRY AGAIN";

            switch(option){
                case 0:
                    control.exitOfFloor(actualUser);
                    System.out.println("BYE, SEE YOU LATER");
                    login();
                    break;
                case 7:
                    login();
                    break;
                case 1:
                    if(actualUser.getLevelAccessNumber()>= 0)                             
                        
                    else
                        System.out.println(erro);
                    valid = true;
                    break;
                case 2:
                     if(actualUser.getLevelAccessNumber()>= 1)                             
                        
                    else
                        System.out.println(erro);
                    valid = true;
                    break;
                case 3:
                     if(actualUser.getLevelAccessNumber()>= 2)                             
                        
                    else
                        System.out.println(erro);
                    valid = true;
                    break;
                case 4:
                     if(actualUser.getLevelAccessNumber()>= 3)                             
                        
                    else
                        System.out.println(erro);
                    valid = true;
                    break;
                case 5:
                     if(actualUser.getLevelAccessNumber()>= 4)                             
                        
                    else
                        System.out.println(erro);
                    valid = true;
                    break;
                case 6:
                     if(actualUser.getLevelAccessNumber()== 5)                             
                        
                    else
                        System.out.println(erro);
                    valid = true;
                    break;
            }
        }while(!valid);
    }
    
    private void reportScreen(){
        System.out.println("--------GET REPORTS OF SYSTEM--------");
        System.out.println("Chose one option:");
        System.out.println("1 - History of Floor");
        System.out.println("2 - History of Employee");
        System.out.println("3 - History of Day");
        System.out.println("4 - History of registered employees");
        System.out.println("5 - History of removed employees");
        System.out.println("0 - Back To Home");
        option = key.nextInt();
        key.nextLine();
        
        valid = false;
        do{
            switch(option){
                case 0:
                    login();
                    valid = true;
                    break;
                case 1:
                    valid = true;
                    break;
                case 2:
                    valid = true;
                    break;
                case 3:
                    valid = true;
                    break;
                default:
                    System.out.println("INVALID OPTION, TRY AGAIN");
                    break;          
            }
        }while(!valid);
    }
    
    //Tela para adicionar funcionario
    private void newEmployeeScreen(){        
        String name = "";
        int age = 0;
        Gender gender = null;
        int code = 0;
        Occupation level = Occupation.VISITOR; //valor generico só para instanciar
       
        // recebe nome
        System.out.println("-------RESGISTER NEW EMPLOYEE-------");
        System.out.println("00 - TO CANCEL ACTION AND GO TO HOME / LOGOUT");
        System.out.println("Name:");
        do{ 
            name = key.nextLine();
            if(name.equals("00")){login();}
            
            if(name.length() < 3 ||
               name.length() > 30){ //verifica tamanho minimo e maximo para o nome
                valid = false;
                System.out.println("INVALID LENGTH OF NAME");
            }else 
                valid = name.matches("[A-Z a-z Çç]{"+name.length()+"}");//verifica se contem apenas letras

            if(valid == false)
                System.out.println("INVALID NAME, TRY AGAIN");
        
        }while(valid == false);
        
        // recebe idade
        System.out.println("Age:");
        do{
            toInt = key.nextLine();
            if(toInt.equals("00") ){login();}

            if(control.stringToInt(toInt) != 0){
                age = control.stringToInt(toInt);
                valid = true;
            }else{
                valid = false;
            }
        }while(valid == false);
        
        //recebe genero
        System.out.println("Gender: \n"+ "1 to Male \n2 to Female");
        do{
            toInt = key.nextLine();
            if(toInt.equals("00")){login();}
            
            if(control.stringToInt(toInt) != 0){
                option = control.stringToInt(toInt);
                valid = true;
            }else{
                valid = false;
            }
            if(option == 1)
                gender = Gender.MALE;
            else if(option == 2)
                gender = Gender.FEMALE;
            else
                System.out.println("INVALID OPTION, TRY AGAIN");
        }while(option != 1 && option != 2);
        
        //recebe codigo
        System.out.println("Code Access:");
        do{          
            toInt = key.nextLine();
            if(toInt.equals("00") ){login();}

            if(control.stringToInt(toInt) != 0){
                code = control.stringToInt(toInt);
                valid = true;
            }else{
                valid = false;
            }
            if(valid == true)
                if(control.getEmployeeWithCode(code) != null){    //se o codigo for valido,verifica se ja existe 
                System.out.println("EMPLOYEE ALREADY REGISTERED,TRY OTHER CODE ");
                valid = false;
            }
        }while(valid == false);
            
        // recebe o nivel de acesso
        System.out.println("level Access:");
        int n = 0;
        for(Occupation o: Occupation.values()){ // mostra somente cargos que esse usuario pode criar
            
            if(actualUser.getLevelAccessNumber() <= o.getAccessLevelNumber())
                break;
            System.out.println(n+ " - " + o);
            n++;
        }
        do{
            toInt = key.nextLine();
            if(toInt.equals("00") ){login();}

            if(toInt.matches("[0-5]{"+toInt.length()+"}")){
                level.setLevelAccess(Integer.valueOf(toInt));
                valid = true;
            }else{
                System.out.println("INVALID LEVEL ACCESS, TRY AGAIN");
                valid = false;
            }
            if(level.getAccessLevelNumber() >= actualUser.getLevelAccessNumber()){
                valid = false;
                System.out.println("YOU CANT CREATE A NEW EMPLOYEE WITH ACCESS LEVEL BIGGER OR EQUAL YOURS");
            }
        }while(valid == false);
        
        System.out.println("SUCCEFULL");
        control.registerNewEmployee(code,level,name,age,gender);
        
        login();
    }
    
    //tela para apagar funcionario
    private void deleteEmployeeScreen(){
        System.out.println("--------REMOVE EMPLOYEE--------");
        System.out.println("Code of Employee to remove");
        System.out.println("00 - TO CANCEL ACTION AND GO TO HOME / LOGOUT");

        
        do{        
            toInt = key.nextLine();
            if(toInt.equals("00")){login();}

            if(control.stringToInt(toInt) != 0) {
                option = control.stringToInt(toInt); //converte String para Int e armazena 
                valid = true;
            }else
                valid = false;  
        }while(!valid);
        
        if(control.getEmployeeWithCode(option) != null) // se existir
            if(control.getEmployeeWithCode(option).getLevelAccessNumber() >= actualUser.getLevelAccessNumber()){
                System.out.println("ACCESS DANIED");
                System.out.println("YOU DONT HAVE AUTHORIZATION TO DELETE THIS EMPLOYEE");
                deleteEmployeeScreen();
        }else{
            control.removeOneEmployeeWithCode(option);
        }
        login();
        
    }
    
    //altera nivel de acesso de um funcionario
    private void changeAccessLevelScreen(){
        Occupation access = Occupation.VISITOR;
        System.out.println("--------CHANGE ACCESS LEVEL OF EMPLOYEE--------");
        System.out.println("Code Of Employee To Change Access Level:");
        System.out.println("00 - TO CANCEL ACTION AND GO TO HOME / LOGOUT");

        do{        
            toInt = key.nextLine();
            if(toInt.equals("00")){login();}

            if(control.stringToInt(toInt) != 0) {
                option = control.stringToInt(toInt); //converte String para Int e armazena 
                valid = true;
            }else
                valid = false;  
        }while(!valid);
        
        System.out.println("New Access Level For This User:");
        access.setLevelAccess(key.nextInt());
        
        if(actualUser.getLevelAccessNumber() <= control.getEmployeeWithCode(option).getLevelAccessNumber()){
            System.out.println("ACCESS DANIED");
            System.out.println("YOU DONT HAVE AUTHORIZATION TO CHANGE THIS EMPLOYEE"); 
            changeAccessLevelScreen();
        }else{
            control.changeAccessLevel(option, access);
        }
        login();
    
    }
    
  
}