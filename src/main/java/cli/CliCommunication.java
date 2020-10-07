package cli;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import conference.ConferenceModel;
import divison.DivisonModel;
import league.ILeagueModel;
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

   public  LeagueModel leagueModel;
   public static ObjectMapper objectMapper;
   private ILeagueValidator leagueValidator;
   private  loadTeamCli loadTeamCli;

    public CliCommunication() {
        objectMapper =new ObjectMapper();
        leagueValidator=new LeagueValidator();
        loadTeamCli = new loadTeamCli();
    }


    @Override
    public void loadTeamFromDatabase() {
        loadTeamCli.getData();
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
    public LeagueModel parseJson(String fileName)  {
        System.out.println("Inside parse JSON method");
        try{
        byte[] mapData = Files.readAllBytes(Paths.get(fileName));
        //Read the json
         JsonNode data= objectMapper.readTree(mapData);
        System.out.println(data);
        //calling the method to set the data to model
        leagueModel = fromJson(data,LeagueModel.class);
        if(leagueValidator.validateLeagueObject(leagueModel)){
            //create team
            System.out.println("Valid JSON");

            return leagueModel;
           // CreateTeamCli createTeamCli = new CreateTeamCli();
            //Here i have all the updated league model object
         //  LeagueModel newlyCreatedLeagueObject= createTeamCli.createNewTeam(leagueModel);
        }
        else {
            System.out.println("Invalid JSON");
        }}
        catch (IOException e){
            System.out.println("Error occurred while parsing the file due to syntax issue");
        }
        return null;
    }

    public static <A> A fromJson(JsonNode node,Class<A> classObj ) throws JsonProcessingException {
        return  objectMapper.treeToValue(node,classObj);
    }
}
