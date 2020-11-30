package statemachine.jsonparser;

import cli.CliAbstractFactory;
import cli.ICli;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import leagueobjectmodel.*;
import statemachine.loadteam.ILoadTeam;
import statemachine.loadteam.LoadTeamAbstractFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Parser implements IParser {

    public ILeagueModel leagueModel;
    public static ObjectMapper objectMapper;
    private final ILeagueValidator leagueValidator;
    private static LeagueObjectModelAbstractFactory leagueObjectModelAbstractFactory;
    private ILoadTeam loadTeam;
    private ICli iCli;

    public Parser() {
        objectMapper = new ObjectMapper();
        leagueValidator = LeagueObjectModelAbstractFactory.getInstance().getLeagueValidator();
        leagueObjectModelAbstractFactory = LeagueObjectModelAbstractFactory.getInstance();
        iCli = CliAbstractFactory.getInstance().getCli();
    }

    @Override
    public ILeagueModel loadTeamFromDatabase() {
        loadTeam = LoadTeamAbstractFactory.getInstance().getLoadTeam();
        return loadTeam.getData();
    }

    @Override
    public ILeagueModel parseJson(String fileName) {

        try {
            byte[] mapData = Files.readAllBytes(Paths.get(fileName));
            JsonNode data = objectMapper.readTree(mapData);
            leagueModel = fromJson(data, LeagueModel.class);
            if (leagueValidator.validateLeagueObject(leagueModel)) {
                leagueObjectModelAbstractFactory.setLeague(leagueModel);
                iCli.printOutput(ParserConstants.FileValid.getValue());
                return leagueModel;
            } else {
                leagueModel = null;
                iCli.printOutput(ParserConstants.FileInvalid.getValue());
            }
        } catch (IOException e) {
            iCli.printOutput(ParserConstants.Error.getValue() + e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return leagueModel;
    }


    private static <A> A fromJson(JsonNode node, Class<A> classObj) throws JsonProcessingException {
        return objectMapper.treeToValue(node, classObj);
    }
}
