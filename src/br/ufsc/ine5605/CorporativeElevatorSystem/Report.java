package br.ufsc.ine5605.CorporativeElevatorSystem;

public class Report {
    private final int employeeCode;
    private final String hour;
    private final String day;
    private final String activity;
    private final int floor;

    public Report(int employeeCode, String hour,String day, String activity, int floor) {
        this.employeeCode = employeeCode;
        this.hour = hour;
        this.day = day;
        this.activity = activity;
        this.floor = floor;
    }

    public int getEmployeeCode() {
        return employeeCode;
    }


    public String getHour() {
        return hour;
    }

    public String getActivity() {
        return activity;
    }

    public String getDay() {
        return day;
    }

    public int getFloor() {
        return floor;
    }
    
    
    
}
