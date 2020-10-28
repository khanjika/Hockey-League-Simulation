package trade;

import conference.ConferenceModel;
import divison.DivisonModel;
import gameplayconfig.TradingModel;
import league.LeagueModel;
import players.PlayerModel;
import teams.TeamsModel;

import java.util.*;


public class FindPlayerToSwap implements IFindPlayerToSwap {
    ITradeTeamPojo tradindgTeam2Details = new TradeTeamPojo ();

    @Override
    public void swapPlayer(TeamsModel team, TradingModel tradeModel, LeagueModel league, ITradeTeamPojo tradingTeamDetails) {
        String teamName = team.getTeamName ();
        List<PlayerModel> tradeWeakPlayers = findWeakPlayer (team, tradeModel);
        Map<Float, ArrayList> finalPlayerMap = findTeamForSwap (league, tradeWeakPlayers, tradingTeamDetails);
        //change this
//        if (tradindgTeam2Details.isUserCreated () == false) {
//            //if (tradindgTeam2Details.isUserCreated () == true) {
//            IAcceptRejectTrade acceptReject = new AcceptRejectTrade ();
//            acceptReject.acceptRejectTrade (tradindgTeam2Details, tradingTeamDetails, tradeWeakPlayers, finalPlayerMap, tradeModel, league);
//        } else {
//            IUserTradeCli userTrade = new UserTradeCli ();
//            userTrade.displayTeamDetails (tradeWeakPlayers);
//
//        }

    }

    public Map<Float, ArrayList> findTeamForSwap(LeagueModel league, List<PlayerModel> weakPlayers, ITradeTeamPojo tradingTeamDetails) {
        Map<Float, ArrayList> finalPlayerMap = new HashMap<> ();
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
                        potentialPlayers = playersFromTeam (team, weakPlayers);
                        finalPlayerMap = teamWithMaxStrength (potentialPlayers, potentialTeamName, potentialDivisionName, potentialConferenceName, isUserCreated, finalPlayerMap);
                    }
                }
            }
        }
        return finalPlayerMap;
    }

    public List<PlayerModel> playersFromTeam(TeamsModel team, List<PlayerModel> weakPlayers) {
        List<PlayerModel> strongPlayers = new ArrayList<> ();
        String weakPlayersPosition = weakPlayers.get (0).getPosition ();
        int noOfPlayersToSwap = weakPlayers.size ();
        int counter = 0;
        strongPlayers = sortPlayersDescending (team.getPlayers ());
        List<PlayerModel> potentialPlayers = new ArrayList<> ();
        for (int i = 0; i < strongPlayers.size (); i++) {
            if (strongPlayers.get (i).getPosition ().equals (weakPlayersPosition) && counter < noOfPlayersToSwap) {
                counter++;
                potentialPlayers.add (strongPlayers.get (i));
            } else {
                if (counter == noOfPlayersToSwap) {
                    counter = 0;
                    break;
                }
            }
        }
        return potentialPlayers;
    }

    public Map<Float, ArrayList> teamWithMaxStrength(List<PlayerModel> potentialPlayers, String teamName, String divisionName, String conferenceName, boolean isUserCreated, Map<Float, ArrayList> finalPlayerMap) {
        ArrayList swapTeamDetails = new ArrayList ();
        float strength = 0;
        int size = potentialPlayers.size ();
        for (int i = 0; i < size; i++) {
            swapTeamDetails.add (potentialPlayers.get (i));
            strength = (potentialPlayers.get (i).getPlayerStrength () + strength);
        }
        if (finalPlayerMap.size () > 0) {
            Map.Entry<Float, ArrayList> entry = finalPlayerMap.entrySet ().iterator ().next ();
            Float mapKey = entry.getKey ();
            if (mapKey < strength) {
                finalPlayerMap.remove (mapKey);
                finalPlayerMap.put (strength, swapTeamDetails);
                tradindgTeam2Details.setTeamName (teamName);
                tradindgTeam2Details.setDivisionName (divisionName);
                tradindgTeam2Details.setConferenceName (conferenceName);
                tradindgTeam2Details.setUserCreated (isUserCreated);
            }
        } else if (finalPlayerMap.size () == 0) {
            finalPlayerMap.put (strength, swapTeamDetails);
            tradindgTeam2Details.setTeamName (teamName);
            tradindgTeam2Details.setDivisionName (divisionName);
            tradindgTeam2Details.setConferenceName (conferenceName);
            tradindgTeam2Details.setUserCreated (isUserCreated);
        }
        return finalPlayerMap;
    }


    public List<PlayerModel> findWeakPlayer(TeamsModel team, TradingModel tradeModel) {
        List<PlayerModel> tradeWeakPlayers = new ArrayList<> ();
        int maxPlayerTrade = tradeModel.getMaxPlayersPerTrade ();
        List<PlayerModel> players = null;
        players = sortPlayersAscending (team.getPlayers ());
        if (players.isEmpty () == false) {
            String weakestPlayerPosition = players.get (0).getPosition ();
            for (int i = 0; i < maxPlayerTrade; i++) {
                if (players.get (i).getPosition ().equals (weakestPlayerPosition)) {
                    PlayerModel p = new PlayerModel ();
                    p = players.get (i);
                    tradeWeakPlayers.add (p);
                }
            }
        }
        return tradeWeakPlayers;
    }

    @Override
    public List<PlayerModel> sortPlayersAscending(List<PlayerModel> players) {
        players.sort (Comparator.comparing (PlayerModel::getPlayerStrength));
        return players;
    }

    @Override
    public List<PlayerModel> sortPlayersDescending(List<PlayerModel> players) {
        players.sort (Comparator.comparing (PlayerModel::getPlayerStrength).reversed ());
        return players;
    }

}
