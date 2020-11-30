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
    Winner(" is ")
    ;


    private String value;

    TrophySystemConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
