package database.serializeobject;

import java.io.File;

public class FileValidator implements IFileValidator{
    @Override
    public boolean isFileExist(String name){
        File file = new File(filePath(name));
        if (file.exists()){
            return true;
        }
        return false;
    }
    @Override
    public String filePath(String name){
        return FileConstant.DirectoryPath.getValue()+name+FileConstant.FileType.getValue();
    }
}
