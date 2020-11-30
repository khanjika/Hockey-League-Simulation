package database.serializeobject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FileValidatorTest {
    IFileValidator file = SerializeObjectAbstractFactory.getInstance().getFileValidator();
    @Test
    void isFileExistTest(){
        assertFalse(file.isFileExist("testing Team"));
        assertTrue(file.isFileExist("robteam"));
    }
    public String filePath(String name){
        return "src\\test\\java\\database\\datasource\\"+name+".JSON";
    }
    @Test
    void filePathTest(){
        assertEquals(file.filePath("testingTeam"),"src\\main\\java\\database\\datasource\\testingTeam.JSON");
    }
}
