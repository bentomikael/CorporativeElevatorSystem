package sistemaelevadorcorporativo;

/**
 *
 * @author 
 */
class MainControl {
    private EmployeeControl eControl;
    private Employee actualUser; 
    private Screen screen ;

    public MainControl() {
        eControl = new EmployeeControl();
    }
    
    //<editor-fold defaultstate="collapsed" desc="Informações de login">
    
    public void setActualUser(int code){
        actualUser = eControl.getEmployeeByCode(code);
    }
    public Employee getActualUser() {
        return actualUser;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Andares">
    
    //entra no andar
    public void goToFloor(int floor){
        try{
            actualUser.setCurrentFloor(floor);
        }catch(Exception e){
            
        }
    }
    
    //sair do andar
    public void exitOfFloor(Employee employee){
        try{
            employee.setCurrentFloor(0);
        }catch(Exception e){
        }
    }
    
    //</editor-fold> // TRY  E  CATCH AQUI! EDITAR 
    
    
   

    
   
}
