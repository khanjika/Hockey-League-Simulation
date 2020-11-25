package statemachine.loadteam;

public abstract class LoadTeamAbstractFactory {

    private static LoadTeamAbstractFactory unique_instance = null;

    public static LoadTeamAbstractFactory getInstance() {
        if(unique_instance == null){
            unique_instance = new LoadTeamAbstractFactoryConcrete();
        }
        return unique_instance;
    }

    public abstract ILoadTeam getLoadTeam();
    public abstract void setLoadTeam(ILoadTeam loadTeam);
}
