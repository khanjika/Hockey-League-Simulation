package cli;

import conference.ConferenceModel;
import conference.ConferenceValidator;
import divison.DivisonModel;
import divison.DivisonValidator;
import league.LeagueModel;
import teams.TeamsModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//This class is used to create a new team using cli
public class CreateTeamCli {

    ConferenceValidator conferenceValidator;
    DivisonValidator divisonValidator;

    private String userEnteredConferenceName;
    private String userEnteredDivisionName;
    private String userEnteredTeamName;
    private String userEnteredGeneralManagerName;
    private String userEnteredHeadCoachName;
    Scanner scannerObject;

    public CreateTeamCli() {
        conferenceValidator = new ConferenceValidator();
        divisonValidator = new DivisonValidator();
        scannerObject = new Scanner(System.in);
    }

    //Method used to create new team
    public LeagueModel createNewTeam(LeagueModel leagueModel) {
        if (isConferenceNameValid(leagueModel)) {
            if (isDivisionNameValid(leagueModel)) {
                if(this.isTeamInformationSetProperly(leagueModel)){
                    LeagueModel newlyCreatedLeagueModelObject = getNewlyCreatedLeagueObject(leagueModel);
                    System.out.println("―――――――――――――――――――――");
                System.out.println("Printing the Model data After");
                for (ConferenceModel conferenceModel : newlyCreatedLeagueModelObject.getConferences()) {
                    System.out.println("Conference name->    " + conferenceModel.getConferenceName());
                    for (DivisonModel divisonModel : conferenceModel.getDivisions()) {
                        System.out.println("Division name->     " + divisonModel.getDivisionName());

                        for(TeamsModel teamsModel:divisonModel.getTeams()){
                            System.out.println("Team is---> " +teamsModel.getTeamName());
                        }
                    }
                }
                System.out.println("―――――――――――――――――――――");
                return newlyCreatedLeagueModelObject;
                }
            }
        }
        return null;
    }

    public boolean isConferenceNameValid(LeagueModel leagueModel) {
        System.out.println("Enter Conference name");
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
        System.out.println("Enter Division name");
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
        System.out.println("Enter Team name");
        this.userEnteredTeamName = scannerObject.nextLine();
        if (isStringValid(userEnteredTeamName)) {
            System.out.println("Enter General Manager name");
            this.userEnteredGeneralManagerName = scannerObject.nextLine();
            if (isStringValid(userEnteredGeneralManagerName)) {
                System.out.println("Enter Head coach name");
                this.userEnteredHeadCoachName = scannerObject.nextLine();
                //Creating new team data in the existing JSON object
                    if (isStringValid(userEnteredHeadCoachName)) {
                            return true;
                }
                else {
                    System.out.println("Enter valid data");
                    isTeamInformationSetProperly(leagueModel);
                }
            } else {
                System.out.println("Enter valid data");
                isTeamInformationSetProperly(leagueModel);
            }
        } else {
            System.out.println("Enter valid data");
            isTeamInformationSetProperly(leagueModel);
        }
        return true;
    }

    private LeagueModel getNewlyCreatedLeagueObject(LeagueModel leagueModel){
        TeamsModel teamsModel = new TeamsModel();
        teamsModel.setTeamName(this.userEnteredTeamName);
        teamsModel.setGeneralManager(this.userEnteredGeneralManagerName);
        teamsModel.setHeadCoach(this.userEnteredHeadCoachName);
        teamsModel.setPlayers(new ArrayList<>());

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
        System.out.println("―――――――――――――――――――――");
        System.out.println("Conference name is " + this.userEnteredConferenceName + " and " + "Division name is " + this.userEnteredDivisionName);
        System.out.println("Team created Successfully!!");
        System.out.println("―――――――――――――――――――――");
        return leagueModel;
    }

    private boolean isStringValid(String str) {
        return str != null && !str.isEmpty();
    }
}
