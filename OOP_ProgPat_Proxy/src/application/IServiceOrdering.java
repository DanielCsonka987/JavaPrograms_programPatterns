package application;

public interface IServiceOrdering {

	void saveDataOfClothesOrdering(Integer orderingId, String clothesName,
			String clothesSize, String clothesColor, Integer amount);

}
