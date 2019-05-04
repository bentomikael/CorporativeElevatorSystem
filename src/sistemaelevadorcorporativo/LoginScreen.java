package sistemaelevadorcorporativo;

public class LoginScreen extends Screen{
    
    /**
     * 
     * @return codigo do funcionario
     */
    public int LoginScreen(){
        System.out.println("--------LOGIN WITH YOU EMPLOYEE CARD / CODE--------");    
            option = inputInt(0);
            return option;  
    }       

}
