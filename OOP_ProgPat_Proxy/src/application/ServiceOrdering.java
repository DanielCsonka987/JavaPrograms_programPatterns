package application;

public class ServiceOrdering implements IServiceOrdering{

	@Override
	public void saveDataOfClothesOrdering(Integer orderingId, String clothesName,
			String clothesSize, String clothesColor, Integer amount) {
		OrderingDatas newOrd = new OrderingDatas(
				orderingId, clothesName, clothesSize,
				clothesColor, amount );
		DataBaseLikeClass.saveNewOrdering(newOrd);
	}

}
