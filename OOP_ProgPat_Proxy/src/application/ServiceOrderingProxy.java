package application;

public class ServiceOrderingProxy implements IServiceOrdering, IServiceProxy{

	private Integer ordId;
	private String clothesName;
	private String clothesSize;
	private String clothesColor;
	private Integer clothesAmount;

	public ServiceOrderingProxy(Integer ordId, String clothesName) {
		super();
		this.ordId = ordId;
		this.clothesName = clothesName;
	}

	@Override
	public void saveDataOfClothesOrdering(Integer orderingId, String clothesName,
			String clothesSize, String clothesColor, Integer amount) {
		ServiceOrdering ord = new ServiceOrdering();
		ord.saveDataOfClothesOrdering(orderingId, clothesName, clothesSize,
				clothesColor, amount);
	}

	@Override
	public void addClothesSize(String size) {
		this.clothesSize = size;
	}

	@Override
	public void addClothesColor(String color) {
		this.clothesColor = color;
	}

	@Override
	public void addClothesAmount(Integer amount) {
		this.clothesAmount = amount;
	}

	@Override
	public void proxyRemoveOrderingContent(Integer id) {
		if(id == this.ordId){
			try {
				this.finalize();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void proxySaveOrderingContet() {
		saveDataOfClothesOrdering(this.ordId, this.clothesName,
				this.clothesSize, this.clothesColor, this.clothesAmount);
	}

	@Override
	public String showCollectedDatas() {
		if(clothesSize == null)
			clothesSize = "";
		if(clothesColor == null)
			clothesColor = "";
		return "ID: "+ ordId + "; Name: " + clothesName + "; Size: " + clothesSize + 
				"; Color: " + clothesColor + "; Amount: " + clothesAmount;
	}


}
