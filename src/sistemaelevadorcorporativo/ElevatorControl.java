package sistemaelevadorcorporativo;

import java.util.ArrayList;
/**
 *
 * @author 
 */
class ElevatorControl {
    private ArrayList<Employee> employees;
    private Employee actualUser; //usado para login
    private MainScreen;

    public ElevatorControl() {
        employees = new ArrayList();
        employees.add(new Employee(999,Employee.Occupation.CEO,"goku",23,Employee.Gender.MALE)); //TESTE, apagar depois
        employees.add(new Employee(888,Employee.Occupation.ADMINISTRATION,"vegeta",22,Employee.Gender.MALE)); //TESTE, apagar depois
        employees.add(new Employee(777,Employee.Occupation.MANAGER,"picolo",10,Employee.Gender.MALE)); //TESTE, apagar depois
        employees.add(new Employee(666,Employee.Occupation.SIMPLE_EMPLOYEE,"majin boo",40,Employee.Gender.MALE)); //TESTE, apagar depois

    }
   
    //<editor-fold defaultstate="collapsed" desc=" metodos para login">
    public void start(){
        MainScreen.login();
    } 
    public void setActualUser(int code){
        actualUser = getEmployeeWithCode(code);
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
    public ArrayList getEmployeePerFloor(int floor){
        ArrayList<Employee> list = new ArrayList();
        for(Employee e: employees)
            if(e.getCurrentFloor() == floor)
                list.add(e);
        return list;
    }
    
    //retorna uma lista com funcionarios com determinado nivel de acesso
    public ArrayList getEmployeesListPerLevelAccess(int level){
        ArrayList<Employee> list = new ArrayList();
        People.Occupation o = null ;
        o.setAccessLevel(level);
        
        for(Employee e : employees)
            if(e.getAccessLevelNumber() == o.accessLevel)
                list.add(e);
        return list;
        }
    
    //procura funcionario cadastrado pelo codigo
    public Employee getEmployeeWithCode(int code){
        Employee employee = null;
        for(Employee e: employees)
            if(e.getCodeAccess() == code){
                employee = e;
                break;
            }
        if(employee == null)
            System.out.println("USER NOT FOUND");
        return employee;                     
    }
    
//</editor-fold>
    
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
    
    public void goToFloor(int code,int floor){}
    
    //sair do andar
    public void exitOfFloor(Employee employee){
        employee.setCurrentFloor(0);
    }
    
    /**converte string em int  (usada para tratamento de erros).
     * Verifica se a String contem apenas numeros e converte,
     * se não, retorna mensagem de erro
    * @param convert String a ser convertida para int
    */
        public int stringToInt(String convert){
            int converted = 0;
        
            if(convert.matches("[0-9]{"+convert.length()+"}")) 
                converted = Integer.valueOf(convert);           
            else
                System.out.println("ONLY NUMBER ARE ALLOWED\n\n TRY AGAIN");
                
        return converted;
    }

    /**
     * retorna os nomes de todos funcionarios da lista
     * @param array entre com array de funcionarios
     */
    public void outputListNames(ArrayList<Employee> array){
        for(Employee e : array)
            System.out.println(e.getName()); 
    }      
    
}
