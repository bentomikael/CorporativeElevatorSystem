package CorporativeElevatorSystem.Screen;

public class FloorScreen extends Screen{
    
    public int FloorScreen(int userLevel,int currentFloor){
        System.out.println("\n\n--------CHOOSE THE FLOOR--------");
        mChoseOption();
        System.out.println("0 - Ground Floor");
       
        //exibe somente opções em que o funcionario tem autorização
        if(userLevel>= 1)
            System.out.println("1 - Employee Floor");
        if(userLevel >= 2)
            System.out.println("2 - Manager Floor");
        if(userLevel >= 3)
            System.out.println("3 - Administrative Floor");
        if(userLevel >= 4)
            System.out.println("4 - Executive Floor");
        if(userLevel == 5)
            System.out.println("5 - CEO Floor");  
       
        // só aceita andar que tenha autorização
        option = inputInt(userLevel);
        if(option == 0)
            mExit();
        else
            mEnteredFloor();
        
        return option;
            
    }
}
