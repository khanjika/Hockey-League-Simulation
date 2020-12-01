package statemachine.trophysystem;


public abstract class TrophySystemAbstractFactoryTest {

    private static TrophySystemAbstractFactoryTest instance;

    public static TrophySystemAbstractFactoryTest instance() {
        if (instance == null) {
            instance = new TrophySystemAbstractFactoryConcreteTest();
        }
        return instance;
    }

    public abstract ITrophySystem createTrophySystem();

    public abstract void setTrophySystem(ITrophySystem trophySystem);
}
