package br.ufsc.ine5605.CorporativeElevatorSystem.Screen;

import br.ufsc.ine5605.CorporativeElevatorSystem.IMessages;
import java.util.Scanner;

public abstract class Screen implements IMessages{
    protected Scanner key; // entrada de dados
    protected int option;

    public Screen() {
        key = new Scanner(System.in);
    }

    
    /**
     * Recebe uma String,garante que contem apenas numeros e converte para int.
     * entra em loop até um valor correto ser inserido.
     * @param maxValue maior numero de entrada permitido
     * @return retorna inteiro positivo, se retornar -1 indica logout.
    */
    public int inputInt(int maxValue){
        String toInt ; 
        boolean valid;
        System.out.println(" 00 - TO CANCEL ACTION AND LOGOUT -- \n");
       
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
                    mInvalidOption();
                    valid=false;
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
    
    //Fica esperando o usuario para prosseguir, semelhante a função 'pause'
    public void standBy(){
        System.out.println("\n Insert any key to continue...");
        key.nextLine();
    }
        
    //<editor-fold defaultstate="collapsed" desc="Mensagens">
        
     @Override
    public void mInvalidOption() {
        System.out.println("\n ***INVALID OPTION! TRY AGAIN*** \n");
    }
     @Override
     public void mInvalidCode(){
        System.out.println("\n ***INVALID CODE! THE CODE CONTAINS 4 NUMBERS*** \n");
    }
     @Override
    public void mDontHavePermision() {
        System.out.println("\n ***YOU DONT HAVE PERMISSION TO EXECUTE THIS OPERATION***");
         System.out.println("DISCONNECTING...\n");
    }
     @Override
    public void mAlreadyRegistered() {
        System.out.println("\n ***USER ALREADY REGISTERED***");
    }
     @Override
    public void mNotFound() {
        System.out.println("\n ***USER NOT FOUND***");
    }
     @Override
    public void mChoseOption() {
        System.out.println("Chose One Option: \n");
    }
     @Override
     public void mCanceled(){
         System.out.println("\n ***ACTION CANCELED***");
     }
     @Override
    public void mAccessLevelOptions(int actualUserLevel, String text,int currentFloor){
        if(currentFloor != 0)
             System.out.println("0 - Ground Floor / Exit");
        if(actualUserLevel>= 1 && currentFloor != 1)
            System.out.println("1 - Simple Employee "+ text);
        if(actualUserLevel >= 2 && currentFloor != 2)
            System.out.println("2 - Manager "+ text);
        if(actualUserLevel >= 3 && currentFloor != 3)
            System.out.println("3 - Administrative "+text);
        if(actualUserLevel >= 4 && currentFloor != 4)
            System.out.println("4 - Executive "+text);
        if(actualUserLevel == 5 && currentFloor != 5)
            System.out.println("5 - CEO "+text);  
    }
    
//</editor-fold>
        
}
