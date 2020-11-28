package database.serializeobject;

public class SerializeObjectAbstractFactoryConcrete extends SerializeObjectAbstractFactory{
    private IFileValidator fileValidator;
    private ISerializeObject serializeObject;

    @Override
    public IFileValidator getFileValidator() {
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
    public ISerializeObject getSerializeObject() {
        if (serializeObject == null){
            serializeObject = new SerializeObject();
        }
        return serializeObject;
    }

    @Override
    public void setSerializeObject(ISerializeObject serializeObject) {
        this.serializeObject = serializeObject;
    }
}
