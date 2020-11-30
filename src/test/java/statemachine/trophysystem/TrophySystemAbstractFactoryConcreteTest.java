package statemachine.trophysystem;

public class TrophySystemAbstractFactoryConcreteTest extends TrophySystemAbstractFactoryTest{
    @Override
    public ITrophySystem getTrophySystem() {
        return TrophySystemAbstractFactory.getInstance().getTrophySystem();
    }

    @Override
    public void setTrophySystem(ITrophySystem trophySystem) {
        TrophySystemAbstractFactory.getInstance().setTrophySystem(trophySystem);
    }
}
