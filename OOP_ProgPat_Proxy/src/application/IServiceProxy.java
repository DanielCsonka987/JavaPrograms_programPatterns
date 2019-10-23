package application;

public interface IServiceProxy {

	void addClothesSize(String size);
	void addClothesColor(String color);
	void addClothesAmount(Integer amount);
	
	String showCollectedDatas();
	
	void proxySaveOrderingContet();
	void proxyRemoveOrderingContent(Integer id);
}
