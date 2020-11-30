package statemachine.createteam;

public abstract class CreateTeamAbstractFactory {
    private static CreateTeamAbstractFactory unique_instance = null;

    public static CreateTeamAbstractFactory instance() {
        if(unique_instance == null){
            unique_instance = new CreateTeamAbstractFactoryConcrete();
        }
        return unique_instance;
    }

    public abstract ICreateTeam createCreateTeam();
}
