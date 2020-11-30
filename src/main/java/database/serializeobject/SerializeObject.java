package database.serializeobject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import leagueobjectmodel.ILeagueModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class SerializeObject implements ISerializeObject {
    IFileValidator fileValidator = new FileValidator();
    @Override
    public boolean serializeLeagueObject(ILeagueModel leagueModel,String name) {

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        String path = fileValidator.filePath(name);
        FileWriter writer;
        try {
            if (fileNotExist(path)) {
                File file = new File(path);
                file.createNewFile();
            }
            writer = new FileWriter(path);
            gson.toJson(leagueModel, writer);
            writer.flush();
            writer.close();
            return true;
        } catch (IOException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    private boolean fileNotExist(String path){
        if(fileValidator.isFileExist(path)){
            return false;
        }
        else{
            return true;
        }
    }
}
