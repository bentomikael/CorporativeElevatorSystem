package br.ufsc.ine5605.CorporativeElevatorSystem;
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
        eControl.login(0);
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
        else{
            eControl.goToFloor(option);
            sControl.standBy();
            logout();
        }
        
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
    
    private void newEmployeeScreen() {
        options = new int[4];
        String name = sControl.addEmployeeScreenName();
        
        if( sControl.getLogoutRequest() == true )
            logout();
        else
            options[0] = sControl.addEmployeeScreenAge();
        
        if( sControl.getLogoutRequest() == true )
            logout();
        else
            options[1] = sControl.addEmployeeScreenGender();
        if( sControl.getLogoutRequest() == true )
            logout();
        else
            options[2] = sControl.addEmployeeScreenCode(eControl.getCodes(eControl.getAllEmployees()));
        if( sControl.getLogoutRequest() == true )
            logout();
        else
            options[3] = sControl.addEmployeeScreenLevel(eControl.getActualUserLevelNumber());
        if( sControl.getLogoutRequest() == true )
            logout();
        else{
            eControl.registerNewEmployee( options[2],
                    eControl.convertOccupation(options[3]),
                    name,
                    options[0],
                    eControl.convertGender(options[1]) );
            
            sControl.standBy();
            homeScreen(eControl.getActualUserLevelNumber());
        }
        
    }

    private void delEmployeeScreen() {
        options = new int[2];
        
        options[0] = sControl.delEmployeeCodeScreen(eControl.getCodes(eControl.getAllEmployees()) );
        if( sControl.getLogoutRequest() == true )
            logout();
        else
            options[1] = sControl.delEmployeeConfirmationScreen(
                         eControl.getActualUserLevelNumber(),
                         eControl.getEmployeeByCode(options[0]).getAccessLevelNumber(),
                         eControl.getEmployeeByCode(options[0]).getName());
        
        if( sControl.getLogoutRequest() == true )
            logout();
        else{
            eControl.removeEmployeeByCode(options[0]);
            sControl.standBy();
            homeScreen(eControl.getActualUserLevelNumber());
        }
    }
     
    private void changeAccessScreen() {
         options = new int[2];
         
        options[0] = sControl.changeEmployeeScreenCode( 
                     eControl.getActualUserCode(),
                     eControl.getCodes( eControl.getAllEmployees()) );
        
        if( sControl.getLogoutRequest() == true )
            logout();
        else
            if(sControl.checkAuthorization(
               eControl.getActualUserLevelNumber(),
               eControl.getEmployeeByCode(options[0]).getAccessLevelNumber()) )
            options[1] = sControl.changeEmployeeScreenLevel( eControl.getActualUserLevelNumber() );
        else
            logout();

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
                    eControl.getList( eControl.getAllEmployees() );                    
                    break;
                case 2:
                    eControl.getList( eControl.getEmployeesByLevelAccess(sControl.employeeListScreenLevel()) );
                    break;
                case 3:
                    eControl.getList( eControl.getEmployeeByFloor(sControl.employeeListScreenFloor()) );
                    break;
                case 4:
                    eControl.getList( eControl.getEmployeesInWork() );
                    break;
            }
        sControl.standBy();
        homeScreen(eControl.getActualUserLevelNumber());
    }
    
    
//</editor-fold>
       
}
