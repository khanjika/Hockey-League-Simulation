package cli;

import players.PlayerModel;
import trade.ITradeModel;

import java.util.Scanner;


public class UserTradeCli implements IUserTradeCli {
    @Override
    public int displayTeamDetails(ITradeModel trade) {
        System.out.println ("The players offered and their statistics:-");
        for (int i = 0; i < trade.getOfferedPlayer ().size (); i++) {
            PlayerModel player = trade.getOfferedPlayer ().get (i);
            System.out.println ("Player's name: " + " " + player.getPlayerName ());
            System.out.println ("Player's position: " + " " + player.getPosition ());
            System.out.println ("Player's age : " + " " + player.getAge ());
            System.out.println ("Player's skating: " + " " + player.getSkating ());
            System.out.println ("Player's shooting: " + " " + player.getShooting ());
            System.out.println ("Player's checking: " + " " + player.getChecking ());
            System.out.println ("Player's saving: " + " " + player.getSaving ());
            System.out.println ("Player's strength: " + " " + player.getPlayerStrength ());
            System.out.println ("================================================");
        }

        System.out.println ("The players requested:-");
        for (int i = 0; i < trade.getRequestedPlayers ().size (); i++) {
            PlayerModel player = trade.getRequestedPlayers ().get (i);
            System.out.println ("Player's name: " + " " + player.getPlayerName ());
            System.out.println ("Player's position: " + " " + player.getPosition ());
            System.out.println ("================================================");
        }

        int userInput = userDecision ();

        return userInput;
    }

    public int userDecision() {
        int input = 0;
        Scanner sc = new Scanner (System.in);
        System.out.println ("Please enter 1 for accepting trade or enter 2 for rejecting trade");
        int userInput = sc.nextInt ();
        if (userInput == 1 || userInput == 2) {
            return userInput;
        } else {
            input = userDecision ();
            return input;
        }
    }
}
