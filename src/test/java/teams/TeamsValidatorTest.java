package teams;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamsValidatorTest {

    @Test
    void validateTeamObject() {
        TeamsModelTest teamsModelTest =new TeamsModelTest();
      TeamsModel teamsModel=  teamsModelTest.getTeamsObject();
      TeamsValidator teamsValidator = new TeamsValidator();
      //update to true
      assertFalse(teamsValidator.validateTeamObject(teamsModel));
    }
}