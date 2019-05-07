package br.ufsc.ine5605.CorporativeElevatorSystem.Screen;

public class FloorScreen extends Screen{

    public FloorScreen() {
    }
     
    public int floorScreen(int userLevel,int currentFloor){
        System.out.println("\n\n--------CHOOSE THE FLOOR--------");
        mChoseOption();
        System.out.println("0 - Ground Floor");
        mAccessLevelOptions(userLevel,"Floor");
       
        // só aceita andar que tenha autorização
        option = inputInt(userLevel);
        if(option == 0)
            mExit();
        else
            mEnteredFloor();
        
        return option;
            
    }
}
