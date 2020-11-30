package database;

public abstract class SerializeObjectAbstractFactory {
    private static SerializeObjectAbstractFactory unique_instance = null;

    public static SerializeObjectAbstractFactory instance(){
        if (unique_instance == null){
            unique_instance = new SerializeObjectAbstractFactoryConcrete();
        }
        return unique_instance;
    }

    public abstract IFileValidator createFileValidator();
    public abstract void setFileValidator(IFileValidator fileValidator);
    public abstract ISerializeObject createSerializeObject();
    public abstract void setSerializeObject(ISerializeObject serializeObject);
    public abstract IDeserializeObject createParser();
}
