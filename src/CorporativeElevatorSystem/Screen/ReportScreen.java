package CorporativeElevatorSystem.Screen;

/**
 *
 * @author Acer
 */
public class ReportScreen extends Screen{
    public void ReportScreen(){
        System.out.println("--------GET REPORTS OF SYSTEM--------");
        mChoseOption();
        System.out.println("1 - History of Floor");
        System.out.println("2 - History of Employee");
        System.out.println("3 - History of Day");
        System.out.println("4 - History of registered employees");
        System.out.println("5 - History of removed employees");
        inputInt(5);
        
        switch(option){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
                        default:
                            reportScreen();
                            break;
            }
        
        
    }
}
