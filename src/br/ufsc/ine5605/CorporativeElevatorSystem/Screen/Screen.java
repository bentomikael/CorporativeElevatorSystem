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
        System.out.println("00 - TO CANCEL ACTION AND LOGOUT \n");
       
        do{
            toInt = key.nextLine();
            if(toInt.equals("")){
                valid = false;
                mInvalidOption();
            }else if(!toInt.equals("00")){
           
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
    
    //Fica esperando o usuario para prosseguir, semelhante a função 'pause'
    public void standBy(){
        System.out.println("\n Insert one key to continue \n");
        key.nextLine();
    }
        
    //<editor-fold defaultstate="collapsed" desc="Mensagens">
        
     @Override
    public void mSuccessAdd() {
        System.out.println("\n --NEW EMPLOYEE REGISTERED SUCCESSFULL--\n");  
    }
     @Override
    public void mSuccessDel() {
        System.out.println("\n--EMPLOYEE REMOVED SUCCESSFULL--\n");
    }
     @Override
     public void mSuccessChange(){
         System.out.println("\n --EMPLOYEE CHANGED SECCESSFULL-- \n");
     }
     @Override
    public void mInvalidName() {
        System.out.println("\n--INVALID NAME! TRY AGAIN--\n");
    }
     @Override
    public void mInvalidOption() {
        System.out.println("\n--INVALID OPTION! TRY AGAIN--\n");
    }
     @Override
    public void mDontHavePermision() {
        System.out.println("\n--YOU DONT HAVE PERMISSION TO EXECUTE THIS OPERATION--");
         System.out.println("DISCONNECTING...\n");
    }
     @Override
    public void mLogout() {
        System.out.println("\n--LOGOUT SUCCESSFULL--");
    }
     @Override
    public void mAlreadyRegistered() {
        System.out.println("\n --USER ALREADY REGISTERED--");
    }
     @Override
    public void mChangeSelfErro() {
        System.out.println("\n --YOU CAN'T CHANGE YOURS OWN ACCESS LEVEL--");
    }
     @Override
    public void mNotFound() {
        System.out.println("\n --USER NOT FOUND--");
    }
     @Override
    public void mChoseOption() {
        System.out.println("Chose One Option: \n");
    }
     @Override
    public void mExit(){
        System.out.println("\n BYE, SEE YOU LATER");  
    }
     @Override
    public void mEnteredFloor(){
         System.out.println("\n YOU WENT TO FLOOR " + option+ "\n\n\n");
    }
     @Override
     public void mCanceled(){
         System.out.println("\n ACTION CANCELED");
     }
     @Override
    public void mAccessLevelOptions(int actualUserLevel, String text){
        if(actualUserLevel>= 1)
            System.out.println("1 - Simple Employee "+ text);
        if(actualUserLevel >= 2)
            System.out.println("2 - Manager "+ text);
        if(actualUserLevel >= 3)
            System.out.println("3 - Administrative "+text);
        if(actualUserLevel >= 4)
            System.out.println("4 - Executive "+text);
        if(actualUserLevel == 5)
            System.out.println("5 - CEO "+text);  
    }
    
//</editor-fold>
        
}
