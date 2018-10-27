
public class EntryWithSpace {

	public EntryWithSpace(Entry e, String space) {
		super();
		this.e = e;
		this.space = space;
	}
	public EntryWithSpace(Entry e) {
		super();
		this.e = e;
		this.space = "";
	}
	private Entry e;
	private String space;
	public Entry getE() {
		return e;
	}
	public void setE(Entry e) {
		this.e = e;
	}
	public String getSpace() {
		return space;
	}
	public void setSpace(String space) {
		this.space = space;
	}
	
}
