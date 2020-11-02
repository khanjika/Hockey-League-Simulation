package gameplayconfig;

public interface IInjuriesPersistent {

int storeInjuriesInformation(float randomInjuryChance,int injuryDaysLow,int injuryDaysHigh);
InjuriesModel getInjuriesInformation(int gamePlayConfigId);
}
