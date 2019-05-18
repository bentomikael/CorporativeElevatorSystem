package br.ufsc.ine5605.corporative_elevator_system.screen;

public class InputScreen {

    public InputScreen() {}
    
    
    public void inputFloor(){
        System.out.println("\n\nFloor:");
    }
    
    public void inputAge(){
        System.out.println("\n\nInput Age:");  
    }
    
    public void inputGender(){
        System.out.println("\n\nGender: \n"+ "0 to Male \n" + "1 to Female");
    }
    
    public void inputCode(){
        System.out.println("\n\nCode Access:");
    }
    
    public void inputOccupation(){
        System.out.println("\n\nEmployee Occupation:"); 
    }
    
    public void inputConfirmation(String name){
        System.out.println("\n Are you sure you want to permanently remove ->"+name.toUpperCase()+"<- from the system??\n");
        System.out.println("1 - To confirm");
    }
    
    public void inputDay(){
        System.out.println("\n\nDay (1-31):");
    }
    
    public void inputMonth(){
        System.out.println("\n\nMonth (1-12)");
    }
    
    public void inputHour() {
        System.out.println("\n\nInput Hour ( 0 - 23) : ");        
    }
}
