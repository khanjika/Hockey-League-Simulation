package trade;

import conference.ConferenceModel;
import divison.DivisonModel;
import league.LeagueModel;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import players.PlayerModel;
import teams.TeamsModel;

import java.util.ArrayList;
import java.util.List;

public class AcceptRejectTradeTest {

    AcceptRejectTrade acceptReject = new AcceptRejectTrade ();


    @Test
    void isCaptainPresent() {
        List<PlayerModel> list = null;
        MockLeague league = new MockLeague ();

        TeamsModel t = league.getTeamsObject1 ();
        List<PlayerModel> listOfPlayers = t.getPlayers ();

        acceptReject.isCaptainPresent (listOfPlayers);
        Assert.assertFalse (listOfPlayers.get (1).isCaptain ());
        Assert.assertTrue (listOfPlayers.get (0).isCaptain ());

        listOfPlayers.get (0).setCaptain (false);
        listOfPlayers.get (1).setCaptain (false);

        acceptReject.isCaptainPresent (listOfPlayers);
        Assert.assertTrue (listOfPlayers.get (0).isCaptain ());
    }

    @Test
    void swapTeams1() {
        MockLeague league = new MockLeague ();
        TradeModel trade = new TradeModel ();
        List<PlayerModel> team1PLayers = new ArrayList<> ();
        List<PlayerModel> team2PLayers = new ArrayList<> ();

        TeamsModel t1 = league.getTeamsObject1 ();
        PlayerModel p1 = t1.getPlayers ().get (0);
        team1PLayers.add (p1);
        trade.setOfferedPlayer (team1PLayers);

        TeamsModel t2 = league.getTeamsObject2 ();
        PlayerModel p2 = t2.getPlayers ().get (0);
        team2PLayers.add (p2);
        trade.setRequestedPlayers (team2PLayers);

        acceptReject.swapTeam1 (t1, trade);
        Assert.assertEquals (t1.getPlayers ().size (), 2);
        Assert.assertEquals (t1.getPlayers ().get (1).getPlayerName (), "C0");
    }

    @Test
    void swapTeam2() {
        MockLeague league = new MockLeague ();
        TradeModel trade = new TradeModel ();
        List<PlayerModel> team1PLayers = new ArrayList<> ();
        List<PlayerModel> team2PLayers = new ArrayList<> ();

        TeamsModel t1 = league.getTeamsObject1 ();
        PlayerModel p1 = t1.getPlayers ().get (0);
        team1PLayers.add (p1);
        trade.setRequestedPlayers (team1PLayers);

        TeamsModel t2 = league.getTeamsObject2 ();
        PlayerModel p2 = t2.getPlayers ().get (0);
        team2PLayers.add (p2);
        trade.setOfferedPlayer (team2PLayers);

        acceptReject.swapTeam1 (t2, trade);
        Assert.assertEquals (t2.getPlayers ().size (), 2);
        Assert.assertEquals (t2.getPlayers ().get (1).getPlayerName (), "A0");
    }

    @Test
    void tradeAccepted() {
        MockLeague league = new MockLeague ();
        TradeModel trade = new TradeModel ();
        TradeTeamPojo pojo1 = new TradeTeamPojo ();
        TradeTeamPojo pojo2 = new TradeTeamPojo ();
        List<PlayerModel> team1PLayers = new ArrayList<> ();
        List<PlayerModel> team2PLayers = new ArrayList<> ();

        LeagueModel leagueModel = league.getLeagueObject ();

        for (ConferenceModel conference : leagueModel.getConferences ()) {
            for (DivisonModel division : conference.getDivisions ()) {
                for (TeamsModel team : division.getTeams ()) {
                    PlayerModel p1 = team.getPlayers ().get (0);
                    team1PLayers.add (p1);
                    trade.setOfferedPlayer (team1PLayers);
                    break;
                }
            }
        }

        for (ConferenceModel conference : leagueModel.getConferences ()) {
            for (DivisonModel division : conference.getDivisions ()) {
                for (TeamsModel team2 : division.getTeams ()) {
                    if (team2.getTeamName () == "Halifax") {
                        PlayerModel p2 = team2.getPlayers ().get (0);
                        team2PLayers.add (p2);
                        trade.setRequestedPlayers (team2PLayers);
                    }
                }
            }
        }

        pojo1.setConferenceName ("Eastern Conference");
        pojo1.setDivisionName ("Atlantic");
        pojo1.setTeamName ("Boston");

        pojo2.setConferenceName ("Eastern Conference");
        pojo2.setDivisionName ("Atlantic");
        pojo2.setTeamName ("Halifax");

        LeagueModel leagueAfterTrading = acceptReject.tradeAccepted (pojo2, pojo1, trade, leagueModel);
        int sizeTeam1 = leagueAfterTrading.getConferences ().get (0).getDivisions ().get (0).getTeams ().get (0).getPlayers ().size ();
        int sizeTeam2 = leagueAfterTrading.getConferences ().get (0).getDivisions ().get (0).getTeams ().get (1).getPlayers ().size ();
        Assert.assertEquals (sizeTeam1, 2);
        Assert.assertEquals (sizeTeam2, 2);
    }

