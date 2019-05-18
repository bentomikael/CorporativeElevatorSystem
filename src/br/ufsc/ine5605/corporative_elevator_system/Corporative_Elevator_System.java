package br.ufsc.ine5605.corporative_elevator_system;

import br.ufsc.ine5605.corporative_elevator_system.controller.MainControl;

/**
 *
 * @author Mikael Bento e Vinicius Hilbert
 */
public class Corporative_Elevator_System {
    
    public static void main(String args[]){
        new MainControl().start();
    }
    /*
     * PIN
     * 9999 CEO
     * 8888 EXECUTIVE
     * 7777 ADMINISTRATIVE
     * 6666 MANAGER
     * 5555 SIMPLE EMPLOYEE
     */
}
