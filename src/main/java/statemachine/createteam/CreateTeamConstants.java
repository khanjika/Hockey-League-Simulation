package statemachine.createteam;

public enum CreateTeamConstants {
    LineSeperator("========================================================="),
    ConferenceName("Conference name->    "),
    DivisionName("Division name->     "),
    TeamNames("Team is--->   "),
    ChoiceError("Enter a valid choice from the displayed list"),
    InvalidString("Invalid String (Please enter string only)"),
    NotInJson("Does not exist in the provided JSON"),
    Success("In memory Team created Successfully!!"),
    EnterConference("Enter Conference name in which you want to create new Team"),
    EnterDivision("Enter Division name in which you want to create new Team"),
    EnterTeam("Enter new team name to be created"),
    EnterCaptain("Select a captain for the team"),
    EnterManager("Select a Manager for the team"),
    EnterCoach("Select a Head Coach for the team"),
    Enter("Enter "),
    EnterGoalies(" more Goalies for the team"),
    EnterForwards(" more Forwards for the team"),
    EnterDefense(" more Defense for the team"),
    TeamCaptain(" is the team captain"),
    Instruction("Here You need to create a new Team in the EXISTING division"),
    DisplayPlayerList("The newly created team players"),
    DisplayActivePlayers("Active team players list"),
    DisplayInactivePlayers("Inactive team players list"),
    LogInfoCreateTeam("New Team created and saved in memory"),
    LogErrorCreateTeam("Error occured while creating new team in the existing league"),
    LogError("Input mismatch error while entering choice")
    ;

    private String value;

    CreateTeamConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
