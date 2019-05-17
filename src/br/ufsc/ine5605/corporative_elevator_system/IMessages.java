package br.ufsc.ine5605.corporative_elevator_system;

/**
 *
 * @author Acer
 */
public interface IMessages {
    
    
    public void mInvalidOption();
    public void mInvalidCode();
    public void mInvalidName();
    public void mDontHavePermision();
    public void mAlreadyRegistered();
    public void mNotFound();
    public void mCanceled();
    public void mAccessLevelOptions(int actualUserLevel,String text);
    public void mWentInFloor(int floor);
    public void mLeavingFloor();
    public void mStandBy();
    public void mToExit();
    public void mChangeSelf();
    
}
