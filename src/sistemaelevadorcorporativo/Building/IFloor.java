package sistemaelevadorcorporativo.Building;
import sistemaelevadorcorporativo.*;
import java.util.ArrayList;

/**
 *
 * @author 
 */
public interface IFloor {
    
    public ArrayList getEmpoyees();
    public void employeeIn(Employee);
    public void employeeOut(Employee);
}
