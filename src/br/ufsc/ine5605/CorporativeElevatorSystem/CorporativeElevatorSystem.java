package br.ufsc.ine5605.CorporativeElevatorSystem;

import br.ufsc.ine5605.CorporativeElevatorSystem.Controller.MainControl;

/**
 * @author Mikael Bento e Vinicius Hilbert
 */
public class CorporativeElevatorSystem {

    /* PIN  
     *9999 = CEO
    * 8888 = EXECUTIVE
    * 7777 = ADMNISTRATIVE
    * 6666 = MANAGER
    * 5555 = SIMPLE
    */
    public static void main(String[] args) {
        new MainControl().start();
    }
   
    //fazer try e catch 
    //completar controlador de report e metodo de report em controlador principal
    //bug: não está alterando Cargo de funcionario. esta alterando nivel de acesso mas não altera ocupação
    //passar enum de cargo de pessoa para funcionario
}
