package CorporativeElevatorSystem.Screen;

public class ChangeEmployeeScreen extends Screen{

    public ChangeEmployeeScreen() {
    }
    
    
    public int inputCodeScreen(){
        
        System.out.println("--------CHANGE ACCESS LEVEL OF EMPLOYEE--------");
        System.out.println("Code Of Employee To Change Access Level:");               
        return inputInt(0);
    }
    
    public int inputOccupationOScreen(int actualUserLevel){
        System.out.println("New Occupation For This User:");
        System.out.println("0 - Visitor");
        mAccessLevelOptions(actualUserLevel-1,"");
        return inputInt(actualUserLevel-1);
    }
}
