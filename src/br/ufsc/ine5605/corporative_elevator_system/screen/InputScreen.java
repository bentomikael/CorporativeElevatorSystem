package br.ufsc.ine5605.corporative_elevator_system.screen;

public class InputScreen {

    public InputScreen() {}
    
    
    public void inputFloor(){
        System.out.println("Floor:");
    }
    
    public void inputAge(){
        System.out.println("Input Age:");  
    }
    
    public void inputGender(){
        System.out.println("Gender: \n"+ "00 to Male \n" + "1 to Female");
    }
    
    public void inputCode(){
        System.out.println("Code Access:");
    }
    
    public void inputOccupation(){
        System.out.println("Employee Occupation:"); 
    }
    
    public void inputConfirmation(String name){
        System.out.println("\n Are you sure you want to permanently remove -"+name.toUpperCase()+"- from the system??");
        System.out.println("1 - To confirm");
    }
    
    public void inputDay(){
        System.out.println("Day (1-31):");
    }
    
    public void inputMonth(){
        System.out.println("Month (1-12)");
    }
    
    public void inputHour() {
        System.out.println("Input Hour ( 0 - 23) : ");        
    }
}
