package leagueobjectmodel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = GeneralManagersModel.class)
public interface IGeneralManagersModel {
    String getName();

    void setName(String name);

    String getPersonality();

    void setPersonality(String personality);
}
