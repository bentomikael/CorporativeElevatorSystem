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
    public ArrayList getEmployeesListPerLevelAccess(Occupation levelAccess){
        ArrayList<Employee> list = new ArrayList();
        
        for(Employee e : employees)
            if(e.getLevelAccessNumber() == (levelAccess.getAccessLevelNumber()))
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
    public void registerNewEmployee(int codeAccess, Occupation levelAccess, String name, int age, Gender gender){
        employees.add(new Employee(codeAccess,levelAccess,name,age,gender));
    }
    
    //remove funcionario pelo codigo
    public boolean removeOneEmployeePerCode(int code){
        boolean valid = false;
        Employee e;
        
        if(employees.contains(getEmployeeWithCode(code)) ){
            e = getEmployeeWithCode(code);
            e = null;
            valid = true;
        }
        return valid;
           

    }
           
    /*  nivel de acesso minimo para manipular algum funcionario :3 (administração) ,
        só resgistrar com nivel de acesso menor ou igual
    */
    public boolean checkAuthorizationToManipulateEmployee(int actualyUserCode,int otherUserAccessLevel){
        boolean authorized = false;
        if(getEmployeeWithCode(actualyUserCode).getLevelAccessNumber() >= 3 &&
           getEmployeeWithCode(actualyUserCode).getLevelAccessNumber()>= otherUserAccessLevel )
            authorized = true;
        return authorized;
        }
    
    //altera nivel de acesso.
    //só deve ser executado apos checar autorização
    public void changeAccessLevel(Employee employee,Occupation newAccessLevel){
        employee.setLevelAccess(newAccessLevel);
    }
    
    // funcionario vai para o andar
    public void goToFloor(int code,int floor){}


       
}
