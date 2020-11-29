package leagueobjectmodel;

public interface IDivisonValidator {

    boolean validateDivisionObject(IDivisonModel divisonModel);

    boolean isDivisionExist(ILeagueModel leagueModel, String divisionName);
}
