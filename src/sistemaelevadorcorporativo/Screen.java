package sistemaelevadorcorporativo;

import java.util.Scanner;

/**
 *
 * @author Mikael
 */
public class Screen {
    Scanner key;
    int option;
    ElevatorControl control;
    Employee actualUser;
    
    public Screen(){
        key = new Scanner(System.in);
        control = new ElevatorControl();
    }
    
    
    public Employee login(){
        System.out.println("--------LOGIN WITH YOU EMPLOYEE CARD / CODE--------");
        option = key.nextInt();
        if(control.getEmployeeWithCode(option) == null){
            System.out.println("USER NOT REGISTERED IN THE SYSTEM");
            return null;
        }else{
            actualUser = control.getEmployeeWithCode(option);
            return control.getEmployeeWithCode(option);
        }
    }
    
    private void home(){
        //verifica se está logado
        if(actualUser != null){
            
        System.out.println("--------WELCOME TO ELEVATOR SYSTEM 1.0--------");
        System.out.println("Chose one option:");
        System.out.println("1- Go to Floor");
        if(actualUser.getLevelAccess()>= 4 )       //verifica se o usuario tem autorização administrativa ou +, se nao tiver, nem mostra a opção
            System.out.println("2- Administrative Options");
        option = key.nextInt();
        key.nextLine();
        
        do{
        switch(option){
            case 1:
                floorScreen();
                break;
            case 2:  
                if(actualUser.getLevelAccess()>= 4 )
                    administrativeScreen();
                else
                    System.out.println("ACCESS DANIED");
                break;
            default:
                System.out.println("INVALID OPTION, TRY AGAIN");
        }
        }while(option != 1 && option != 2);
    }else
        System.out.println("ACCESS DANIED");
    }
    
    private void administrativeScreen(){
        System.out.println("--------ADMINISTRATIVE SESION--------");
        System.out.println("Chose one option:");
        System.out.println("1 - Register New Employee");
        System.out.println("2 - Remove Employee");
        System.out.println("3 - Change Access Level of one employee");
        System.out.println("4 - Reports");
        System.out.println("0 - Back To Home");
        option = key.nextInt();
        key.nextLine();
        
        boolean control = false;
        do{
            switch(option){
                case 0:
                    home();
                    control = true;
                    break;
                case 1:
                    control = true;
                    break;
                case 2:
                    control = true;
                    break;
                case 3:
                    control = true;
                    break;
                case 4:
                    control = true;
                    break;
                case 5:
                    control = true;
                    break;
                case 6:
                    control = true;
                    break;
                default:
                    System.out.println("INVALID OPTION, TRY AGAIN");
                    break;
                    
            }
        }while(!control);

    }
    
    private void floorScreen(){
        System.out.println("--------CHOOSE THE FLOOR--------");
        System.out.println("Chose one option:");
        System.out.println("1 - First Floor");
        System.out.println("2 - Employee Floor");
        System.out.println("3 - Manager Floor");
        System.out.println("4 - Administrative Floor");
        System.out.println("5 - Executive Floor");
        System.out.println("6 - CEO Floor");  
        System.out.println("0 - Back to Home");
        option = key.nextInt();
        key.nextLine();
        
        boolean controlMenu = false;
        do{
            switch(option){
                case 0:
                    home();
                    controlMenu = true;
                    break;
                case 1:
                    if(actualUser.getLevelAccess() >= 1)                             
                        
                    else
                        System.out.println("ACCESS DANIED");
                    controlMenu = true;
                    break;
                case 2:
                     if(actualUser.getLevelAccess() >= 2)                             
                        
                    else
                        System.out.println("ACCESS DANIED");
                    controlMenu = true;
                    break;
                case 3:
                     if(actualUser.getLevelAccess() >= 3)                             
                        
                    else
                        System.out.println("ACCESS DANIED");
                    controlMenu = true;
                    break;
                case 4:
                     if(actualUser.getLevelAccess() >= 4)                             
                        
                    else
                        System.out.println("ACCESS DANIED");
                    controlMenu = true;
                    break;
                case 5:
                     if(actualUser.getLevelAccess() >= 5)                             
                        
                    else
                        System.out.println("ACCESS DANIED");
                    controlMenu = true;
                    break;
                case 6:
                     if(actualUser.getLevelAccess() == 6)                             
                        
                    else
                        System.out.println("ACCESS DANIED");
                    controlMenu = true;
                    break;
                default:
                    System.out.println("INVALID OPTION, TRY AGAIN");
                    break;
            }
        }while(!controlMenu);
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
        
        boolean control = false;
        do{
            switch(option){
                case 0:
                    home();
                    control = true;
                    break;
                case 1:
                    control = true;
                    break;
                case 2:
                    control = true;
                    break;
                case 3:
                    control = true;
                    break;
                default:
                    System.out.println("INVALID OPTION, TRY AGAIN");
                    break;          
            }
        }while(!control);
    }

    private void newEmployeeScreen(){
        int level = 0;
        int access = 0;
        String name;
        Gender gender = null;
        int age;
       
        System.out.println("-------RESGISTER NEW EMPLOYEE-------");
        System.out.println("Name:");
        name = key.nextLine();
        
        System.out.println("Age:");
        age = key.nextInt();
        
        System.out.println("Gender:" + "1 to Male /n 2 to Female");
        option = key.nextInt();
        do{
        if(option == 1)
            gender = Gender.MALE;
        else if(option == 2)
            gender = Gender.FEMALE;
        else
            System.out.println("INVALID NUMBER, TRY AGAIN");
        }while(option != 1 && option != 2);
        
        System.out.println("codeAccess:");
        access = key.nextInt();
        
        System.out.println("levelAccess:");
        level = key.nextInt();
        
         //tratamento de erros
        if(level > actualUser.getLevelAccess())
            System.out.println("ERROR, YOU DONT HAVE AUTHORIZATION TO CREATE A USER WITH ACCESS LEVEL BIG THAN YOURS");
        else if(control.getEmployeeWithCode(access) != null)
            System.out.println("EMPLOYEE ALREADY REGISTERED");
        else
            control.registerNewEmployee(access,level,name,age,gender);
    }
    
    
}