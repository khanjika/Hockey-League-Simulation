package statemachine.loadteam;

public enum LoadTeamConstants {
    LineSeperator("============================================="),
    TeamName("Enter Team Name"),
    TeamExist("The Team name entered exists in the league"),
    LoadData("Loading the data...."),
    TeamNotExist("Team does not exists!. Please provide a valid team name to continue..."),
    NullException("Encountered error while parsing the file ");
    private String value;

    LoadTeamConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
