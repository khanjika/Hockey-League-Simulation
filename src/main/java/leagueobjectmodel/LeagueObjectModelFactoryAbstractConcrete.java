package leagueobjectmodel;

import java.util.Random;

public class LeagueObjectModelFactoryAbstractConcrete extends LeagueObjectModelAbstractFactory {
    private ILeagueModel league;
    private ILeagueValidator leagueValidator;
    private IConferenceModel conference;
    private IConferenceValidator conferenceValidator;
    private IDivisonModel division;
    private IDivisonValidator divisionValidator;
    private ITeamsModel teams;
    private ITeamsValidator teamsValidator;
    private IPlayerModel player;
    private IPlayerValidator playerValidator;
    private IFreeAgentModel freeAgent;
    private IFreeAgentValidator freeAgentValidator;
    private IGamePlayConfigModel gamePlayConfig;
    private IHeadCoachModel headCoach;
    private ICoachValidator coachValidator;
    private ICoachModel coach;
    private IGeneralManagersModel generalManagers;
    private IGeneralManagersValidator generalManagersValidator;
    private IFreeAgentModel freeAgentModel;
    private IPlayerModel newPlayerModel;
    private Random random;
    private ISortTeams sortTeams;

    @Override
    public IFreeAgentModel getFreeAgent() {
        if (freeAgent == null) {
            freeAgent = new FreeAgentModel ();
        }
        return freeAgent;
    }

    @Override
    public void setFreeAgent(IFreeAgentModel freeAgent) {
        this.freeAgent = freeAgent;
    }

    @Override
    public ILeagueModel getLeague() {
        if (league == null) {
            league = new LeagueModel ();
        }
        return league;
    }

    @Override
    public void setLeague(ILeagueModel league) {
        this.league = league;
    }

    @Override
    public IFreeAgentModel getFreeAgentModel(){
        if (freeAgent == null){
            freeAgent = new FreeAgentModel();
        }
        return freeAgent;
    }

    @Override
    public void setFreeAgentModel(IFreeAgentModel freeAgent){
        this.freeAgent = freeAgent;
    }

    @Override
    public IFreeAgentValidator getFreeAgentModelValidator(){
        if (freeAgentValidator == null){
            freeAgentValidator = new FreeAgentValidator();
        }
        return freeAgentValidator;
    }

    @Override
    public void setFreeAgentModelValidator(IFreeAgentValidator freeAgentValidator){
        this.freeAgentValidator = freeAgentValidator;
    }

    @Override
    public IConferenceModel getConference() {
        if (conference == null) {
            conference = new ConferenceModel ();
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
            division = new DivisonModel ();
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
            teams = new TeamsModel ();
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
            player = new PlayerModel ();
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
            gamePlayConfig = new GamePlayConfigModel ();
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
            headCoach = new HeadCoachModel ();
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
            generalManagers = new GeneralManagersModel ();
        }
        return generalManagers;
    }

    @Override
    public void setGeneralManagers(IGeneralManagersModel generalManagers) {
        this.generalManagers = generalManagers;
    }

    @Override
    public ILeagueValidator getLeagueValidator() {
        if (leagueValidator == null) {
            leagueValidator = new LeagueValidator ();
        }
        return leagueValidator;
    }

    @Override
    public void setLeagueValidator(ILeagueValidator leagueValidator) {
        this.leagueValidator = leagueValidator;
    }

    @Override
    public IConferenceValidator getConferenceValidator() {
        if (conferenceValidator == null) {
            conferenceValidator = new ConferenceValidator ();
        }
        return conferenceValidator;
    }

    @Override
    public void setConferenceValidator(IConferenceValidator conferenceValidator) {
        this.conferenceValidator = conferenceValidator;
    }

    @Override
    public IDivisonValidator getDivisionValidator() {
        if (divisionValidator == null) {
            divisionValidator = new DivisonValidator ();
        }
        return divisionValidator;
    }

    @Override
    public void setDivisionValidator(IDivisonValidator divisionValidator) {
        this.divisionValidator = divisionValidator;
    }

    @Override
    public ITeamsValidator getTeamsValidator() {
        if (teamsValidator == null) {
            teamsValidator = new TeamsValidator ();
        }
        return teamsValidator;
    }

    @Override
    public void setTeamsValidator(ITeamsValidator teamsValidator) {
        this.teamsValidator = teamsValidator;
    }

    @Override
    public IPlayerValidator getPlayerValidator() {
        if (playerValidator == null) {
            playerValidator = new PlayerValidator ();
        }
        return playerValidator;
    }

    @Override
    public void setPlayerValidator(IPlayerValidator playerValidator) {
        this.playerValidator = playerValidator;
    }

    @Override
    public ICoachValidator getCoachValidator() {
        if (coachValidator == null) {
            coachValidator = new CoachValidator ();
        }
        return coachValidator;
    }

    @Override
    public void setCoachValidator(ICoachValidator coachValidator) {
        this.coachValidator = coachValidator;
    }

    @Override
    public IGeneralManagersValidator getGeneralManagersValidator() {
        if (generalManagersValidator == null) {
            generalManagersValidator = new GeneralManagersValidator ();
        }
        return generalManagersValidator;
    }

    @Override
    public void setGeneralManagersValidator(IGeneralManagersValidator generalManagersValidator) {
        this.generalManagersValidator = generalManagersValidator;
    }

    @Override
    public IPlayerModel getNewPlayerModel() {
        return newPlayerModel = new PlayerModel() ;
    }

    public void setNewPlayerModel(IPlayerModel newPlayerModel) {
        this.newPlayerModel = newPlayerModel;
    }

    @Override
    public Random createRandom() {
        if(random == null){
            random = new Random();
        }
        return random;
    }

    @Override
    public void setRandom(Random random) {
        this.random = random;
    }

    @Override
    public void setSortTeam(ISortTeams sortTeams) {
          this.sortTeams=sortTeams;
    }

    @Override
    public ISortTeams getSortTeams() {
        if(sortTeams == null){
            sortTeams = new SortTeams();
        }
        return sortTeams;
    }
}


