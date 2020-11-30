package database.serializeobject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class FileValidatorTest {

    IFileValidator file = SerializeObjectAbstractFactory.getInstance().getFileValidator();

    @Test
    void isFileExistTest(){
        assertFalse(file.isFileExist("testingTeam"));
    }

    @Test
    void filePathTest(){
        assertEquals(file.filePath("testingTeam"),"src\\main\\java\\database\\datasource\\testingTeam.JSON");
    }
}
