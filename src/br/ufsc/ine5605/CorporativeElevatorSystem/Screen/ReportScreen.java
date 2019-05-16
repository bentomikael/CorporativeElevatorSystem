package br.ufsc.ine5605.CorporativeElevatorSystem.Screen;

public class ReportScreen extends Screen{

    public ReportScreen() {
    }
    
    
    public int reportScreen(){
        System.out.println("--------GET REPORTS OF SYSTEM--------");
        mChoseOption();
        System.out.println("1 - Report of Floor");
        System.out.println("2 - Report of Employee");
        System.out.println("3 - Report of Day");
        System.out.println("4 - Report of Hour");
        System.out.println("5 - Report of registered employees");
        System.out.println("6 - Report of removed employees");
        System.out.println("7 - Report General");
        return inputInt(7);    
    }
    
    
    
}
