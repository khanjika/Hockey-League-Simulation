package database;

import cli.CliAbstractFactory;
import cli.ICli;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import leagueobjectmodel.ILeagueModel;
import leagueobjectmodel.ILeagueValidator;
import leagueobjectmodel.LeagueModel;
import leagueobjectmodel.LeagueObjectModelAbstractFactory;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class DeserializeObject implements IDeserializeObject {

    public ILeagueModel leagueModel;
    public static ObjectMapper objectMapper;
    private final ILeagueValidator leagueValidator;
    private static LeagueObjectModelAbstractFactory leagueObjectModelAbstractFactory;
    private ICli iCli;
    final static Logger logger = Logger.getLogger(DeserializeObject.class);

    public DeserializeObject() {
        objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        leagueValidator = LeagueObjectModelAbstractFactory.getInstance().getLeagueValidator();
        leagueObjectModelAbstractFactory = LeagueObjectModelAbstractFactory.getInstance();
        iCli = CliAbstractFactory.getInstance().getCli();
    }



    @Override
    public ILeagueModel parseJson(String fileName) {

        try {
            byte[] mapData = Files.readAllBytes(Paths.get(fileName));
            JsonNode data = objectMapper.readTree(mapData);
            leagueModel = fromJson(data, LeagueModel.class);
            leagueObjectModelAbstractFactory.setLeague(leagueModel);
            if (leagueValidator.validateLeagueObject(leagueModel)) {
                logger.info(ParserConstants.LogInfo.getValue());
                iCli.printOutput(ParserConstants.FileValid.getValue());
                return leagueModel;
            } else {
                iCli.printOutput(ParserConstants.FileInvalid.getValue());
            }
        } catch (IOException error) {
            logger.error(ParserConstants.LogError.getValue(),error);
            iCli.printOutput(ParserConstants.Error.getValue() + error);
        } catch (Exception error) {
            logger.error(ParserConstants.LogError.getValue(),error);
            iCli.printOutput(ParserConstants.Error.getValue() + error);
        }
        return null;
    }


    private static <A> A fromJson(JsonNode node, Class<A> classObj) throws JsonProcessingException {
        return objectMapper.treeToValue(node, classObj);
    }
}
