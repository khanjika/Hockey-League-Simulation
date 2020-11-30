package statemachine.states.playerdraft;

public class PlayerDraftAbstractFactoryConcrete extends PlayerDraftAbstractFactory{
    private IPlayerDraft playerDraft;
    private IDraftSelectionOrder draftSelectionOrder;

    @Override
    public IPlayerDraft createPlayerDraft() {
        if(playerDraft == null){
            playerDraft = new PlayerDraft();
        }
        return playerDraft;
    }

    @Override
    public void setPlayerDraft(IPlayerDraft playerDraft) {
        this.playerDraft = playerDraft;
    }

    @Override
    public IDraftSelectionOrder createDraftSelectionOrder() {
        if(draftSelectionOrder == null ){
            draftSelectionOrder = new DraftSelectionOrder();
        }
        return draftSelectionOrder;
    }

    @Override
    public void setDraftSelectionOrder(IDraftSelectionOrder draftSelectionOrder) {
        this.draftSelectionOrder = draftSelectionOrder;
    }
}