    @Test
    void tradeRejected() {
        MockLeague league = new MockLeague ();
        TradeModel trade = new TradeModel ();
        TradeTeamPojo pojo1 = new TradeTeamPojo ();
        TradeTeamPojo pojo2 = new TradeTeamPojo ();
        List<PlayerModel> team1PLayers = new ArrayList<> ();
        List<PlayerModel> team2PLayers = new ArrayList<> ();

        LeagueModel leagueModel = league.getLeagueObject ();

        for (ConferenceModel conference : leagueModel.getConferences ()) {
            for (DivisonModel division : conference.getDivisions ()) {
                for (TeamsModel team : division.getTeams ()) {
                    PlayerModel p1 = team.getPlayers ().get (0);
                    team1PLayers.add (p1);
                    trade.setOfferedPlayer (team1PLayers);
                    break;
                }
            }
        }

        for (ConferenceModel conference : leagueModel.getConferences ()) {
            for (DivisonModel division : conference.getDivisions ()) {
                for (TeamsModel team2 : division.getTeams ()) {
                    if (team2.getTeamName () == "Halifax") {
                        PlayerModel p2 = team2.getPlayers ().get (0);
                        team2PLayers.add (p2);
                        trade.setRequestedPlayers (team2PLayers);
                    }
                }
            }
        }

        pojo1.setConferenceName ("Eastern Conference");
        pojo1.setDivisionName ("Atlantic");
        pojo1.setTeamName ("Boston");

        pojo2.setConferenceName ("Eastern Conference");
        pojo2.setDivisionName ("Atlantic");
        pojo2.setTeamName ("Halifax");

        LeagueModel leagueAfterTrading = acceptReject.tradeRejected (pojo2, pojo1, leagueModel, trade);
        int sizeTeam1 = leagueAfterTrading.getConferences ().get (0).getDivisions ().get (0).getTeams ().get (0).getPlayers ().size ();
        int sizeTeam2 = leagueAfterTrading.getConferences ().get (0).getDivisions ().get (0).getTeams ().get (1).getPlayers ().size ();
        Assert.assertEquals (sizeTeam1, 2);
        Assert.assertEquals (sizeTeam2, 2);

        String player1Name = leagueAfterTrading.getConferences ().get (0).getDivisions ().get (0).getTeams ().get (0).getPlayers ().get (0).getPlayerName ();
        String player2Name = leagueAfterTrading.getConferences ().get (0).getDivisions ().get (0).getTeams ().get (0).getPlayers ().get (1).getPlayerName ();

        Assert.assertEquals (player1Name, "A0");
        Assert.assertEquals (player2Name, "C0");
    }

    @Test
    void acceptRejectTrade() {
        MockLeague league = new MockLeague ();
        TradeModel trade = new TradeModel ();
        TradeTeamPojo pojo1 = new TradeTeamPojo ();
        TradeTeamPojo pojo2 = new TradeTeamPojo ();
        List<PlayerModel> team1PLayers = new ArrayList<> ();
        List<PlayerModel> team2PLayers = new ArrayList<> ();

        LeagueModel leagueModel = league.getLeagueObject ();

        for (ConferenceModel conference : leagueModel.getConferences ()) {
            for (DivisonModel division : conference.getDivisions ()) {
                for (TeamsModel team : division.getTeams ()) {
                    PlayerModel p1 = team.getPlayers ().get (0);
                    team1PLayers.add (p1);
                    trade.setOfferedPlayer (team1PLayers);
                    break;
                }
            }
        }

        for (ConferenceModel conference : leagueModel.getConferences ()) {
            for (DivisonModel division : conference.getDivisions ()) {
                for (TeamsModel team2 : division.getTeams ()) {
                    if (team2.getTeamName () == "Halifax") {
                        PlayerModel p2 = team2.getPlayers ().get (0);
                        team2PLayers.add (p2);
                        trade.setRequestedPlayers (team2PLayers);
                    }
                }
            }
        }

        pojo1.setConferenceName ("Eastern Conference");
        pojo1.setDivisionName ("Atlantic");
        pojo1.setTeamName ("Boston");

        pojo2.setConferenceName ("Eastern Conference");
        pojo2.setDivisionName ("Atlantic");
        pojo2.setTeamName ("Halifax");

        LeagueModel leagueAfterTrading = acceptReject.acceptRejectTrade (pojo2, pojo1, trade, leagueModel);
        int sizeTeam1 = leagueAfterTrading.getConferences ().get (0).getDivisions ().get (0).getTeams ().get (0).getPlayers ().size ();
        int sizeTeam2 = leagueAfterTrading.getConferences ().get (0).getDivisions ().get (0).getTeams ().get (1).getPlayers ().size ();
        Assert.assertEquals (sizeTeam1, 2);
        Assert.assertEquals (sizeTeam2, 2);

        String player1Name = leagueAfterTrading.getConferences ().get (0).getDivisions ().get (0).getTeams ().get (0).getPlayers ().get (0).getPlayerName ();
        String player2Name = leagueAfterTrading.getConferences ().get (0).getDivisions ().get (0).getTeams ().get (0).getPlayers ().get (1).getPlayerName ();

        Assert.assertEquals (player1Name, "A0");
        Assert.assertEquals (player2Name, "C0");
    }


}

