package sistemaelevadorcorporativo;

import java.util.ArrayList;
/**
 *
 * @author 
 */
class ElevatorControl {
    private ArrayList<Employee> employees;
    private Employee actualUser; //usado para login
    private MainScreen screen;

    public ElevatorControl() {
        employees = new ArrayList();
        employees.add(new Employee(999,Employee.Occupation.CEO,"goku",23,Employee.Gender.MALE)); //TESTE, apagar depois
        employees.add(new Employee(888,Employee.Occupation.ADMINISTRATION,"vegeta",22,Employee.Gender.MALE)); //TESTE, apagar depois
        employees.add(new Employee(777,Employee.Occupation.MANAGER,"picolo",10,Employee.Gender.MALE)); //TESTE, apagar depois
        employees.add(new Employee(666,Employee.Occupation.SIMPLE_EMPLOYEE,"majin boo",40,Employee.Gender.MALE)); //TESTE, apagar depois

    }
    
    //<editor-fold defaultstate="collapsed" desc="Metodos de login">
    public void start(){
        screen.login();
    } 
    public void setActualUser(int code){
        actualUser = getEmployeeWithCode(code);
        screen.home();
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
        return employee;                     
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
    
    //<editor-fold defaultstate="collapsed" desc="Andares">
    //entra no andar
    public void goToFloor(int floor){
        try{
            actualUser.setCurrentFloor(floor);
        }catch(Exception e){
            screen.logout();
        }
    }
    
    //sair do andar
    public void exitOfFloor(Employee employee){
        try{
            employee.setCurrentFloor(0);
        }catch(Exception e){
            screen.logout();
        }
    }
    //</editor-fold>
    
    
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
     * retorna os nomes de todos funcionarios do array
     * @param array entre com array de funcionarios
     */
    public void outputListNames(ArrayList<Employee> array){
        for(Employee e : array)
            System.out.println(e.getName()); 
    }    
       
}
