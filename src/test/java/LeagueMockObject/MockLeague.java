package LeagueMockObject;

import leagueobjectmodel.*;

import java.util.ArrayList;
import java.util.List;

public class MockLeague {

    public static LeagueModel getLeagueObject() {
        LeagueModel leagueModel = new LeagueModel();
        GamePlayConfigModel gamePLayModel = new GamePlayConfigModel();
        TradingModel tradingModel = new TradingModel ();
        tradingModel.setLossPoint(8);
        tradingModel.setMaxPlayersPerTrade(1);
        tradingModel.setRandomAcceptanceChance(1f);
        tradingModel.setRandomTradeOfferChance(0.05f);
        leagueModel.setLeagueName("Dalhousie Hockey League");
        AgingModel agingModel = new AgingModel();
        agingModel.setAverageRetirementAge(35);
        agingModel.setMaximumAge(50);
        GameResolverModel gameResolverModel = new GameResolverModel();
        gameResolverModel.setRandomWinChance(0.1f);
        TrainingModel trainingModel = new TrainingModel();
        trainingModel.setDaysUntilStatIncreaseCheck(100);
        InjuriesModel injuriesModel = new InjuriesModel();
        injuriesModel.setInjuryDaysHigh(250);
        injuriesModel.setInjuryDaysLow(1);
        injuriesModel.setRandomInjuryChance(0.05f);
        List<IConferenceModel> conferenceModelObjectList = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            ConferenceModel conferenceModel = getConferenceObject();
            conferenceModelObjectList.add(conferenceModel);
        }
        leagueModel.setConferences(conferenceModelObjectList);
        gamePLayModel.setInjuries(injuriesModel);
        List<FreeAgentModel> freeAgentModelList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            FreeAgentModel freeAgentModel = getFreeAgentModel("Roshan", "forward", 20, 16, 12, 11, 0);
            FreeAgentModel freeAgentModel1 = getFreeAgentModel("Arthy", "defense", 25, 3, 16, 13, 15);
            FreeAgentModel freeAgentModel2 = getFreeAgentModel("Zankruth", "goalie", 24, 18, 13, 9, 10);
            freeAgentModelList.add(freeAgentModel);
            freeAgentModelList.add((freeAgentModel1));
            freeAgentModelList.add(freeAgentModel2);
        }

        leagueModel.setGameplayConfig(gamePLayModel);
        gamePLayModel.setTrading(tradingModel);
        gamePLayModel.setAging(agingModel);
        leagueModel.setGameplayConfig(gamePLayModel);
        return leagueModel;
    }

    public static ConferenceModel getConferenceObject() {
        ConferenceModel conferenceModel = new ConferenceModel();
        conferenceModel.setConferenceName("Eastern Conference");
        List<IDivisonModel> divisionModelObjectList = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            DivisonModel divisonModel = getDivisionObject();
            divisionModelObjectList.add(divisonModel);
        }
        conferenceModel.setDivisions(divisionModelObjectList);
        return conferenceModel;
    }

    public static DivisonModel getDivisionObject() {
        DivisonModel divisonModel = new DivisonModel();
        divisonModel.setDivisionName("Atlantic");
        List<ITeamsModel> teamModelObjectList = new ArrayList<>();

        for (int i = 0; i < 1; i++) {
            TeamsModel teamsModel = getTeamsObject1();
            TeamsModel teamsModel1 = getTeamsObject2();
            teamModelObjectList.add(teamsModel);
            teamModelObjectList.add(teamsModel1);
        }

        divisonModel.setTeams(teamModelObjectList);
        return divisonModel;
    }

    public static TeamsModel getTeamsObject1() {
        TeamsModel teamsModel = new TeamsModel();
        HeadCoachModel headCoachModel = new HeadCoachModel();
        headCoachModel.setName("Mary Smith");
        headCoachModel.setSkating(0.5f);
        headCoachModel.setShooting(0.8f);
        headCoachModel.setChecking(0.3f);
        headCoachModel.setSaving(0.5f);
        teamsModel.setHeadCoach(headCoachModel);
        teamsModel.setTeamName("Boston");
        teamsModel.setUserCreatedTeam(false);
        boolean isCaptain = true;
        String playerName = "A";
        List<PlayerModel> playerModelObjectList = new ArrayList<>();
        for (int i = 0; i < 1; i++) {

            playerName = playerName + i;
            PlayerModel playerModel = getPlayerModel(playerName, "forward", false, 20, 10, 10, 10, 10);
            PlayerModel playerModel1 = getPlayerModel(playerName, "defense", false, 20, 13, 16, 17, 11);
            PlayerModel playerModel2 = getPlayerModel(playerName, "goalie", false, 20, 11, 18, 17, 11);
            PlayerModel playerModel3 = getPlayerModel(playerName, "goalie", false, 20, 19, 16, 17, 10);
            isCaptain = false;
            playerModelObjectList.add(playerModel);
            playerModelObjectList.add(playerModel1);
            playerModelObjectList.add(playerModel2);
            playerModelObjectList.add(playerModel3);
        }
        teamsModel.setPlayers(playerModelObjectList);
        return teamsModel;
    }

    public static TeamsModel getTeamsObject2() {
        TeamsModel teamsModel = new TeamsModel();
        HeadCoachModel headCoachModel = new HeadCoachModel();
        headCoachModel.setName("Mary Smith");
        headCoachModel.setSkating(0.5f);
        headCoachModel.setShooting(0.8f);
        headCoachModel.setChecking(0.3f);
        headCoachModel.setSaving(0.5f);
        teamsModel.setHeadCoach(headCoachModel);
        teamsModel.setTeamName("Halifax");
        teamsModel.setUserCreatedTeam(false);
        boolean isCaptain = true;
        String playerName = "C";
        List<PlayerModel> playerModelObjectList = new ArrayList<>();
        for (int i = 0; i < 1; i++) {

            playerName = playerName + i;
            PlayerModel playerModel = getPlayerModel(playerName, "forward", false, 20, 12, 10, 11, 10);
            PlayerModel playerModel1 = getPlayerModel(playerName, "defense", false, 20, 13, 19, 7, 11);
            PlayerModel playerModel2 = getPlayerModel(playerName, "goalie", false, 20, 11, 18, 17, 11);
            PlayerModel playerModel3 = getPlayerModel(playerName, "goalie", false, 20, 19, 16, 17, 10);
            isCaptain = false;
            playerModelObjectList.add(playerModel);
            playerModelObjectList.add(playerModel1);
            playerModelObjectList.add(playerModel2);
            playerModelObjectList.add(playerModel3);
        }
        teamsModel.setPlayers(playerModelObjectList);
        return teamsModel;
    }


    public static PlayerModel getPlayerModel(String playerName, String position, boolean iscaptain, int age, float skating, float shooting, float checking, float saving) {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setCaptain(iscaptain);
        playerModel.setPlayerName(playerName);
        playerModel.setPosition(position);
        playerModel.setAge(age);
        playerModel.setSkating(skating);
        playerModel.setChecking(checking);
        playerModel.setSaving(saving);
        playerModel.calculatePlayerStrength(playerModel);
        return playerModel;
    }

    public static FreeAgentModel getFreeAgentModel(String playerName, String position, int age, float skating, float shooting, float checking, float saving) {
        FreeAgentModel freeAgentModel = new FreeAgentModel();
        freeAgentModel.setPlayerName(playerName);
        freeAgentModel.setPosition(position);
        freeAgentModel.setAge(age);
        freeAgentModel.setSkating(skating);
        freeAgentModel.setShooting(shooting);
        freeAgentModel.setChecking(checking);
        freeAgentModel.setSaving(saving);
        return freeAgentModel;
    }
}
