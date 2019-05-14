package br.ufsc.ine5605.CorporativeElevatorSystem.Screen;

public class AddEmployeeScreen extends Screen{
    
    public void AddEmployeeScreen(){     
    } 
    public String addEmployeeeScreen(){
        System.out.println("-------RESGISTER NEW EMPLOYEE-------");
        System.out.println("\n 00 - TO CANCEL ACTION AND LOGOUT");
        System.out.println("Name:"); 
        return key.nextLine();
    }
}
