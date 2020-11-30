package statemachine.trade;

import leagueobjectmodel.ITeamsModel;
import leagueobjectmodel.PlayerModel;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;

public class CalculateStrength implements ICalculateStrength {
    private static final Logger logger = Logger.getLogger (CalculateStrength.class);
    private final float goodForwardStrength = 400;
    private final float goodDefenseStrength = 290;
    private final float goodGoalieStrength = 100;

    private enum playerPosition {
        forward,
        defense,
        goalie
    }

    @Override
    public int findTeamStrengthWeakness(ITradeTeamPojo teamDetails, HashMap strengthMap) {
        int counterForward = 0;
        int counterDefense = 0;
        int counterGoalie = 0;
        int totalCounter;

        float forwardStrength = (float) strengthMap.get (playerPosition.forward.toString ());
        float defenseStrength = (float) strengthMap.get (playerPosition.defense.toString ());
        float goalieStrength = (float) strengthMap.get (playerPosition.goalie.toString ());

        if (forwardStrength > goodForwardStrength) {
            counterForward += 1;
        }
        if (defenseStrength > goodDefenseStrength) {
            counterDefense += 1;
        }
        if (goalieStrength > goodGoalieStrength) {
            counterGoalie += 1;
        }
        teamDetails.setIsDefenseStrong (counterDefense);
        teamDetails.setIsForwardStrong (counterForward);
        teamDetails.setIsGoalieStrong (counterGoalie);
        totalCounter = counterForward + counterDefense + counterGoalie;
        return totalCounter;

    }

    @Override
    public HashMap findStrength(ITeamsModel team) {
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
}
