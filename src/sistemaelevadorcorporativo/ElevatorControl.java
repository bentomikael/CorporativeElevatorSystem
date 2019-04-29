package sistemaelevadorcorporativo;

import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author 
 */
class ElevatorControl implements Messages{
    private ArrayList<Employee> employees;
    private Employee actualUser; //usado para login

    public ElevatorControl() {
        employees = new ArrayList();
        employees.add(new Employee(999,Employee.Occupation.CEO,"goku",23,Employee.Gender.MALE)); //TESTE, apagar depois
        employees.add(new Employee(888,Employee.Occupation.ADMINISTRATION,"vegeta",22,Employee.Gender.MALE)); //TESTE, apagar depois
        employees.add(new Employee(777,Employee.Occupation.MANAGER,"picolo",10,Employee.Gender.MALE)); //TESTE, apagar depois
        employees.add(new Employee(666,Employee.Occupation.SIMPLE_EMPLOYEE,"majin boo",40,Employee.Gender.MALE)); //TESTE, apagar depois

    }
   
    //<editor-fold defaultstate="collapsed" desc=" metodos para login">
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
            JOptionPane.showMessageDialog(null,
                "USER NOT FOUND\n\n", //mensagem
                "NOT FOUND ERROR", // titulo da janela 
                JOptionPane.ERROR_MESSAGE); // tipo de janela
        return employee;                     
    }
    
//</editor-fold>
    
    //registra funcionario
    public Employee registerNewEmployee
    (int codeAccess, Employee.Occupation levelAccess, String name, int age, Employee.Gender gender){
        employees.add(new Employee(codeAccess,levelAccess,name,age,gender));
        
        JOptionPane.showMessageDialog(null,
        "New User Registered:\n\n "+ getEmployeeWithCode(codeAccess).getName(),
        "NEW EMPLOYEE REGISTERED SUCCESSFULY", 
        JOptionPane.INFORMATION_MESSAGE); 
        
        return getEmployeeWithCode(codeAccess);
    }
    
    //remove funcionario pelo codigo
    public void removeOneEmployeeWithCode(int code){
        
        JOptionPane.showMessageDialog(null,
        "User Removed:\n\n "+ getEmployeeWithCode(code).getName(),
        "EMPLOYEE REMOVED SUCCESSFULY", 
        JOptionPane.INFORMATION_MESSAGE);    
        
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
                JOptionPane.showMessageDialog(null,
                "ONLY NUMBER ARE ALLOWED\n\n TRY AGAIN", //mensagem
                "IMPUT ERROR", // titulo da janela 
                JOptionPane.ERROR_MESSAGE); // tipo de janela
        
        return converted;
    }

    /**
     * retorna os nomes de todos funcionarios da lista
     * @param array entre com array de funcionarios
     */
    public void outputListNames(ArrayList<Employee> array){
        String[] list = new String[array.size()];
        int i = 0;
        for(Employee e : array)
            list[i++] = e.getName();
        JOptionPane.showInputDialog(null,"Employees", "teste", JOptionPane.PLAIN_MESSAGE, null, list, null);
    }      

    //<editor-fold defaultstate="collapsed" desc="Messages panel">
    @Override
    public void successAdd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void successDel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void invalidNumber() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void invalidName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void invalidOption() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notHavePermision() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void logout() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alreadyRegistered() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeSelfErro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notFound() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//</editor-fold>
    
}
