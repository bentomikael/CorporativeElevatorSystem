package br.ufsc.ine5605.CorporativeElevatorSystem.Screen;

public class LoginScreen extends Screen{

    public LoginScreen() {
    }
    
    public int login(){
        System.out.println("--------LOGIN WITH YOU EMPLOYEE CARD / CODE--------");    
            return inputInt(0);  
    }       
    
}
