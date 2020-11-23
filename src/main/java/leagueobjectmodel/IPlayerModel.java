package leagueobjectmodel;

import java.time.LocalDate;
import java.util.List;

public interface IPlayerModel {

    void calculatePlayerStrength(PlayerModel playerModel);

    void checkPlayerInjury(PlayerModel playerModel, LocalDate date);

    void aging(PlayerModel playerModel, int daysToAge, LocalDate date);

    void setAgingModel(AgingModel agingModel);

    void setFreeAgentsList(List<FreeAgentModel> freeAgentList);

    InjuriesModel getInjuriesModel();

    void setInjuriesModel(InjuriesModel injuriesModel);
}
