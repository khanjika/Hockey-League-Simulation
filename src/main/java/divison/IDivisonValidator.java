package divison;

import league.LeagueModel;

public interface IDivisonValidator {

    boolean validateDivisionObject(DivisonModel divisonModel);

    boolean isDivisionExist(LeagueModel leagueModel, String divisionName);
}
