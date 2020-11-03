package teams;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TeamsValidatorTest {

    @Test
    void validateTeamObject() {
        TeamsModelTest teamsModelTest = new TeamsModelTest();
        TeamsModel teamsModel = TeamsModelTest.getTeamsObject();
        TeamsValidator teamsValidator = new TeamsValidator();
        assertTrue(teamsValidator.validateTeamObject(teamsModel));
    }
}
