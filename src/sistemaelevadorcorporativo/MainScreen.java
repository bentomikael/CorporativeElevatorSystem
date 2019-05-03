package sistemaelevadorcorporativo;

import java.util.Scanner;

/**
 *
 * @author 
 */
public class MainScreen {
    public Scanner key;             // entrada de dados
    public ElevatorControl control;
    public int option;              //variável auxiliar para selecionar opções 
    
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
    public void logout(){
        control.mLogout();
        login();
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
    
    /**
     * Recebe uma String,garante que contem apenas numeros e converte para int.
     * entra em loop até um valor correto ser inserido.
     * @param maxValue maior numero de entrada permitido
     * @return option
    */
    public int inputInt(int maxValue){
        String toInt; 
        boolean valid;
        System.out.println("\n 0 - TO CANCEL ACTION AND LOGOUT");
        
        do{
            toInt = key.nextLine();
        
            if(toInt.equals("0")){ 
                logout();
            } 
        
           if(control.stringToInt(toInt) != 0) { // verifica se a String contem apenas numeros
                option = Integer.parseInt(toInt);  //converte para int
                valid = true;
            }else
                valid = false;
           
           // verifica se esta no limite indicado. se limite = 0,limite infinito
           if(valid == true && option > maxValue && maxValue != 0){ 
               valid = false;
               control.mInvalidOption();
           }
        }while(!valid);
        
        return option;
  }
    
            
   
}
