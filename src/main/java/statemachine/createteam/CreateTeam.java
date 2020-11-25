package statemachine.createteam;

import cli.CliAbstractFactory;
import cli.ICli;
import cli.IDisplayPersons;
import leagueobjectmodel.*;

import java.util.ArrayList;
import java.util.List;

public class CreateTeam implements ICreateTeam {

    IConferenceValidator conferenceValidator;
    IDivisonValidator divisionValidator;
    private String userEnteredConferenceName;
    private String userEnteredDivisionName;
    private String userEnteredTeamName;
    private GeneralManagersModel userEnteredGeneralManagerName;
    private HeadCoachModel userEnteredHeadCoachName;
    private final IDisplayPersons displayPersons;
    private static ITeamsModel iTeamsModel;
    private final ITeamsValidator iTeamsValidator;
    private final ICli iCli;
    private static ILeagueModel newlyCreatedLeagueModelObject;
    List<PlayerModel> userCreatedPlayers;
    int choice;

    public CreateTeam() {
        conferenceValidator = LeagueObjectModelAbstractFactory.getInstance().getConferenceValidator();
        divisionValidator = LeagueObjectModelAbstractFactory.getInstance().getDivisonValidator();
        userCreatedPlayers = new ArrayList<>();
        displayPersons = CliAbstractFactory.getInstance().getDisplayPersons();
        iTeamsModel = LeagueObjectModelAbstractFactory.getInstance().getTeams();
        newlyCreatedLeagueModelObject = LeagueObjectModelAbstractFactory.getInstance().getLeague();
        iCli = CliAbstractFactory.getInstance().getCli();
        iTeamsValidator = LeagueObjectModelAbstractFactory.getInstance().getTeamsValidator();
    }

    @Override
    public ILeagueModel createNewTeam(ILeagueModel leagueModel) {
        if (isConferenceNameValid(leagueModel)) {
            if (isDivisionNameValid(leagueModel)) {
                if (this.isTeamInformationSetProperly(leagueModel)) {
                    newlyCreatedLeagueModelObject = getNewlyCreatedLeagueObject(leagueModel);
                    iCli.printOutput(CreateTeamConstants.LineSeperator.getValue());
                    for (ConferenceModel conferenceModel : newlyCreatedLeagueModelObject.getConferences()) {
                        iCli.printOutput(CreateTeamConstants.ConferenceName.getValue() + conferenceModel.getConferenceName());
                        for (DivisonModel divisonModel : conferenceModel.getDivisions()) {
                            iCli.printOutput(CreateTeamConstants.DivisionName.getValue() + divisonModel.getDivisionName());
                            for (TeamsModel teamsModel : divisonModel.getTeams()) {
                                iCli.printOutput(CreateTeamConstants.TeamNames.getValue() + teamsModel.getTeamName());
                            }
                        }
                    }
                    iCli.printOutput(CreateTeamConstants.LineSeperator.getValue());
                    return newlyCreatedLeagueModelObject;
                }
            }
        }
        return null;
    }

    private boolean isConferenceNameValid(ILeagueModel leagueModel) {
        iCli.printOutput(CreateTeamConstants.LineSeperator.getValue());
        iCli.printOutput(CreateTeamConstants.Instruction.getValue());
        iCli.printOutput(CreateTeamConstants.LineSeperator.getValue());
        iCli.printOutput(CreateTeamConstants.EnterConference.getValue());
        String conferenceName = iCli.readStringInput();
        if (isStringValid(conferenceName)) {
            if (conferenceValidator.isConferenceExist(leagueModel, conferenceName)) {
                this.userEnteredConferenceName = conferenceName;
                return true;
            } else {
                iCli.printOutput(CreateTeamConstants.NotInJson.getValue());
                isConferenceNameValid(leagueModel);

            }
        } else {
            iCli.printOutput(CreateTeamConstants.InvalidString.getValue());
            isConferenceNameValid(leagueModel);
        }
        return true;
    }

