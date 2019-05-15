package br.ufsc.ine5605.CorporativeElevatorSystem.Screen;

public class AdministrativeOptionsScreen extends Screen{

    public AdministrativeOptionsScreen() {
    }
    
    public int administrativeOptions(){
        System.out.println("\n--------ADMINISTRATIVE SESION--------");
        mChoseOption();
        System.out.println("1 - Register New Employee");
        System.out.println("2 - Remove Employee");
        System.out.println("3 - Change Access Level of one employee");
        System.out.println("4 - Reports");
        System.out.println("5 - List of Employees");
        
        do{
            option = inputInt(5);
            if(option == 0)
                mInvalidOption();
        }while(option == 0);
        
        return option;
    } 
    
    
}
