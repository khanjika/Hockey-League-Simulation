package database;

import leagueobjectmodel.ILeagueModel;

public interface ISerializeObject {
    boolean serializeLeagueObject(ILeagueModel leagueModel,String name);
}
