package statemachine;

public enum StateMachine {
    Import{
        @Override
        public void state(){
            System.out.println("import");
        }
    },
    Player_Choice{
        @Override
        public void state(){
            System.out.println("player_choice");
        }
    },
    Create_Team{
        @Override
        public void state(){
            System.out.println("create_team");
        }
    },
    Load_Team{
        @Override
        public void state(){
            System.out.println("load_team");
        }
    };
    State state;
    public abstract void state();
}
