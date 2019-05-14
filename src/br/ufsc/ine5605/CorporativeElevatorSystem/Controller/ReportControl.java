package br.ufsc.ine5605.CorporativeElevatorSystem.Controller;

import br.ufsc.ine5605.CorporativeElevatorSystem.Report;
import java.util.ArrayList;

public class ReportControl {
    private ArrayList<Report> reports;

    public ReportControl() {
        reports = new ArrayList();
    }

    public ArrayList<Report> getReports() {
        return reports;
    }
        
    public void addReport(int employeeCode, String hour, String day, String activity, int floor){
        reports.add( new Report(employeeCode, hour, day, activity,floor) );
    }
    
    public ArrayList getReportByDay(String day){
        ArrayList array = new ArrayList();
        for(Report r:reports)
            if(r.getDay() == day)
                array.add(r);
        return array;
        }
    public ArrayList getReportByFloor(int floor){
    ArrayList array = new ArrayList();
        for(Report r:reports)
            if(r.getFloor() == floor)
                array.add(r);
        return array;
    }
    public ArrayList getReportByEmployeeCode(int EmployeeCode){
        ArrayList array = new ArrayList();
        for(Report r:reports)
            if(r.getEmployeeCode()== EmployeeCode)
                array.add(r);
        return array;
    }
    public ArrayList getReportByActivity(String activity){
        ArrayList array = new ArrayList();
        for(Report r:reports)
            if(r.getActivity().equals(activity))
                array.add(r);
        return array;
    }
    
}