    private boolean isDivisionNameValid(ILeagueModel leagueModel) {
        iCli.printOutput(CreateTeamConstants.EnterDivision.getValue());
        String divisionName = iCli.readStringInput();
        if (isStringValid(divisionName)) {
            if (divisionValidator.isDivisionExist(leagueModel, divisionName)) {
                this.userEnteredDivisionName = divisionName;
                return true;
            } else {
                iCli.printOutput(CreateTeamConstants.NotInJson.getValue());
                isDivisionNameValid(leagueModel);
            }
        } else {
            iCli.printOutput(CreateTeamConstants.InvalidString.getValue());
            isDivisionNameValid(leagueModel);
        }
        return true;
    }

    private boolean isTeamInformationSetProperly(ILeagueModel leagueModel) {
        iCli.printOutput(CreateTeamConstants.EnterTeam.getValue());
        this.userEnteredTeamName = iCli.readStringInput();
        if (iTeamsValidator.isTeamAlreadyExist(this.userEnteredTeamName)) {
            return false;
        }
        leagueModel.setCurrentTeam(this.userEnteredTeamName);
        if (isStringValid(userEnteredTeamName)) {
            getTeamInformation(leagueModel);
            return true;
        }
        return false;
    }

    private void getTeamInformation(ILeagueModel leagueModel){
        getManager(leagueModel);
        getHeadCoach(leagueModel);
        getForwards(leagueModel.getForwards(),leagueModel);
        getDefense(leagueModel.getDefenses(),leagueModel);
        getGoalies(leagueModel.getGoalies(),leagueModel);
        getCaptain();
//        ISortTeams sortTeams = new SortTeams();
//        displayPersons.displayTeamPlayers(sortTeams.sortActivePlayers(userCreatedPlayers));
    }

    private void getForwards(List<FreeAgentModel> availableForwards, ILeagueModel leagueModel){
        int requiredForwards = 16;
        int player = 0;
        while(player < requiredForwards){
            iCli.printOutput(CreateTeamConstants.Enter.getValue() + (requiredForwards - player) + CreateTeamConstants.EnterForwards.getValue());
            displayPersons.displayPlayers(availableForwards);
            choice = iCli.readIntInput();
            if (choice > 0 && choice <= availableForwards.size()){
                createTeamPlayer(availableForwards.get(choice - 1));
                availableForwards.remove(choice-1);
                leagueModel.getFreeAgents().remove(availableForwards.get(choice - 1));
                player ++;
            }
        }
    }

    private void getDefense(List<FreeAgentModel> availableDefense, ILeagueModel leagueModel){
        int requiredDefenses = 10;
        int player = 0;
        while(player < requiredDefenses){
            iCli.printOutput(CreateTeamConstants.Enter.getValue() + (requiredDefenses - player) + CreateTeamConstants.EnterDefense.getValue());
            displayPersons.displayPlayers(availableDefense);
            choice = iCli.readIntInput();
            if (choice > 0 && choice <= availableDefense.size()){
                createTeamPlayer(availableDefense.get(choice - 1));
                availableDefense.remove(choice-1);
                leagueModel.getFreeAgents().remove(availableDefense.get(choice - 1));
                player ++;
            }
        }
    }

    private void getGoalies(List<FreeAgentModel> availableGoalies, ILeagueModel leagueModel){
        int requiredGoalies = 4;
        int player = 0;
        while(player < requiredGoalies){
            iCli.printOutput(CreateTeamConstants.Enter.getValue() + (requiredGoalies - player) + CreateTeamConstants.EnterGoalies.getValue());
            displayPersons.displayPlayers(availableGoalies);
            choice = iCli.readIntInput();
            if (choice > 0 && choice <= availableGoalies.size()){
                createTeamPlayer(availableGoalies.get(choice - 1));
                availableGoalies.remove(choice - 1);
                leagueModel.getFreeAgents().remove(availableGoalies.get(choice - 1));
                player ++;
            }
        }
    }

    private void getCaptain(){
        iCli.printOutput(CreateTeamConstants.DisplayPlayerList.getValue());
        displayPersons.displayTeamPlayers(userCreatedPlayers);
        iCli.printOutput(CreateTeamConstants.EnterCaptain.getValue());
        choice = iCli.readIntInput();
        userCreatedPlayers.get(choice - 1).setCaptain(true);
        iCli.printOutput(userCreatedPlayers.get(choice - 1).getPlayerName() + CreateTeamConstants.TeamCaptain.getValue());
    }

