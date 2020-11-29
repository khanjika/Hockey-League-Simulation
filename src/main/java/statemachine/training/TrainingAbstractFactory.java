package statemachine.training;

public abstract class TrainingAbstractFactory {
    private static TrainingAbstractFactory unique_instance = null;

    public static TrainingAbstractFactory getInstance(){
        if(unique_instance == null){
            unique_instance = new TrainingAbstractFactoryConcrete();
        }
        return unique_instance;
    }

    public abstract ITraining getTraining();

}
