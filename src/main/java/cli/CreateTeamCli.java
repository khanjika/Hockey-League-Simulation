package cli;

import coach.CoachModel;
import conference.ConferenceModel;
import conference.ConferenceValidator;
import divison.DivisonModel;
import divison.DivisonValidator;
import freeagent.FreeAgentModel;
import league.LeagueModel;
import players.PlayerModel;
import teams.HeadCoachModel;
import teams.TeamsModel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

//This class is used to create a new team using cli
public class CreateTeamCli implements  ICreateTeamCli{

    ConferenceValidator conferenceValidator;
    DivisonValidator divisonValidator;

    private String userEnteredConferenceName;
    private String userEnteredDivisionName;
    private String userEnteredTeamName;
    private String userEnteredGeneralManagerName;
    private HeadCoachModel userEnteredHeadCoachName;
    Scanner scannerObject;
    List<PlayerModel> userCreatedPlayers;
//    List<FreeAgentModel> availableFreeAgents;
    int choice;

    public CreateTeamCli() {
        conferenceValidator = new ConferenceValidator();
        divisonValidator = new DivisonValidator();
        scannerObject = new Scanner(System.in);
        userCreatedPlayers = new ArrayList<>();
    }

    //Method used to create new team
    @Override
    public LeagueModel createNewTeam(LeagueModel leagueModel) {
        if (isConferenceNameValid(leagueModel)) {
            if (isDivisionNameValid(leagueModel)) {
                if (this.isTeamInformationSetProperly(leagueModel)) {
                    LeagueModel newlyCreatedLeagueModelObject = getNewlyCreatedLeagueObject(leagueModel);
                    System.out.println("=====================================");
                    for (ConferenceModel conferenceModel : newlyCreatedLeagueModelObject.getConferences()) {
                        System.out.println("Conference name->    " + conferenceModel.getConferenceName());
                        for (DivisonModel divisonModel : conferenceModel.getDivisions()) {
                            System.out.println("Division name->     " + divisonModel.getDivisionName());
                            for (TeamsModel teamsModel : divisonModel.getTeams()) {
                                System.out.println("Team is---> " + teamsModel.getTeamName());
                            }
                        }
                    }
                    System.out.println("=====================================");
                    return newlyCreatedLeagueModelObject;
                }
            }
        }
        return null;
    }

    public boolean isConferenceNameValid(LeagueModel leagueModel) {
        System.out.println("=====================================");
        System.out.println("Here You need to create a new Team in the EXISTING division");
        System.out.println("=====================================");
        System.out.println("Enter Conference name in which you want to create new Team");
        String conferenceName = scannerObject.nextLine();
        if (isStringValid(conferenceName)) {
            if (conferenceValidator.isConferenceExist(leagueModel, conferenceName)) {
                this.userEnteredConferenceName = conferenceName;
                return true;
            } else {
                System.out.println("Does not exist in the provided JSON");
                isConferenceNameValid(leagueModel);

            }
        } else {
            System.out.println("Invalid String (Please enter string only)");
            isConferenceNameValid(leagueModel);
        }
        return true;
    }

    public boolean isDivisionNameValid(LeagueModel leagueModel) {
        System.out.println("Enter Division name In which You want to create new Team");
        String divisionName = scannerObject.nextLine();
        if (isStringValid(divisionName)) {
            if (divisonValidator.isDivisionExist(leagueModel, divisionName)) {
                this.userEnteredDivisionName = divisionName;
                return true;
            } else {
                System.out.println("Does not exist in the provided JSON");
                isDivisionNameValid(leagueModel);
            }
        } else {
            System.out.println("Invalid String (Please enter String only)");
            isDivisionNameValid(leagueModel);
        }
        return true;
    }

    public boolean isTeamInformationSetProperly(LeagueModel leagueModel) {
        System.out.println("Enter New Team name");
        this.userEnteredTeamName = scannerObject.nextLine();
        if (isStringValid(userEnteredTeamName)) {
            if (isManagerValid(leagueModel)) {
                if (isHeadCoachValid(leagueModel)) {
//                    availableFreeAgents = leagueModel.getFreeAgents();
                    if (isPlayersValid(leagueModel)) {
                        return true;
                    }
                }
            }
        }
        return true;
    }

    String name;
    String position;
    Boolean captain;
    float skating;
    float shooting;
    float saving;
    float checking;
    int age;


