//
//package statemachine;
//
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//
//
//
//public class StateMachineTest {
//    @Test
//    void getImportJson(){
//        try {
//            StateMachine stateMachine = new StateMachine();
//            stateMachine.setImportJson(stateMachine.getImportJson());
//            stateMachine.setCurrentState(stateMachine.getImportJson());
//            assertNotNull(stateMachine.getCurrentState());
//        }
//        catch (Exception exception){
//            fail("State is not valid. Got an Exception");
//        }
//    }
//    @Test
//    void setImportJson(){
//        try {
//            StateMachine stateMachine = new StateMachine();
//            stateMachine.setImportJson(stateMachine.getImportJson());
//            stateMachine.setCurrentState(stateMachine.getImportJson());
//            assertNotNull(stateMachine.getCurrentState());
//        }
//        catch (Exception exception){
//            fail("State is not set. Got an Exception");
//        }
//    }
//    @Test
//    void getPlayerTeamChoice(){
//        try {
//            StateMachine stateMachine = new StateMachine();
//            stateMachine.setPlayerTeamChoice(stateMachine.getPlayerTeamChoice());
//            stateMachine.setCurrentState(stateMachine.getPlayerTeamChoice());
//            assertNotNull(stateMachine.getCurrentState());
//        }
//        catch (Exception exception){
//            fail("State is not valid. Got an Exception");
//        }
//    }
//    @Test
//    void setPlayerTeamChoice(){
//        try {
//            StateMachine stateMachine = new StateMachine();
//            stateMachine.setPlayerTeamChoice(stateMachine.getPlayerTeamChoice());
//            stateMachine.setCurrentState(stateMachine.getPlayerTeamChoice());
//            assertNotNull(stateMachine.getCurrentState());
//        }
//        catch (Exception exception){
//            fail("State is not set. Got an Exception");
//        }
//    }
//    @Test
//    void getPlayerSeasonsChoice(){
//        try {
//            StateMachine stateMachine = new StateMachine();
//            stateMachine.setPlayerSeasonsChoice(stateMachine.getPlayerSeasonsChoice());
//            stateMachine.setCurrentState(stateMachine.getPlayerSeasonsChoice());
//            assertNotNull(stateMachine.getCurrentState());
//        }
//        catch (Exception exception){
//            fail("State is not valid. Got an Exception");
//        }
//    }
//    @Test
//    void setPlayerSeasonsChoice(){
//        try {
//            StateMachine stateMachine = new StateMachine();
//            stateMachine.setPlayerSeasonsChoice(stateMachine.getPlayerSeasonsChoice());
//            stateMachine.setCurrentState(stateMachine.getPlayerSeasonsChoice());
//            assertNotNull(stateMachine.getCurrentState());
//        }
//        catch (Exception exception){
//            fail("State is not set. Got an Exception");
//        }
//    }
//    @Test
//    void getCreateTeam(){
//        try {
//            StateMachine stateMachine = new StateMachine();
//            stateMachine.setCreateTeam(stateMachine.getCreateTeam());
//            stateMachine.setCurrentState(stateMachine.getCreateTeam());
//            assertNotNull(stateMachine.getCurrentState());
//        }
//        catch (Exception exception){
//            fail("State is not valid. Got an Exception");
//        }
//    }
//    @Test
//    void setCreateTeam(){
//        try {
//            StateMachine stateMachine = new StateMachine();
//            stateMachine.setCreateTeam(stateMachine.getCreateTeam());
//            stateMachine.setCurrentState(stateMachine.getCreateTeam());
//            assertNotNull(stateMachine.getCurrentState());
//        }
//        catch (Exception exception){
//            fail("State is not set. Got an Exception");
//        }
//    }
//    @Test
//    void getLoadTeam(){
//        try {
//            StateMachine stateMachine = new StateMachine();
//            stateMachine.setCreateTeam(stateMachine.getLoadTeam());
//            stateMachine.setCurrentState(stateMachine.getLoadTeam());
//            assertNotNull(stateMachine.getCurrentState());
//        }
//        catch (Exception exception){
//            fail("State is not valid. Got an Exception");
//        }
//    }
//    @Test
//    void setLoadTeam(){
//        try {
//            StateMachine stateMachine = new StateMachine();
//            stateMachine.setLoadTeam(stateMachine.getLoadTeam());
//            stateMachine.setCurrentState(stateMachine.getLoadTeam());
//            assertNotNull(stateMachine.getCurrentState());
//        }
//        catch (Exception exception){
//            fail("State is not set. Got an Exception");
//        }
//    }
//    @Test
//    void getSimulate(){
//        try {
//            StateMachine stateMachine = new StateMachine();
//            stateMachine.setSimulate(stateMachine.getSimulate());
//            stateMachine.setCurrentState(stateMachine.getSimulate());
//            assertNotNull(stateMachine.getCurrentState());
//        }
//        catch (Exception exception){
//            fail("State is not valid. Got an Exception");
//        }
//    }
//    @Test
//    void setSimulate(){
//        try {
//            StateMachine stateMachine = new StateMachine();
//            stateMachine.setSimulate(stateMachine.getSimulate());
//            stateMachine.setCurrentState(stateMachine.getSimulate());
//            assertNotNull(stateMachine.getCurrentState());
//        }
//        catch (Exception exception){
//            fail("State is not set. Got an Exception");
//        }
//    }
//
//    @Test
//    void fileImported(){
//        try{
//            StateMachine stateMachine = new StateMachine();
//            assertEquals(stateMachine.fileImported(),stateMachine.getPlayerTeamChoice());
//        }
//        catch (Exception exception){
//            fail("Player team choice state not returned. Got an Exception");
//        }
//    }
//
//    @Test
//    void playerChoiceLoadTeam(){
//        try{
//            StateMachine stateMachine = new StateMachine();
//            assertEquals(stateMachine.playerChoiceLoadTeam(),stateMachine.getLoadTeam());
//        }
//        catch(Exception exception){
//            fail("Load team state not returned. Got an Exception");
//        }
//    }
//    //Change this to create team
//    @Test
//    void playerChoiceCreateTeam(){
//        try{
//            StateMachine stateMachine = new StateMachine();
//            assertEquals(stateMachine.playerChoiceCreateTeam(),stateMachine.getCreateTeam());
//        }
//        catch(Exception exception){
//            fail("Create team state not returned. Got an Exception");
//        }
//    }
//    @Test
//    void teamLoaded(){
//        try{
//            StateMachine stateMachine = new StateMachine();
//            assertEquals(stateMachine.teamLoaded(),stateMachine.getPlayerSeasonsChoice());
//        }
//        catch(Exception exception){
//            fail("Player Seasons choice state not returned. Got an Exception");
//        }
//    }
//
//    @Test
//    void newTeamCreated(){
//        try{
//            StateMachine stateMachine = new StateMachine();
//            assertEquals(stateMachine.newTeamCreated(),stateMachine.getPlayerSeasonsChoice());
//        }
//        catch(Exception exception){
//            fail("Player Seasons choice state not returned. Got an Exception");
//        }
//    }
//
//    @Test
//    void simulateSeasons(){
//        try{
//            StateMachine stateMachine = new StateMachine();
//            assertEquals(stateMachine.simulateSeasons(),stateMachine.getSimulate());
//        }
//        catch(Exception exception){
//            fail("Seasons simulate state not returned. Got an Exception");
//        }
//    }
//}
