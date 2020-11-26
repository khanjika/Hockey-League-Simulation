package statemachine.jsonparser;

public abstract class ParserAbstractFactory {
    private static ParserAbstractFactory unique_instance = null;

    public static ParserAbstractFactory getInstance() {
        if (unique_instance == null){
            unique_instance = new ParserAbstractFactoryConcrete();
        }
        return unique_instance;
    }

    public abstract IParser getParser();
}
