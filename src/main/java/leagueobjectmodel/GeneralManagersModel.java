package leagueobjectmodel;

public class GeneralManagersModel implements IGeneralManagersModel {
    private String name;
    private String personality;

    public GeneralManagersModel() {
    }

    public GeneralManagersModel(String name, String personality) {
        this.name = name;
        this.personality = personality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }
}
