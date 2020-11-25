package database.serializeobject;

public abstract class SerializeObjectAbstractFactory {
    private static SerializeObjectAbstractFactory unique_instance = null;

    public static SerializeObjectAbstractFactory getInstance(){
        if (unique_instance == null){
            unique_instance = new SerializeObjectAbstractFactoryConcrete();
        }
        return unique_instance;
    }

    public abstract IFileValidator getFileValidator();
    public abstract void setFileValidator(IFileValidator fileValidator);
    public abstract ISerializeObject getSerializeObject();
    public abstract void setSerializeObject(ISerializeObject serializeObject);
}
