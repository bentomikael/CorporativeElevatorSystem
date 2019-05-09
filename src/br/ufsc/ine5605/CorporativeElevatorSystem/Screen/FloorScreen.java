package br.ufsc.ine5605.CorporativeElevatorSystem.Screen;

public class FloorScreen extends Screen{

    public FloorScreen() {
    }
     
    public int floorOptions(int userLevel,int currentFloor){
        System.out.println("\n\n--------CHOOSE THE FLOOR--------");
        mChoseOption();
        mAccessLevelOptions(userLevel,"Floor",currentFloor);
       
        // só aceita andar que tenha autorização
        return inputInt(userLevel);  
    }
}
