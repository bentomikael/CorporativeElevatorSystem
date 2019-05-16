package br.ufsc.ine5605.CorporativeElevatorSystem;

public class Report {
    private final String employeeName; // usuario atual
    private final String type; // Registered , Removed , Changed, Go To Floor
    private final String thatName; // usuario secundario, qual foi alterado
    private final String date;
    private final String hour;    
    private final String floor;

    public Report(String employeeName, String type, String thatName, 
                  String date, String hour, String floor) {
        
        this.employeeName = employeeName;
        this.type = type;
        this.thatName = thatName;
        this.date = date;
        this.hour = hour;
        this.floor = floor;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getType() {
        return type;
    }

    public String getThatName() {
        return thatName;
    }

    public String getDate() {
        return date;
    }

    public String getHour() {
        return hour;
    }

    public String getFloor() {
        return floor;
    }

    
   
    
    
    
}
