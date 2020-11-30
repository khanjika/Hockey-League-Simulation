package database.serializeobject;

public enum FileConstant {
    DirectoryPath("src\\main\\java\\database\\datasource\\"),
    FileType(".JSON");

    private String value;
    FileConstant(String value) {
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
