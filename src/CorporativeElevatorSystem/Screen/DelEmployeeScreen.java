package CorporativeElevatorSystem.Screen;

/**
 *
 * @author Acer
 */
public class DelEmployeeScreen extends Screen{

    public DelEmployeeScreen() {
    }
    
    
    public int inputCodeScreen(){
        System.out.println("--------REMOVE EMPLOYEE--------");
        System.out.println("Code of Employee to remove:");
        return inputInt(0);        
    }
    
    public int inputConfirmationScreen(String name){
        System.out.println("\n Are you sure you want to permanently remove "+name+" from the system??".toUpperCase());
        System.out.println("1 - To confirm");
        System.out.println("0 - To cancel");
        return inputInt(1);
    }
}
