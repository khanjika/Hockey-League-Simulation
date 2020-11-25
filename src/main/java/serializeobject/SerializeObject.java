package serializeobject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import leagueobjectmodel.ILeagueModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class SerializeObject implements ISerializeObject {
    FileValidator fileValidator = new FileValidator();
    @Override
    public boolean serializeLeagueObject(ILeagueModel leagueModel,String name) {

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        String path = fileValidator.filePath(name);
        FileWriter writer;
        try {
            System.out.println(leagueModel.getCoaches().size());
            if(fileValidator.isFileExist(path)){
                writer = new FileWriter(path);
                gson.toJson(leagueModel, writer);
            }
            else{
                File file = new File(path);
                System.out.println(path);
                file.createNewFile();
                writer = new FileWriter(path);
                gson.toJson(leagueModel, writer);
            }
            writer.flush();
            writer.close();
            return true;
        } catch (IOException exception) {
            exception.printStackTrace();
            return false;
        }
    }
}
