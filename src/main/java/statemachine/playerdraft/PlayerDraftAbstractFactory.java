package statemachine.playerdraft;

public abstract class PlayerDraftAbstractFactory {
    public static PlayerDraftAbstractFactory unique_instance = null;

    public static PlayerDraftAbstractFactory getInstance() {
        if (unique_instance == null) {
            unique_instance = new PlayerDraftAbstractFactoryConcrete();
        }
        return unique_instance;
    }

    public abstract IPlayerDraft createPlayerDraft();

    public abstract void setPlayerDraft(IPlayerDraft playerDraft);

    public abstract IDraftSelectionOrder createDraftSelectionOrder();

    public abstract void setDraftSelectionOrder(IDraftSelectionOrder draftSelectionOrder);
}
