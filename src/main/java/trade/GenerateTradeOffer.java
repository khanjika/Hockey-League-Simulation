package trade;

import conference.ConferenceModel;
import divison.DivisonModel;
import gameplayconfig.GamePlayConfigModel;
import gameplayconfig.TradingModel;
import league.LeagueModel;
import teams.TeamsModel;


public class GenerateTradeOffer implements IGenerateTradeOffer {
    ITradeTeamPojo tradingTeamDetails = new TradeTeamPojo ();
    IFindPlayerToSwap tradePlayers = new FindPlayerToSwap ();
    IGenerateRandomNo random = new GenerateRandomNo ();

    public boolean calculateLossPoint(float lossMatches, TradingModel tradeModel) {
        float lossPoint = tradeModel.getLossPoint ();
        if (lossMatches >= lossPoint) {
            return true;
        } else {
            return false;
        }
    }


    public boolean makeTradeOffer(TradingModel tradeModel) {
        float randomNo = random.generateRandomNumber ();
        float tradeChance = tradeModel.getRandomTradeOfferChance ();
        if (randomNo < tradeChance) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public LeagueModel checkTrading(LeagueModel leagueModel) {
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
                                tradingTeamDetails.setConferenceName (conferenceName);
                                tradingTeamDetails.setDivisionName (divisionName);
                                tradingTeamDetails.setTeamName (teamName);
                                tradingTeamDetails.setUserCreated (false);
                                tradePlayers.swapPlayer (leagueModel, team, tradingTeamDetails);
                            }
                        }
                    }
                }
            }
        }
        return leagueModel;
    }
}



