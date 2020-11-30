package statemachine.trophysystem;

public class TrophySystemAbstractFactoryConcreteTest extends TrophySystemAbstractFactoryTest{
    @Override
    public ITrophySystem createTrophySystem() {
        return TrophySystemAbstractFactory.instance().createTrophySystem();
    }

    @Override
    public void setTrophySystem(ITrophySystem trophySystem) {
        TrophySystemAbstractFactory.instance().setTrophySystem(trophySystem);
    }
}
