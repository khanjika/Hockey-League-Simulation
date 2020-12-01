package statemachine.loadteam;

public class LoadTeamAbstractFactoryConcrete extends LoadTeamAbstractFactory{
    private ILoadTeam loadTeam;

    @Override
    public ILoadTeam createLoadTeam() {
        if (loadTeam == null){
            loadTeam = new LoadTeam();
        }
        return loadTeam;
    }

}
