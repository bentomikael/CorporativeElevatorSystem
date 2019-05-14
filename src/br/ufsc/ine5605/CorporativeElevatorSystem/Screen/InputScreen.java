package br.ufsc.ine5605.CorporativeElevatorSystem.Screen;

public class InputScreen extends Screen{

    public InputScreen() {
    }
    
    public int inputFloor(){
        System.out.println("Floor:");
        return inputInt(5);
    }
    public int inputDay(){
        System.out.println("Day:");
        return inputInt(31);
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
        mAccessLevelOptions(actualUserLevel-1,"",0);
        return inputInt(actualUserLevel-1);
    }
    public int inputConfirmation(String name){
        System.out.println("\n Are you sure you want to permanently remove -"+name.toUpperCase()+"- from the system??");
        System.out.println("1 - To confirm");
        System.out.println("0 - To cancel");
        return inputInt(1);
    }
}
