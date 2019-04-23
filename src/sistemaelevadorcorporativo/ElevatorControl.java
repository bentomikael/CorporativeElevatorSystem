package sistemaelevadorcorporativo;
import java.util.ArrayList;
/**
 *
 * @author Mikael
 */
class ElevatorControl {
    private ArrayList<Employee> employees;
    
    public Employee getEmployeeWithCode(int code){
        Employee employee = null;
        for(Employee e: employees)
            employee = e;
        return employee;                     
    }
    public void goToFloor(int code,Floor floor){}
    
    public void registerNewEmployee(){
        employees.add(new Employee(codeAccess,levelAccess,name,age,gender));
    }
    public void removeOneEmployee(){}
    
    public boolean checkAuthorizationForRegister(int actualyUserCode,int newUserAccessLevel){
        boolean authorized = false;
        if(getEmployeeWithCode(actualyUserCode).getLevelAccess() >= 4 && getEmployeeWithCode(actualyUserCode).getLevelAccess() >= newUserAccessLevel)
            authorized = true;
        return authorized;
            }
    
    public ArrayList getEmployeesListPerLevelAccess(int levelAccess){}
    
    
}
