package sistemaelevadorcorporativo;

/**
 *
 * @author Acer
 */
public enum Occupation {
    CEO(5),
    EXECUTIVE(4),
    ADMINISTRATION(3),
    MANAGER(2),
    SIMPLE_EMPLOYEE(1),
    VISITOR(0);
    
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
