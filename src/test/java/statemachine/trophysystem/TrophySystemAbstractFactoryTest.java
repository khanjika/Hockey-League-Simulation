package statemachine.trophysystem;


public abstract class TrophySystemAbstractFactoryTest {

    private static TrophySystemAbstractFactoryTest instance;

    public static TrophySystemAbstractFactoryTest getTrophySystemInstance() {
        if (instance == null) {
            instance = new TrophySystemAbstractFactoryConcreteTest();
        }
        return instance;
    }

    public abstract ITrophySystem getTrophySystem();

    public abstract void setTrophySystem(ITrophySystem trophySystem);
}
