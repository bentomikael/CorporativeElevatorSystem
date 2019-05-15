package br.ufsc.ine5605.CorporativeElevatorSystem.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainControl {
    private EmployeeControl eControl;
    private ScreenControl sControl;
    private int[] options;  //usada para manipular as opçoes recebidas de tela
    private Date date;
    private SimpleDateFormat format;
    
    public MainControl() {
        eControl = new EmployeeControl();
        sControl = new ScreenControl();
        options = new int[5];
        date = new Date();
    }
    
    //<editor-fold defaultstate="collapsed" desc="Manipulação de tempo">
    public String getDate() {
        format = new SimpleDateFormat("dd/mm/yyyy");
        return format.format(date);
    }
    
    public String getHour(){
        format = new SimpleDateFormat("hh:mm");
        return format.format(date);
    }
    
//</editor-fold>     
     
    //<editor-fold defaultstate="collapsed" desc="Login">
    /** 
     * Inicia nova classe que verifica logout
     * Pega os dados da tela pelo controlador de tela.
     * Atribui o usuario atual e usa o nivel de acesso para iniciar home.
    */
    public void start(){ 
        
        
        eControl.login( 
                sControl.login(
                eControl.getCodes(
                eControl.getAllEmployees() )) );
        new LogoutCheck().start();

        home( eControl.getActualUserLevelNumber() );
    }
    
    private void logout(){
        start();
       }
    
    /**
     * Thread que verifica constantemente se foi requisitado o logout por sControl
     */
    private class LogoutCheck extends Thread{
        private boolean logged;
        
        public LogoutCheck() {
            logged = true;
        }
        
        @Override
        public void run(){
            
            while(logged){
                
                try {
                    sleep(100);
                } catch (InterruptedException ex) {
                    continue;
                }
                
                if(sControl.getLogoutRequest())
                    logged = false;     
            }
            
            logout();
            try {
                finalize();
            } catch (Throwable ex) {}
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize(); //To change body of generated methods, choose Tools | Templates.
        }
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
        
        options[0] = sControl.floor(
                     eControl.getActualUserLevelNumber(),
                     eControl.getActualUserFloor() );
       
            eControl.goToFloor(options[0]);
            sControl.standBy();
            logout();  
    }

    private void administrativeOptions() {
        
        options[0] = sControl.administrativeOptions();
       
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
    
    private void newEmployee() {
        
        String name = sControl.addEmployeeName();
        
        
            options[0] = sControl.addEmployeeAge();
        
        
            options[1] = sControl.addEmployeeGender();
        
       
            options[2] = sControl.addEmployeeCode(eControl.getCodes(eControl.getAllEmployees() ));
        
        
            options[3] = sControl.addEmployeeOccupation(eControl.getActualUserLevelNumber() );
        
        
            eControl.registerNewEmployee( 
                    options[2],
                    eControl.convertOccupation(options[3]),
                    name,
                    options[0],
                    eControl.convertGender(options[1]) );
            
            sControl.standBy();
            home(eControl.getActualUserLevelNumber());
        
        
    }

    private void delEmployee() {
        
        options[0] = sControl.delEmployeeCode(eControl.getCodes(eControl.getAllEmployees()) );
       
        options[1] = sControl.delEmployeeConfirmation(
                        eControl.getActualUserLevelNumber(),
                        eControl.getEmployeeByCode(options[0]).getAccessLevelNumber(),
                        eControl.getEmployeeByCode(options[0]).getName());
        
            eControl.removeEmployeeByCode(options[0]);
            sControl.standBy();
            home( eControl.getActualUserLevelNumber() );
        
    }
     
    private void changeAccess() { // não está alterando
         
        options[0] = sControl.changeEmployeeCode( 
                    eControl.getActualUserCode(),
                    eControl.getCodes( eControl.getAllEmployees()) );
        
       
        sControl.checkAuthorization(
        eControl.getActualUserLevelNumber(),
        eControl.getEmployeeByCode( options[0] ).getAccessLevelNumber());
        
        options[1] = sControl.changeEmployeeOccupation( 
                    eControl.getActualUserLevelNumber() );
        

        eControl.changeAccessLevel(options[0], options[1]);
        sControl.standBy();
        home(eControl.getActualUserLevelNumber());      
    }

    private void report(){
        options[0] = sControl.reportScreen( eControl.getActualUserLevelNumber() );
       
        switch(options[0]){
            case 1:
                options[1] = sControl.reportScreenFloor();
                break;
            case 2:
                options[1] = sControl.reportScreenCode();
                break;
            case 3:
                options[1] = sControl.reportScreenDay();
                break;
            case 4:
                options[1] = sControl.reportScreenOccupation();
                break;
            case 5:
                break;
            case 6:
                break;
        }
    }

    private void list() {
        
        options[0] = sControl.employeesList();
        
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
    
    private void includeReport(){}
    
//</editor-fold>
       
    
}
