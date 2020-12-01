package statemachine.trade;

import cli.CliAbstractFactory;
import leagueobjectmodel.IPlayerModel;

import java.io.PrintStream;
import java.util.Scanner;


public class UserTradeCli implements IUserTradeCli {

    private Scanner sc;
    private PrintStream out;
    private ITradeModel model;

    public UserTradeCli() {
        sc = CliAbstractFactory.getInstance ().getSc ();
        out = CliAbstractFactory.getInstance ().getOut ();
        model = TradeAbstractFactory.instance ().createTradeModel ();
    }

    @Override
    public int displayTeamDetails() {
        out.println ("The players offered and their statistics:-");
        if (model.getOfferedPlayer ().size () > 0) {
            for (int i = 0; i < model.getOfferedPlayer ().size (); i++) {
                IPlayerModel player = model.getOfferedPlayer ().get (i);
                out.println ("Player's name: " + " " + player.getPlayerName ());
                out.println ("Player's position: " + " " + player.getPosition ());
                out.println ("Player's age : " + " " + player.getAge ());
                out.println ("Player's skating: " + " " + player.getSkating ());
                out.println ("Player's shooting: " + " " + player.getShooting ());
                out.println ("Player's checking: " + " " + player.getChecking ());
                out.println ("Player's saving: " + " " + player.getSaving ());
                out.println ("Player's strength: " + " " + player.getPlayerStrength ());
                out.println ("================================================");
            }
        }

        out.print("The players requested:-");
        for (int i = 0; i < model.getRequestedPlayers ().size (); i++) {
            IPlayerModel player = model.getRequestedPlayers ().get (i);
            out.println ("Player's name: " + " " + player.getPlayerName ());
            out.println ("Player's position: " + " " + player.getPosition ());
            out.println ("================================================");
        }
        int userInput = userDecision ();
        return userInput;
    }

    private int userDecision() {
        int input = 0;
        out.println ("Please enter 1 for accepting trade or enter 2 for rejecting trade");
        int userInput = sc.nextInt ();
        if (userInput == 1 || userInput == 2) {

            return userInput;
        } else {
            input = userDecision ();
            return input;
        }
    }
}
