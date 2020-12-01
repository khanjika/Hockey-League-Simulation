package statemachine.training;

public abstract class TrainingAbstractFactory {
    private static TrainingAbstractFactory unique_instance = null;

    public static TrainingAbstractFactory instance(){
        if(unique_instance == null){
            unique_instance = new TrainingAbstractFactoryConcrete();
        }
        return unique_instance;
    }

    public abstract ITraining createTraining();

    public abstract void setTraining(ITraining training);

}
