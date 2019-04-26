package sistemaelevadorcorporativo;

/**
 *
 * @author Mikael
 */
public class Employee implements People {
    private final int codeAccess;
    private Occupation accessLevel;
    private int currentFloor;
    private final String name;
    private int age;
    private final Gender gender;

    public Employee(int codeAccess, Occupation accessLevel, String name, int age, Gender gender) {
        this.codeAccess = codeAccess;
        this.accessLevel = accessLevel;
        this.name = name;
        this.age = age;
        this.gender = gender;
        currentFloor = 0;
    }

    
    @Override
    public String getName() {return name;}

    @Override
    public int getAge() {return age;}
    
    public void setAge(int age){this.age = age;}

    
    public int getCodeAccess() {return codeAccess;}

    public int getAccessLevelNumber() {return accessLevel.accessLevel;}

    public void setAccessLevel(Occupation levelAccess) {this.accessLevel = levelAccess;}

    public int getCurrentFloor() {return currentFloor;}

    public void setCurrentFloor(int currentFloor) {this.currentFloor = currentFloor;}
    
    
     
}
