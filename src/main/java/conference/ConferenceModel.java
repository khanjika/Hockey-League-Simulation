package conference;

import divison.DivisonModel;

import java.util.List;

public class ConferenceModel implements  IConferenceModel{

    private IConferencePersistent iConferencePersistent;
    private DivisonModel divisonModel;
    private String conferenceName;
    private List<DivisonModel> divisions;

    public ConferenceModel() {
        iConferencePersistent = new ConferencePersistent();
        divisonModel = new DivisonModel();
    }

    public String getConferenceName() {
        return conferenceName;
    }

    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }


    public List<DivisonModel> getDivisions() {
        return divisions;
    }

    public void setDivisions(List<DivisonModel> divisions) {
        this.divisions = divisions;
    }

    public boolean storeConferenceInformation(ConferenceModel conferenceModel, int leagueId) {

        //is conference in that specific eague already exist
       if(isConferenceAlreadyExist(conferenceModel.getConferenceName(),leagueId))
       {
           System.out.println("Conference already Exist in the DB");
           return false;
       }
       else {
           int conferenceId = iConferencePersistent.addConferenceInformation(conferenceModel.getConferenceName(), leagueId);
           for (DivisonModel divisonModel : conferenceModel.getDivisions()) {
               this.divisonModel.storeDivisionInformation(divisonModel, conferenceId);
           }
       }
        return false;
    }

    public boolean isConferenceAlreadyExist(String conferenceName, int leagueId){
        return false;
    }

    @Override
    public int getConferenceId(String conferenceName, int leagueId) {
        return 0;
    }


}
