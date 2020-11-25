package statemachine.jsonparser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import leagueobjectmodel.*;
import statemachine.jsonparser.ICliCommunication;
import statemachine.loadteam.loadTeamCli;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class CliCommunication implements ICliCommunication {

    public ILeagueModel leagueModel;
    public static ObjectMapper objectMapper;
    private final ILeagueValidator leagueValidator;
    private static LeagueObjectModelAbstractFactory leagueObjectModelAbstractFactory;
    private statemachine.loadteam.loadTeamCli loadTeamCli;

    public CliCommunication() {
        objectMapper = new ObjectMapper();
        leagueValidator = LeagueObjectModelAbstractFactory.getInstance().getLeagueValidator();
        leagueObjectModelAbstractFactory = LeagueObjectModelAbstractFactory.getInstance();
    }


    @Override
    public ILeagueModel loadTeamFromDatabase() {
        loadTeamCli = new loadTeamCli();
        return loadTeamCli.getData();
    }

    @Override
    public boolean isFileExist(String fileName) {
        try {
            File myObj = new File(fileName);
            return myObj.exists();
        } catch (Exception e) {
            System.out.println("Error while parsing");
        }
        return false;

    }


    @Override
    public ILeagueModel parseJson(String fileName) {

        try {
            byte[] mapData = Files.readAllBytes(Paths.get(fileName));
            JsonNode data = objectMapper.readTree(mapData);
            leagueModel = fromJson(data, LeagueModel.class);
            leagueObjectModelAbstractFactory.setLeague(leagueModel);
            if (leagueValidator.validateLeagueObject(leagueModel)) {
                System.out.println("Your Provided JSON is valid.");
                for (ConferenceModel conferenceModel : leagueModel.getConferences()) {
                    for (DivisonModel divisonModel : conferenceModel.getDivisions()) {
                        for (TeamsModel teamsModel : divisonModel.getTeams()) {
                            for (PlayerModel playerModel : teamsModel.getPlayers()) {
                                playerModel.calculatePlayerStrength(playerModel);
                            }
                        }
                    }
                }

                return leagueModel;
            } else {
                System.out.println("Invalid JSON");
            }
        } catch (IOException e) {
            System.out.println("Error occurred while parsing the file due to syntax issue" + e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public LeagueModel calculateStrength(LeagueModel leagueModel) {
        LeagueModel updatedLeagueModel = leagueModel;
        for (ConferenceModel conferenceModel : updatedLeagueModel.getConferences()) {
            for (DivisonModel divisonModel : conferenceModel.getDivisions()) {
                for (TeamsModel teamsModel : divisonModel.getTeams()) {
                    for (PlayerModel playerModel : teamsModel.getPlayers()) {
                        playerModel.calculatePlayerStrength(playerModel);
                    }
                }
            }
        }
        return updatedLeagueModel;
    }


    private static <A> A fromJson(JsonNode node, Class<A> classObj) throws JsonProcessingException {
        return objectMapper.treeToValue(node, classObj);
    }
}
