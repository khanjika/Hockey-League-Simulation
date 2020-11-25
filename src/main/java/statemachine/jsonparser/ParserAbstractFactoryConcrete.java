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

    @Override
    public void setParser(IParser parser) {
        this.parser = parser;
    }
}
