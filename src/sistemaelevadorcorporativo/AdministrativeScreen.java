package sistemaelevadorcorporativo;

/**
 *
 * @author Acer
 */
public class AdministrativeScreen extends MainScreen{
    
    //tela de opçoes administrativas
    public void AdministrativeScreen(){
        System.out.println("--------ADMINISTRATIVE SESION--------");
        super.control.mChoseOption();
        System.out.println("1 - Register New Employee");
        System.out.println("2 - Remove Employee");
        System.out.println("3 - Change Access Level of one employee");
        System.out.println("4 - Reports");
        System.out.println("5 - List of Employees");
        inputInt(5);
    
        switch(option){
            case 1:
                newEmployeeScreen();
                break;
            case 2:
                deleteEmployeeScreen();
                break;
            case 3:
                changeAccessLevelScreen();
                break;
            case 4:
                reportScreen();
                break;      
            case 5:
                listScreen();
                break;
            default:
                AdministrativeScreen();
                break;
            }
        
    }
    
    //incompleto
    private void reportScreen(){
        System.out.println("--------GET REPORTS OF SYSTEM--------");
        super.control.mChoseOption();
        System.out.println("1 - History of Floor");
        System.out.println("2 - History of Employee");
        System.out.println("3 - History of Day");
        System.out.println("4 - History of registered employees");
        System.out.println("5 - History of removed employees");
        inputInt(5);
        
        switch(option){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
                        default:
                            reportScreen();
                            break;
            }
        
        
    }

    //Tela para adicionar funcionario
    private void newEmployeeScreen(){        
        String name = "";
        int age = 0;
        People.Gender gender = null;
        int code = 0;
        Employee.Occupation level = null;
        boolean valid;
       
        // recebe nome
        System.out.println("-------RESGISTER NEW EMPLOYEE-------");
        System.out.println("0 - TO CANCEL ACTION AND GO TO HOME / LOGOUT \n");
        System.out.println("Name:");
       
        do{ 
            name = key.nextLine();
            if(name.equals("0")){
                logout();
            }            
                //verifica se contem apenas letras
                valid = name.matches("[A-Z a-z Çç]{"+name.length()+"}");

            if(valid == false)
                super.control.mInvalidName();
        }while(!valid);
        
        // recebe idade
        System.out.println("Age:");
        age = inputInt(0);
        
        //recebe genero
        System.out.println("Gender: \n"+ "1 to Male \n" + "2 to Female");
            do{ 
                inputInt(2);
                super.control.mInvalidOption();
            }while(option == 0) ; 
            
            if(option == 1)
                gender = People.Gender.MALE;
            else if(option == 2)
                gender = People.Gender.FEMALE;
        
        //recebe codigo
        System.out.println("Code Access:");
        do{          
            code = inputInt(0);
            
            //verifica se ja existe 
            if(super.control.getEmployeeWithCode(code) != null){    
                super.control.mAlreadyRegistered();
                valid = false;
            }
        }while(!valid);
            
        // recebe o nivel de acesso
        System.out.println("level Access:");
        int n = 0;
        
        //mostra somente cargos que esse usuario pode criar
        for(Employee.Occupation o: Employee.Occupation.values()){ 
            
            if(super.control.getActualUser().getAccessLevelNumber() <= o.accessLevel)
                break;
            System.out.println(n+ " - " + o);
            n++;
        }
        do{
            level.setAccessLevel(inputInt(5));
            
            if(level.accessLevel >= super.control.getActualUser().getAccessLevelNumber()){;;
                valid = false;
                super.control.mDontHavePermision();
            }
            else
                valid = true;
        }while(!valid);
        
        super.control.registerNewEmployee(code,level,name,age,gender);
        logout();
    } 
    
    //tela para apagar funcionario
    private void deleteEmployeeScreen(){
        System.out.println("--------REMOVE EMPLOYEE--------");
        System.out.println("Code of Employee to remove:");
        inputInt(0);
        
        // verifica se existe
        if(super.control.getEmployeeWithCode(option) != null) 
            //verifica se nivel é maior que o do usuario atual
            if(super.control.getEmployeeWithCode(option).getAccessLevelNumber() >=
               super.control.getActualUser().getAccessLevelNumber()){
               super.control.mDontHavePermision();
                deleteEmployeeScreen();
        }else{
            super.control.mNotFound();
            deleteEmployeeScreen();
        }
        
        super.control.removeOneEmployeeWithCode(option);
        logout();
        
    }
    
    //tela para alterar nivel de acesso de um funcionario
    private void changeAccessLevelScreen(){
        int userCode ;
        Employee.Occupation access = null;
        
        System.out.println("--------CHANGE ACCESS LEVEL OF EMPLOYEE--------");
        System.out.println("Code Of Employee To Change Access Level:");

        userCode = inputInt(0);
        
        //verifica se não é o propio codigo e se nao achou usuario
        if(super.control.getActualUser().getCodeAccess() == userCode) {
            super.control.mChangeSelfErro();
            changeAccessLevelScreen();
        }else if(super.control.getEmployeeWithCode(userCode) == null){ 
            super.control.mNotFound();
            changeAccessLevelScreen();
        }
        
        System.out.println("New Access Level For This User:");
        
        access.setAccessLevel(inputInt(5));
        
        if(super.control.getActualUser().getAccessLevelNumber()<=
           super.control.getEmployeeWithCode(userCode).getAccessLevelNumber()){
            super.control.mDontHavePermision();
            changeAccessLevelScreen();
        }else{
            super.control.changeAccessLevel(userCode, access );
        }
        logout();
    
    }

    //tela de lista de funcionarios
    private void listScreen() {
        System.out.println("--------LISTS OF EMPLOYEES--------");
        super.control.mChoseOption();
        System.out.println("1 - All Employees");
        System.out.println("2 - Employees Per Access Level");
        System.out.println("3 - Employees Per Floor");
        System.out.println("4 - Employees In Work");
        inputInt(4);
        
        switch(option){
            case 1:
                super.control.getNames(super.control.getAllEmployees());
                break;
            case 2:
                System.out.println("Enter Level Number");
                inputInt(5);
                super.control.getNames(super.control.getEmployeesPerLevelAccess(option));
                break;
            case 3:
                System.out.println("Enter Floor Number");
                inputInt(6);
                super.control.getNames(super.control.getEmployeePerFloor(option));
                break;
            case 4:
                super.control.getNames(super.control.getEmployeesInWork());
                break;
            default:
                listScreen();
                break;
        }

    }
}
