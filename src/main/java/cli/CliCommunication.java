package cli;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import conference.ConferenceModel;
import divison.DivisonModel;
import league.ILeagueValidator;
import league.LeagueModel;
import league.LeagueValidator;
import players.PlayerModel;
import teams.TeamsModel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class CliCommunication implements ICliCommunication {

    public LeagueModel leagueModel;
    public static ObjectMapper objectMapper;
    private ILeagueValidator leagueValidator;
    private loadTeamCli loadTeamCli;

    public CliCommunication() {
        System.out.println("CLI communication object is created");
        objectMapper = new ObjectMapper();
        leagueValidator = new LeagueValidator();
        loadTeamCli = new loadTeamCli();
    }


    @Override
    public boolean loadTeamFromDatabase() {
        return loadTeamCli.getData();
    }

    @Override
    public boolean isFileExist(String fileName) {
        try {
            File myObj = new File(fileName);
            if (myObj.exists()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error while parsing");
        }
        return false;

    }


    @Override
    public LeagueModel parseJson(String fileName) {
        try {
            byte[] mapData = Files.readAllBytes(Paths.get(fileName));
            JsonNode data = objectMapper.readTree(mapData);
            leagueModel = fromJson(data, LeagueModel.class);
            if (leagueValidator.validateLeagueObject(leagueModel)) {
                System.out.println("Your Provided JSON is valid.");
                ///------------------
                for(ConferenceModel conferenceModel:leagueModel.getConferences()){
                    for(DivisonModel divisonModel:conferenceModel.getDivisions()){
                        for(TeamsModel teamsModel:divisonModel.getTeams()){
                            for (PlayerModel playerModel : teamsModel.getPlayers()){
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
            System.out.println("Error occurred while parsing the file due to syntax issue"+ e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public LeagueModel calculateStrength(LeagueModel leagueModel) throws Exception {
        LeagueModel updatedLeagueModel = leagueModel;
        for(ConferenceModel conferenceModel:updatedLeagueModel.getConferences()){
            for(DivisonModel divisonModel:conferenceModel.getDivisions()){
                for(TeamsModel teamsModel:divisonModel.getTeams()){
                    for (PlayerModel playerModel : teamsModel.getPlayers()){
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
