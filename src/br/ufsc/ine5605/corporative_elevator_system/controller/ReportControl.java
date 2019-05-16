package br.ufsc.ine5605.CorporativeElevatorSystem.Controller;

import br.ufsc.ine5605.CorporativeElevatorSystem.Report;
import java.util.ArrayList;

public class ReportControl {
    private ArrayList<Report> reports;

    public ReportControl() {
        reports = new ArrayList();
        
    }

     public void addReport(String employeeName, String type, String thatName, 
                          String date, String hour, String floor){
      
        reports.add(new Report(employeeName,type,thatName,date,hour,floor) );
    }
     
    //<editor-fold defaultstate="collapsed" desc="Gets">
    public ArrayList<Report> getAllReports() {
        return reports;
    }
    
    public ArrayList getReportByEmployee(String EmployeeName){
        ArrayList array = new ArrayList();
        for(Report r:reports)
            if(r.getEmployeeName().equals(EmployeeName))
                array.add(r);
        return array;
    }
    
    public ArrayList getReportByType(String type){
        ArrayList array = new ArrayList();
        for(Report r:reports)
            if(r.getType().equals(type))
                array.add(r);
        return array;
    }
    
    public ArrayList getReportByDate(String date){
        ArrayList array = new ArrayList();
        for(Report r:reports)
            if(r.getDate().equals(date))
                array.add(r);
        return array;
        }
    
    public ArrayList getReportByHour(String hour){
        ArrayList array = new ArrayList();
        for(Report r:reports)
            if(r.getHour().substring(0,2).equals(hour))
                
                array.add(r);
        return array;
    }
    
    public ArrayList getReportByFloor(String floor){
    ArrayList array = new ArrayList();
        for(Report r:reports)
            if(r.getFloor().equals(floor))
                array.add(r);
        return array;
    }
//</editor-fold>
      
    public void printIt (ArrayList<Report> array){
        
        if(array.isEmpty())
            System.out.println("--------NO REPORTS YET--------");
        else{
            System.out.printf("%s %15s %16s %14s %11s %11s\n",
            " _________________", " _______ ","_________ "," ________"," ________"," _________");
            System.out.printf("%s %15s %15s %15s %s %s\n",
            "|       Name      |","|  Action  |","| Altered |","|   Date  |","|   Hour  |","|  Floor  |");
        
            for(Report r : array)
                System.out.printf("%-24s %-15s %-10s %14s %10s %8s \n",
                        r.getEmployeeName(),
                        r.getType(),
                        r.getThatName(),
                        r.getDate(),
                        r.getHour(),
                        r.getFloor());
        }
    
    }
}
