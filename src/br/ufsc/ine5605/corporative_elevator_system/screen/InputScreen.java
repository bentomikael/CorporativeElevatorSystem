package br.ufsc.ine5605.CorporativeElevatorSystem.Screen;

public class InputScreen extends Screen{

    public InputScreen() {
    }
    
    public int inputFloor(){
        System.out.println("Floor:");
        return inputInt(5);
    }
    public int inputAge(){
        System.out.println("Age:");
        return inputInt(0);
    }
    public int inputGender(){
        System.out.println("Gender: \n"+ "1 to Male \n" + "2 to Female");
        return inputInt(2);
    }
    public int inputCode(){
        System.out.println("Code Access:");
        return inputInt(0);
    }
    public int inputOccupation(int actualUserLevel){
        System.out.println("Employee Occupation:");
        mAccessLevelOptions(actualUserLevel,"",0);
        return inputInt(actualUserLevel-1);
    }
    public int inputConfirmation(String name){
        System.out.println("\n Are you sure you want to permanently remove -"+name.toUpperCase()+"- from the system??");
        System.out.println("1 - To confirm");
        return inputInt(1);
    }
    public int inputDay(){
        System.out.println("Day (1-31):");
        return inputInt(31);
    }
    public int inputMonth(){
        System.out.println("Month (1-12)");
        return inputInt(12);
    }
    public int inputHour() {
        System.out.println("Input Hour ( 0 - 23) : ");
        return inputInt(23);
        
    }
}
