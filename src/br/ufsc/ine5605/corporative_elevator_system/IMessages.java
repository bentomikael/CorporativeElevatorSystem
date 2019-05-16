package br.ufsc.ine5605.CorporativeElevatorSystem;

/**
 *
 * @author Acer
 */
public interface IMessages {
    
    
    public void mInvalidOption();
    public void mInvalidCode();
    public void mDontHavePermision();
    public void mAlreadyRegistered();
    public void mNotFound();
    public void mChoseOption();
    public void mCanceled();
    public void mAccessLevelOptions(int actualUserLevel,String text,int currentFloor);
}
