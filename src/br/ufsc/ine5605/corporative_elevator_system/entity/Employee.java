package br.ufsc.ine5605.corporative_elevator_system.entity;

public class Employee extends People {
    private final int code;
    private Occupation accessLevel;
    private int currentFloor;
    private final Gender gender;    

    public Employee(int code, Occupation accessLevel, String name, int age, Gender gender) {
        this.code = code;
        this.accessLevel = accessLevel;
        this.name = name;
        this.age = age;
        this.gender = gender;
        currentFloor = 0; 
        
    }
    
    public int getCodeAccess() {return code;}
        
    public int getAccessLevelNumber() {return accessLevel.accessLevel;}
    
    public Occupation getOccupation(){return accessLevel;}
    
    public Gender getGender(){return gender;}

    public int getCurrentFloor() {return currentFloor;}
    
    
    public void setCurrentFloor(int currentFloor) {
        if(this.currentFloor == currentFloor)
            throw new IllegalArgumentException("YOU ALREADY IN THIS FLOOR");
        else
            this.currentFloor = currentFloor;
    }
    
    public void setOccupation(Occupation accessLevel) {this.accessLevel=accessLevel;}

}
