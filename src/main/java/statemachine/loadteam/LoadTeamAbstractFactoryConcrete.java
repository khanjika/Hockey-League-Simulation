package statemachine.loadteam;

public class LoadTeamAbstractFactoryConcrete extends LoadTeamAbstractFactory{
    private ILoadTeam loadTeam;

    @Override
    public ILoadTeam getLoadTeam() {
        if (loadTeam == null){
            loadTeam = new LoadTeam();
        }
        return loadTeam;
    }

}
