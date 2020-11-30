package statemachine.training;

public class TrainingAbstractFactoryConcreteTest extends TrainingAbstractFactoryTest{

    @Override
    public ITraining getTraining() {
        return TrainingAbstractFactory.getInstance().getTraining();
    }

    @Override
    public void setTraining(ITraining training) {
        TrainingAbstractFactory.getInstance();
    }
}
