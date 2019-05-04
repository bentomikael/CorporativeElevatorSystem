package sistemaelevadorcorporativo;

import java.util.Scanner;

public abstract class Screen implements IMessages{
    public Scanner key; // entrada de dados
    public EmployeeControl eControl;
    protected int option;

    
    /**
     * Recebe uma String,garante que contem apenas numeros e converte para int.
     * entra em loop até um valor correto ser inserido.
     * @param maxValue maior numero de entrada permitido
     * @return option
    */
    public int inputInt(int maxValue){
        String toInt; 
        boolean valid = false;
        System.out.println("\n 0 - TO CANCEL ACTION AND LOGOUT");
        
        do{
            toInt = key.nextLine();
        
            if(toInt.equals("0")){ 
                logout();
            } 
            
           // verifica se a String contem apenas numeros
           if(toInt.matches("[0-9]{"+toInt.length()+"}")) { 
                option = Integer.parseInt(toInt);  //converte para int
                valid = true;
            }else{
               mInvalidOption();
           }
           
           // verifica se esta no limite indicado. se limite = 0,limite infinito
           if(valid == true && option > maxValue && maxValue != 0){ 
               valid = false;
               mInvalidOption();
           }
        }while(!valid);
        
        return option;
  }
    
    public void logout(){
        mLogout();
        
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
    public void mActualUser(){
        System.out.println("Actual User: "+eControl.getActualUser().getName());
    }
     @Override
    public void mOnlyNumbers(){
        System.out.println("ONLY NUMBER ARE ALLOWED\n\n TRY AGAIN");
    }
    
//</editor-fold>
        
}