    private boolean isPlayersValid(LeagueModel leagueModel) {
        int goalies = 2;
        int skaters = 18;
        int totalPlayers = 20;
        List<FreeAgentModel> currentAvailablePlayers = new ArrayList<>(leagueModel.getFreeAgents());
        PlayerModel player;
        int players = 0;
        while (players < totalPlayers) {
            System.out.printf("Select %d more players for your team", totalPlayers - players);
            System.out.println();
            System.out.println("=====================================");
            int displayNumber = 1;
            for (FreeAgentModel freeAgentModel : currentAvailablePlayers) {
                System.out.println(displayNumber + " -> " + freeAgentModel.getPlayerName() + " " + freeAgentModel.getAge() + " " + freeAgentModel.getPosition() + " " + freeAgentModel.getChecking()
                        + " " + freeAgentModel.getSaving() +
                        " " + freeAgentModel.getShooting() + " " + freeAgentModel.getSkating());
                displayNumber++;
            }
            System.out.println("Enter Player " + (players + 1));
            choice = scannerObject.nextInt();
            if (choice > 0 && choice <= currentAvailablePlayers.size()) {
                name = currentAvailablePlayers.get(choice - 1).getPlayerName();
                captain = false;
                age = currentAvailablePlayers.get(choice - 1).getAge();
                position = currentAvailablePlayers.get(choice - 1).getPosition();
                saving = currentAvailablePlayers.get(choice - 1).getSaving();
                checking = currentAvailablePlayers.get(choice - 1).getChecking();
                shooting = currentAvailablePlayers.get(choice - 1).getShooting();
                skating = currentAvailablePlayers.get(choice - 1).getSkating();
                if (position.equals("goalie")) { // add to constants
                    goalies--;
                }else{
                    skaters--;
                }
                System.out.println(2 - goalies);
                System.out.println(18 - skaters);
                if (skaters < 0){
                    skaters ++;
                    System.out.printf("Enter %d more goalies",goalies);
                    System.out.println();
                }else {
                    player = new PlayerModel(name, position, captain, age, skating, shooting, checking, saving);
                    userCreatedPlayers.add(player);
                    currentAvailablePlayers.remove(choice - 1);
                    players++;
                }
                }
            }
        System.out.println("The newly created team players");
        System.out.println("=====================================");
        int displayNumber = 1;
        for (PlayerModel teamPlayer : userCreatedPlayers){
            System.out.println(displayNumber + " -> " + teamPlayer.getPlayerName() + " " + teamPlayer.getAge() + " " + teamPlayer.getPosition() + " " + teamPlayer.getChecking()
                    + " " + teamPlayer.getSaving() +
                    " " + teamPlayer.getShooting() + " " + teamPlayer.getSkating());
            displayNumber++;
        }
        System.out.println("Select a captain for the team");
        choice = scannerObject.nextInt();
        userCreatedPlayers.get(choice - 1).setCaptain(true);
        System.out.println(userCreatedPlayers.get(choice - 1).getPlayerName() + " is the team captain" );
        return (goalies == 0 && skaters == 0);
    }
    private boolean isHeadCoachValid(LeagueModel leagueModel){
        displayCoaches(leagueModel);
        choice = scannerObject.nextInt();
        List<CoachModel> coachList = leagueModel.getCoaches();
        HeadCoachModel headCoach;
        if (choice > 0 && choice <= coachList.size()){
            name = coachList.get(choice - 1).getName();
            skating = coachList.get(choice - 1).getSkating();
            shooting = coachList.get(choice - 1).getShooting();
            saving = coachList.get(choice - 1).getSaving();
            checking = coachList.get(choice - 1).getChecking();
            headCoach = new HeadCoachModel(name, skating, shooting, checking, saving);
            this.userEnteredHeadCoachName = headCoach;
            leagueModel.getCoaches().remove(choice - 1);
            return true;
        } else{
            System.out.println("Enter a valid choice from the list");
            return isHeadCoachValid(leagueModel);
        }
    }

    private boolean isManagerValid(LeagueModel leagueModel){
        displayManagers(leagueModel);
        choice = scannerObject.nextInt();
        List<String> managersList = leagueModel.getGeneralManagers();
        if (choice > 0 && choice <= managersList.size()){
            this.userEnteredGeneralManagerName = managersList.get(choice - 1);
            leagueModel.getGeneralManagers().remove(choice - 1);
            return true;
        }else {
            System.out.println("Enter a valid choice from the list");
            return isManagerValid(leagueModel);
        }
    }

    private void displayManagers(LeagueModel leagueModel){
        System.out.println("Select a Manager for the team");
        System.out.println("=====================================");
        int ManagerCount = 1;
        for(String generalManager:leagueModel.getGeneralManagers()){
            System.out.println(ManagerCount+ " -> "+ generalManager);
            ManagerCount ++;
        }
    }

    private void displayCoaches(LeagueModel leagueModel){
        System.out.println("Select a Coach for the team");
        System.out.println("=====================================");
        int CoachCount = 1;
        leagueModel.getCoaches().sort(Comparator.comparing(CoachModel::getName));
        for(CoachModel coachModel:leagueModel.getCoaches()){
            System.out.println(CoachCount+ " -> "+coachModel.getName()  + " " + coachModel.getChecking() + " " +
                    coachModel.getSaving() + " " + coachModel.getShooting() + " " + coachModel.getSkating());
            CoachCount ++;
        }
    }

    private void displayFreeAgents(LeagueModel leagueModel){

        leagueModel.getFreeAgents().sort(Comparator.comparing(FreeAgentModel::getAge));
        int displayNumber = 1;
        for (FreeAgentModel freeAgentModel:leagueModel.getFreeAgents()){
            System.out.println(displayNumber + " -> " + freeAgentModel.getPlayerName() + " " +freeAgentModel.getAge() + " " +freeAgentModel.getChecking()
                    + " " +freeAgentModel.getSaving() +
                    " " + freeAgentModel.getShooting() + " " + freeAgentModel.getSkating());
            displayNumber ++;
        }
    }

    private LeagueModel getNewlyCreatedLeagueObject(LeagueModel leagueModel){
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
        System.out.println("=====================================");
        System.out.println("Conference name is " + this.userEnteredConferenceName + " and " + "Division name is " + this.userEnteredDivisionName);
        System.out.println("In memory Team created Successfully!!");
        System.out.println("=====================================");
        return leagueModel;
    }

    private boolean isStringValid(String str) {
        return str != null && !str.isEmpty();
    }
}
