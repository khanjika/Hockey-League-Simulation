package statemachine;
//main class to call first

public class StateMachineSimulator {
    private final StateMachine stateMachine;

    public StateMachineSimulator(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }
    StateMachine state;
    public void stimulate(){
        switch (stateMachine){
            case Import:
                state = StateMachine.Import;
                state.state();
                break;
            case Player_Choice:
                state = StateMachine.Player_Choice;
                state.state();
                break;
            case Create_Team:
                state = StateMachine.Create_Team;
                state.state();
                break;
            case Load_Team:
                state = StateMachine.Load_Team;
                state.state();
                break;
        }
    }
}
