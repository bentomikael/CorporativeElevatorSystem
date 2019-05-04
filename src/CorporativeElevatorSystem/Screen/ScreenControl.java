package CorporativeElevatorSystem.Screen;

public class ScreenControl {
    private HomeScreen homeScreen;
    private LoginScreen loginScreen;
    private FloorScreen floorScreen;
    private AdministrativeOptionsScreen admScreen;
    private ReportScreen repScreen;
    private AddEmployeeScreen addScreen;
    private DelEmployeeScreen delScreen;
    private ChangeEmployeeScreen changeScreen;
    private EmployeeListScreen listScreen;
    
    public ScreenControl() {
        homeScreen = new HomeScreen();
        loginScreen = new LoginScreen();
        floorScreen = new FloorScreen();
        admScreen = new AdministrativeOptionsScreen();
        repScreen = new ReportScreen();
        addScreen = new AddEmployeeScreen();
        delScreen = new DelEmployeeScreen();
        changeScreen = new ChangeEmployeeScreen();
        listScreen = new EmployeeListScreen();
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

    public int administrativeOptionsScreen() {
        return admScreen.AdministrativeOptionsScreen();
    }
    
    public void addEmployeeScreen(){
        
    }
    
    public void removeEmployeeScreen(){}
    public void changeEmployeeScreen(){}
    public void reportScreen(){}
    public void employeesListScreen(){}    
            
    
}
