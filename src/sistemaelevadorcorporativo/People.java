package sistemaelevadorcorporativo;

/**
 *
 * @author Mikael
 */
public interface People {
    
    public String getName();
    
    public int getAge(); 
    
    public enum Occupation {
    
    VISITOR(0),
    SIMPLE_EMPLOYEE(1),
    MANAGER(2),
    ADMINISTRATION(3),
    EXECUTIVE(4),
    CEO(5);

    public int accessLevel;
    Occupation(int access){
        this.accessLevel = access;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }
    
    }
    
    public enum Gender {
    MALE,
    FEMALE;
}
    
}
