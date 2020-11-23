package leagueobjectmodel;

public interface IDivisonValidator {

    boolean validateDivisionObject(DivisonModel divisonModel);

    boolean isDivisionExist(LeagueModel leagueModel, String divisionName);
}
