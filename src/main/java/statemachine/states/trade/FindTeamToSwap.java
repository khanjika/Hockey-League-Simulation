package statemachine.states.trade;

import leagueobjectmodel.*;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindTeamToSwap implements IFindTeamToSwap {

    private ITeamsModel teamsModel;
    private ITradeModel model;
    private ICalculateStrength calculateStrength;
    private IAcceptRejectTrade acceptRejectTrade;
    private ITradeTeamPojo teamDetails;
    private IUserTradeCli userTradeCli;

    public FindTeamToSwap() {
        teamsModel = LeagueObjectModelAbstractFactory.getInstance ().getTeams ();
        model = TradeAbstractFactory.instance ().createTradeModel ();
        calculateStrength = TradeAbstractFactory.instance ().createStrength ();
        acceptRejectTrade = TradeAbstractFactory.instance ().createAcceptRejectTrade ();
        userTradeCli = TradeAbstractFactory.instance ().createUserTradeCli ();
        teamDetails = TradeAbstractFactory.instance ().createTeamPojo ();
    }

    private static final Logger logger = Logger.getLogger (FindTeamToSwap.class);
    private static int flag = 0;

    private enum playerPosition {
        forward,
        defense,
        goalie
    }

    @Override
    public ILeagueModel find(ILeagueModel league) {
        findPossibleTeam (league);
        if (model.getTradeOfferedTeam ().isUserCreated ()) {
            int userInput = userTradeCli.displayTeamDetails ();
            if (userInput == 1) {
                league = acceptRejectTrade.tradeAccepted (league);
            }
        } else {
            league = acceptRejectTrade.acceptRejectTrade (league);
        }
        return league;
    }


    @Override
    public void findPossibleTeam(ILeagueModel league) {
        String generateTradeTeam = model.getTradeInitiatingTeam ().getTeamName ();
        String generateTradeDivision = model.getTradeInitiatingTeam ().getDivisionName ();
        String generateTradeConference = model.getTradeInitiatingTeam ().getConferenceName ();
        for (ConferenceModel conference : league.getConferences ()) {
            String potentialConferenceName = conference.getConferenceName ();
            for (DivisonModel division : conference.getDivisions ()) {
                String potentialDivisionName = division.getDivisionName ();
                for (TeamsModel team : division.getTeams ()) {
                    boolean isUserCreated = team.isUserCreatedTeam ();
                    String potentialTeamName = team.getTeamName ();
                    if (potentialTeamName.equals (generateTradeTeam) && (potentialDivisionName.equals (generateTradeDivision)) && (potentialConferenceName.equals (generateTradeConference))) {
                    } else {
                        HashMap<String, Float> strengthMap = calculateStrength.findStrength (team);
                        int totalStrengthCounter = calculateStrength.findTeamStrengthWeakness (teamDetails, strengthMap);
                        if (totalStrengthCounter > 0) {
                            selectTeam (team);
                        }
                    }
                    if (flag == 1) {
                        teamDetails.setConferenceName (potentialConferenceName);
                        teamDetails.setDivisionName (potentialDivisionName);
                        teamDetails.setTeamName (potentialTeamName);
                        teamDetails.setUserCreated (isUserCreated);
                        model.setTradeOfferedTeam (teamDetails);
                        break;
                    }
                }
                if (flag == 1) {
                    break;
                }
            }
            if (flag == 1) {
                flag = 0;
                break;
            }
        }
    }

    public void selectTeam(TeamsModel team) {
        List<PlayerModel> requestedPlayers = new ArrayList<> ();
        if (model.getTradeInitiatingTeam ().getIsGoalieStrong () == 0) {
            logger.debug ("Need a goalie to make the team strong !!");
            if (teamDetails.getIsGoalieStrong () == 1) {
                findSuitablePlayers (team, playerPosition.goalie.toString (), requestedPlayers);
            }
        }
        if (model.getTradeInitiatingTeam ().getIsForwardStrong () == 0) {
            logger.debug ("Need a forward player to make the team strong !!");
            if (teamDetails.getIsForwardStrong () == 1) {
                findSuitablePlayers (team, playerPosition.forward.toString (), requestedPlayers);
            }
        }
        if (model.getTradeInitiatingTeam ().getIsDefenseStrong () == 0) {
            logger.debug ("Need a defense player to make the team strong !!");
            if (teamDetails.getIsDefenseStrong () == 1) {
                findSuitablePlayers (team, playerPosition.defense.toString (), requestedPlayers);
            }
        }
    }

    public void findSuitablePlayers(TeamsModel teams, String position, List<PlayerModel> requestedPlayers) {
        float initiatingWeakPositionStrength = 0;
        float possiblePlayerStrength;
        int counter = 0;

        List<PlayerModel> initiatingTeamPlayers = teamsModel.sortPlayersOfTeamDescending (model.getTradeInitiatingTeam ().getPlayersList ());
        List<PlayerModel> offeredTradeTeamPlayers = teamsModel.sortPlayersOfTeamDescending (teams.getPlayers ());
        List<PlayerModel> offeredPlayers = model.getOfferedPlayer ();
        List<PlayerModel> playersOfThatPosition = new ArrayList<> ();

        float teamStrength = calculateStrength.findTeamStrength (teams.getPlayers ());
        float offeredPlayerStrength = calculateStrength.findTeamStrength (offeredPlayers);

        for (int i = 0; i < initiatingTeamPlayers.size (); i++) {
            if (initiatingTeamPlayers.get (i).getPosition ().equals (position)) {
                if (counter == 1) {
                    initiatingWeakPositionStrength = initiatingTeamPlayers.get (i).getPlayerStrength ();
                    break;
                }
                counter += 1;
            }
        }

        for (int i = 0; i < offeredTradeTeamPlayers.size (); i++) {
            if (offeredTradeTeamPlayers.get (i).getPosition ().equals (position)) {
                playersOfThatPosition.add (offeredTradeTeamPlayers.get (i));
            }
        }

        for (int i = 1; i < playersOfThatPosition.size (); i++) {
            logger.debug ("Entered");
            possiblePlayerStrength = playersOfThatPosition.get (i).getPlayerStrength ();
            if (possiblePlayerStrength < initiatingWeakPositionStrength) {
                break;
            } else {
                float strength = teamStrength + offeredPlayerStrength - possiblePlayerStrength;
                if (strength > teamStrength) {
                    logger.debug ("Trade with this team");
                    flag = 1;
                    PlayerModel p = playersOfThatPosition.get (i);
                    requestedPlayers.add (p);
                    model.setRequestedPlayers (requestedPlayers);
                    break;
                } else {
                    break;
                }
            }
        }
    }
}
