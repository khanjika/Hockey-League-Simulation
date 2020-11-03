package trade;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TradeTeamPojoTest {

    TradeTeamPojo pojo = new TradeTeamPojo();

    @Test
    void setConferenceName() {
        String conferenceName = "Eastern Conference";
        pojo.setConferenceName(conferenceName);

        Assert.assertEquals(pojo.getConferenceName(), "Eastern Conference");
    }

    @Test
    void setDivisionName() {
        String divisionName = "Atlantic";
        pojo.setDivisionName(divisionName);

        Assert.assertEquals(pojo.getDivisionName(), "Atlantic");
    }

    @Test
    void setTeamName() {
        String teamName = "Boston";
        pojo.setTeamName(teamName);

        Assert.assertEquals(pojo.getTeamName(), "Boston");
    }

    @Test
    void setUserCreated() {
        Boolean isUserCreated = true;
        pojo.setUserCreated(isUserCreated);

        Assert.assertEquals(pojo.isUserCreated(), true);
    }

    @Test
    void getConferenceName() {
        String conferenceName = "Eastern Conference";
        pojo.setConferenceName(conferenceName);

        Assert.assertEquals(pojo.getConferenceName(), "Eastern Conference");
    }

    @Test
    void getDivisionName() {
        String divisionName = "Atlantic";
        pojo.setDivisionName(divisionName);

        Assert.assertEquals(pojo.getDivisionName(), "Atlantic");
    }

    @Test
    void getTeamName() {
        String teamName = "Boston";
        pojo.setTeamName(teamName);

        Assert.assertEquals(pojo.getTeamName(), "Boston");
    }

    @Test
    void isUserCreated() {
        Boolean isUserCreated = true;
        pojo.setUserCreated(isUserCreated);

        Assert.assertEquals(pojo.isUserCreated(), true);
    }
}
