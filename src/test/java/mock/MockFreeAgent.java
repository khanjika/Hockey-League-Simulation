package mock;

import freeagent.FreeAgentModel;

public class MockFreeAgent {
    public static FreeAgentModel getFreeAgentModel(){
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setPlayerName("Agent one");
        freeAgentModel.setPosition("forward");
        freeAgentModel.setAge(25);
        freeAgentModel.setSkating(10);
        freeAgentModel.setShooting(10);
        freeAgentModel.setChecking(10);
        freeAgentModel.setSaving(10);
        freeAgentModel.setRetired(false);
        freeAgentModel.setDays(0);
        freeAgentModel.setRetirementLikelyHood(0);
        return freeAgentModel;
    }

    public static FreeAgentModel getInvalidFreeAgentModel(){
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setPlayerName("");
        freeAgentModel.setPosition("forward");
        freeAgentModel.setAge(25);
        freeAgentModel.setSkating(10);
        freeAgentModel.setShooting(10);
        freeAgentModel.setChecking(10);
        freeAgentModel.setSaving(10);
        freeAgentModel.setRetired(false);
        freeAgentModel.setDays(0);
        freeAgentModel.setRetirementLikelyHood(0);
        return freeAgentModel;
    }

    public static FreeAgentModel getInvalidStatFreeAgentModel(){
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setPlayerName("Agent one");
        freeAgentModel.setPosition("forward");
        freeAgentModel.setAge(25);
        freeAgentModel.setSkating(10);
        freeAgentModel.setShooting(-1000);
        freeAgentModel.setChecking(10);
        freeAgentModel.setSaving(10);
        freeAgentModel.setRetired(false);
        freeAgentModel.setDays(0);
        freeAgentModel.setRetirementLikelyHood(0);
        return freeAgentModel;
    }


    public static FreeAgentModel getForwardFreeAgentModel(){
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setPlayerName("Agent one");
        freeAgentModel.setPosition("forward");
        freeAgentModel.setAge(25);
        freeAgentModel.setSkating(10);
        freeAgentModel.setShooting(10);
        freeAgentModel.setChecking(10);
        freeAgentModel.setSaving(10);
        freeAgentModel.setRetired(false);
        freeAgentModel.setDays(0);
        freeAgentModel.setRetirementLikelyHood(0);
        return freeAgentModel;
    }

    public static FreeAgentModel getDefenseFreeAgentModel(){
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setPlayerName("Agent one");
        freeAgentModel.setPosition("defense");
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

    public static FreeAgentModel getGoalieFreeAgentModel(){
        FreeAgentModel freeAgentModel = new FreeAgentModel();
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
