package br.ufsc.ine5605.CorporativeElevatorSystem.Screen;

public class FloorScreen extends Screen{

    public FloorScreen() {
    }
     
    public int floorOptions(int userLevel,int currentFloor){
        System.out.println("\n\n--------CHOOSE THE FLOOR--------");
        mChoseOption();
        System.out.println("0 - Ground Floor");
        mAccessLevelOptions(userLevel,"Floor");
       
        // só aceita andar que tenha autorização
        option = inputInt(userLevel);
        if(option == 0){
            System.out.println("YOU OUT OF THE FLOOR"); 
            System.out.println("BYE BYE, SEE YOU LATER");

        }else
            System.out.println("\n YOU WENT TO FLOOR " + option+ "\n\n\n");
        
        return option;
            
    }
}
