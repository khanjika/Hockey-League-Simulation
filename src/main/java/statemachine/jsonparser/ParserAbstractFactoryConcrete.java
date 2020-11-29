package statemachine.jsonparser;

public class ParserAbstractFactoryConcrete extends ParserAbstractFactory{
    private IParser parser;

    @Override
    public IParser getParser() {
        if (parser == null){
            parser = new Parser();
        }
        return parser;
    }

}
