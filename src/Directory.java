import java.util.ArrayList;
import java.util.Date;

public class Directory extends Entry{

	private ArrayList<Entry> contents;
	public Directory(String name, Date date) {
		super(name, date);
		this.contents = new ArrayList<>();
	}
	

	public ArrayList<Entry> getContents() {
		return contents;
	}

	public void setContents(ArrayList<Entry> contents) {
		this.contents = contents;
	}
	public void addEntry(Entry e)
	{
		this.contents.add(e);
	}
	public void deleteEntry(Entry e)
	{
		this.contents.remove(e);
	}
	
}
