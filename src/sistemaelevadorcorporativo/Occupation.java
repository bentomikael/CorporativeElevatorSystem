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

    private int levelAccess;
    Occupation(int access){
        this.levelAccess = access;
    }
    
    public int getAccessLevelNumber(){return levelAccess;
    }

    public void setLevelAccess(int levelAccess) {
        this.levelAccess = levelAccess;
    }
    
}
