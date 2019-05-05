package CorporativeElevatorSystem;
class MainControl {
    private EmployeeControl eControl;
    private ScreenControl sControl;
    private int option;
    private int[] options;
    
    public MainControl() {
        eControl = new EmployeeControl();
        sControl = new ScreenControl();
    }
    
    //<editor-fold defaultstate="collapsed" desc="Login">
    /** 
     * Pega os dados da tela pelo controlador de tela.
     * Verifica a existencia do usuario,caso não exista, repete.
     * Atribui o usuario atual e usa o nivel de acesso para iniciar homeScreen.
    */
    public void start(){        
        do{
            eControl.login( sControl.login() );
        }while( eControl.getActualUser() == null );
        
        homeScreen( eControl.getActualUserLevelNumber() );

    }
    private void logout(){
        start();
       }
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Controle de açoes por tela">
    /**
     * @param actualAccessLevel nivel do usuario atual(recebe valor de start())
     * Se usuario escolheu opção 1 vai pra tela de andares.
     * Se usuario escolheru 2 vai pra tela de opçoes administrativas.
    */
    private void homeScreen( int actualAccessLevel ) {
        
        option = sControl.home( actualAccessLevel );
        if( sControl.getLogoutRequest() == true )
            logout();
        else
            switch(option){
                case 1:
                    floorScreen();
                    break;
                case 2:
                    administrativeOptionsScreen();
                    break;
            }     
    }

    private void floorScreen(){
        option = sControl.floorScreen( eControl.getActualUserLevelNumber(),
                                       eControl.getActualUserFloor() );
        if( sControl.getLogoutRequest() == true )
            logout();
        else
            eControl.goToFloor(option);
        
    }

    private void administrativeOptionsScreen() {
        
        option = sControl.administrativeOptionsScreen();
        if( sControl.getLogoutRequest() == true )
            logout();
        else
            switch(option){
                case 1:
                    newEmployeeScreen();
                    break;
                case 2:
                    delEmployeeScreen();
                    break;
                case 3:
                    changeAccessScreen();
                    break;
                case 4:
                    reportsScreen();
                    break;
                case 5:
                    listScreen();
                    break;
            }
    }
    
    private void newEmployeeScreen() {}

    private void delEmployeeScreen() {}
     
    private void changeAccessScreen() {
         
        options[0] = sControl.changeEmployeeScreenCode( 
                     eControl.getActualUserCode(),
                     eControl.getCodes( eControl.getAllEmployees()) );
        if( sControl.getLogoutRequest() == true )
            logout();
        else
            options[1] = sControl.changeEmployeeScreenLevel( eControl.getActualUserLevelNumber() );

        if( sControl.getLogoutRequest() == true )
            logout();
        else{
            eControl.changeAccessLevel(options[0], options[1]);
            logout();
        }
    }

    private void reportsScreen(){}

    private void listScreen() {
        
        option = sControl.employeesListScreen();
        if( sControl.getLogoutRequest() == true )
            logout();
        else
            switch(option){
                case 1:
                    eControl.getNames( eControl.getAllEmployees() );                    
                    break;
                case 2:
                    eControl.getNames( eControl.getEmployeesByLevelAccess(option) );
                    break;
                case 3:
                    eControl.getNames( eControl.getEmployeeByFloor(option) );
                    break;
                case 4:
                    eControl.getNames( eControl.getEmployeesInWork() );
                    break;
            }
        sControl.standBy();
        homeScreen(eControl.getActualUserLevelNumber());
    }
    
//</editor-fold>
       
}
