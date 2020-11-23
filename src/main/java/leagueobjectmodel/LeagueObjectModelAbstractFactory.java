package leagueobjectmodel;

public abstract class LeagueObjectModelAbstractFactory {

    private static LeagueObjectModelAbstractFactory unique_instance = null;

    public static LeagueObjectModelAbstractFactory getInstance() {
        if (unique_instance == null) {
            unique_instance = new LeagueObjectModelFactoryAbstractConcrete();
        }
        return unique_instance;
    }

    public abstract ILeagueModel getLeague();

    public abstract void setLeague(ILeagueModel league);

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
}