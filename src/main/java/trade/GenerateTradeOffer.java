package trade;

import conference.ConferenceModel;
import divison.DivisonModel;
import gameplayconfig.GamePlayConfigModel;
import gameplayconfig.TradingModel;
import league.LeagueModel;
import teams.TeamsModel;

import java.util.Random;


public class GenerateTradeOffer implements IGenerateTradeOffer {
    ITradeTeamPojo tradingTeamDetails = new TradeTeamPojo ();
    IFindPlayerToSwap tradePlayers = new FindPlayerToSwap ();

    public boolean calculateLossPoint(float lossMatches, TradingModel tradeModel) {
        float lossPoint = tradeModel.getLossPoint ();
        if (lossMatches >= lossPoint) {
            return true;
        } else {
            return false;
        }
    }

    public float generateRandomNumber() {
        Random random = new Random ();
        float randomNo = 0;
        randomNo = random.nextFloat ();
        return randomNo;
    }

    public boolean makeTradeOffer(TradingModel tradeModel) {
        //Uncomment this
        //float randomNo = generateRandomNumber();
        float randomNo = 0.02f;
        float tradeChance = tradeModel.getRandomTradeOfferChance ();
        if (randomNo < tradeChance) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkTrading(LeagueModel leagueModel) {
        GamePlayConfigModel gameConfig = leagueModel.getGameplayConfig ();
        TradingModel tradeModel = gameConfig.getTrading ();
        for (ConferenceModel conference : leagueModel.getConferences ()) {
            String conferenceName = conference.getConferenceName ();
            for (DivisonModel division : conference.getDivisions ()) {
                String divisionName = division.getDivisionName ();
                for (TeamsModel team : division.getTeams ()) {
                    String teamName = team.getTeamName ();
                    if (team.isUserCreatedTeam () == false) {
                        //Fetch lossMatch value
                        float lossMatches = 9;
                        //Get the loss point of the team
                        if (calculateLossPoint (lossMatches, tradeModel)) {
                            if (makeTradeOffer (tradeModel)) {
                                //set the tradeloss point to zero here
                                FindPlayerToSwap findPlayer = new FindPlayerToSwap ();
                                tradingTeamDetails.setConferenceName (conferenceName);
                                tradingTeamDetails.setDivisionName (divisionName);
                                tradingTeamDetails.setTeamName (teamName);
                                tradingTeamDetails.setUserCreated (false);
                                tradePlayers.swapPlayer (team, tradeModel, leagueModel, tradingTeamDetails);
                            } else {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }
}



