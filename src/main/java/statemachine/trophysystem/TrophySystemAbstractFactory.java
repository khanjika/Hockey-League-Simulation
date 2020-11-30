package statemachine.trophysystem;

public abstract class TrophySystemAbstractFactory {

    private static TrophySystemAbstractFactory unique_instance = null;

    public static TrophySystemAbstractFactory getInstance(){
        if(unique_instance == null){
            unique_instance = new TrophySystemAbstractFactoryConcrete();
        }
        return unique_instance;
    }

    public abstract ITrophySystem getTrophySystem();

    public abstract void setTrophySystem(ITrophySystem trophySystem);
}
