package CorporativeElevatorSystem.Screen;

import CorporativeElevatorSystem.Employee;
import CorporativeElevatorSystem.People;

/**
 *
 * @author Acer
 */
public class AddEmployeeScreen extends Screen{
    
    public void AddEmployeeScreen(){        
        int age ;
        People.Gender gender = null;
        int code = 0;
        Employee.Occupation level = null;
        boolean valid;       
        
    } 
    
    public String inputName(){
        String name;
        System.out.println("-------RESGISTER NEW EMPLOYEE-------");
        System.out.println("Name:");
       
        do{ 
            name = key.nextLine();          
                //verifica se contem apenas letras
                valid = name.matches("[A-Z a-z Çç]{"+name.length()+"}");

            if(valid == false)
                mInvalidName();
        }while(!valid);
        return "";
    }
    public int inputAge(){
        System.out.println("Age:");
        return inputInt(0);
    }
    public int inputGender(){
        System.out.println("Gender: \n"+ "1 to Male \n" + "2 to Female");
            do{ 
                inputInt(2);
                mInvalidOption();
            }while(option == 0) ; 
            
            if(option == 1)
                gender = People.Gender.MALE;
            else if(option == 2)
                gender = People.Gender.FEMALE;
            return inputInt(2);
    }
    public int inputCode(){
        System.out.println("Code Access:");
        do{          
            code = inputInt(0);
            
            //verifica se ja existe 
            if(eControl.getEmployeeByCode(code) != null){    
                mAlreadyRegistered();
                valid = false;
            }
        }while(!valid);
        return inputInt(0);
    }
    public int inputAccessLevel(){
        System.out.println("level Access:");
        int n = 0;
        
        //mostra somente cargos que esse usuario pode criar
        for(Employee.Occupation o: Employee.Occupation.values()){ 
            
            if(eControl.getActualUser().getAccessLevelNumber() <= o.accessLevel)
                break;
            System.out.println(n+ " - " + o);
            n++;
        }
        do{
            level.setAccessLevel(inputInt(5));
            
            if(level.accessLevel >= eControl.getActualUser().getAccessLevelNumber()){;;
                valid = false;
                mDontHavePermision();
            }
            else
                valid = true;
        }while(!valid);
        
        eControl.registerNewEmployee(code,level,name,age,gender);
        logout();
        return inputInt(0);
    }
    
}
