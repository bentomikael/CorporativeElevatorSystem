package br.ufsc.ine5605.CorporativeElevatorSystem.Screen;

public class HomeScreen extends Screen{

    public HomeScreen() {}
    
     /**
      * @param userLevel indica qual o nivel de acesso do usuario atual
      * @return o numero da opção escolhida
      */
    public int homeScreen(int userLevel){
        System.out.println("\n\n--------WELCOME TO CORPORATIVE ELEVATOR SYSTEM--------\n");
        mChoseOption();
        System.out.println("1- Go to Floor");
        
            if(userLevel >= 3) {      
                System.out.println("2- Administrative Options");   
                option = inputInt(2);
            }else
                option = inputInt(1);
        
        return option;
    }
}
