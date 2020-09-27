package players;

public class PlayerValidator implements IPlayerValidator {


    public PlayerValidator() {
        System.out.println("Constructor called");
    }

    @Override
    public boolean validatePlayerObject(PlayerModel playerModel) {

        if (isStringValid(playerModel.getPlayerName()) && isStringValid(playerModel.getPosition()) && playerModel.isCaptain() != null) {
          if(validatePosition(playerModel.getPosition())){
              return true;
          }
          else {
              System.out.println("Position for player "+ playerModel.getPlayerName() + " is not correct" );
              return false;
          }
        }
        else{
            return false;
        }

    }


   private boolean validatePosition(String str){

       String position= str.toLowerCase();
        if(position.equals("goalie") || position.equals("forward") || position.equals("defense")){
            return true;
        }
        else {
            return false;
        }
    }
    private boolean isStringValid(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return true;
    }


}
