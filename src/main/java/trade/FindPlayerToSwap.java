package trade;

import cli.IUserTradeCli;
import cli.UserTradeCli;
import conference.ConferenceModel;
import divison.DivisonModel;
import gameplayconfig.GamePlayConfigModel;
import gameplayconfig.TradingModel;
import league.LeagueModel;
import players.PlayerModel;
import teams.ISortTeams;
import teams.SortTeams;
import teams.TeamsModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FindPlayerToSwap implements IFindPlayerToSwap {
    ITradeTeamPojo RequestTeamDetails = new TradeTeamPojo ();
    IAcceptRejectTrade acceptReject = new AcceptRejectTrade ();
    ISortTeams sort = new SortTeams ();

    @Override
    public LeagueModel findPlayersToSwap(LeagueModel league, TeamsModel team, ITradeTeamPojo tradingTeamDetails) {
        IUserTradeCli userTrade = new UserTradeCli ();
        GamePlayConfigModel gameConfig = league.getGameplayConfig ();
        TradingModel tradeModel = gameConfig.getTrading ();

        TradeModel trade = offeredPlayer (team, tradeModel);
        findTeamForSwap (league, tradingTeamDetails, trade);

        if (RequestTeamDetails.isUserCreated ()) {

            int userInput = userTrade.displayTeamDetails (trade);
            if (userInput == 1) {
                league = acceptReject.tradeAccepted (RequestTeamDetails, tradingTeamDetails, trade, league);
            }
        } else {
            System.out.println ("Trade offered to team:" + " " + RequestTeamDetails.getTeamName ());
            league = acceptReject.acceptRejectTrade (RequestTeamDetails, tradingTeamDetails, trade, league);
        }
        return league;
    }

    @Override
    public TradeModel offeredPlayer(TeamsModel team, TradingModel tradeModel) {
        TradeModel trade = new TradeModel ();
        List<PlayerModel> offeredPlayerList = new ArrayList<> ();
        List<PlayerModel> players = null;

        int maxPlayerTrade = tradeModel.getMaxPlayersPerTrade ();
        players = sort.sortPlayersAscending (team.getPlayers ());

        if (players.isEmpty () == false) {
            String weakestPlayerPosition = players.stream ().findFirst ().get ().getPosition ();
            if (weakestPlayerPosition.length () > 0) {
                for (int i = 0; i < maxPlayerTrade; i++) {
                    if (players.get (i).getPosition ().equals (weakestPlayerPosition)) {
                        PlayerModel p = new PlayerModel ();
                        p = players.get (i);
                        offeredPlayerList.add (p);
                    }
                }
            }
        }
        trade.setOfferedPlayer (offeredPlayerList);
        return trade;
    }

    public TradeModel findTeamForSwap(LeagueModel league, ITradeTeamPojo tradingTeamDetails, TradeModel trade) {
        Map<Float, ArrayList> requestingPlayerMap = new HashMap<> ();

        String generateTradeTeam = tradingTeamDetails.getTeamName ();
        String generateTradeDivision = tradingTeamDetails.getDivisionName ();
        String generateTradeConference = tradingTeamDetails.getConferenceName ();

        for (ConferenceModel conference : league.getConferences ()) {
            String potentialConferenceName = conference.getConferenceName ();
            for (DivisonModel division : conference.getDivisions ()) {
                String potentialDivisionName = division.getDivisionName ();
                for (TeamsModel team : division.getTeams ()) {
                    boolean isUserCreated = team.isUserCreatedTeam ();
                    String potentialTeamName = team.getTeamName ();
                    if (potentialTeamName.equals (generateTradeTeam) && (potentialDivisionName.equals (generateTradeDivision)) && (potentialConferenceName.equals (generateTradeConference))) {
                    } else {
                        List<PlayerModel> potentialPlayers = new ArrayList<> ();
                        ITradeTeamPojo potentialTeamDetails = new TradeTeamPojo ();

                        potentialPlayers = playersFromTeam (team, trade);

                        potentialTeamDetails.setTeamName (potentialTeamName);
                        potentialTeamDetails.setDivisionName (potentialDivisionName);
                        potentialTeamDetails.setConferenceName (potentialConferenceName);
                        potentialTeamDetails.setUserCreated (isUserCreated);

                        requestingPlayerMap = teamWithMaxStrength (potentialPlayers, potentialTeamDetails, requestingPlayerMap);
                    }
                }
            }
        }
        Map.Entry<Float, ArrayList> entry = requestingPlayerMap.entrySet ().iterator ().next ();
        ArrayList teamPlayer2 = entry.getValue ();
        trade.setRequestedPlayers (teamPlayer2);
        return trade;
    }

    public List<PlayerModel> playersFromTeam(TeamsModel team, TradeModel trade) {
        List<PlayerModel> sortedPlayerList = new ArrayList<> ();
        List<PlayerModel> potentialPlayers = new ArrayList<> ();

        List<PlayerModel> offeredPlayers = trade.getOfferedPlayer ();
        int noOfPlayersToSwap = offeredPlayers.size ();
        if (noOfPlayersToSwap > 0) {
            String weakPlayersPosition = offeredPlayers.stream ().findFirst ().get ().getPosition ();
            int counter = 0;
            sortedPlayerList = sort.sortPlayersDescending (team.getPlayers ());

            for (int i = 0; i < sortedPlayerList.size (); i++) {
                if (sortedPlayerList.get (i).getPosition ().equals (weakPlayersPosition) && counter < noOfPlayersToSwap) {
                    counter++;
                    potentialPlayers.add (sortedPlayerList.get (i));
                } else {
                    if (counter == noOfPlayersToSwap) {
                        counter = 0;
                        break;
                    }
                }
            }
        }
        return potentialPlayers;
    }

    public Map<Float, ArrayList> teamWithMaxStrength(List<PlayerModel> potentialPlayers, ITradeTeamPojo potentialTeamDetails, Map<Float, ArrayList> requestingPlayerMap) {
        ArrayList swapTeamDetails = new ArrayList ();

        float strength = 0;
        int size = potentialPlayers.size ();
        for (int i = 0; i < size; i++) {
            swapTeamDetails.add (potentialPlayers.get (i));
            strength = (potentialPlayers.get (i).getPlayerStrength () + strength);
        }
        if (requestingPlayerMap.size () > 0) {
            Map.Entry<Float, ArrayList> entry = requestingPlayerMap.entrySet ().iterator ().next ();
            Float mapKey = entry.getKey ();
            if (mapKey < strength) {
                requestingPlayerMap.remove (mapKey);
                requestingPlayerMap.put (strength, swapTeamDetails);
                RequestTeamDetails.setTeamName (potentialTeamDetails.getTeamName ());
                RequestTeamDetails.setDivisionName (potentialTeamDetails.getDivisionName ());
                RequestTeamDetails.setConferenceName (potentialTeamDetails.getConferenceName ());
                RequestTeamDetails.setUserCreated (potentialTeamDetails.isUserCreated ());
            }
        } else if (requestingPlayerMap.size () == 0) {
            requestingPlayerMap.put (strength, swapTeamDetails);
            RequestTeamDetails.setTeamName (potentialTeamDetails.getTeamName ());
            RequestTeamDetails.setDivisionName (potentialTeamDetails.getDivisionName ());
            RequestTeamDetails.setConferenceName (potentialTeamDetails.getConferenceName ());
            RequestTeamDetails.setUserCreated (potentialTeamDetails.isUserCreated ());
        }
        return requestingPlayerMap;
    }

}
