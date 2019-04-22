package sistemaelevadorcorporativo;

import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class Screen {
    Scanner key;
    int option;
    
    public Screen(){
        key = new Scanner(System.in);
    }
    
    public void home(){
        System.out.println("--------WELCOME TO ELEVATOR SYSTEM 1.0--------");
        System.out.println("Chose one option:");
        System.out.println("1- Go to Floor");
        System.out.println("2- Administrative Options");
        option = key.nextInt();
        key.nextLine();
        
        do{
        switch(option){
            case 1:
                break;
            case 2:
                administrativeScreen();
                break;
            default:
                System.out.println("INVALID OPTION, TRY AGAIN");
        }
        }while(option != 1 && option != 2);
    }
    private void administrativeScreen(){
        System.out.println("--------ADMINISTRATIVE SESION--------");
        System.out.println("Chose one option:");
        System.out.println("1 - Register New Employee");
        System.out.println("2 - Remove Employee");
        System.out.println("3 - Change Access Level");
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
    private void reportScreen(){
        System.out.println("--------GET REPORTS OF SYSTEM--------");
        System.out.println("Chose one option:");
        System.out.println("1 - History of Floor");
        System.out.println("2 - History of Employee");
        System.out.println("3 - History of Day");
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
}
