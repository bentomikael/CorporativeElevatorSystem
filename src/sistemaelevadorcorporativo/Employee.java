package sistemaelevadorcorporativo;

/**
 *
 * @author Mikael
 */
public class Employee implements People {
    private final int codeAccess;
    private int levelAccess;
    private int currentFloor;
    private final String name;
    private int age;
    private final Gender gender;
    private int daniedAccessAttempts;                 //será realmente nescessario?

    public Employee(int codeAccess, int levelAccess, String name, int age, Gender gender) {
        this.codeAccess = codeAccess;
        this.levelAccess = levelAccess;
        this.name = name;
        this.age = age;
        this.gender = gender;
        currentFloor = 0;
        daniedAccessAttempts = 0;
    }


    @Override
    public String getName() {return name;}

    @Override
    public int getAge() {return age;}
    
    public void setAge(int age){this.age = age;}

    @Override
    public String gender() {return gender;}
    
    public int getCodeAccess() {return codeAccess;}

    public int getLevelAccess() {return levelAccess;}

    public void setLevelAccess(int levelAccess) {this.levelAccess = levelAccess;}

    public int getCurrentFloor() {return currentFloor;}

    public void setCurrentFloor(int currentFloor) {this.currentFloor = currentFloor;}
    
    public int getDaniedAccessAttempts(){return daniedAccessAttempts;}
    
     
}
