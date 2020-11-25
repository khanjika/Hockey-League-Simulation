package serializeobject;

public interface IFileValidator {
    boolean isFileExist(String name);
    String filePath(String name);
}
