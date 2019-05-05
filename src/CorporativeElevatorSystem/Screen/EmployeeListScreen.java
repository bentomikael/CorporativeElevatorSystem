package CorporativeElevatorSystem.Screen;

/**
 *
 * @author Acer
 */
public class EmployeeListScreen extends Screen{

    public EmployeeListScreen() {
    }
    
    public int employeeListScreen() {
        System.out.println("--------LISTS OF EMPLOYEES--------");
        mChoseOption();
        System.out.println("1 - All Employees");
        System.out.println("2 - Employees Per Access Level");
        System.out.println("3 - Employees Per Floor");
        System.out.println("4 - Employees In Work");
        do{
            option = inputInt(4);
            if(option == 0)
                mInvalidOption();
        }while(option == 0);
        
        return option;

    }
}
