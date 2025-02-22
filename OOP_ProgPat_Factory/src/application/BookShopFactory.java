package application;

public class BookShopFactory {

	private Integer id = 0;
	
	public IVolume setTheNewVolume(String[] datas, Integer date, VolumeChategories typeVol){
		id++;
		if(typeVol == VolumeChategories.BOOK){
			return new VolumeBook(id, datas[0], date);
		}else if (typeVol == VolumeChategories.COMIC){
			return new VolumeComic(id, datas[0], date, datas[1]);
		}
		return null;
	}
	
	public enum VolumeChategories{ BOOK, COMIC }
}
