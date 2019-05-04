package CorporativeElevatorSystem.Screen;

/**
 *
 * @author Acer
 */
public class DelEmployeeScreen extends Screen{
    public void DelEmployeeScreen(){
        System.out.println("--------REMOVE EMPLOYEE--------");
        System.out.println("Code of Employee to remove:");
        inputInt(0);
        
        // verifica se existe
        if(eControl.getEmployeeByCode(option) != null) 
            //verifica se nivel é maior que o do usuario atual
            if(eControl.getEmployeeByCode(option).getAccessLevelNumber() >=
               eControl.getActualUser().getAccessLevelNumber()){
               mDontHavePermision();
                deleteEmployeeScreen();
        }else{
            mNotFound();
            deleteEmployeeScreen();
        }
        
        eControl.removeEmployeeByCode(option);
        logout();
        
    }
}
