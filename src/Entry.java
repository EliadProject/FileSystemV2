import java.util.ArrayList;
import java.util.Date;
import java.util.Stack;

public abstract class Entry {

	public Entry(String name, Date date) {
		super();
		this.name = name;
		this.date = date;
	}

	
	protected String name;
	protected Date date;
	
	public static void printFileSystem(Stack<EntryWithSpace> s)
	{
		if(s.isEmpty())
			return;
		EntryWithSpace entryws = s.pop();
		Entry entry = entryws.getE();
		String space = entryws.getSpace();
		if (entry instanceof File)
		{
			System.out.println(space + entry.name );
			
		}
		else if (entry instanceof Directory) {
		    // Guaranteed to succeed, barring classloader shenanigans
			Directory dir = (Directory) entry;
			System.out.println(space + entry.name + ":");
			
			StringBuilder strBuilder = new StringBuilder(space);
			space = strBuilder.append("\t").toString();
			
			for(Entry cont : dir.getContents())
			{
				s.push(new EntryWithSpace(cont,space));
			}
			
		}
		printFileSystem(s);
	}
	
	public static boolean addEntry(Stack<Entry> s, Entry newEntry, String parentDirName)
	{
		if(s.isEmpty())
			return false;
		Entry entry = s.pop();
		
		if (entry instanceof Directory) {
		    // Guaranteed to succeed, barring classloader shenanigans
			Directory dic = (Directory) entry;
			if(entry.name.equals(parentDirName))
			{
				dic.addEntry(newEntry);
				return true;
			}
			else
			{
				for(Entry cont : dic.getContents())
				{
					s.push(cont);
				}
			}
			
		}
		return addEntry(s,newEntry,parentDirName);
	}
	
	public static boolean delete(Stack<Entry> s, String entryName) {
		if(s.isEmpty())
			return false;
		Entry entry = s.pop();
		
		if (entry instanceof Directory) {
		    // Guaranteed to succeed, barring classloader shenanigans
			Directory dir = (Directory) entry;
			if(entry.name.equals(entryName))
			{
				//delets from dir
				dir.deleteEntry(dir);
				return true;
			}
			else
			{
				for(Entry cont : dir.getContents())
				{
					s.push(cont);
				}
			}
			
		}
		return delete(s,entryName);
	}
	
	public static boolean checkUnique(Stack<Entry> s, String entryName)
	{
		if(s.isEmpty())
			return true;
		Entry entry = s.pop();
		
		if(entry.name.equals(entryName))
			return false;
		
		if (entry instanceof Directory) {
		    // Guaranteed to succeed, barring classloader shenanigans
			Directory dir = (Directory) entry;
			for(Entry cont : dir.getContents())
			{
				s.push(cont);
			}
		}
		return checkUnique(s, entryName);
	}
	
}
