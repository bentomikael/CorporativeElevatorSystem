package br.ufsc.ine5605.CorporativeElevatorSystem.Screen;

/**
 *
 * @author Acer
 */
public class EmployeeListScreen extends Screen{

    public EmployeeListScreen() {
    }
    
    
    public int employeeListOptions() {
        System.out.println("--------LISTS OF EMPLOYEES--------");
        mChoseOption();
        System.out.println("1 - All Employees");
        System.out.println("2 - Employees Per Occupation");
        System.out.println("3 - Employees Per Floor");
        System.out.println("4 - Employees In Work");
        do{
            option = inputInt(4);
            if(option == 0)
                mInvalidOption();
        }while(option == 0);
        
        return option;

    }
    
    public int inputLevel(){
        System.out.println("\n INSERT EMPLOYEE OCCUPATIION");
        mAccessLevelOptions(5, "");
        return inputInt(5);
    }
    
    public int inputFloor(){
        System.out.println("\n INSERT THE FLOOR \n");
        mAccessLevelOptions(5, "Floor");
        return inputInt(5);
    }
    
}
