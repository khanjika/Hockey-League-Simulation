package leagueobjectmodel;

import java.util.Random;

public abstract class LeagueObjectModelFactoryAbstractTest  {
    private static LeagueObjectModelFactoryAbstractTest instance;

    public static LeagueObjectModelFactoryAbstractTest getInstance(){
        if(instance == null){
            instance = new LeagueObjectModelFactoryAbstractConcreteTest();
        }
        return instance;
    }

    public abstract IFreeAgentModel getFreeAgent();

    public abstract void setFreeAgent(IFreeAgentModel freeAgent);

    public abstract ILeagueModel getLeague();

    public abstract void setLeague(ILeagueModel league);

    public abstract IFreeAgentValidator getFreeAgentModelValidator();

    public abstract void setFreeAgentModelValidator(IFreeAgentValidator freeAgentValidator);

    public abstract IConferenceModel getConference();

    public abstract void setConference(IConferenceModel conference);

    public abstract IDivisonModel getDivision();

    public abstract void setDivision(IDivisonModel division);

    public abstract ITeamsModel getTeams();

    public abstract void setTeams(ITeamsModel teams);

    public abstract IPlayerModel getPlayer();

    public abstract void setPlayer(IPlayerModel player);

    public abstract IGamePlayConfigModel getGamePlayConfig();

    public abstract void setGamePlayConfig(IGamePlayConfigModel gamePlayConfig);

    public abstract IHeadCoachModel getHeadCoach();

    public abstract void setHeadCoach(IHeadCoachModel headCoach);

    public abstract ICoachModel getCoach();

    public abstract void setCoach(ICoachModel coach);

    public abstract IGeneralManagersModel getGeneralManagers();

    public abstract void setGeneralManagers(IGeneralManagersModel generalManagers);

    public abstract ILeagueValidator getLeagueValidator();

    public abstract void setLeagueValidator(ILeagueValidator leagueValidator);

    public abstract IConferenceValidator getConferenceValidator();

    public abstract void setConferenceValidator(IConferenceValidator conferenceValidator);

    public abstract IDivisonValidator getDivisionValidator();

    public abstract void setDivisionValidator(IDivisonValidator divisionValidator);

    public abstract ITeamsValidator getTeamsValidator();

    public abstract void setTeamsValidator(ITeamsValidator teamsValidator);

    public abstract IPlayerValidator getPlayerValidator();

    public abstract void setPlayerValidator(IPlayerValidator playerValidator);

    public abstract ICoachValidator getCoachValidator();

    public abstract void setCoachValidator(ICoachValidator coachValidator);

    public abstract IGeneralManagersValidator getGeneralManagersValidator();

    public abstract void setGeneralManagersValidator(IGeneralManagersValidator generalManagersValidator);

    public abstract IPlayerModel getNewPlayerModel();

    public abstract Random createRandom();
}
