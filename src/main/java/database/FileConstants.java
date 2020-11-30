package database;

public enum FileConstants {
    DirectoryPath("src\\main\\java\\database\\datasource\\"),
    FileType(".JSON"),
    LogErrorWrite("Error while writing to file "),
    LogInfoWrite("Stored data to JSON file");

    private String value;
    FileConstants(String value) {
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
