package CorporativeElevatorSystem.Screen;

/**
 *
 * @author Acer
 */
public class ReportScreen extends Screen{

    public ReportScreen() {
    }
    
    
    public void reportScreen(){
        System.out.println("--------GET REPORTS OF SYSTEM--------");
        mChoseOption();
        System.out.println("1 - History of Floor");
        System.out.println("2 - History of Employee");
        System.out.println("3 - History of Day");
        System.out.println("4 - History of registered employees");
        System.out.println("5 - History of removed employees");
        inputInt(5);    
    }
}
