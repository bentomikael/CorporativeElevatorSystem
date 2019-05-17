package br.ufsc.ine5605.corporative_elevator_system.screen;

public class HomeScreen {

    public HomeScreen() {}
    
    public void homeScreen(boolean administrative){
        System.out.println("\n\n--------WELCOME TO CORPORATIVE ELEVATOR SYSTEM--------\n");
        System.out.println("1- Go to Floor");
        if(administrative)
            System.out.println("2- Administrative Options");   

    }
}
