package sistemaelevadorcorporativo;

/**
 *
 * @author Acer
 */
public class FloorScreen extends MainScreen{
    
    public void FloorScreen(){
        System.out.println("\n\n--------CHOOSE THE FLOOR--------");
        super.control.mChoseOption();
        //exibe somente opções em que o funcionario tem autorização
        if(super.control.getActualUser().getCurrentFloor() != 0)
            System.out.println("0 - Get of the Floor \n");
        
        if(super.control.getActualUser().getAccessLevelNumber()>= 0)    
            System.out.println("1 - First Floor");
        if(super.control.getActualUser().getAccessLevelNumber()>= 1)
            System.out.println("2 - Employee Floor");
        if(super.control.getActualUser().getAccessLevelNumber() >= 2)
            System.out.println("3 - Manager Floor");
        if(super.control.getActualUser().getAccessLevelNumber() >= 3)
            System.out.println("4 - Administrative Floor");
        if(super.control.getActualUser().getAccessLevelNumber() >= 4)
            System.out.println("5 - Executive Floor");
        if(super.control.getActualUser().getAccessLevelNumber() >= 5)
            System.out.println("6 - CEO Floor");  
       
        // só aceita andar que tenha autorização
        inputInt(super.control.getActualUser().getAccessLevelNumber() + 1);

        switch(option){
            case 0:
                    super.control.exitOfFloor(super.control.getActualUser());
                    System.out.println("BYE, SEE YOU LATER");
                break;
            case 1:
                super.control.goToFloor(1);
                break;
            case 2:
                super.control.goToFloor(2);

                break;
            case 3:
                super.control.goToFloor(3);
                break;
            case 4:
                super.control.goToFloor(4);
                break;
            case 5:
                super.control.goToFloor(5);
                break;
            case 6:
                super.control.goToFloor(6);
                break;
            }
    }
}
