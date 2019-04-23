package sistemaelevadorcorporativo;
import java.util.ArrayList;
import sistemaelevadorcorporativo.Floors.*;
/**
 *
 * @author Mikael
 */
class ElevatorControl {
    private ArrayList<Employee> employees;
    
    public ArrayList getEmployees(){
        return employees;
    }
    
    //retorna uma lista com funcionarios com determinado nivel de acesso
    public ArrayList getEmployeesListPerLevelAccess(int levelAccess){
        ArrayList<Employee> list = new ArrayList();
        
        for(Employee e : employees)
            if(e.getLevelAccess() == levelAccess)
                list.add(e);
        return list;
        }
    
    //procura funcionario cadastrado pelo codigo
    public Employee getEmployeeWithCode(int code){
        Employee employee = null;
        for(Employee e: employees)
            employee = e;
        return employee;                     
    }
    
    
    //registra funcionario
    public void registerNewEmployee(int codeAccess, int levelAccess, String name, int age, Gender gender){
        employees.add(new Employee(codeAccess,levelAccess,name,age,gender));
    }
    
    //remove funcionario pelo codigo
    public void removeOneEmployeePerCode(int code){
        for(Employee e : employees)
            if(e.getCodeAccess() == code)
                e = null;
    }
           
    /*  nivel de acesso minimo para registrar funcionario :4 (administração) ,
        só resgistrar com nivel de acesso menor ou igual
    */
    public boolean checkAuthorizationToManipulateEmployee(int actualyUserCode,int otherUserAccessLevel){
        boolean authorized = false;
        if(getEmployeeWithCode(actualyUserCode).getLevelAccess() >= 4 && getEmployeeWithCode(actualyUserCode).getLevelAccess() >= otherUserAccessLevel)
            authorized = true;
        return authorized;
        }
    
    public void goToFloor(int code,int floor){}

       
}
