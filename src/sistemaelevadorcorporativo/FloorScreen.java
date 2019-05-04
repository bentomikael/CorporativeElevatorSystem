package sistemaelevadorcorporativo;

public class FloorScreen extends Screen{
    
    public int FloorScreen(int userLevel,int currentFloor){
        System.out.println("\n\n--------CHOOSE THE FLOOR--------");
        mChoseOption();
        //exibe somente opções em que o funcionario tem autorização
        if(currentFloor != 0)
            System.out.println("0 - Get of the Floor \n");
            
        System.out.println("1 - First Floor");
        
        if(userLevel>= 1)
            System.out.println("2 - Employee Floor");
        if(userLevel >= 2)
            System.out.println("3 - Manager Floor");
        if(userLevel >= 3)
            System.out.println("4 - Administrative Floor");
        if(userLevel >= 4)
            System.out.println("5 - Executive Floor");
        if(userLevel == 5)
            System.out.println("6 - CEO Floor");  
       
        // só aceita andar que tenha autorização
        inputInt(userLevel + 1);

        switch(option){
            case 0:
                    eControl.exitOfFloor(eControl.getActualUser());
                    
                break;
            case 1:
                eControl.goToFloor(1);
                break;
            case 2:
                eControl.goToFloor(2);

                break;
            case 3:
                eControl.goToFloor(3);
                break;
            case 4:
                eControl.goToFloor(4);
                break;
            case 5:
                eControl.goToFloor(5);
                break;
            case 6:
                eControl.goToFloor(6);
                break;
            }
    }
}
