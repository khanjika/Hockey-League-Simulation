package teams;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MockTeamsPersistent {

    int addTeamInformation() {
        return 1;
    }

    boolean isTeamNameExist() {
        return true;
    }

    int getTeamId() {
        return 1;
    }

    int addHeadCoahDetails() {
        return 1;
    }

    int addGeneralManagerDetails() {
        return 1;
    }

    TeamPojo getTeamInformation() {
        TeamPojo team = new TeamPojo();
        team.setTeamId (1);
        team.setGeneralManagerName ("Khanjika");
        team.setHeadCoach ("Rob");
        return team;
    }
}
