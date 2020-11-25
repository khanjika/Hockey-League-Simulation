//package trade;
//
//import leagueobjectmodel.*;
//
//
//public class GenerateTradeOffer implements IGenerateTradeOffer {
//    ITradeTeamPojo tradingTeamDetails = new TradeTeamPojo();
//    IFindPlayerToSwap tradePlayers = new FindPlayerToSwap();
//
//    public boolean calculateLossPoint(float lossMatches, TradingModel tradeModel) {
//        float lossPoint = tradeModel.getLossPoint();
//        return lossMatches >= lossPoint;
//    }
//
//
//    public boolean makeTradeOffer(TradingModel tradeModel) {
//        float tradeChance = tradeModel.getRandomTradeOfferChance();
//        return Math.random() < tradeChance;
//    }
//
//    @Override
//    public ILeagueModel checkTrading(ILeagueModel leagueModel) {
//        GamePlayConfigModel gameConfig = leagueModel.getGameplayConfig();
//        TradingModel tradeModel = gameConfig.getTrading();
//        if (leagueModel == null) {
//            System.out.println("League Model is null");
//            return leagueModel;
//        } else {
//            for (ConferenceModel conference : leagueModel.getConferences()) {
//                String conferenceName = conference.getConferenceName();
//                for (DivisonModel division : conference.getDivisions()) {
//                    String divisionName = division.getDivisionName();
//                    for (TeamsModel team : division.getTeams()) {
//                        String teamName = team.getTeamName();
//                        if (team.isUserCreatedTeam() == false) {
//                            float lossPoint = team.getLossPoint();
//                            if (calculateLossPoint(lossPoint, tradeModel)) {
//                                if (makeTradeOffer(tradeModel)) {
//                                    //set the tradeloss point to zero here
//                                    System.out.println("Trade initiated by team:" + " " + teamName);
//                                    tradingTeamDetails.setConferenceName(conferenceName);
//                                    tradingTeamDetails.setDivisionName(divisionName);
//                                    tradingTeamDetails.setTeamName(teamName);
//                                    tradingTeamDetails.setUserCreated(false);
//                                    tradePlayers.findPlayersToSwap(leagueModel, team, tradingTeamDetails);
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//            return leagueModel;
//        }
//    }
//
//}
//
//
//
