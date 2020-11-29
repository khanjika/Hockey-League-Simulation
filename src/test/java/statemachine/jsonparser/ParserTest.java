package statemachine.jsonparser;

import database.serializeobject.IFileValidator;
import database.serializeobject.SerializeObjectAbstractFactory;
import leagueobjectmodel.ILeagueModel;
import org.junit.jupiter.api.Test;

public class ParserTest {
    @Test
    void parseJsonTest(){
        IParser parser = ParserAbstractFactory.getInstance().getParser();
        IFileValidator fileValidator = SerializeObjectAbstractFactory.getInstance().getFileValidator();
        ILeagueModel leagueModel = parser.parseJson(fileValidator.filePath("testing"));

    }
}
