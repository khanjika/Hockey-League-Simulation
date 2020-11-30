package statemachine.training;

public enum TrainingConstants {

    LoggerTrainingInfo("Player performed training based on head coach stats "),
    LoggerTrainingError("Player and head coach objects passed to training were not initialized"),
    ExceptionError("Objects passed to training class were null");

    private String value;

    TrainingConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
