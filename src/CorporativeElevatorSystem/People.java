package CorporativeElevatorSystem;

/**
 *
 * @author 
 */
public abstract class People {
    protected String name;
    protected int age;
    protected enum Gender {MALE,FEMALE;};
   
    public String getName(){
        return name;
    }
    
    public int getAge(){
        return age;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    
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
        
        public void setAccessLevel(int access){
            accessLevel = access;
        }
        
    
    }
   
}