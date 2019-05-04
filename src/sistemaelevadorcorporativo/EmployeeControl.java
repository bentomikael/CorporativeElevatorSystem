package sistemaelevadorcorporativo;

import java.util.ArrayList;

public class EmployeeControl {
    ArrayList<Employee> employees;
    private Employee actualUser; 


    public EmployeeControl() {
        employees = new ArrayList(); 
        employees.add(new Employee(999,Employee.Occupation.CEO,"goku",23,Employee.Gender.MALE)); //TESTE, apagar depois
        employees.add(new Employee(888,Employee.Occupation.EXECUTIVE,"vegeta",22,Employee.Gender.MALE)); //TESTE, apagar depois
        employees.add(new Employee(777,Employee.Occupation.ADMINISTRATION,"joao amoedo",10,Employee.Gender.MALE)); //TESTE, apagar depois
        employees.add(new Employee(666,Employee.Occupation.MANAGER,"bolsonaro",40,Employee.Gender.MALE)); //TESTE, apagar depois
        employees.add(new Employee(555,Employee.Occupation.SIMPLE_EMPLOYEE,"dilma",30,Employee.Gender.FEMALE)); //TESTE, apagar depois
        employees.add(new Employee(444,Employee.Occupation.VISITOR,"Rex",8,Employee.Gender.MALE)); //TESTE, apagar depois

    }
    
    //<editor-fold defaultstate="collapsed" desc="Informações de login">
   
    /**
     * 
     * @param code codigo do usuario tentando fazer login
     * @return se existir, define usuario atual e retorna ele,se nao, retorna null
     */
    public Employee login(int code){
                
        if(getEmployeeByCode(code) == null){
            return null;
        }else{
            setActualUserByCode(code);
            return getActualUser();
        }
    }
    
    private void setActualUserByCode(int code){
        actualUser = getEmployeeByCode(code);
    }
    
    public Employee getActualUser() {
        return actualUser;
    }
    
    //</editor-fold>
    
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
        
        System.out.println("New User Registered:\n\n"+ getEmployeeByCode(codeAccess).getName()); 
        
        return getEmployeeByCode(codeAccess);
    }
    
    //remove funcionario pelo codigo
    public void removeEmployeeByCode(int code){
        
        System.out.println("User Removed:\n\n "+ getEmployeeByCode(code).getName());     
         employees.remove(getEmployeeByCode(code));
    }
    
    //altera nivel de acesso de outro funcionario
    public void changeAccessLevel(int code,Employee.Occupation newAccessLevel){
        getEmployeeByCode(code).setAccessLevel(newAccessLevel);
    }
   
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Andares">
    
    //entra no andar
    public void goToFloor(int floor){
        try{
            getActualUser().setCurrentFloor(floor);
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
