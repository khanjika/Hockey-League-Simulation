package serializeobject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import leagueobjectmodel.LeagueModel;

import java.io.FileWriter;
import java.io.IOException;


public class SerializeObject implements ISerializeObject {
    FileValidator fileValidator = new FileValidator();
    @Override
    public boolean serializeLeagueObject(LeagueModel leagueModel,String name) {

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(fileValidator.filePath(name))) {
            gson.toJson(leagueModel, writer);
            return true;
        } catch (IOException exception) {
            exception.printStackTrace();
            return false;
        }
    }
}
