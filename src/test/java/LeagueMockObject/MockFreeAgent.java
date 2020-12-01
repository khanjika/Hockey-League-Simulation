package LeagueMockObject;


import LeagueMockObject.MockLeagueAbstractFactory;
import leagueobjectmodel.IFreeAgentModel;

public class MockFreeAgent {

    static IFreeAgentModel freeAgentModel = MockLeagueAbstractFactory.getMockInstance().createFreeAgent();

    public static IFreeAgentModel getFreeAgentModel() {
        freeAgentModel.setPlayerName("Agent one");
        freeAgentModel.setPosition("forward");
        freeAgentModel.setAge(25);
        freeAgentModel.setSkating(10);
        freeAgentModel.setShooting(10);
        freeAgentModel.setChecking(10);
        freeAgentModel.setSaving(10);
        freeAgentModel.setRetired(false);
        freeAgentModel.setBirthDay(1);
        freeAgentModel.setBirthMonth(1);
        freeAgentModel.setBirthYear(1997);
        freeAgentModel.setRetirementLikelyHood(0);
        return freeAgentModel;
    }

    public static IFreeAgentModel getInvalidFreeAgentModel() {
        freeAgentModel.setPlayerName("");
        freeAgentModel.setPosition("forward");
        freeAgentModel.setAge(25);
        freeAgentModel.setSkating(10);
        freeAgentModel.setShooting(10);
        freeAgentModel.setChecking(10);
        freeAgentModel.setSaving(10);
        freeAgentModel.setRetired(false);
        freeAgentModel.setBirthDay(1);
        freeAgentModel.setBirthMonth(1);
        freeAgentModel.setBirthYear(1997);
        freeAgentModel.setRetirementLikelyHood(0);
        return freeAgentModel;
    }

    public static IFreeAgentModel getInvalidStatFreeAgentModel() {
        freeAgentModel.setPlayerName("Agent one");
        freeAgentModel.setPosition("forward");
        freeAgentModel.setAge(25);
        freeAgentModel.setSkating(10);
        freeAgentModel.setShooting(-1000);
        freeAgentModel.setChecking(10);
        freeAgentModel.setSaving(10);
        freeAgentModel.setRetired(false);
        freeAgentModel.setBirthDay(1);
        freeAgentModel.setBirthMonth(1);
        freeAgentModel.setBirthYear(1997);
        freeAgentModel.setRetirementLikelyHood(0);
        return freeAgentModel;
    }


    public static IFreeAgentModel getForwardFreeAgentModel() {
        freeAgentModel.setPlayerName("Agent one");
        freeAgentModel.setPosition("forward");
        freeAgentModel.setAge(25);
        freeAgentModel.setSkating(10);
        freeAgentModel.setShooting(10);
        freeAgentModel.setChecking(10);
        freeAgentModel.setSaving(10);
        freeAgentModel.setRetired(false);
        freeAgentModel.setBirthDay(1);
        freeAgentModel.setBirthMonth(1);
        freeAgentModel.setBirthYear(1997);
        freeAgentModel.setRetirementLikelyHood(0);
        return freeAgentModel;
    }

    public static IFreeAgentModel getDefenseFreeAgentModel() {
        freeAgentModel.setPlayerName("Agent one");
        freeAgentModel.setPosition("defense");
        freeAgentModel.setAge(25);
        freeAgentModel.setSkating(10);
        freeAgentModel.setShooting(10);
        freeAgentModel.setChecking(10);
        freeAgentModel.setSaving(10);
        freeAgentModel.setBirthDay(1);
        freeAgentModel.setBirthMonth(1);
        freeAgentModel.setBirthYear(1997);
        freeAgentModel.setRetired(false);
        freeAgentModel.setRetirementLikelyHood(0);
        return freeAgentModel;
    }

    public static IFreeAgentModel getGoalieFreeAgentModel() {
        freeAgentModel.setPlayerName("Agent one");
        freeAgentModel.setPosition("goalie");
        freeAgentModel.setAge(25);
        freeAgentModel.setSkating(10);
        freeAgentModel.setShooting(10);
        freeAgentModel.setChecking(10);
        freeAgentModel.setSaving(10);
        freeAgentModel.setDays(0);
        freeAgentModel.setRetired(false);
        freeAgentModel.setRetirementLikelyHood(0);
        return freeAgentModel;
    }

}
