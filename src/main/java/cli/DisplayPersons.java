package cli;

import coach.CoachModel;
import freeagent.FreeAgentModel;
import players.PlayerModel;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DisplayPersons {

    public void displayTeamPlayers(List<PlayerModel> players){
        Map<Integer, Integer> columnLength = new HashMap<Integer, Integer>();
        StringBuilder format = new StringBuilder();
        String header[] = {"Number", "Name", "Position",
                "Age", "Checking", "Skating", "Shooting", "Saving"};

        IntStream.range(0, header.length).forEach(a -> {
            if (columnLength.get(a) == null) {
                columnLength.put(a, header[a].length());
            }
        });
        IntStream.range(0, players.size()).forEach(a -> {
            String name = players.get(a).getPlayerName();
            if (columnLength.get(1) < name.length()) {
                columnLength.put(1, name.length());
            }
        });
        String line = columnLength.entrySet().stream().reduce("", (ln, b) -> {
            String templn = "+-";
            templn = templn + Stream.iterate(0, i -> i +1).limit(b.getValue()).reduce("", (ln1, b1) -> ln1 + "-",
                    (a1, b1) -> a1 + b1);
            templn = templn + "-";
            return ln + templn;
        }, (a, b) -> a + b);
        columnLength.entrySet().stream().forEach(e -> format.append("| %" + "" + e.getValue() + "s "));
        format.append("|\n");
        System.out.println(line);
        System.out.printf(format.toString(), header[0], header[1], header[2], header[3], header[4], header[5]
                , header[6], header[7]);
        System.out.println(line);
        IntStream.range(0, players.size()).forEach(index -> {
            System.out.printf(format.toString(),
                    index + 1, players.get(index).getPlayerName(), players.get(index).getPosition(),
                    players.get(index).getAge(), players.get(index).getChecking(),
                    players.get(index).getSkating(), players.get(index).getShooting(),
                    players.get(index).getSaving());
        });
        line = line + "+\n";
        System.out.println(line);
    }



    public void displayCoaches(List<CoachModel> coaches){
        Map<Integer, Integer> columnLength = new HashMap<Integer, Integer>();
        StringBuilder format = new StringBuilder();
        String header[] = {"Number", "Name", "Checking", "Skating", "Shooting", "Saving"};
        IntStream.range(0, header.length).forEach(a -> {
            if (columnLength.get(a) == null) {
                columnLength.put(a, header[a].length());
            }
        });
        IntStream.range(0, coaches.size()).forEach(a -> {
            String name = coaches.get(a).getName();
            if (columnLength.get(1) < name.length()) {
                columnLength.put(1, name.length());
            }
        });
        String line = columnLength.entrySet().stream().reduce("", (ln, b) -> {
            String templn = "+-";
            templn = templn + Stream.iterate(0, i -> i +1).limit(b.getValue()).reduce("", (ln1, b1) -> ln1 + "-",
                    (a1, b1) -> a1 + b1);
            templn = templn + "-";
            return ln + templn;
        }, (a, b) -> a + b);
        columnLength.entrySet().stream().forEach(e -> format.append("| %" + "" + e.getValue() + "s "));
        format.append("|\n");
        System.out.println(line);
        System.out.printf(format.toString(), header[0], header[1], header[2], header[3], header[4], header[5]);
        System.out.println(line);
        IntStream.range(0, coaches.size()).forEach(index -> {
            System.out.printf(format.toString(),
                    index + 1, coaches.get(index).getName(), coaches.get(index).getChecking(),
                    coaches.get(index).getSkating(), coaches.get(index).getShooting(),
                    coaches.get(index).getSaving());
        });
        line = line + "+\n";
        System.out.println(line);
    }

    public void displayManagers(List<String> generalManagers){
        Map<Integer, Integer> columnLength = new HashMap<Integer, Integer>();
        StringBuilder format = new StringBuilder();
        String header[] = {"Number", "Name"};
        IntStream.range(0, header.length).forEach(a -> {
            if (columnLength.get(a) == null) {
                columnLength.put(a, header[a].length());
            }
        });
        IntStream.range(0, generalManagers.size()).forEach(a -> {
            String name = generalManagers.get(a);
            if (columnLength.get(1) < name.length()) {
                columnLength.put(1, name.length());
            }
        });
        String line = columnLength.entrySet().stream().reduce("", (ln, b) -> {
            String templn = "+-";
            templn = templn + Stream.iterate(0, i -> i +1).limit(b.getValue()).reduce("", (ln1, b1) -> ln1 + "-",
                    (a1, b1) -> a1 + b1);
            templn = templn + "-";
            return ln + templn;
        }, (a, b) -> a + b);
        columnLength.entrySet().stream().forEach(e -> format.append("| %" + "" + e.getValue() + "s "));
        format.append("|\n");
        System.out.println(line);
        System.out.printf(format.toString(), header[0], header[1]);
        System.out.println(line);
        IntStream.range(0, generalManagers.size()).forEach(index -> {
            System.out.printf(format.toString(),
                    index + 1, generalManagers.get(index));
        });
        line = line + "+\n";
        System.out.println(line);
    }
    public void displayPlayers(List<FreeAgentModel> freeAgentModel) {

        Map<Integer, Integer> columnLength = new HashMap<Integer, Integer>();
        StringBuilder format = new StringBuilder();
        String header[] = {"Number", "Name", "Position",
                "Age", "Checking", "Skating", "Shooting", "Saving"};

        IntStream.range(0, header.length).forEach(a -> {
            if (columnLength.get(a) == null) {
                columnLength.put(a, header[a].length());
            }
        });
        IntStream.range(0, freeAgentModel.size()).forEach(a -> {
            String name = freeAgentModel.get(a).getPlayerName();
            if (columnLength.get(1) < name.length()) {
                columnLength.put(1, name.length());
            }
        });
        String line = columnLength.entrySet().stream().reduce("", (ln, b) -> {
            String templn = "+-";
            templn = templn + Stream.iterate(0, i -> i +1).limit(b.getValue()).reduce("", (ln1, b1) -> ln1 + "-",
                    (a1, b1) -> a1 + b1);
            templn = templn + "-";
            return ln + templn;
        }, (a, b) -> a + b);
        columnLength.entrySet().stream().forEach(e -> format.append("| %" + "" + e.getValue() + "s "));
        format.append("|\n");
        System.out.println(line);
        System.out.printf(format.toString(), header[0], header[1], header[2], header[3], header[4], header[5]
                , header[6], header[7]);
        System.out.println(line);
        IntStream.range(0, freeAgentModel.size()).forEach(index -> {
            System.out.printf(format.toString(),
                    index + 1, freeAgentModel.get(index).getPlayerName(), freeAgentModel.get(index).getPosition(),
                    freeAgentModel.get(index).getAge(), freeAgentModel.get(index).getChecking(),
                    freeAgentModel.get(index).getSkating(), freeAgentModel.get(index).getShooting(),
                    freeAgentModel.get(index).getSaving());
        });
        line = line + "+\n";
        System.out.println(line);
    }
}