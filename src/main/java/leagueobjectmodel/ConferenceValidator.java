package leagueobjectmodel;


import cli.CliAbstractFactory;
import cli.ICli;

public class ConferenceValidator implements IConferenceValidator {


    private static IDivisonValidator divisonValidator;
    private int numberOfDivision = 0;
    ICli cli = CliAbstractFactory.getInstance().getCli();

    public ConferenceValidator() {
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
                    cli.printOutput("Encountered problem while validating Divisions in Conferene ==> " + conferenceModel.getConferenceName());
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
