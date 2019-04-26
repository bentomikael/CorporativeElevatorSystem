package sistemaelevadorcorporativo;

/**
 *
 * @author Acer
 */
public enum Occupation {
    
    VISITOR(0),
    SIMPLE_EMPLOYEE(1),
    MANAGER(2),
    ADMINISTRATION(3),
    EXECUTIVE(4),
    CEO(5);

    private int accessLevel;
    Occupation(int access){
        this.accessLevel = access;
    }
    
    public int getAccessLevelNumber(){
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }
    
}
