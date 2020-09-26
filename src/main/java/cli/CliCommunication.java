package cli;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import conference.ConferenceModel;
import divison.DivisonModel;
import league.ILeagueModel;
import league.LeagueModel;
import players.PlayerModel;
import teams.TeamsModel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class CliCommunication implements ICliCommunication {

   public static LeagueModel leagueModel;
   public static ObjectMapper objectMapper;

    public CliCommunication() {
        objectMapper =new ObjectMapper();
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
            System.out.println(e);
        }
        return false;

    }


    @Override
    public void parseJson(String fileName) throws IOException {
        byte[] mapData = Files.readAllBytes(Paths.get(fileName));



        //creating league model object
        leagueModel=new LeagueModel();

        //Read the json
         JsonNode data= objectMapper.readTree(mapData);
        System.out.println(data);

        //calling the method to set the data to model
        leagueModel =fromJson(data,LeagueModel.class);

        System.out.println(leagueModel.getLeagueName());



        for(ConferenceModel temp:leagueModel.getConferences()){
           for(DivisonModel temp01 : temp.getDivisions()){
              for(TeamsModel temp02 : temp01.getTeams()){
                 for(PlayerModel temp03  :temp02.getPlayers())
                 {
                     System.out.println(temp03.getPlayerName());
                 }
              }
           }
        }



    }

    public static <A> A fromJson(JsonNode node,Class<A> classObj ) throws JsonProcessingException {

        return  objectMapper.treeToValue(node,classObj);

    }



}
