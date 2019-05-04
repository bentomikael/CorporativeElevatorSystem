package sistemaelevadorcorporativo;

import java.util.ArrayList;

/**
 *
 * @author mikael.bento
 */
public class EmployeeControl {
    ArrayList<Employee> employees;

    public EmployeeControl() {
        employees = new ArrayList();
                
        employees.add(new Employee(999,Employee.Occupation.CEO,"goku",23,Employee.Gender.MALE)); //TESTE, apagar depois
        employees.add(new Employee(888,Employee.Occupation.ADMINISTRATION,"vegeta",22,Employee.Gender.MALE)); //TESTE, apagar depois
        employees.add(new Employee(777,Employee.Occupation.MANAGER,"joao amoedo",10,Employee.Gender.MALE)); //TESTE, apagar depois
        employees.add(new Employee(666,Employee.Occupation.SIMPLE_EMPLOYEE,"bolsonaro",40,Employee.Gender.MALE)); //TESTE, apagar depois
        employees.add(new Employee(555,Employee.Occupation.VISITOR,"dilma",30,Employee.Gender.FEMALE)); //TESTE, apagar depois
    }
    
    //<editor-fold desc="gets de funcionarios">
    
    // retorna todos funcionarios cadastrados
    public ArrayList getAllEmployees(){
        return employees;
    }
    
    //retorna todos funcionarios que estão em algum andar
    public ArrayList getEmployeesInWork(){
        ArrayList<Employee> list = new ArrayList();
        for(Employee e: employees)
            if(e.getCurrentFloor() != 0)
                list.add(e);
        return list;
    }
    
    //retorna funcionarios de determinado andar
    public ArrayList getEmployeeByFloor(int floor){
        ArrayList<Employee> list = new ArrayList();
        for(Employee e: employees)
            if(e.getCurrentFloor() == floor)
                list.add(e);
        return list;
    }
    
    //retorna uma lista com funcionarios com determinado nivel de acesso
    public ArrayList getEmployeesByLevelAccess(int level){
        ArrayList<Employee> list = new ArrayList();
        People.Occupation o = null ;
        o.setAccessLevel(level);
        
        for(Employee e : employees)
            if(e.getAccessLevelNumber() == o.accessLevel)
                list.add(e);
        return list;
        }
    
    //procura funcionario cadastrado pelo codigo
    public Employee getEmployeeByCode(int code){
        Employee employee = null;
        for(Employee e: employees)
            if(e.getCodeAccess() == code){
                employee = e;
                break;
            }
        return employee;                     
    }
    
    /**
     * imprime os nomes de todos funcionarios de um array
     * @param array entre com array de funcionarios
     */
    public void getNames(ArrayList<Employee> array){
        for(Employee e : array)
            System.out.println(e.getName()); 
    }  
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Manipulação de usuarios">
    
    //registra funcionario
    public Employee registerNewEmployee
    (int codeAccess, Employee.Occupation levelAccess, String name, int age, Employee.Gender gender){
        employees.add(new Employee(codeAccess,levelAccess,name,age,gender));
        
        System.out.println("New User Registered:\n\n"+ getEmployeeWithCode(codeAccess).getName()); 
        
        return getEmployeeWithCode(codeAccess);
    }
    
    //remove funcionario pelo codigo
    public void removeOneEmployeeWithCode(int code){
        
        System.out.println("User Removed:\n\n "+ getEmployeeWithCode(code).getName());     
         employees.remove(getEmployeeWithCode(code));
    }
    
    //altera nivel de acesso de outro funcionario
    public void changeAccessLevel(int code,Employee.Occupation newAccessLevel){
        getEmployeeWithCode(code).setAccessLevel(newAccessLevel);
    }
   
    //</editor-fold>
}
