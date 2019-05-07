package br.ufsc.ine5605.CorporativeElevatorSystem;

/**
 *
 * @author Acer
 */
public interface IMessages {
    
    public void mSuccessAdd();
    public void mSuccessDel();
    public void mSuccessChange();
    public void mInvalidName();
    public void mInvalidOption();
    public void mDontHavePermision();
    public void mLogout();
    public void mAlreadyRegistered();
    public void mChangeSelfErro();
    public void mNotFound();
    public void mChoseOption();
    public void mExit();
    public void mEnteredFloor();
    public void mCanceled();
    public void mAccessLevelOptions(int actualUserLevel,String text);
}
