package statemachine.createteam;

public class CreateTeamAbstractFactoryConcrete extends CreateTeamAbstractFactory{

    private ICreateTeam createTeamCli;
    @Override
    public ICreateTeam getCreateTeam() {
        if (createTeamCli == null){
            createTeamCli = new CreateTeam();
        }
        return createTeamCli;
    }
}
