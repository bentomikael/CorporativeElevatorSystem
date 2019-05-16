package br.ufsc.ine5605.CorporativeElevatorSystem.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainControl {
    
    private EmployeeControl eControl;
    private ScreenControl sControl;
    private ReportControl rControl;
    private int[] options;  //usada para manipular as opçoes recebidas de tela
    private Date date;
    private SimpleDateFormat format;
    private String rep; // usado para registrar relatorios
    private boolean logged; // usado para saber quando está logado
    
    public MainControl() {
        eControl = new EmployeeControl();
        sControl = new ScreenControl();
        rControl = new ReportControl();
        options = new int[5];
        date = new Date();
    }
    
    //<editor-fold defaultstate="collapsed" desc="Threads auxiliares">
    /**
     * Busca por ação a ser registrada no relatorio
     */
    private class ReportsRegister extends Thread{
        private boolean verify = true;

        public ReportsRegister() {
        }
        
        @Override
        public void run(){
            while(verify){
                
                switch(rep){
                    case "floor":
                        rControl.addReport(eControl.getActualUserName(),
                        "Go To Floor",
                        "-",
                        getDate(),
                        getHour(),
                        Integer.toString(options[0]));
                        break;
                    case "new":
                        rControl.addReport(eControl.getActualUserName(),
                        "Registered",
                        eControl.getEmployeeByCode(options[2]).getName(),
                        getDate(),
                        getHour(),
                        "-");
                        break;
                    case "del":
                        rControl.addReport(eControl.getActualUserName(),
                        "Removed",
                        eControl.getEmployeeByCode(options[0]).getName(),
                        getDate(),
                        getHour(),
                        "-");
                        break;
                    case "change":
                        rControl.addReport(eControl.getActualUserName(),
                        "Changed",
                        eControl.getEmployeeByCode(options[0]).getName(),
                        getDate(),
                        getHour(),
                        "-");
                        break;
                    case "logout":
                        verify = false;
                        break;
                    }
                try {
                        sleep(300);
                    } catch (InterruptedException ex) {
                        continue;
                    }
                rep = "";
                }
            try {
                finalize();
            } catch (Throwable ex) {}
        }
    }
     
    /**
     * Thread que verifica constantemente se foi requisitado o logout por sControl
     */
    private class LogoutCheck extends Thread{
        
        public LogoutCheck() {
            logged = true;
        }
        
        @Override
        public void run(){
            
            while(logged){
                                
                if(sControl.getLogoutRequest())
                    logout();
                
                try {
                    sleep(100);
                } catch (InterruptedException ex) {
                    continue;
                }
            }
            
            try {
                finalize();
            }catch (Throwable ex) {}
        }

        
    }
    
//</editor-fold>
    
    
    //<editor-fold defaultstate="collapsed" desc="Manipulação de tempo">
    private String getDate() {
        format = new SimpleDateFormat("dd/MM/yy");
        return format.format(date);
    }
    
    private String getHour(){
        format = new SimpleDateFormat("HH:mm");
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
        rep = "logout";
        logged = false;

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

        switch(options[0]){
            case 1:
                floor();
                break;
            case 2:
                administrativeOptions();
                break;
        }
        
        new ReportsRegister().start();
    }

    private void floor(){
        
        options[0] = sControl.floor(
            eControl.getActualUserLevelNumber(),
            eControl.getActualUserFloor() );
       
        eControl.goToFloor(options[0]);
        
        rep = "floor";
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


        options[2] = sControl.addEmployeeCode(
                     eControl.getCodes( eControl.getAllEmployees() ));


        options[3] = sControl.addEmployeeOccupation(
                     eControl.getActualUserLevelNumber() );


        eControl.registerNewEmployee( 
                options[2],
                eControl.convertOccupation(options[3]),
                name,
                options[0],
                eControl.convertGender(options[1]) );

        rep = "new";

                sControl.standBy();
        home(eControl.getActualUserLevelNumber());
        
        
    }

    private void delEmployee() {
        
        options[0] = sControl.delEmployeeCode(
            eControl.getCodes(eControl.getAllEmployees()) );
       
        options[1] = sControl.delEmployeeConfirmation(
            eControl.getActualUserLevelNumber(),
            eControl.getEmployeeByCode(options[0]).getAccessLevelNumber(),
            eControl.getEmployeeByCode(options[0]).getName());
           
        rep = "del";

        eControl.removeEmployeeByCode(options[0]);
        
        sControl.standBy();
        home( eControl.getActualUserLevelNumber() );  
    }
     
    private void changeAccess() { 
         
        options[0] = sControl.changeEmployeeCode( 
            eControl.getActualUserCode(),
            eControl.getCodes( eControl.getAllEmployees()) );
        
       
        if(sControl.checkAuthorization(
        eControl.getActualUserLevelNumber(),
        eControl.getEmployeeByCode( options[0] ).getAccessLevelNumber() )) {
            
            
            options[1] = sControl.changeEmployeeOccupation( 
                eControl.getActualUserLevelNumber() );
            
            eControl.changeOccupation(
                options[0], 
                eControl.convertOccupation(options[1]));
            
            rep = "change";
            
            sControl.standBy();
            home(eControl.getActualUserLevelNumber());      
        }
        
    }

    private void report(){
        options[0] = sControl.reportScreen(
            eControl.getActualUserLevelNumber());
       
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
                options[1] = sControl.reportScreenHour();
                break;
            case 5:
                
                break;
            case 6:
                break;
            case 7:
                break;
        }
    }

    private void list() {
        
        options[0] = sControl.employeesList();
        
        switch(options[0]){
            case 1:
                eControl.printIt(eControl.getAllEmployees() );                    
                break;
            case 2:
                eControl.printIt( 
                eControl.getEmployeesByLevelAccess(
                sControl.employeeListOccupation()) );
                break;
            case 3:
                eControl.printIt( 
                eControl.getEmployeeByFloor(
                sControl.employeeListFloor()) );
                break;
            case 4:
                eControl.printIt( eControl.getEmployeesInWork() );
                break;
        }
        sControl.standBy();
        home(eControl.getActualUserLevelNumber());
    }
    
//</editor-fold>
       
   
}
