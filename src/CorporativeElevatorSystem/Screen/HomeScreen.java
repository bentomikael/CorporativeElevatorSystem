package CorporativeElevatorSystem.Screen;

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
        
        //só mostra e permite opçao pra quem tem autorização
        do{
            if(userLevel >= 3) {      
                System.out.println("2- Administrative Options");   
                option = inputInt(2);
            }else
                option = inputInt(1);
            if(option == 0)
                mInvalidOption();
        }while(option == 0);
        
        return option;
    }
}
