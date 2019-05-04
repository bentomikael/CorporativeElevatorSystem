package CorporativeElevatorSystem.Screen;

/**
 *
 * @author Acer
 */
public class EmployeeListScreen extends Screen{
    public void EmployeeListScreen() {
        System.out.println("--------LISTS OF EMPLOYEES--------");
        mChoseOption();
        System.out.println("1 - All Employees");
        System.out.println("2 - Employees Per Access Level");
        System.out.println("3 - Employees Per Floor");
        System.out.println("4 - Employees In Work");
        inputInt(4);
        
        switch(option){
            case 1:
                eControl.getNames(eControl.getAllEmployees());
                break;
            case 2:
                System.out.println("Enter Level Number");
                inputInt(5);
                eControl.getNames(eControl.getEmployeesByLevelAccess(option));
                break;
            case 3:
                System.out.println("Enter Floor Number");
                inputInt(6);
                eControl.getNames(eControl.getEmployeeByFloor(option));
                break;
            case 4:
                eControl.getNames(eControl.getEmployeesInWork());
                break;
            default:
                listScreen();
                break;
        }

    }
}
