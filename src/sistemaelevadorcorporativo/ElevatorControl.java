package sistemaelevadorcorporativo;

import java.util.ArrayList;
import javafx.stage.Screen;
/**
 *
 * @author 
 */
class ElevatorControl implements Messages{
    private ArrayList<Employee> employees;
    private Employee            actualUser; 
    private MainScreen          screen ;

    public ElevatorControl() {
        employees = new ArrayList();
                
        employees.add(new Employee(999,Employee.Occupation.CEO,"goku",23,Employee.Gender.MALE)); //TESTE, apagar depois
        employees.add(new Employee(888,Employee.Occupation.ADMINISTRATION,"vegeta",22,Employee.Gender.MALE)); //TESTE, apagar depois
        employees.add(new Employee(777,Employee.Occupation.MANAGER,"joao amoedo",10,Employee.Gender.MALE)); //TESTE, apagar depois
        employees.add(new Employee(666,Employee.Occupation.SIMPLE_EMPLOYEE,"bolsonaro",40,Employee.Gender.MALE)); //TESTE, apagar depois
        employees.add(new Employee(555,Employee.Occupation.VISITOR,"dilma",30,Employee.Gender.FEMALE)); //TESTE, apagar depois


    }
    
    //<editor-fold defaultstate="collapsed" desc="Informações de login">
    
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
    public ArrayList getEmployeesPerLevelAccess(int level){
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
    
    
    /**converte string em int  (usada para tratamento de erros).
     * Recebe uma String, verifica se contem apenas numeros
     * se não, retorna mensagem de erro
    * @param convert String a ser convertida para int
    * @return se valido retorna valor em int, se nao retorna 0
    */
        public int stringToInt(String convert){
            int converted = 0;
        
            if(convert.matches("[0-9]{"+convert.length()+"}")) 
                converted = Integer.valueOf(convert);           
            else
                System.out.println("ONLY NUMBER ARE ALLOWED\n\n TRY AGAIN");
                
        return converted;
    }  

    //<editor-fold defaultstate="collapsed" desc="Mensagens">
        
     @Override
    public void mSuccessAdd() {
         System.out.println("--NEW EMPLOYEE REGISTERED SUCCESSFULL--");  
    }
    @Override
    public void mSuccessDel() {
        System.out.println("--EMPLOYEE REMOVED SUCCESSFULL--");
    }
    @Override
    public void mInvalidName() {
        System.out.println("--INVALID NAME! TRY AGAIN--");
    }
    @Override
    public void mInvalidOption() {
        System.out.println("--INVALID OPTION! TRY AGAIN--");
    }
    @Override
    public void mDontHavePermision() {
        System.out.println("--YOU DONT HAVE PERMISSION TO EXECUTE THIS OPERATION--");
    }
    @Override
    public void mLogout() {
        System.out.println("--LOGOUT SUCCESSFULL--");
    }
    @Override
    public void mAlreadyRegistered() {
        System.out.println("--USER ALREADY REGISTERED--");
    }
    @Override
    public void mChangeSelfErro() {
        System.out.println("--YOU CAN'T CHANGE YOURS OWN ACCESS LEVEL--");
    }
    @Override
    public void mNotFound() {
        System.out.println("--USER NOT FOUND--");
    }
    @Override
    public void mChoseOption() {
        System.out.println("Chose One Option: \n");
    }
//</editor-fold>
   
}
