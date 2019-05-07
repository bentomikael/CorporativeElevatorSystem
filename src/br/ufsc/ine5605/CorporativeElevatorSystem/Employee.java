package br.ufsc.ine5605.CorporativeElevatorSystem;

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
    
    public Gender getGender(){return gender;}

    public int getCurrentFloor() {return currentFloor;}
    
    public void setCurrentFloor(int currentFloor) {this.currentFloor = currentFloor;}
    
    public void setOccupation(int accessLevel) {this.accessLevel.setAccessLevel(accessLevel);}

}
