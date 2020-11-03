package coach;

public interface ICoachPersistent {

    int storeCoachesInformation(String leagueId, String headCoachName, float skating, float shooting, float checking, float saving);
}
