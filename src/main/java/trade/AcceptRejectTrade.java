package trade;

import conference.ConferenceModel;
import divison.DivisonModel;
import league.LeagueModel;
import players.PlayerModel;
import teams.TeamsModel;

import java.util.ArrayList;
import java.util.List;

public class AcceptRejectTrade implements IAcceptRejectTrade {

    ISortTeams sort = new SortTeams ();
    IGenerateRandomNo random = new GenerateRandomNo ();

    @Override
    public LeagueModel acceptRejectTrade(ITradeTeamPojo team2, ITradeTeamPojo team1, TradeModel trade, LeagueModel leagueModel) {
        float offeredPlayerStrength = 0;
        float requestedPlayerStrength = 0;
        int noOfPlayersToSwap = trade.getOfferedPlayer ().size ();

        for (int i = 0; i < noOfPlayersToSwap; i++) {
            offeredPlayerStrength = trade.getOfferedPlayer ().get (i).getPlayerStrength () + offeredPlayerStrength;
        }

        for (int i = 0; i < noOfPlayersToSwap; i++) {
            requestedPlayerStrength = trade.getRequestedPlayers ().get (i).getPlayerStrength () + requestedPlayerStrength;
        }

        if (offeredPlayerStrength > requestedPlayerStrength) {
            //Trade is accepted
            leagueModel = tradeAccepted (team2, team1, trade, leagueModel);
        } else {
            //Trade is rejected
            leagueModel = tradeRejected (team2, team1, leagueModel, trade);
        }
        return leagueModel;
    }

    @Override
    public LeagueModel tradeRejected(ITradeTeamPojo team2, ITradeTeamPojo team1, LeagueModel leagueModel, TradeModel trade) {
        float randomAcceptanceChance = leagueModel.getGameplayConfig ().getTrading ().getRandomAcceptanceChance ();

        float randomNo = random.generateRandomNumber ();

        if (randomNo < randomAcceptanceChance) {
            leagueModel = tradeAccepted (team2, team1, trade, leagueModel);
        }
        return leagueModel;
    }

    @Override
    public LeagueModel tradeAccepted(ITradeTeamPojo team2, ITradeTeamPojo team1, TradeModel trade, LeagueModel league) {

        boolean successTeam1 = false;
        boolean successTeam2 = false;

        String TradingTeam1 = team1.getTeamName ();
        String TradingDivision1 = team1.getDivisionName ();
        String TradingConference1 = team1.getConferenceName ();

        String TradingTeam2 = team2.getTeamName ();
        String TradingDivision2 = team2.getDivisionName ();
        String TradingConference2 = team2.getConferenceName ();

        for (ConferenceModel conference : league.getConferences ()) {
            for (DivisonModel division : conference.getDivisions ()) {
                for (TeamsModel team : division.getTeams ()) {
                    String teamName = team.getTeamName ();
                    String divisionName = division.getDivisionName ();
                    String conferenceName = conference.getConferenceName ();
                    if (teamName.equals (TradingTeam1) && divisionName.equals (TradingDivision1) && conferenceName.equals (TradingConference1)) {
                        successTeam1 = swapTeam1 (team, trade);
                    }
                    if (teamName.equals (TradingTeam2) && divisionName.equals (TradingDivision2) && conferenceName.equals (TradingConference2)) {
                        successTeam2 = swapTeam2 (team, trade);
                    }
                    if (successTeam1 && successTeam2) {
                        break;
                    }

                }
            }
        }
        return league;
    }

    @Override
    public boolean swapTeam1(TeamsModel team, TradeModel trade) {
        List<PlayerModel> t1 = new ArrayList ();
        t1 = team.getPlayers ();
        for (int i = 0; i < trade.getRequestedPlayers ().size (); i++) {
            PlayerModel strongPlayer = (PlayerModel) trade.getRequestedPlayers ().get (i);
            t1.add (strongPlayer);
        }
        for (int i = 0; i < trade.getOfferedPlayer ().size (); i++) {
            PlayerModel weakPlayer = trade.getOfferedPlayer ().get (i);
            for (int j = 0; j < t1.size (); j++) {
                if (weakPlayer.equals (t1.get (j))) {
                    t1.remove (weakPlayer);
                    break;
                }
            }
        }
        team.setPlayers (t1);
        isCaptainPresent (t1);
        team.calculateTeamStrength (team);
        return true;
    }

    @Override
    public boolean swapTeam2(TeamsModel team, TradeModel trade) {
        List<PlayerModel> t2 = new ArrayList<> ();
        t2 = team.getPlayers ();
        for (int i = 0; i < trade.getOfferedPlayer ().size (); i++) {
            PlayerModel weakPlayer = trade.getOfferedPlayer ().get (i);
            t2.add (weakPlayer);
        }
        for (int i = 0; i < trade.getRequestedPlayers ().size (); i++) {
            PlayerModel strongPlayer = (PlayerModel) trade.getRequestedPlayers ().get (i);
            for (int j = 0; j < t2.size (); j++) {
                if (strongPlayer.equals (t2.get (j))) {
                    t2.remove (strongPlayer);
                    break;
                }
            }
        }
        team.setPlayers (t2);
        isCaptainPresent (t2);
        team.calculateTeamStrength (team);
        return true;
    }

    @Override
    public List<PlayerModel> isCaptainPresent(List<PlayerModel> teamPlayerDetails) {
        int counter = 0;
        teamPlayerDetails = sort.sortPlayersDescending (teamPlayerDetails);
        for (int i = 0; i < teamPlayerDetails.size (); i++) {
            if (teamPlayerDetails.get (i).isCaptain ()) {
                counter++;
                if (counter == 2) {
                    teamPlayerDetails.get (i).setCaptain (false);
                }
            }
        }

        if (counter == 0 && !teamPlayerDetails.isEmpty ()) {
            teamPlayerDetails.stream ().findFirst ().get ().setCaptain (true);
        }
        return teamPlayerDetails;
    }

}



