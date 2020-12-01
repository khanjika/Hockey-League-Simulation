package statemachine.trophysystem;

public class TrophySystemAbstractFactoryConcrete extends TrophySystemAbstractFactory {
    private ITrophySystem trophySystem;

    @Override
    public ITrophySystem createTrophySystem() {
        if(trophySystem == null){
            trophySystem = new TrophySystem();
        }
        return trophySystem;
    }

    @Override
    public void setTrophySystem(ITrophySystem trophySystem) {
        this.trophySystem = trophySystem;
    }
}
