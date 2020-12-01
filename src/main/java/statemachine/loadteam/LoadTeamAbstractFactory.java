package statemachine.loadteam;

public abstract class LoadTeamAbstractFactory {

    private static LoadTeamAbstractFactory unique_instance = null;

    public static LoadTeamAbstractFactory instance() {
        if(unique_instance == null){
            unique_instance = new LoadTeamAbstractFactoryConcrete();
        }
        return unique_instance;
    }

    public abstract ILoadTeam createLoadTeam();
}
