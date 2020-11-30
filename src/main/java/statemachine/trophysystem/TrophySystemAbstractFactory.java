package statemachine.trophysystem;

public abstract class TrophySystemAbstractFactory {

    private static TrophySystemAbstractFactory unique_instance = null;

    public static TrophySystemAbstractFactory instance(){
        if(unique_instance == null){
            unique_instance = new TrophySystemAbstractFactoryConcrete();
        }
        return unique_instance;
    }

    public abstract ITrophySystem createTrophySystem();

    public abstract void setTrophySystem(ITrophySystem trophySystem);
}
