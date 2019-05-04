package CorporativeElevatorSystem.Screen;

public class AdministrativeOptionsScreen extends Screen{
    
    //tela de opçoes administrativas
    public int AdministrativeOptionsScreen(){
        System.out.println("--------ADMINISTRATIVE SESION--------");
        mChoseOption();
        System.out.println("1 - Register New Employee");
        System.out.println("2 - Remove Employee");
        System.out.println("3 - Change Access Level of one employee");
        System.out.println("4 - Reports");
        System.out.println("5 - List of Employees");
        return inputInt(5);
        } 
    
    
}
