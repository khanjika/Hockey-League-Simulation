package statemachine.states.playerdraft;

import leagueobjectmodel.*;

import java.time.LocalDate;
import java.util.*;

public class PlayerDraft implements IPlayerDraft {

    Random random = new Random();
    private String[] PLAYER_FIRST_NAMES = {"Zankrut", "Roshan", "Khanjika", "Arthy", "Mozhgan", "Akshay", "Dhruvesh", "Shivang", "Panth", "Ronaldo"};
    private String[] PlAYER_LAST_NAMES = {"Thakkar", "Patel", "Arora", "Umapathy", "Saeidi", "Hawkey", "Sampali", "Desai"};
    private int[] PLAYER_AGES = {18, 19, 20, 21};
    private int[] STAT_RANGE_ONE = {12, 13, 14, 15, 16, 17, 18, 19, 20};
    private int[] STAT_RANGE_TWO = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
    private int[] STAT_RANGE_THREE = {8, 9, 10, 11, 12, 13, 14, 15};
    private int[] STAT_RANGE_FOUR = {9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
    private int[] STAT_RANGE_FIVE = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private int[] STAT_RANGE_SIX = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    private int[] STAT_RANGE_SEVEN = {1, 2, 3, 4, 5, 6, 7};
    private int NO_OF_DRAFTS = 7;
    private int NO_OF_TEAMS = 6;
    private float PER_OF_FORWARD_PLAYERS = 0.5F;
    private float PER_OF_DEFENSE_PLAYERS = 0.4F;
    private float PER_OF_GOALIE_PLAYERS = 0.1F;
    private boolean captain = false;
    List<IPlayerModel> draftedPlayers = new ArrayList<>();
    List<ITeamsModel> teamList = new ArrayList<>();


    public String generatePlayerName() {
        String playerName = null;
        int value = random.nextInt(PLAYER_FIRST_NAMES.length);
        playerName = PLAYER_FIRST_NAMES[value];
        value = random.nextInt(PlAYER_LAST_NAMES.length);
        playerName = playerName + " " + PlAYER_LAST_NAMES[value];
        return playerName;
    }

    public int generatePlayerAge() {
        int playerAge = 0;
        int value = random.nextInt(PLAYER_AGES.length);
        playerAge = PLAYER_AGES[value];
        return playerAge;
    }


    public int generatePlayerBirthYear(int playerAge) {
        int playerBirthYear = 0;
        playerBirthYear = LocalDate.now().getYear() - playerAge;
        return playerBirthYear;
    }

    public int generatePlayerBirthMonth() {
        int playerBirthMonth = 0;
        playerBirthMonth = random.nextInt(12);
        return playerBirthMonth;
    }

    public int generatePlayerBirthDay(int month) {
        int playerBirthDay = 0;
        if (month == Month.February.ordinal()) {
            playerBirthDay = random.nextInt(28);
        } else if (month == Month.January.ordinal() || month == Month.March.ordinal() || month == Month.May.ordinal() ||
                month == Month.July.ordinal() || month == Month.August.ordinal() || month == Month.October.ordinal() || month == Month.December.ordinal()) {
            playerBirthDay = random.nextInt(31);
        } else {
            playerBirthDay = random.nextInt(30);
        }
        return playerBirthDay;
    }

    public int generatePlayerSkatingStat(String position) {
        int skating = 0;
        int value = 0;
        if (position.equals(PlayerPosition.FORWARD.toString())) {
            value = random.nextInt(STAT_RANGE_ONE.length);
            skating = STAT_RANGE_ONE[value];
        } else if (position.equals(PlayerPosition.DEFENSE.toString())) {
            value = random.nextInt(STAT_RANGE_TWO.length);
            skating = STAT_RANGE_TWO[value];
        } else if (position.equals(PlayerPosition.GOALIE.toString())) {
            value = random.nextInt(STAT_RANGE_THREE.length);
            skating = STAT_RANGE_THREE[value];
        }
        return skating;
    }

    public int generatePlayerShootingStat(String position) {
        int shooting = 0;
        int value = 0;
        if (position.equals(PlayerPosition.FORWARD.toString())) {
            value = random.nextInt(STAT_RANGE_ONE.length);
            shooting = STAT_RANGE_ONE[value];
        } else if (position.equals(PlayerPosition.DEFENSE.toString())) {
            value = random.nextInt(STAT_RANGE_FOUR.length);
            shooting = STAT_RANGE_FOUR[value];
        } else if (position.equals(PlayerPosition.GOALIE.toString())) {
            value = random.nextInt(STAT_RANGE_FIVE.length);
            shooting = STAT_RANGE_FIVE[value];
        }
        return shooting;
    }

    public int generatePlayerCheckingStat(String position) {
        int checking=0;
        int value=0;
        if (position.equals(PlayerPosition.FORWARD.toString())) {
            value = random.nextInt(STAT_RANGE_FOUR.length);
            checking = STAT_RANGE_FOUR[value];
        } else if (position.equals(PlayerPosition.DEFENSE.toString())) {
            value = random.nextInt(STAT_RANGE_ONE.length);
            checking = STAT_RANGE_ONE[value];
        } else if (position.equals(PlayerPosition.GOALIE.toString())) {
            value = random.nextInt(STAT_RANGE_SIX.length);
            checking = STAT_RANGE_SIX[value];
        }
        return checking;
    }

    public int generatePlayerSavingStat(String position) {
        int checking = 0;
        int value = 0;
        if (position.equals(PlayerPosition.FORWARD.toString())) {
            value = random.nextInt(STAT_RANGE_SEVEN.length);
            checking = STAT_RANGE_SEVEN[value];
        } else if (position.equals(PlayerPosition.DEFENSE.toString())) {
            value = random.nextInt(STAT_RANGE_SIX.length);
            checking = STAT_RANGE_SIX[value];
        } else if (position.equals(PlayerPosition.GOALIE.toString())) {
            value = random.nextInt(STAT_RANGE_ONE.length);
            checking = STAT_RANGE_ONE[value];
        }
        return checking;
    }

    public List<IPlayerModel> draftPlayers() {
        int totalNumberOfPlayers = NO_OF_TEAMS * NO_OF_DRAFTS;
        int totalForwardPlayers = Math.round(totalNumberOfPlayers * PER_OF_FORWARD_PLAYERS);
        int totalDefensePlayers = Math.round(totalNumberOfPlayers * PER_OF_DEFENSE_PLAYERS);
        int totalGoaliePlayers = Math.round(totalNumberOfPlayers * PER_OF_GOALIE_PLAYERS);
        List<IPlayerModel> forwardPlayers = draftForwardPlayers(totalForwardPlayers);
        List<IPlayerModel> defensePlayers = draftDefensePlayers(totalDefensePlayers);
        List<IPlayerModel> goaliePlayers = draftGoaliePlayer(totalGoaliePlayers);
        draftedPlayers.addAll(forwardPlayers);
        draftedPlayers.addAll(defensePlayers);
        draftedPlayers.addAll(goaliePlayers);
        return draftedPlayers;
    }

    private List<IPlayerModel> draftGoaliePlayer(int totalGoaliePlayers) {
        List<IPlayerModel> goaliePlayerList = new ArrayList<>();
        for (int i = 0; i < totalGoaliePlayers; i++) {
            IPlayerModel player = LeagueObjectModelAbstractFactory.getInstance().getNewPlayerModel();
            int playerAge = generatePlayerAge();
            int playerBirthYear = generatePlayerBirthYear(playerAge);
            int playerBirthMonth = generatePlayerBirthMonth();
            int playerBirthDay = generatePlayerBirthDay(playerBirthMonth);
            player.setPlayerName(generatePlayerName());
            player.setPosition(PlayerPosition.GOALIE.toString());
            player.setSkating(generatePlayerSkatingStat(PlayerPosition.GOALIE.toString()));
            player.setShooting(generatePlayerShootingStat(PlayerPosition.GOALIE.toString()));
            player.setChecking(generatePlayerCheckingStat(PlayerPosition.GOALIE.toString()));
            player.setSaving(generatePlayerSavingStat(PlayerPosition.GOALIE.toString()));
            player.setCaptain(captain);
            player.setAge(playerAge);
            player.setBirthYear(playerBirthYear);
            player.setBirthMonth(playerBirthMonth);
            player.setBirthDay(playerBirthDay);
            goaliePlayerList.add(player);
        }
        return goaliePlayerList;
    }

    private List<IPlayerModel> draftDefensePlayers(int totalDefensePlayers) {
        List<IPlayerModel> defensePlayerList = new ArrayList<>();
        for (int i = 0; i < totalDefensePlayers; i++) {
            IPlayerModel player = LeagueObjectModelAbstractFactory.getInstance().getNewPlayerModel();
            int playerAge = generatePlayerAge();
            int playerBirthYear = generatePlayerBirthYear(playerAge);
            int playerBirthMonth = generatePlayerBirthMonth();
            int playerBirthDay = generatePlayerBirthDay(playerBirthMonth);
            player.setPlayerName(generatePlayerName());
            player.setPosition(PlayerPosition.DEFENSE.toString());
            player.setSkating(generatePlayerSkatingStat(PlayerPosition.DEFENSE.toString()));
            player.setShooting(generatePlayerShootingStat(PlayerPosition.DEFENSE.toString()));
            player.setChecking(generatePlayerCheckingStat(PlayerPosition.DEFENSE.toString()));
            player.setSaving(generatePlayerSavingStat(PlayerPosition.DEFENSE.toString()));
            player.setCaptain(captain);
            player.setAge(playerAge);
            player.setBirthYear(playerBirthYear);
            player.setBirthMonth(playerBirthMonth);
            player.setBirthDay(playerBirthDay);
            defensePlayerList.add(player);
        }
        return defensePlayerList;
    }

    private List<IPlayerModel> draftForwardPlayers(int totalForwardPlayers) {
        List<IPlayerModel> forwardPlayerList = new ArrayList<>();
        for (int i = 0; i < totalForwardPlayers; i++) {
            IPlayerModel player = LeagueObjectModelAbstractFactory.getInstance().getNewPlayerModel();
            int playerAge = generatePlayerAge();
            int playerBirthYear = generatePlayerBirthYear(playerAge);
            int playerBirthMonth = generatePlayerBirthMonth();
            int playerBirthDay = generatePlayerBirthDay(playerBirthMonth);
            player.setPlayerName(generatePlayerName());
            player.setPosition(PlayerPosition.FORWARD.toString());
            player.setSkating(generatePlayerSkatingStat(PlayerPosition.FORWARD.toString()));
            player.setShooting(generatePlayerShootingStat(PlayerPosition.FORWARD.toString()));
            player.setChecking(generatePlayerCheckingStat(PlayerPosition.FORWARD.toString()));
            player.setSaving(generatePlayerSavingStat(PlayerPosition.FORWARD.toString()));
            player.setCaptain(captain);
            player.setAge(playerAge);
            player.setBirthYear(playerBirthYear);
            player.setBirthMonth(playerBirthMonth);
            player.setBirthDay(playerBirthDay);
            forwardPlayerList.add(player);
        }
        return forwardPlayerList;
    }

    public void getTeamStandingList(ILeagueModel leagueModel){
        System.out.println("Inside Team Standing List method");
        for(IConferenceModel conferenceModel : leagueModel.getConferences()){
            for(IDivisonModel divisonModel : conferenceModel.getDivisions()){
                List<TeamsModel> teams = divisonModel.getTeams();
                Collections.sort(teams,teamModelComparator);
                for(int i=0;i<teams.size();i++){
                   // System.out.println("Team Name"+teams.get(i).getTeamName()+" Win Point "+teams.get(i).getWinPoint());
                    teamList.add(teams.get(i));
                }
                for(int i = 0; i<teamList.size();i++){
                    System.out.println("Team Name: "+teamList.get(i).getTeamName()+" Win Point "+teamList.get(i).getWinPoint());
                }
            }
        }
    }

    public static Comparator<TeamsModel> teamModelComparator = new Comparator<TeamsModel>() {
        @Override
        public int compare(TeamsModel o1, TeamsModel o2) {
            int teamOneWinPoint = o1.getWinPoint();
            int teamTwoWinPoint = o2.getWinPoint();
            return teamTwoWinPoint - teamOneWinPoint;
        }
    };


}