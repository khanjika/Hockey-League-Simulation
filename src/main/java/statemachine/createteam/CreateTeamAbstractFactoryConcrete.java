package statemachine.createteam;

public class CreateTeamAbstractFactoryConcrete extends CreateTeamAbstractFactory{

    private ICreateTeam createTeamCli;
    @Override
    public ICreateTeam createCreateTeam() {
        if (createTeamCli == null){
            createTeamCli = new CreateTeam();
        }
        return createTeamCli;
    }
}
