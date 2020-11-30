package leagueobjectmodel;


public class ConferenceValidator implements IConferenceValidator {

    private static IConferenceValidator conferenceValidator;
    private static IDivisonValidator divisonValidator;
    private int numberOfDivision = 0;

    public ConferenceValidator() {
        //conferenceValidator = new ConferenceValidator();
        divisonValidator = new DivisonValidator();
    }

    @Override
    public boolean validateConferenceObject(IConferenceModel conferenceModel) {

        if (conferenceModel.getConferenceName() == null || conferenceModel.getConferenceName() == "") {
            return false;
        } else {
            for (IDivisonModel divisonModel : conferenceModel.getDivisions()) {
                numberOfDivision++;
                if (divisonValidator.validateDivisionObject(divisonModel)) {
                    continue;
                } else {
                    System.out.println("Encountered problem while validating Divisions in Conferene ==> " + conferenceModel.getConferenceName());
                    return false;
                }

            }
        }

        if (numberOfDivision % 2 == 0) {
            return true;
        } else {
            return true;
        }
    }

    @Override
    public boolean isConferenceExist(ILeagueModel leagueModel, String conferenceName) {
        for (IConferenceModel conferenceModel : leagueModel.getConferences()) {
            if (conferenceModel.getConferenceName().equalsIgnoreCase(conferenceName)) {
                return true;
            }
        }
        return false;
    }

}
