package statemachine.jsonparser;

public enum ParserConstants {
    FileNotExists("File does not exists in the specified location"),
    FileValid("Your Provided JSON is valid."),
    FileInvalid("Invalid JSON"),
    Error("Error occurred while parsing the file due to syntax issue");
    private String value;

    ParserConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
