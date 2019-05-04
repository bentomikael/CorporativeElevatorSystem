package CorporativeElevatorSystem.Screen;

class HomeScreen extends Screen{
    
     /**
      * 
      * @param userLevel indica qual o nivel de acesso do usuario
      * @return a opção escolhida
      */
    public int HomeScreen(int userLevel){
        System.out.println("\n\n--------WELCOME TO CORPORATIVE ELEVATOR SYSTEM--------\n");
        mChoseOption();
        System.out.println("1- Go to Floor");
        
        //só mostra e permite opçao pra quem tem autorização
        if(userLevel >= 3) {      
            System.out.println("2- Administrative Options");   
            return inputInt(2);
        }else
            return inputInt(1);
         
    }
}
