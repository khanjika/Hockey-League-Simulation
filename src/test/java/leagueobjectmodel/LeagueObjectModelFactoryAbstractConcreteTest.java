package leagueobjectmodel;

import java.util.Random;

public class LeagueObjectModelFactoryAbstractConcreteTest extends LeagueObjectModelFactoryAbstractTest {
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


    @Override
    public IFreeAgentModel getFreeAgent() {
        return LeagueObjectModelAbstractFactory.getInstance().getFreeAgent();
    }

    @Override
    public void setFreeAgent(IFreeAgentModel freeAgent) {
        LeagueObjectModelAbstractFactory.getInstance().setFreeAgent(freeAgent);
    }

    @Override
    public ILeagueModel getLeague() {
        return LeagueObjectModelAbstractFactory.getInstance().getLeague();
    }


    @Override
    public void setLeague(ILeagueModel league) {
        LeagueObjectModelAbstractFactory.getInstance().setLeague(league);
    }


    @Override
    public IFreeAgentValidator getFreeAgentModelValidator() {
        return LeagueObjectModelAbstractFactory.getInstance().getFreeAgentModelValidator();
    }

    @Override
    public void setFreeAgentModelValidator(IFreeAgentValidator freeAgentValidator) {
        LeagueObjectModelAbstractFactory.getInstance().setFreeAgentModelValidator(freeAgentValidator);
    }

    @Override
    public IConferenceModel getConference() {
        return LeagueObjectModelAbstractFactory.getInstance().getConference();
    }

    @Override
    public void setConference(IConferenceModel conference) {
        LeagueObjectModelAbstractFactory.getInstance().setConference(conference);
    }

    @Override
    public IDivisonModel getDivision() {

        return LeagueObjectModelAbstractFactory.getInstance().getDivision();
    }

    @Override
    public void setDivision(IDivisonModel division) {
        LeagueObjectModelAbstractFactory.getInstance().setDivision(division);
    }

    @Override
    public ITeamsModel getTeams() {
        return LeagueObjectModelAbstractFactory.getInstance().getTeams();
    }

    @Override
    public void setTeams(ITeamsModel teams) {
        LeagueObjectModelAbstractFactory.getInstance().setTeams(teams);
    }

    @Override
    public IPlayerModel getPlayer() {
        return LeagueObjectModelAbstractFactory.getInstance().getNewPlayerModel();
    }

    @Override
    public void setPlayer(IPlayerModel player) {
        LeagueObjectModelAbstractFactory.getInstance().setPlayer(player);
    }

    @Override
    public IGamePlayConfigModel getGamePlayConfig() {

        return LeagueObjectModelAbstractFactory.getInstance().getGamePlayConfig();
    }

    @Override
    public void setGamePlayConfig(IGamePlayConfigModel gamePlayConfig) {
        LeagueObjectModelAbstractFactory.getInstance().setGamePlayConfig(gamePlayConfig);
    }

    @Override
    public IHeadCoachModel getHeadCoach() {

        return LeagueObjectModelAbstractFactory.getInstance().getHeadCoach();
    }

    @Override
    public void setHeadCoach(IHeadCoachModel headCoach) {
        LeagueObjectModelAbstractFactory.getInstance().setHeadCoach(headCoach);
    }

    @Override
    public ICoachModel getCoach() {
        return LeagueObjectModelAbstractFactory.getInstance().getCoach();
    }

    @Override
    public void setCoach(ICoachModel coach) {
        LeagueObjectModelAbstractFactory.getInstance().setCoach(coach);
    }

    @Override
    public IGeneralManagersModel getGeneralManagers() {

        return LeagueObjectModelAbstractFactory.getInstance().getGeneralManagers();
    }

    @Override
    public void setGeneralManagers(IGeneralManagersModel generalManagers) {
        LeagueObjectModelAbstractFactory.getInstance().setGeneralManagers(generalManagers);
    }

    @Override
    public ILeagueValidator getLeagueValidator() {

        return LeagueObjectModelAbstractFactory.getInstance().getLeagueValidator();
    }

    @Override
    public void setLeagueValidator(ILeagueValidator leagueValidator) {
        LeagueObjectModelAbstractFactory.getInstance().setLeagueValidator(leagueValidator);
    }

    @Override
    public IConferenceValidator getConferenceValidator() {
        return LeagueObjectModelAbstractFactory.getInstance().getConferenceValidator();
    }

    @Override
    public void setConferenceValidator(IConferenceValidator conferenceValidator) {
        LeagueObjectModelAbstractFactory.getInstance().setConferenceValidator(conferenceValidator);
    }

    @Override
    public IDivisonValidator getDivisionValidator() {

        return LeagueObjectModelAbstractFactory.getInstance().getDivisionValidator();
    }

    @Override
    public void setDivisionValidator(IDivisonValidator divisionValidator) {
        LeagueObjectModelAbstractFactory.getInstance().setDivisionValidator(divisionValidator);
    }

    @Override
    public ITeamsValidator getTeamsValidator() {

        return LeagueObjectModelAbstractFactory.getInstance().getTeamsValidator();
    }

    @Override
    public void setTeamsValidator(ITeamsValidator teamsValidator) {
        LeagueObjectModelAbstractFactory.getInstance().setTeamsValidator(teamsValidator);
    }

    @Override
    public IPlayerValidator getPlayerValidator() {
        if (playerValidator == null) {
            playerValidator = new PlayerValidator();
        }
        return playerValidator;
    }

    @Override
    public void setPlayerValidator(IPlayerValidator playerValidator) {
        this.playerValidator = playerValidator;
    }

    @Override
    public ICoachValidator getCoachValidator() {

        return LeagueObjectModelAbstractFactory.getInstance().getCoachValidator();
    }

    @Override
    public void setCoachValidator(ICoachValidator coachValidator) {
        LeagueObjectModelAbstractFactory.getInstance().setCoachValidator(coachValidator);
    }

    @Override
    public IGeneralManagersValidator getGeneralManagersValidator() {

        return LeagueObjectModelAbstractFactory.getInstance().getGeneralManagersValidator();
    }

    @Override
    public void setGeneralManagersValidator(IGeneralManagersValidator generalManagersValidator) {
        LeagueObjectModelAbstractFactory.getInstance().setGeneralManagers(generalManagers);
    }

    @Override
    public IPlayerModel getNewPlayerModel() {
        return LeagueObjectModelAbstractFactory.getInstance().getNewPlayerModel();
    }

    @Override
    public Random createRandom() {
        return LeagueObjectModelAbstractFactory.getInstance().createRandom();
    }

}


