package sistemaelevadorcorporativo;

import java.util.Scanner;

/**
 *
 * @author 
 */
public class MainScreen {
    public Scanner         key;// entrada de dados 
    public ElevatorControl control;
    public int             option; //variável auxiliar para selecionar opções 
    
    public MainScreen(){
        key = new Scanner(System.in);
        control = new ElevatorControl();
    }
    
   /**
    * Loga armazenando o usuario em control.atualUser
    */
    public void login(){
        System.out.println("--------LOGIN WITH YOU EMPLOYEE CARD / CODE--------");
                
        do{
            inputInt(0);
            if(control.getEmployeeWithCode(option) == null){ 
                control.mNotFound();
            }else
                control.setActualUser(option); 
            
        }while(control.getEmployeeWithCode(option) == null);
    }
    public void logout(){
        control.mLogout();
        control.start();
    }

    // tela inicial
    public void home(){
        System.out.println("--------WELCOME TO CORPORATIVE ELEVATOR SYSTEM--------");
        control.mChoseOption();
        
        System.out.println("1- Go to Floor");
        //verifica se o usuario tem autorização administrativa ou +, se nao tiver, nem mostra a opção
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
