package sistemaelevadorcorporativo;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import sistemaelevadorcorporativo.Floors.*;
/**
 *
 * @author Mikael
 */
class ElevatorControl {
    private ArrayList<Employee> employees;

    public ElevatorControl() {
        employees = new ArrayList();
    }
    
    // retorna todos funcionarios cadastrados
    public ArrayList getAllEmployees(){
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
            if(e.getCodeAccess() == code){
                employee = e;
                break;
            }
        return employee;                     
    }
    
    //registra funcionario
    public Employee registerNewEmployee(int codeAccess, Occupation levelAccess, String name, int age, Gender gender){
        employees.add(new Employee(codeAccess,levelAccess,name,age,gender));
        
        JOptionPane.showMessageDialog(null,
        "New User Registered:\n\n "+ getEmployeeWithCode(codeAccess).getName(),
        "NEW EMPLOYEE REGISTERED SUCCESSFULY", 
        JOptionPane.INFORMATION_MESSAGE); 
        
        return getEmployeeWithCode(codeAccess);
    }
    
    //remove funcionario pelo codigo
    public void removeOneEmployeeWithCode(int code){
        Employee e;
        
        JOptionPane.showMessageDialog(null,
        "User Removed:\n\n "+ getEmployeeWithCode(code).getName(),
        "EMPLOYEE REMOVED SUCCESSFULY", 
        JOptionPane.INFORMATION_MESSAGE); 
    
            e = getEmployeeWithCode(code);
            e = null;           

    }
    
    //altera nivel de acesso de outro funcionario
    public void changeAccessLevel(int code,Occupation newAccessLevel){
        getEmployeeWithCode(code).setLevelAccess(newAccessLevel);
    }
    
    public void goToFloor(int code,int floor){}
    
    //sair do andar
    public void exitOfFloor(Employee employee){
        employee.setCurrentFloor(0);
    }
    
    //converte string em int  (usada para tratamento de erros)
    public int stringToInt(String strToInt){
        int converted = 0;
            if(strToInt.matches("[0-9]{"+strToInt.length()+"}")) //verifica se contem apenas numeros
                converted = Integer.valueOf(strToInt);           //transforma String em int
            else
                JOptionPane.showMessageDialog(null,
                "ONLY NUMBER ARE ALLOWED\n\n TRY AGAIN", //mensagem
                "IMPUT ERROR", // titulo da janela 
                JOptionPane.ERROR_MESSAGE); // tipo de janela
        return converted;
    }



       
}
