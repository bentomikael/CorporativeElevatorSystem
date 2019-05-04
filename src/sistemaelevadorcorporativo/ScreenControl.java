package sistemaelevadorcorporativo;

public class ScreenControl {
    private HomeScreen homeScreen;
    private LoginScreen loginScreen;
    private FloorScreen floorScreen;
    private AdministrativeScreen admScreen;
//    private ReportScreen repScreen;
//    private AddEmployeeScreen addScreen;
//    private DelEmployeeScreen delScreen;
//    private ChangeEmployeeScreen changeScreen;
//    private EmployeeListScreen listScreen;
    
    public ScreenControl() {
        homeScreen = new HomeScreen();
        loginScreen = new LoginScreen();
        floorScreen = new FloorScreen();
        admScreen = new AdministrativeScreen();
//        repScreen = new
//        addScreen = new
//        delScreen = new 
//        changeScreen = new
//        listScreen = new
    }
    
    public int login(){
        return loginScreen.LoginScreen();
    }
    
    public int home(int userLevel){            
        return homeScreen.HomeScreen(userLevel);
    }

    public int floorScreen(int userLevel,int currentFloor) {
        return floorScreen.FloorScreen(userLevel,currentFloor);
    }

    public void administrativeScreen() {}
    public void reportScreen(){}
    public void newEmployeeScreen(){}
    public void removeEmployeeScreen(){}
    public void changeEmployeeScreen(){}
    public void employeesListScreen(){}    
    
    
    
}
