package conference;

import divison.DivisonModel;
import divison.DivisonValidator;
import divison.IDivisonValidator;


public class ConferenceValidator implements IConferenceValidator {

    private static IConferenceValidator conferenceValidator;
    private static IDivisonValidator divisonValidator ;
    private int numberOfDivision = 0;


    public ConferenceValidator() {
        System.out.println("Inside the constructor of Conference Validator");
      divisonValidator  = new DivisonValidator();
    }


    @Override
    public boolean validateConferenceObject(ConferenceModel conferenceModel) {

        if (conferenceModel.getConferenceName() == null || conferenceModel.getConferenceName() == "") {
            return false;
        } else {
          //  System.out.println(conferenceModel.getConferenceName());
            for (DivisonModel divisonModel : conferenceModel.getDivisions()) {
               // System.out.println(divisonModel);
                numberOfDivision++;
                if (divisonValidator.validateDivisionObject(divisonModel)) {
                    continue;
                } else {
                    System.out.println("Encountered problem while validating Divisions");
                    return false;
                }

            }
        }

        if (numberOfDivision % 2 == 0) {
            return true;
        } else {
            //IMPORTANT NEED TO MAKE IT TO FALSE
            //System.out.println("Number of Division is not even");
            return true;
        }
    }

}
