package database.serializeobject;

import database.IFileValidator;
import database.SerializeObjectAbstractFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class FileValidatorTest {

    IFileValidator file = SerializeObjectAbstractFactory.instance().createFileValidator();

    @Test
    void isFileExistTest(){
        assertFalse(file.isFileExist("team, bad"));
    }

    @Test
    void filePathTest(){
        assertEquals(file.filePath("testingTeam"),"src\\main\\java\\database\\datasource\\testingTeam.JSON");
    }
}
