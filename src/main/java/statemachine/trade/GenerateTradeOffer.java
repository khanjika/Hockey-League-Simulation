package statemachine.trade;

import leagueobjectmodel.*;
import org.apache.log4j.Logger;

public class GenerateTradeOffer implements IGenerateTradeOffer {
    private ITradeTeamPojo tradingTeamDetails;
    private ITradeModel model;
    private IFindOfferedPlayers findOfferedPlayers;

    public GenerateTradeOffer() {
        tradingTeamDetails = TradeAbstractFactory.instance ().createTeamPojo ();
        model = TradeAbstractFactory.instance ().createTradeModel ();
        findOfferedPlayers = TradeAbstractFactory.instance ().createOfferedPlayers ();
    }

    private static final Logger logger = Logger.getLogger (GenerateTradeOffer.class);

    private enum generalManagerPersonality {
        shrewd,
        normal,
        gambler
    }

    public boolean calculateLossPoint(float lossMatches, ITradingModel tradeModel) {
        float lossPoint = tradeModel.getLossPoint ();
        return lossMatches >= lossPoint;
    }

    public boolean makeTradeOffer(ITradingModel tradeModel, ITeamsModel team) {
        float randomTradeChance = 0;
        float tradeChance = tradeModel.getRandomTradeOfferChance ();
        String managerPosition = team.getGeneralManager ().getPersonality ();
        if (managerPosition.equals (generalManagerPersonality.gambler.toString ())) {
            randomTradeChance = tradeModel.getGmTable ().getGambler ();
        }
        if (managerPosition.equals (generalManagerPersonality.normal.toString ())) {
            tradeModel.getGmTable ().getNormal ();
        }
        if (managerPosition.equals (generalManagerPersonality.shrewd.toString ())) {
            tradeModel.getGmTable ().getShrewd ();
        }
        return Math.random () < (tradeChance + randomTradeChance);
    }

    @Override
    public ILeagueModel checkTrading(ILeagueModel leagueModel) {
        logger.debug ("Inside Trading");
        if (leagueModel == null) {
            throw new NullPointerException ();
        }
        IGamePlayConfigModel gameConfig = leagueModel.getGameplayConfig ();
        ITradingModel tradeModel = gameConfig.getTrading ();
        for (IConferenceModel conference : leagueModel.getConferences ()) {
            String conferenceName = conference.getConferenceName ();
            for (IDivisonModel division : conference.getDivisions ()) {
                String divisionName = division.getDivisionName ();
                for (ITeamsModel team : division.getTeams ()) {
                    String teamName = team.getTeamName ();
                    if (!team.isUserCreatedTeam ()) {
                        float lossPoint = team.getLossPoint ();
                        //if (calculateLossPoint (lossPoint, tradeModel)) {
                        //if (makeTradeOffer (tradeModel, team)) {
                        team.setLossPointForTrading (0);
                        logger.debug ("Trade initiated by team:" + " " + teamName);
                        tradingTeamDetails.setConferenceName (conferenceName);
                        tradingTeamDetails.setDivisionName (divisionName);
                        tradingTeamDetails.setTeamName (teamName);
                        tradingTeamDetails.setUserCreated (false);
                        tradingTeamDetails.setPlayersList (team.getPlayers ());
                        model.setTradeInitiatingTeam (tradingTeamDetails);
                        findOfferedPlayers.findStrength (leagueModel, team, model);
                        //}
                        //}
                    }
                }
            }
        }
        return leagueModel;
    }
}





