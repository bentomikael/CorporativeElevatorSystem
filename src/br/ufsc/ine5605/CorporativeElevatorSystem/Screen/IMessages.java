package br.ufsc.ine5605.CorporativeElevatorSystem.Screen;

/**
 *
 * @author Acer
 */
public interface IMessages {
    
    
    public void mInvalidOption();
    public void mDontHavePermision();
    public void mAlreadyRegistered();
    public void mNotFound();
    public void mChoseOption();
    public void mCanceled();
    public void mAccessLevelOptions(int actualUserLevel,String text);
}
