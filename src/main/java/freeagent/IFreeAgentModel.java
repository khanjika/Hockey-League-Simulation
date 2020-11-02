package freeagent;

import league.LeagueModel;

import java.util.List;

public interface IFreeAgentModel {
    void calculateFreeAgentStrength(FreeAgentModel freeAgentModel);
    void aging(FreeAgentModel freeAgentModel, int daysToAge);
    FreeAgentModel getReplacementFreeAgent(List<FreeAgentModel> freeAgents, String playerPosition);
   void storeFreeAgentInformation(FreeAgentModel freeAgentModel, int leagueId);

}
