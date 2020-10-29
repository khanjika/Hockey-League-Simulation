package states;

import cli.InitialCli;
import coach.CoachModel;
import conference.ConferenceModel;
import divison.DivisonModel;
import gameplayconfig.AgingModel;
import gameplayconfig.GamePlayConfigModel;
import league.LeagueModel;
import players.PlayerModel;
import matchSchedules.IRegularSeasonSchedule;
import matchSchedules.RegularSeasonSchedule;
import serializeObject.SerializeObject;
import statemachine.StateMachine;
import teams.TeamsModel;

public class ImportJsonState implements ITransition {
    StateMachine stateMachine;
    InitialCli initialCli;
    private boolean userInput;
    private String cliArgument;
    private LeagueModel inMemoryLeagueModel;
    ITransition createTeamState;

    public ImportJsonState(StateMachine currentStateMachine) {
        stateMachine = currentStateMachine;
    }

    public ImportJsonState(String[] args, StateMachine currentStateMachine) {
        if (args.length == 0) {
            cliArgument = null;
        } else {
            cliArgument = args[0];
        }
        initialCli = new InitialCli();
        stateMachine = currentStateMachine;
    }

    public StateMachine getStateMachine() {
        return stateMachine;
    }

    public void setStateMachine(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public void entry(){
        if (cliArgument == null) {
            stateMachine.setCurrentState(stateMachine.playerChoiceLoadTeam());
            exit();
        } else {
            inMemoryLeagueModel = initialCli.parseJson(cliArgument);

            System.out.println("Printing values for testing");
            System.out.println(inMemoryLeagueModel);
            for (ConferenceModel conferenceModel:inMemoryLeagueModel.getConferences()) {
                System.out.println(conferenceModel.getConferenceName());
            }
            for(ConferenceModel conferenceModel:inMemoryLeagueModel.getConferences()){
                System.out.println(conferenceModel.getConferenceName());
                for(DivisonModel divisonModel:conferenceModel.getDivisions()){
                    for(TeamsModel teamsModel:divisonModel.getTeams()){
                        System.out.println("--------Team and Player Strength---------");
                        System.out.println(teamsModel.getTeamName());
                        teamsModel.calculateTeamStrength(teamsModel);
                        System.out.println(teamsModel.getTeamName()+" : "+teamsModel.getTeamStrength());
                        for (PlayerModel playerModel : teamsModel.getPlayers()){
                            playerModel.calculatePlayerStrength(playerModel);
                            System.out.println(playerModel.getPlayerName()+" : "+playerModel.getPlayerStrength());
                        }
                    }
                }
            }
            System.out.println(inMemoryLeagueModel.getGeneralManagers());
            for(CoachModel coachModel:inMemoryLeagueModel.getCoaches()){
                System.out.println(coachModel.getName());
            }
            GamePlayConfigModel gamePlayConfigModel = inMemoryLeagueModel.getGameplayConfig();
            System.out.println("---------------AGING-------------------");
            System.out.println(gamePlayConfigModel.getAging().getAverageRetirementAge());
            System.out.println(gamePlayConfigModel.getAging().getMaximumAge());

            System.out.println("---------------GameResolver-------------------");
            System.out.println(gamePlayConfigModel.getGameResolver().getRandomWinChance());

            System.out.println("---------------Injuries-------------------");
            System.out.println(gamePlayConfigModel.getInjuries().getRandomInjuryChance());
            System.out.println(gamePlayConfigModel.getInjuries().getInjuryDaysLow());
            System.out.println(gamePlayConfigModel.getInjuries().getInjuryDaysHigh());

            System.out.println("---------------training-------------------");
            System.out.println(gamePlayConfigModel.getTraining().getDaysUntilStatIncreaseCheck());

            System.out.println("---------------Trading-------------------");
            System.out.println(gamePlayConfigModel.getTrading().getLossPoint());
            System.out.println(gamePlayConfigModel.getTrading().getRandomTradeOfferChance());
            System.out.println(gamePlayConfigModel.getTrading().getMaxPlayersPerTrade());
            System.out.println(gamePlayConfigModel.getTrading().getRandomAcceptanceChance());
            task();
        }
    }

    @Override
    public void task(){
        createTeamState = new CreateTeamState(inMemoryLeagueModel, stateMachine);
        stateMachine.setCreateTeam(createTeamState);
        stateMachine.setCurrentState(stateMachine.playerChoiceCreateTeam());
        exit();
    }

    @Override
    public void exit(){
        stateMachine.getCurrentState().entry();
    }
}
