package br.ufsc.ine5605.CorporativeElevatorSystem;


public class MainControl {
    private EmployeeControl eControl;
    private ScreenControl sControl;
    private int[] options;  //usada para manipular as opçoes recebidas de tela
    
    public MainControl() {
        eControl = new EmployeeControl();
        sControl = new ScreenControl();
        options = new int[5];
        
    }
     
    //<editor-fold defaultstate="collapsed" desc="Login">
    /** 
     * Pega os dados da tela pelo controlador de tela.
     * Verifica a existencia do usuario,caso não exista, repete.
     * Atribui o usuario atual e usa o nivel de acesso para iniciar home.
    */
    public void start(){ 
        eControl.login(0);
        do{
            eControl.login( sControl.login() );
        }while( eControl.getActualUser() == null );
        
        home( eControl.getActualUserLevelNumber() );

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
    private void home( int actualAccessLevel ) {
        
        options[0] = sControl.home( actualAccessLevel );
        if( sControl.getLogoutRequest() == true )
            logout();
        else
            switch(options[0]){
                case 1:
                    floor();
                    break;
                case 2:
                    administrativeOptions();
                    break;
            }     
    }

    private void floor(){
        options[0] = sControl.floor( eControl.getActualUserLevelNumber(),
                                       eControl.getActualUserFloor() );
        if( sControl.getLogoutRequest() == true )
            logout();
        else{
            eControl.goToFloor(options[0]);
            sControl.standBy();
            logout();
        }
        
    }

    private void administrativeOptions() {
        
        options[0] = sControl.administrativeOptions();
        if( sControl.getLogoutRequest() == true )
            logout();
        else
            switch(options[0]){
                case 1:
                    newEmployee();
                    break;
                case 2:
                    delEmployee();
                    break;
                case 3:
                    changeAccess();
                    break;
                case 4:
                    report();
                    break;
                case 5:
                    list();
                    break;
            }
    }
    
    /**
     * Coleta informações e usa para registrar novo funcionario
     */
    private void newEmployee() {
        
        String name = sControl.addEmployeeName();
        
        if( sControl.getLogoutRequest() == true )
            logout();
        else
            options[0] = sControl.addEmployeeAge();
        
        if( sControl.getLogoutRequest() == true )
            logout();
        else
            options[1] = sControl.addEmployeeGender();
        if( sControl.getLogoutRequest() == true )
            logout();
        else
            options[2] = sControl.addEmployeeCode(eControl.getCodes(eControl.getAllEmployees()));
        if( sControl.getLogoutRequest() == true )
            logout();
        else
            options[3] = sControl.addEmployeeOccupation(eControl.getActualUserLevelNumber());
        if( sControl.getLogoutRequest() == true )
            logout();
        else{
            eControl.registerNewEmployee( 
                    options[2],
                    eControl.convertOccupation(options[3]),
                    name,
                    options[0],
                    eControl.convertGender(options[1]) );
            
            sControl.standBy();
            home(eControl.getActualUserLevelNumber());
        }
        
    }

    private void delEmployee() {
        
        options[0] = sControl.delEmployeeCode(eControl.getCodes(eControl.getAllEmployees()) );
        if( sControl.getLogoutRequest() == true )
            logout();
        else
            options[1] = sControl.delEmployeeConfirmation(
                         eControl.getActualUserLevelNumber(),
                         eControl.getEmployeeByCode(options[0]).getAccessLevelNumber(),
                         eControl.getEmployeeByCode(options[0]).getName());
        
        if( sControl.getLogoutRequest() == true )
            logout();
        else{
            eControl.removeEmployeeByCode(options[0]);
            sControl.standBy();
            home(eControl.getActualUserLevelNumber());
        }
    }
     
    private void changeAccess() {
         
        options[0] = sControl.changeEmployeeCode( 
                     eControl.getActualUserCode(),
                     eControl.getCodes( eControl.getAllEmployees()) );
        
        if( sControl.getLogoutRequest() == true )
            logout();
        else
            if(sControl.checkAuthorization(
               eControl.getActualUserLevelNumber(),
               eControl.getEmployeeByCode(options[0]).getAccessLevelNumber()) )
            options[1] = sControl.changeEmployeeOccupation( eControl.getActualUserLevelNumber() );
        else
            logout();

        if( sControl.getLogoutRequest() == true )
            logout();
        else{
            eControl.changeAccessLevel(options[0], options[1]);
            logout();
        }
    }

    private void report(){}

    private void list() {
        
        options[0] = sControl.employeesList();
        if( sControl.getLogoutRequest() == true )
            logout();
        else
            switch(options[0]){
                case 1:
                    eControl.getList( eControl.getAllEmployees() );                    
                    break;
                case 2:
                    eControl.getList( eControl.getEmployeesByLevelAccess(sControl.employeeListOccupation()) );
                    break;
                case 3:
                    eControl.getList( eControl.getEmployeeByFloor(sControl.employeeListFloor()) );
                    break;
                case 4:
                    eControl.getList( eControl.getEmployeesInWork() );
                    break;
            }
        sControl.standBy();
        home(eControl.getActualUserLevelNumber());
    }
    
    
//</editor-fold>
       
}
