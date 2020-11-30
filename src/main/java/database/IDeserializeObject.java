package database;

import leagueobjectmodel.ILeagueModel;

public interface IDeserializeObject {

    ILeagueModel parseJson(String fileName);
}
