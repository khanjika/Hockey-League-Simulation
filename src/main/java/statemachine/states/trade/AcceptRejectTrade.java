package statemachine.states.trade;

import leagueobjectmodel.*;

import java.util.ArrayList;
import java.util.List;

public class AcceptRejectTrade implements IAcceptRejectTrade {

    private ITradeModel model;

    public AcceptRejectTrade() {
        model = TradeAbstractFactory.getUniqueInstance ().getTradeModel ();
    }

    @Override
    public ILeagueModel acceptRejectTrade(ILeagueModel leagueModel) {
        float offeredPlayerStrength = 0;
        float requestedPlayerStrength = 0;

        for (int i = 0; i < model.getOfferedPlayer ().size (); i++) {
            offeredPlayerStrength += model.getOfferedPlayer ().get (i).getPlayerStrength ();
        }

        for (int i = 0; i < model.getRequestedPlayers ().size (); i++) {
            requestedPlayerStrength += model.getRequestedPlayers ().get (i).getPlayerStrength ();
        }

        if (offeredPlayerStrength > requestedPlayerStrength) {
            leagueModel = tradeAccepted (leagueModel);
        } else {
            leagueModel = tradeRejected (leagueModel);
        }
        return leagueModel;
    }

    @Override
    public ILeagueModel tradeRejected(ILeagueModel leagueModel) {
        float randomAcceptanceChance = leagueModel.getGameplayConfig ().getTrading ().getRandomAcceptanceChance ();

        if (Math.random () < randomAcceptanceChance) {
            leagueModel = tradeAccepted (leagueModel);
        }
        return leagueModel;
    }

    @Override
    public ILeagueModel tradeAccepted(ILeagueModel league) {
        boolean successTeam1 = false;
        boolean successTeam2 = false;

        String TradingTeam1 = model.getTradeInitiatingTeam ().getTeamName ();
        String TradingDivision1 = model.getTradeInitiatingTeam ().getDivisionName ();
        String TradingConference1 = model.getTradeInitiatingTeam ().getConferenceName ();

        String TradingTeam2 = model.getTradeOfferedTeam ().getTeamName ();
        String TradingDivision2 = model.getTradeOfferedTeam ().getDivisionName ();
        String TradingConference2 = model.getTradeOfferedTeam ().getConferenceName ();


        for (ConferenceModel conference : league.getConferences ()) {
            for (DivisonModel division : conference.getDivisions ()) {
                for (TeamsModel team : division.getTeams ()) {
                    String teamName = team.getTeamName ();
                    String divisionName = division.getDivisionName ();
                    String conferenceName = conference.getConferenceName ();
                    if (teamName.equals (TradingTeam1) && divisionName.equals (TradingDivision1) && conferenceName.equals (TradingConference1)) {
                        successTeam1 = swapTeam1 (team);
                        team.calculateTeamStrength (team);
                    }
                    if (teamName.equals (TradingTeam2) && divisionName.equals (TradingDivision2) && conferenceName.equals (TradingConference2)) {
                        successTeam2 = swapTeam2 (team);
                        team.calculateTeamStrength (team);
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
    public boolean swapTeam1(ITeamsModel team) {
        List<PlayerModel> t1 = team.getPlayers ();
        for (int i = 0; i < model.getRequestedPlayers ().size (); i++) {
            PlayerModel requestedPlayer = model.getRequestedPlayers ().get (i);
            t1.add (requestedPlayer);
        }
        for (int i = 0; i < model.getOfferedPlayer ().size (); i++) {
            PlayerModel offeredPlayer = model.getOfferedPlayer ().get (i);
            for (int j = 0; j < t1.size (); j++) {
                if (offeredPlayer.equals (t1.get (j))) {
                    t1.remove (offeredPlayer);
                    break;
                }
            }
        }
        team.setPlayers (t1);
        return true;
    }

    @Override
    public boolean swapTeam2(ITeamsModel team) {
        List<PlayerModel> t2 = new ArrayList<> ();

        t2 = team.getPlayers ();
        for (int i = 0; i < model.getOfferedPlayer ().size (); i++) {
            PlayerModel weakPlayer = model.getOfferedPlayer ().get (i);
            t2.add (weakPlayer);
        }
        for (int i = 0; i < model.getRequestedPlayers ().size (); i++) {
            PlayerModel strongPlayer = model.getRequestedPlayers ().get (i);
            for (int j = 0; j < t2.size (); j++) {
                if (strongPlayer.equals (t2.get (j))) {
                    t2.remove (strongPlayer);
                    break;
                }
            }
        }
        team.setPlayers (t2);
        return true;
    }
}



