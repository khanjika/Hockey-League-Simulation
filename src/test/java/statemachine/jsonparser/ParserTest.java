package statemachine.jsonparser;

import database.serializeobject.IFileValidator;
import database.serializeobject.SerializeObjectAbstractFactory;
import leagueobjectmodel.ILeagueModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParserTest {
    @Test
    void parseJsonTest(){
        IParser parse = ParserAbstractFactory.getInstance().getParser();
        ILeagueModel league = parse.parseJson ("src/test/java/league.json");
        assertNotNull(league);
    }
}
