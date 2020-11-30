package statemachine.training;


public abstract class TrainingAbstractFactoryTest {

    private static TrainingAbstractFactoryTest instance;

    public static TrainingAbstractFactoryTest instance() {
        if (instance == null) {
            instance = new TrainingAbstractFactoryConcreteTest();
        }
        return instance;
    }

    public abstract ITraining createTraining();

    public abstract void setTraining(ITraining training);
}
