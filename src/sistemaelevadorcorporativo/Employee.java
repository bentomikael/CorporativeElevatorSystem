package sistemaelevadorcorporativo;

/**
 *
 * @author Mikael
 */
public class Employee implements People {
    private final int codeAccess;
    private Occupation levelAccess;
    private int currentFloor;
    private final String name;
    private int age;
    private final Gender gender;

    public Employee(int codeAccess, Occupation levelAccess, String name, int age, Gender gender) {
        this.codeAccess = codeAccess;
        this.levelAccess = levelAccess;
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

    @Override
    public Gender gender() {return gender;}
    
    public int getCodeAccess() {return codeAccess;}

    public int getLevelAccessNumber() {return levelAccess.getAccessLevelNumber();}

    public void setLevelAccess(Occupation levelAccess) {this.levelAccess = levelAccess;}

    public int getCurrentFloor() {return currentFloor;}

    public void setCurrentFloor(int currentFloor) {this.currentFloor = currentFloor;}
    
    
     
}
