import java.util.Date;

public class File extends Entry {
	
	public File(String name, Date date, int size) {
		super(name, date);
		this.size = size;
	}

	private int size;

}
