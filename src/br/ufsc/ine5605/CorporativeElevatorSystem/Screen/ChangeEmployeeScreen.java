package br.ufsc.ine5605.CorporativeElevatorSystem.Screen;

public class ChangeEmployeeScreen extends Screen{

    public ChangeEmployeeScreen() {
    }
    
    
    public int inputCode(){
        
        System.out.println("\n--------CHANGE ACCESS LEVEL OF EMPLOYEE--------\n");
        System.out.println("Code Of Employee To Change Access Level:");               
        return inputInt(0);
    }
    
    public int inputOccupation(int actualUserLevel){
        System.out.println("\n New Occupation For This User:");
        System.out.println("0 - Visitor");
        mAccessLevelOptions(actualUserLevel-1,"",0);
        return inputInt(actualUserLevel-1);
    }
}
