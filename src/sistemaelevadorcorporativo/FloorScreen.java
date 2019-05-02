package sistemaelevadorcorporativo;

/**
 *
 * @author Acer
 */
public class FloorScreen extends MainScreen{
    
    public void FloorScreen(){
        System.out.println("--------CHOOSE THE FLOOR--------");
        System.out.println("Chose one option:");
        
        //exibe somente opções em que o funcionario tem autorização
        if(control.getActualUser().getCurrentFloor() != 0)
            System.out.println("10 - Get of the Floor \n");
        if(control.getActualUser().getAccessLevelNumber()>= 0)    
            System.out.println("1 - First Floor");
        if(control.getActualUser().getAccessLevelNumber()>= 1)
            System.out.println("2 - Employee Floor");
        if(control.getActualUser().getAccessLevelNumber() >= 2)
            System.out.println("3 - Manager Floor");
        if(control.getActualUser().getAccessLevelNumber() >= 3)
            System.out.println("4 - Administrative Floor");
        if(control.getActualUser().getAccessLevelNumber() >= 4)
            System.out.println("5 - Executive Floor");
        if(control.getActualUser().getAccessLevelNumber() >= 5)
            System.out.println("6 - CEO Floor");  
       
        // só aceita andar que tenha autorização
        inputInt(control.getActualUser().getAccessLevelNumber() + 1);

        switch(option){
            case 10:
                    control.exitOfFloor(control.getActualUser());
                    System.out.println("BYE, SEE YOU LATER");
                break;
            case 1:
                control.goToFloor(1);
                break;
            case 2:
                control.goToFloor(2);

                break;
            case 3:
                control.goToFloor(3);
                break;
            case 4:
                control.goToFloor(4);
                break;
            case 5:
                control.goToFloor(5);
                break;
            case 6:
                control.goToFloor(6);
                break;
            }
    }
}
