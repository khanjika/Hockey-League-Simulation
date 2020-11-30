package database;

public interface IFileValidator {
    boolean isFileExist(String name);
    String filePath(String name);
}
