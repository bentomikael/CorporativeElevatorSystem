package sistemaelevadorcorporativo;

import java.util.Scanner;

/**
 *
 * @author 
 */
public class MainScreen {
    public ElevatorControl control;
    
    public MainScreen(){
        control = new ElevatorControl();
        key = new Scanner(System.in);
    }
    
   /**
    * Loga armazenando o usuario em control.atualUser
    */
    public void login(){

        System.out.println("--------LOGIN WITH YOU EMPLOYEE CARD / CODE--------");
                
            inputInt(0);
            if(control.getEmployeeWithCode(option) == null){ 
                control.mNotFound();
                login();
            }else{
                control.setActualUser(option); 
                home();
            }
            
    }
    

    // tela inicial
    public void home(){
        System.out.println(control.getActualUser().getCurrentFloor());
        System.out.println("\n\n--------WELCOME TO CORPORATIVE ELEVATOR SYSTEM--------\n");
        control.mChoseOption();
        System.out.println("1- Go to Floor");
        //só mostra opçao pra quem tem autorização
        if(control.getActualUser().getAccessLevelNumber()>= 3 )       
            System.out.println("2- Administrative Options");        
      
        do{
            inputInt(2);
            // verifica se o usuario digitou '2' sem ter autorização
            if(option == 2 && control.getActualUser().getAccessLevelNumber() < 3){
                option = 0;
                control.mInvalidOption();
            }
        }while(option == 0 );
        
        switch(option){
            case 1:
                new FloorScreen().FloorScreen();
                break;
            case 2:  
                new AdministrativeScreen().AdministrativeScreen();
                break;
        }
        
    }
    
     
}
