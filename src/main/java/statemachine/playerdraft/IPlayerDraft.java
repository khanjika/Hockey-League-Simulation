package statemachine.playerdraft;

import leagueobjectmodel.IPlayerModel;

import java.util.List;

public interface IPlayerDraft {


    abstract String generatePlayerName();

    abstract int generatePlayerAge();

    abstract int generatePlayerBirthYear(int playerAge);

    abstract int generatePlayerBirthMonth();

    abstract int generatePlayerBirthDay(int month);

    abstract int generatePlayerSkatingStat(String position);

    abstract int generatePlayerShootingStat(String position);

    abstract int generatePlayerCheckingStat(String position);

    abstract int generatePlayerSavingStat(String position);

    abstract List<IPlayerModel> draftPlayers(int totalTeams);

    abstract List<IPlayerModel> draftGoaliePlayer(int totalGoaliePlayers);

    abstract List<IPlayerModel> draftDefensePlayers(int totalDefensePlayers);

    abstract List<IPlayerModel> draftForwardPlayers(int totalForwardPlayers);

}
