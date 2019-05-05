package CorporativeElevatorSystem;

/**
 *
 * @author 
 */
public class Employee extends People {
    private final int codeAccess;
    private Occupation accessLevel;
    private int currentFloor;
    private final Gender gender;    

    public Employee(int codeAccess, Occupation accessLevel, String name, int age, Gender gender) {
        this.codeAccess = codeAccess;
        this.accessLevel = accessLevel;
        this.name = name;
        this.age = age;
        this.gender = gender;
        currentFloor = 0; 
        
    }
    
    public int getCodeAccess() {return codeAccess;}
        
    public int getAccessLevelNumber() {return accessLevel.accessLevel;}

    public void setAccessLevelNumber(int accessLevel) {this.accessLevel.setAccessLevel(accessLevel);}

    public int getCurrentFloor() {return currentFloor;}

    public void setCurrentFloor(int currentFloor) {this.currentFloor = currentFloor;}
    
    
     
}
