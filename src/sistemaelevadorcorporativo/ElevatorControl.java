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
            if(e.getCodeAccess() == code){
                employee = e;
                break;
            }
        return employee;                     
    }
    
    //registra funcionario
    public Employee registerNewEmployee(int codeAccess, Occupation levelAccess, String name, int age, Gender gender){
        employees.add(new Employee(codeAccess,levelAccess,name,age,gender));
        return getEmployeeWithCode(codeAccess);
    }
    
    //remove funcionario pelo codigo
    public boolean removeOneEmployeeWithCode(int code){
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
    public boolean checkAuthorizationToManipulateEmployee(Employee actualUser,int otherUserAccessLevel){
        boolean authorized = false;
        if(getEmployeeWithCode(actualUser.getCodeAccess()).getLevelAccessNumber() >= 3 &&
           getEmployeeWithCode(actualUser.getCodeAccess()).getLevelAccessNumber()>= otherUserAccessLevel )
            authorized = true;
        return authorized;
        }
    
    //altera nivel de acesso de outro funcionario
    //só deve ser executado apos checar autorização
    public void changeAccessLevel(int code,Occupation newAccessLevel){
        getEmployeeWithCode(code).setLevelAccess(newAccessLevel);
    }
    
 
    public void goToFloor(int code,int floor){}
    public void exitOfFloor(Employee employee){}
    
    
    
    
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
