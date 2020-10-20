package trade;
import java.util.Random;

import conference.ConferenceModel;
import divison.DivisonModel;
import gameplayconfig.GamePlayConfigModel;
import gameplayconfig.TradingModel;
import league.LeagueModel;
import teams.TeamsModel;

public class GenerateTradeOffer implements IGenerateTradeOffer{
    private boolean calculateLossPoint(float lossMatches, TradingModel tradeModel) {
        float lossPoint = tradeModel.getLossPoint ();
        if (lossMatches >= lossPoint) {
            return true;
        }
        else{
            return false;
        }
    }

    private float generateRandomNumber(){
        Random random = new Random();
        float randomNo = 0;
        randomNo=random.nextFloat();
        return randomNo;
    }

    private boolean makeTradeOffer(TradingModel tradeModel){
        float randomNo = generateRandomNumber();
        float tradeChance = tradeModel.getRandomTradeOfferChance ();
        if(randomNo < tradeChance){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean checkTrading(LeagueModel leagueModel) {
        GamePlayConfigModel gameConfig = leagueModel.getGameplayConfig ();
        TradingModel tradeModel  = gameConfig.getTrading ();
        for(ConferenceModel conference : leagueModel.getConferences()) {
            for(DivisonModel division : conference.getDivisions ()) {
                for(TeamsModel team : division.getTeams ()) {
                    float lossMatches = 9;
                        //Get the loss point of the team
                      if (calculateLossPoint (lossMatches, tradeModel) == true) {
                             if(makeTradeOffer (tradeModel)) {
                                 return true;
                             }
                             else{
                                 return false;
                             }
                      }
                      else{
                          return false;
                      }
                }
            }
        }
        return false;
    }
}
