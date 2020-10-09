package conference;

import divison.DivisonModel;
import divison.IDivisonModel;

import java.util.List;

public class ConferenceModel implements  IConferenceModel{

    private IConferencePersistent iConferencePersistent;
    private IDivisonModel divisonModel;
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

    public void storeConferenceInformation(ConferenceModel conferenceModel, int leagueId) {
        //is conference in that specific league already exist
       if(isConferenceAlreadyExist(conferenceModel.getConferenceName(),leagueId))
       {
           System.out.println("Conference already Exist in the DB");
       }
       else {
           System.out.println("Inside store conference information method=>"+conferenceModel.getConferenceName());
           int conferenceId = iConferencePersistent.addConferenceInformation(conferenceModel.getConferenceName(), leagueId);
           for (DivisonModel divisonModel : conferenceModel.getDivisions()) {
               this.divisonModel.storeDivisionInformation(divisonModel, conferenceId);
           }
       }

    }

    public boolean isConferenceAlreadyExist(String conferenceName, int leagueId){
        System.out.println("League Id is:"+leagueId);
        return iConferencePersistent.isConferenceAlreadyExist(conferenceName,leagueId);
    }

    @Override
    public int getConferenceId(String conferenceName, int leagueId) {
       return iConferencePersistent.getConferenceInformation(conferenceName,leagueId);
    }


}
