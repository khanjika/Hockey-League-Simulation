package divison;

public interface IDivisonModel {

    boolean isDivisionAlreadyExist(String divisionName, int conferenceId);

    int getDivisionId(String divisionName, int conferenceId);

    void storeDivisionInformation(DivisonModel divisonModel, int conferenceId);
}
