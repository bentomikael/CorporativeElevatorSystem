package CorporativeElevatorSystem.Screen;

public class AddEmployeeScreen extends Screen{
    
    public void AddEmployeeScreen(){     
    } 
    
    public String inputName(){
        System.out.println("-------RESGISTER NEW EMPLOYEE-------");
        System.out.println("\n 00 - TO CANCEL ACTION AND LOGOUT");
        System.out.println("Name:");
        String name = key.nextLine();
        return name;
    }
    
    public int inputAge(){
        System.out.println("Age:");
        return inputInt(0);
    }
    
    public int inputGender(){
        System.out.println("Gender: \n"+ "1 to Male \n" + "2 to Female");
        return inputInt(2);
    }
    
    public int inputCode(){
        System.out.println("Code Access:");
        return inputInt(0);
    }
    
    public int inputOccupation(int actualUserLevel){
        System.out.println("Employee Occupation:");
        System.out.println("0 - Visitor");
        mAccessLevelOptions(actualUserLevel-1,"");
        return inputInt(actualUserLevel-1);
    }
    
}
