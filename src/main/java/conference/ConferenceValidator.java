package conference;

import divison.DivisonModel;
import divison.DivisonValidator;
import divison.IDivisonValidator;
import league.LeagueModel;


public class ConferenceValidator implements IConferenceValidator {

    private static IConferenceValidator conferenceValidator;
    private static IDivisonValidator divisonValidator ;
    private int numberOfDivision = 0;


    public ConferenceValidator() {

      divisonValidator  = new DivisonValidator();
    }


    @Override
    public boolean validateConferenceObject(ConferenceModel conferenceModel) {

        if (conferenceModel.getConferenceName() == null || conferenceModel.getConferenceName() == "") {
            return false;
        } else {
            for (DivisonModel divisonModel : conferenceModel.getDivisions()) {
                numberOfDivision++;
                if (divisonValidator.validateDivisionObject(divisonModel)) {
                    continue;
                } else {
                    System.out.println("Encountered problem while validating Divisions in Conferene ==> "+conferenceModel.getConferenceName());
                    return false;
                }

            }
        }

        if (numberOfDivision % 2 == 0) {
            return true;
        } else {
            System.out.println("Number of Division is not even");
            return false;
        }
    }

    @Override
    public boolean isConferenceExist(LeagueModel leagueModel,String conferenceName) {
        for(ConferenceModel conferenceModel:leagueModel.getConferences()){
            if(conferenceModel.getConferenceName().equalsIgnoreCase(conferenceName)){
                return true;
            }
        }
        return false;
    }

}
