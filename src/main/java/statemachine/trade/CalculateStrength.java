package statemachine.trade;

import leagueobjectmodel.*;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;

public class CalculateStrength implements ICalculateStrength {
    private static final Logger logger = Logger.getLogger (CalculateStrength.class);
    private float averageForwardStrength = 0;
    private float averageDefenseStrength = 0;
    private float averageGoalieStrength = 0;

    private enum playerPosition {
        forward,
        defense,
        goalie
    }

    @Override
    public int totalStrengthCounter(ITeamsModel team, HashMap strengthMap, ILeagueModel league) {
        int counterForward = 0;
        int counterDefense = 0;
        int counterGoalie = 0;
        int totalCounter;
        findAveragePositionStrength(league);
        if ((float) strengthMap.get (playerPosition.forward.toString ()) > averageForwardStrength) {
            counterForward += 1;
        }
        if ((float) strengthMap.get (playerPosition.defense.toString ()) > averageDefenseStrength) {
            counterDefense += 1;
        }
        if ((float) strengthMap.get (playerPosition.goalie.toString ()) > averageGoalieStrength) {
            counterGoalie += 1;
        }
        team.setIsDefenseStrong (counterDefense);
        team.setIsForwardStrong (counterForward);
        team.setIsGoalieStrong (counterGoalie);
        totalCounter = counterForward + counterDefense + counterGoalie;
        return totalCounter;

    }

    @Override
    public HashMap findPositionStrength(ITeamsModel team) {
        float totalForwardStrength = 0;
        float totalDefenseStrength = 0;
        float totalGoalieStrength = 0;
        HashMap<String, Float> strengthMap = new HashMap<> ();
        List<PlayerModel> playerList = team.getPlayers ();
        for (int i = 0; i < playerList.size (); i++) {
            if (playerList.get (i).getPosition ().equals (playerPosition.forward.toString ())) {
                float forwardStrength = playerList.get (i).getPlayerStrength ();
                totalForwardStrength += forwardStrength;
            } else if (playerList.get (i).getPosition ().equals (playerPosition.defense.toString ())) {
                float defenseStrength = playerList.get (i).getPlayerStrength ();
                totalDefenseStrength += defenseStrength;
            } else {
                float goalieStrength = playerList.get (i).getPlayerStrength ();
                totalGoalieStrength += goalieStrength;
            }
        }
        strengthMap.put (playerPosition.forward.toString (), totalForwardStrength);
        strengthMap.put (playerPosition.defense.toString (), totalDefenseStrength);
        strengthMap.put (playerPosition.goalie.toString (), totalGoalieStrength);
        return strengthMap;
    }

    @Override
    public float findTeamStrength(List<PlayerModel> players) {
        float totalStrength = 0;
        for (int i = 0; i < players.size (); i++) {
            totalStrength += players.get (i).getPlayerStrength ();
        }
        return totalStrength;
    }

    @Override
    public void findAveragePositionStrength(ILeagueModel league) {
        HashMap<String, Float> strengthMap = new HashMap<> ();

        int totalTeam = 0;
        float totalForward = 0;
        float totaldefense = 0;
        float totalGoalie = 0;
        for (IConferenceModel conference : league.getConferences ()) {
            for (IDivisonModel division : conference.getDivisions ()) {
                for (ITeamsModel team : division.getTeams ()) {
                    totalTeam += 1;
                    HashMap map = findPositionStrength (team);
                    totalForward = totalForward + (float) map.get ("forward");
                    totaldefense = totaldefense + (float) map.get ("defense");
                    totalGoalie = totalGoalie + (float) map.get ("goalie");
                }
            }
        }
        averageForwardStrength = totalForward / totalTeam;
        averageForwardStrength = (float) (averageForwardStrength + (averageForwardStrength * 0.10));

        averageDefenseStrength = totaldefense / totalTeam;
        averageDefenseStrength = (float) (averageDefenseStrength + (averageDefenseStrength * 0.10));

        averageGoalieStrength = totalGoalie / totalTeam;
        averageGoalieStrength = (float) (averageGoalieStrength + (averageGoalieStrength * 0.10));

    }
}
