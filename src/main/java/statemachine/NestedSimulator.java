package statemachine;

public class NestedSimulator {
    Integer seasons;

    public NestedSimulator(){}

    public NestedSimulator(Integer seasons) {
        this.seasons = seasons;
        PrintSeasons();
    }

    public Integer getSeasons() {
        return seasons;
    }

    public void setSeasons(Integer seasons) {
        this.seasons = seasons;
    }

    public void PrintSeasons(){
        for (int season = 1; season <= getSeasons(); season++){
            System.out.println("Season"+season);
        }
    }
}
