package application;

public class VolumeComic implements IVolume{
	private Integer id;
	private String title;
	private Integer date;
	private String universe;
	
	public VolumeComic(Integer id, String title, Integer date, String universe) {
		super();
		this.id = id;
		this.title = title;
		this.date = date;
		this.universe = universe;
	}

	@Override
	public String toString() {
		return "Comic [id=" + id + ", title=" + title + ", date=" + date + ", universe=" + universe + "]";
	}
	
	
	
}
