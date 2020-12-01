package LeagueMockObject;

import leagueobjectmodel.GeneralManagersModel;

public class MockGeneralManagers {
    public static GeneralManagersModel getGeneralManagersModel(){
        GeneralManagersModel generalManagersModel = new GeneralManagersModel();
        generalManagersModel.setName("Karan Smith");
        generalManagersModel.setPersonality("normal");
        return generalManagersModel;
    }
}
