package leagueobjectmodel;

import leagueobjectmodel.TeamPojo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TeamPojoTest {

    @Test
    void getTeamId() {
        TeamPojo teamPojo = new TeamPojo();
        teamPojo.setTeamId(1);
        assertEquals(teamPojo.getTeamId(), 1);
    }

    @Test
    void setTeamId() {
        TeamPojo teamPojo = new TeamPojo();
        teamPojo.setTeamId(1);
        assertEquals(teamPojo.getTeamId(), 1);
    }

    @Test
    void getGeneralManagerName() {
        TeamPojo teamPojo = new TeamPojo();
        teamPojo.setGeneralManagerName("NAme");
        assertEquals(teamPojo.getGeneralManagerName(), "NAme");
    }

    @Test
    void setGeneralManagerName() {
        TeamPojo teamPojo = new TeamPojo();
        teamPojo.setGeneralManagerName("NAme");
        assertEquals(teamPojo.getGeneralManagerName(), "NAme");
    }

    @Test
    void getHeadCoach() {
        TeamPojo teamPojo = new TeamPojo();
        teamPojo.setHeadCoach("coach");
        assertEquals(teamPojo.getHeadCoach(), "coach");
    }

    @Test
    void setHeadCoach() {
        TeamPojo teamPojo = new TeamPojo();
        teamPojo.setHeadCoach("coach");
        assertEquals(teamPojo.getHeadCoach(), "coach");
    }
}
