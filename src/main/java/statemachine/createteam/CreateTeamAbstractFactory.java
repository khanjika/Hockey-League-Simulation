package statemachine.createteam;

public abstract class CreateTeamAbstractFactory {
    private static CreateTeamAbstractFactory unique_instance = null;

    public static CreateTeamAbstractFactory getInstance() {
        if(unique_instance == null){
            unique_instance = new CreateTeamAbstractFactoryConcrete();
        }
        return unique_instance;
    }

    public abstract ICreateTeam getCreateTeam();
}