    private void createTeamPlayer(FreeAgentModel freeAgentModel){
        String name;
        String position;
        float skating;
        float shooting;
        float saving;
        float checking;
        int age;
        int birthDay;
        int birthMonth;
        int birthYear;
        PlayerModel player;
        name = freeAgentModel.getPlayerName();
        age = freeAgentModel.getAge();
        position = freeAgentModel.getPosition();
        saving = freeAgentModel.getSaving();
        checking = freeAgentModel.getChecking();
        shooting = freeAgentModel.getShooting();
        skating = freeAgentModel.getSkating();
        birthDay = freeAgentModel.getBirthDay();
        birthMonth = freeAgentModel.getBirthMonth();
        birthYear = freeAgentModel.getBirthYear();
        player = new PlayerModel(name, position, false, age, skating, shooting, checking, saving, birthDay, birthMonth, birthYear);
        userCreatedPlayers.add(player);
    }

    private void getHeadCoach(ILeagueModel leagueModel) {
        String name;
        float skating;
        float shooting;
        float saving;
        float checking;
        iCli.printOutput(CreateTeamConstants.EnterCoach.getValue());
        displayPersons.displayCoaches(leagueModel.getCoaches());
        choice = iCli.readIntInput();
        List<CoachModel> coachList = leagueModel.getCoaches();
        HeadCoachModel headCoach;
        if (choice > 0 && choice <= coachList.size()) {
            name = coachList.get(choice - 1).getName();
            skating = coachList.get(choice - 1).getSkating();
            shooting = coachList.get(choice - 1).getShooting();
            saving = coachList.get(choice - 1).getSaving();
            checking = coachList.get(choice - 1).getChecking();
            headCoach = new HeadCoachModel(name, skating, shooting, checking, saving);
            this.userEnteredHeadCoachName = headCoach;
            leagueModel.getCoaches().remove(choice - 1);
        } else {
            iCli.printOutput(CreateTeamConstants.ChoiceError.getValue());
            getHeadCoach(leagueModel);
        }
    }

    private void getManager(ILeagueModel leagueModel) {
        iCli.printOutput(CreateTeamConstants.EnterManager.getValue());
        displayPersons.displayManagers(leagueModel.getGeneralManagers());
        choice = iCli.readIntInput();
        List<GeneralManagersModel> managersList = leagueModel.getGeneralManagers();
        if (choice > 0 && choice <= managersList.size()) {
            this.userEnteredGeneralManagerName = managersList.get(choice - 1);
            leagueModel.getGeneralManagers().remove(choice - 1);
        } else {
            iCli.printOutput(CreateTeamConstants.ChoiceError.getValue());
            getManager(leagueModel);
        }
    }

    private ILeagueModel getNewlyCreatedLeagueObject(ILeagueModel leagueModel) {
        TeamsModel teamsModel = new TeamsModel();
        teamsModel.setTeamName(this.userEnteredTeamName);
        teamsModel.setGeneralManager(this.userEnteredGeneralManagerName);
        teamsModel.setUserCreatedTeam(true);
        teamsModel.setHeadCoach(this.userEnteredHeadCoachName);
        teamsModel.setPlayers(userCreatedPlayers);

        for (ConferenceModel conferenceModel : leagueModel.getConferences()) {
            if (conferenceModel.getConferenceName().equalsIgnoreCase(userEnteredConferenceName)) {
                for (DivisonModel divisonModel : conferenceModel.getDivisions()) {
                    if (divisonModel.getDivisionName().equalsIgnoreCase(userEnteredDivisionName)) {
                        List<TeamsModel> existingCreatedTeamList = divisonModel.getTeams();
                        existingCreatedTeamList.add(teamsModel);
                    }
                }
            }
        }
        iCli.printOutput(CreateTeamConstants.LineSeperator.getValue());
        iCli.printOutput(CreateTeamConstants.Success.getValue());
        iCli.printOutput(CreateTeamConstants.LineSeperator.getValue());
        return leagueModel;
    }

    private boolean isStringValid(String str) {
        if(str == null || str.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}
