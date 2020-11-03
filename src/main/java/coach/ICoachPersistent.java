package coach;

public interface ICoachPersistent {

    int storeCoachesInformation(int leagueId, String headCoachName, float skating, float shooting, float checking, float saving);
}
