package serializeObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import league.LeagueModel;

import java.io.FileWriter;
import java.io.IOException;

public class SerializeObject {
    public boolean serializeLeagueObject(LeagueModel leagueModel,String locationPath) {

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(locationPath)) {
            gson.toJson(leagueModel, writer);
        } catch (IOException exception) {
//            exception.printStackTrace();
            return false;
        }
        return true;
    }
}
