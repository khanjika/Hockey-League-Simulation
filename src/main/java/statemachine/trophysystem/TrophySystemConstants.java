package statemachine.trophysystem;

public enum TrophySystemConstants {
    CoachTrophy("Jack Adam's Award"),
    PlayerTrophy("Calder Memorial Trophy"),
    BestTeamTrophy("President's Trophy"),
    LowestTeamTrophy("Participation Trophy"),
    DefenseManTrophy("Rob Hawkey Memorial Cup"),
    ForwardManTrophy("Maurice Richard Trophy"),
    GoalieTrophy("Vezina Trophy"),
    LineSpace("\n"),
    LineSeperator("=================================="),
    Year("Winner of the trophy of the year "),
    Winner(" is "),
    LogError("League object is null in trophy system"),
    ExceptionError("League Object is not initialized for trophy system"),
    LogInfoTeamsUpdate("Teams Standing Observer notified and updated"),
    LogInfoTeamsDisplay("Teams Standing Observer display notified and displayed"),
    LogInfoPlayerUpdate("Player Standing Observer notified and updated"),
    LogInfoPlayerDisplay("Player Standing Observer display notified and displayed"),
    LogInfoGoalieUpdate("Goalie Standing Observer notified and updated"),
    LogInfoGoalieDisplay("Goalie Standing Observer display notified and displayed"),
    LogInfoForwardUpdate("Forward Standing Observer notified and updated"),
    LogInfoForwardDisplay("Forward Standing Observer display notified and displayed"),
    LogInfoDefenseUpdate("Defense Standing Observer notified and updated"),
    LogInfoDefenseDisplay("Defense Standing Observer display notified and displayed"),
    LogInfoCoachUpdate("Coach Standing Observer notified and updated"),
    LogInfoCoachDisplay("Coach Standing Observer display notified and displayed"),
    LogInfoSubjectUpdate("All the observers of the subjects are notified for update"),
    LogInfoSubjectDisplay("All the observers of the subjects are notified for diplay")
    ;


    private String value;

    TrophySystemConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
