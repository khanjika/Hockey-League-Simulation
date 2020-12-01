package statemachine.trade;

import leagueobjectmodel.*;
import org.apache.log4j.Logger;

public class GenerateTradeOffer implements IGenerateTradeOffer {
    private static final Logger logger = Logger.getLogger (GenerateTradeOffer.class);
    private IFindOfferedPlayers findOfferedPlayers;

    private enum generalManagerPersonality {
        shrewd,
        normal,
        gambler
    }

    public GenerateTradeOffer() {
        findOfferedPlayers = TradeAbstractFactory.instance ().createOfferedPlayers ();
    }

    @Override
    public boolean calculateLossPoint(float lossMatches, ITradingModel tradeModel) {
        float lossPoint = tradeModel.getLossPoint ();
        return lossMatches >= lossPoint;
    }

    @Override
    public boolean calculateTradeChance(ITradingModel tradeModel, ITeamsModel team) {
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
        logger.info ("Inside Trading");
        if (leagueModel == null) {
            throw new NullPointerException ();
        }
        IGamePlayConfigModel gameConfig = leagueModel.getGameplayConfig ();
        ITradingModel tradeModel = gameConfig.getTrading ();
        for (IConferenceModel conference : leagueModel.getConferences ()) {
            for (IDivisonModel division : conference.getDivisions ()) {
                for (ITeamsModel team : division.getTeams ()) {
                    String teamName = team.getTeamName ();
                    if (team.isUserCreatedTeam ()==false) {
                        float lossPoint = team.getLossPoint ();
                        if (calculateLossPoint (lossPoint, tradeModel)) {
                            if (calculateTradeChance (tradeModel, team)) {
                                team.setLossPointForTrading (0);
                                logger.info ("Loss point is set to 0 for team:" + " " + teamName);
                                logger.info ("Trade is initiated by team:" + " " + teamName);
                                ITeamsModel initiatingTeam = team;
                                findOfferedPlayers.findPossibleTrade (leagueModel, team);
                            }
                        }
                    }
                }
            }
        }
        return leagueModel;
    }
}





