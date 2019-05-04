package CorporativeElevatorSystem.Screen;

import CorporativeElevatorSystem.IMessages;
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
        System.out.println("\n 00 - TO CANCEL ACTION AND LOGOUT");
       
        do{
            toInt = key.nextLine();
            if(!toInt.equals("00")){
           
                // verifica se a String contem apenas numeros
                if(toInt.matches("[0-9]{"+toInt.length()+"}")) { 
                    option = Integer.valueOf(toInt);  //converte para int
                    valid = true;
                }else{
                   mInvalidOption();
                   valid = false;
               }

                // verifica se esta no limite indicado. se limite = 0,limite infinito
                if(valid == true && option > maxValue && maxValue != 0){ 
                    valid = false;
                    mInvalidOption();
               }
            }else{
                valid = true;
                mLogout();
                option = -1;
            }
        }while(!valid);
        return option;
  }
        
    //<editor-fold defaultstate="collapsed" desc="Mensagens">
        
     @Override
    public void mSuccessAdd() {
         System.out.println("--NEW EMPLOYEE REGISTERED SUCCESSFULL--");  
    }
     @Override
    public void mSuccessDel() {
        System.out.println("--EMPLOYEE REMOVED SUCCESSFULL--");
    }
     @Override
    public void mInvalidName() {
        System.out.println("--INVALID NAME! TRY AGAIN--");
    }
     @Override
    public void mInvalidOption() {
        System.out.println("--INVALID OPTION! TRY AGAIN--");
    }
     @Override
    public void mDontHavePermision() {
        System.out.println("--YOU DONT HAVE PERMISSION TO EXECUTE THIS OPERATION--");
    }
     @Override
    public void mLogout() {
        System.out.println("--LOGOUT SUCCESSFULL--");
    }
     @Override
    public void mAlreadyRegistered() {
        System.out.println("--USER ALREADY REGISTERED--");
    }
     @Override
    public void mChangeSelfErro() {
        System.out.println("--YOU CAN'T CHANGE YOURS OWN ACCESS LEVEL--");
    }
     @Override
    public void mNotFound() {
        System.out.println("--USER NOT FOUND--");
    }
     @Override
    public void mChoseOption() {
        System.out.println("Chose One Option: \n");
    }
     @Override
    public void mExit(){
        System.out.println("BYE, SEE YOU LATER");  
    }
     @Override
    public void mOnlyNumbers(){
        System.out.println("ONLY NUMBER ARE ALLOWED\n\n TRY AGAIN");
    }
     @Override
    public void mEnteredFloor(){
         System.out.println("YOU WENT TO FLOOR " + option+ "\n\n\n");
    }
    
//</editor-fold>
        
}
