package database;

public class SerializeObjectAbstractFactoryConcrete extends SerializeObjectAbstractFactory{
    private IFileValidator fileValidator;
    private ISerializeObject serializeObject;

    @Override
    public IFileValidator createFileValidator() {
        if(fileValidator == null){
            fileValidator = new FileValidator();
        }
        return fileValidator;
    }

    @Override
    public void setFileValidator(IFileValidator fileValidator) {
        this.fileValidator = fileValidator;
    }

    @Override
    public ISerializeObject createSerializeObject() {
        if (serializeObject == null){
            serializeObject = new SerializeObject();
        }
        return serializeObject;
    }

    @Override
    public void setSerializeObject(ISerializeObject serializeObject) {
        this.serializeObject = serializeObject;
    }

    private IDeserializeObject parser;

    @Override
    public IDeserializeObject createParser() {
        if (parser == null){
            parser = new DeserializeObject();
        }
        return parser;
    }
}
