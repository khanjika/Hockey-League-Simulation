package database;

public enum ParserConstants {
    FileNotExists("File does not exists in the specified location"),
    FileValid("Your Provided JSON is valid."),
    FileInvalid("Invalid JSON"),
    Error("Error occurred while parsing the file due to syntax issue"),
    LogInfo("File parsed successfully from the given filepath"),
    LogError("Encountered error while parsing the file from given location");
    private String value;

    ParserConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
