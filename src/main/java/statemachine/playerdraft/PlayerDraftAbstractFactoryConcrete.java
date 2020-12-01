package statemachine.playerdraft;

import org.apache.log4j.Logger;

public class PlayerDraftAbstractFactoryConcrete extends PlayerDraftAbstractFactory{
    private IPlayerDraft playerDraft;
    private IDraftSelectionOrder draftSelectionOrder;
    final static Logger logger = Logger.getLogger(PlayerDraftAbstractFactory.class);
    @Override
    public IPlayerDraft createPlayerDraft() {
        if(playerDraft == null){
            logger.info("Object created for player draft");
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
            logger.info("Object created for draftSelectionOrder");
            draftSelectionOrder = new DraftSelectionOrder();
        }
        return draftSelectionOrder;
    }

    @Override
    public void setDraftSelectionOrder(IDraftSelectionOrder draftSelectionOrder) {
        this.draftSelectionOrder = draftSelectionOrder;
    }
}
