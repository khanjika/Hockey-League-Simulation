package coach;

public interface ICoachPersistent {

    int storeCoachesInformation(int leagueId, int headCoachName, float skating, float shooting, float checking, float saving);
}
