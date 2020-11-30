package statemachine.training;


public abstract class TrainingAbstractFactoryTest {

    private static TrainingAbstractFactoryTest instance;

    public static TrainingAbstractFactoryTest getTrainingInstance() {
        if (instance == null) {
            instance = new TrainingAbstractFactoryConcreteTest();
        }
        return instance;
    }

    public abstract ITraining getTraining();

    public abstract void setTraining(ITraining training);
}
