package CorporativeElevatorSystem.Screen;

import CorporativeElevatorSystem.Employee;

/**
 *
 * @author Acer
 */
public class ChangeEmployeeScreen extends Screen{
    public void changeAccessLevelScreen(){
        int userCode ;
        Employee.Occupation access = null;
        
        System.out.println("--------CHANGE ACCESS LEVEL OF EMPLOYEE--------");
        System.out.println("Code Of Employee To Change Access Level:");

        userCode = inputInt(0);
        
        //verifica se não é o propio codigo e se nao achou usuario
        if(eControl.getActualUser().getCodeAccess() == userCode) {
            mChangeSelfErro();
            changeAccessLevelScreen();
        }else if(eControl.getEmployeeByCode(userCode) == null){ 
            mNotFound();
            changeAccessLevelScreen();
        }
        
        System.out.println("New Access Level For This User:");
        
        access.setAccessLevel(inputInt(5));
        
        if(eControl.getActualUser().getAccessLevelNumber()<=
           eControl.getEmployeeByCode(userCode).getAccessLevelNumber()){
            mDontHavePermision();
            changeAccessLevelScreen();
        }else{
            eControl.changeAccessLevel(userCode, access );
        }
        logout();
    
    }
}
