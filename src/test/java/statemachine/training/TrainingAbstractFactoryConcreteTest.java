package statemachine.training;

public class TrainingAbstractFactoryConcreteTest extends TrainingAbstractFactoryTest{

    @Override
    public ITraining createTraining() {
        return TrainingAbstractFactory.instance().createTraining();
    }

    @Override
    public void setTraining(ITraining training) {
        TrainingAbstractFactory.instance();
    }
}
