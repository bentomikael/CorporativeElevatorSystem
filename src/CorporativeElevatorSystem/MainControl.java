package CorporativeElevatorSystem;

import CorporativeElevatorSystem.Screen.ScreenControl;

class MainControl {
    private EmployeeControl eControl;
    private ScreenControl sControl;
    private int option;
    

    public MainControl() {
        eControl = new EmployeeControl();
        sControl = new ScreenControl();
    }
    
    /** 
     * Pega os dados da tela pelo controlador de tela.
     * Verifica a existencia do usuario,caso não exista, repete.
     * Atribui o usuario atual e usa o nivel de acesso para iniciar homeScreen.
    */
    public void start(){        
        do{
            eControl.login( sControl.login() );
        }while( eControl.getActualUser() == null );
        homeScreen( eControl.getActualUser().getAccessLevelNumber() );

    }
    private void logout(){
           start();
       }

    /**
     * @param actualAccessLevel nivel do usuario atual
     * Se usuario escolheu opção 1 vai pra tela de andares.
     * Se usuario escolheru 2 vai pra tela administrativa.
    */
    private void homeScreen( int actualAccessLevel ) {
        option = sControl.home( actualAccessLevel );
                    
        switch(option){
            case -1:
                logout();
                break;
            case 1:
                floorScreen();
                break;
            case 2:
                administrativeOptionsScreen();
                break;
        }     
    }

    private void floorScreen(){
        eControl.goToFloor
        (sControl.floorScreen( eControl.getActualUser().getAccessLevelNumber(),
                               eControl.getActualUser().getCurrentFloor() ) );
        logout();
        
    }

    private void administrativeOptionsScreen() {
        option = sControl.administrativeOptionsScreen();
        
        switch(option){
            case -1:
                logout();
                break;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void delEmployeeScreen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
    private void changeAccessScreen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void reportsScreen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void listScreen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
