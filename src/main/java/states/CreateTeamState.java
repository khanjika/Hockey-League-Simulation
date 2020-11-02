package states;

import cli.CreateTeamCli;
import coach.CoachModel;
import league.ILeagueModel;
import league.LeagueModel;
import matchSchedules.PlayoffSchedule;
import serializeObject.SerializeObject;
import statemachine.StateMachine;

public class CreateTeamState implements ITransition {
    StateMachine stateMachine;
    LeagueModel currentModel;
    CreateTeamCli createTeamCli;

    LeagueModel updatedLeagueModel;
    PlayerSeasonsChoiceState playerSeasonsChoiceState;
    ILeagueModel iLeagueModel;

    public CreateTeamState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public CreateTeamState(LeagueModel leagueModel, StateMachine stateMachine) {
        iLeagueModel = new LeagueModel();
        createTeamCli = new CreateTeamCli();
        this.currentModel = leagueModel;
        this.stateMachine = stateMachine;
    }

    public StateMachine getStateMachine() {
        return stateMachine;
    }

    public void setStateMachine(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public LeagueModel getUpdatedLeagueModel() { return updatedLeagueModel; }

    public void setUpdatedLeagueModel(LeagueModel updatedLeagueModel) { this.updatedLeagueModel = updatedLeagueModel; }
    @Override
    public void entry() {
        task();
    }

    @Override
    public void task() {
        this.updatedLeagueModel = createTeamCli.createNewTeam(currentModel);
        PlayoffSchedule playoffSchedule = new PlayoffSchedule();
        playoffSchedule.generatePlayoffSchedule(updatedLeagueModel);
        exit();
    }

    @Override
    public void exit() {
            SerializeObject serializeObject = new SerializeObject();
            serializeObject.serializeLeagueObject(this.updatedLeagueModel);
            playerSeasonsChoiceState = new PlayerSeasonsChoiceState(updatedLeagueModel, stateMachine);
            stateMachine.setPlayerSeasonsChoice(playerSeasonsChoiceState);
            stateMachine.setCurrentState(stateMachine.getPlayerSeasonsChoice());
            stateMachine.getCurrentState().entry();
    }

}

