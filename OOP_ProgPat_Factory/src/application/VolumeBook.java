package application;

public class VolumeBook implements IVolume{
	private Integer id;
	private String title;
	private Integer date;
	
	
	
	public VolumeBook(Integer id, String title, Integer date) {
		super();
		this.id = id;
		this.title = title;
		this.date = date;
	}



	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + title + ", date=" + date + "]";
	}
	
}
