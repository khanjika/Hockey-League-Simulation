package leagueobjectmodel;

public class LeagueObjectModelFactoryAbstractConcrete extends LeagueObjectModelAbstractFactory {
    private ILeagueModel league;
    private IConferenceModel conference;
    private IDivisonModel division;
    private ITeamsModel teams;
    private IPlayerModel player;
    private IGamePlayConfigModel gamePlayConfig;
    private IHeadCoachModel headCoach;
    private ICoachModel coach;
    private IGeneralManagersModel generalManagers;

    @Override
    public ILeagueModel getLeague() {
        if (league == null) {
            league = new LeagueModel();
        }
        return league;
    }

    @Override
    public void setLeague(ILeagueModel league) {
        this.league = league;
    }

    @Override
    public IConferenceModel getConference() {
        if (conference == null) {
            conference = new ConferenceModel();
        }
        return conference;
    }

    @Override
    public void setConference(IConferenceModel conference) {
        this.conference = conference;
    }

    @Override
    public IDivisonModel getDivision() {
        if (division == null) {
            division = new DivisonModel();
        }
        return division;
    }

    @Override
    public void setDivision(IDivisonModel division) {
        this.division = division;
    }

    @Override
    public ITeamsModel getTeams() {
        if (teams == null) {
            teams = new TeamsModel();
        }
        return teams;
    }

    @Override
    public void setTeams(ITeamsModel teams) {
        this.teams = teams;
    }

    @Override
    public IPlayerModel getPlayer() {
        if (player == null) {
            player = new PlayerModel();
        }
        return player;
    }

    @Override
    public void setPlayer(IPlayerModel player) {
        this.player = player;
    }

    @Override
    public IGamePlayConfigModel getGamePlayConfig() {
        if (gamePlayConfig == null) {
            gamePlayConfig = new GamePlayConfigModel();
        }
        return gamePlayConfig;
    }

    @Override
    public void setGamePlayConfig(IGamePlayConfigModel gamePlayConfig) {
        this.gamePlayConfig = gamePlayConfig;
    }

    @Override
    public IHeadCoachModel getHeadCoach() {
        if (headCoach == null) {
            headCoach = new HeadCoachModel();
        }
        return headCoach;
    }

    @Override
    public void setHeadCoach(IHeadCoachModel headCoach) {
        this.headCoach = headCoach;
    }

    @Override
    public ICoachModel getCoach() {
        return coach;
    }

    @Override
    public void setCoach(ICoachModel coach) {
        this.coach = coach;
    }

    @Override
    public IGeneralManagersModel getGeneralManagers() {
        if (generalManagers == null) {
            generalManagers = new GeneralManagersModel();
        }
        return generalManagers;
    }

    @Override
    public void setGeneralManagers(IGeneralManagersModel generalManagers) {
        this.generalManagers = generalManagers;
    }
}
