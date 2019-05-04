package sistemaelevadorcorporativo;

class MainControl {
    private EmployeeControl eControl;
    private ScreenControl sControl;
   
    

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
            eControl.login(sControl.login());
        }while(eControl.login(sControl.login()) == null);
        homeScreen(eControl.login(sControl.login()).getAccessLevelNumber());

    }

    /**
     * @param actualAccessLevel nivel do usuario atual
     * Se usuario escolheu opção 1 vai pra tela de andares.
     * Se usuario escolheru 2 vai pra tela administrativa.
    */
    public void homeScreen(int actualAccessLevel) {
        if(sControl.home(actualAccessLevel) == 1)
            sControl.floorScreen();
        if(sControl.home(actualAccessLevel) == 2)
            sControl.administrativeScreen();
            
    }
       
}
