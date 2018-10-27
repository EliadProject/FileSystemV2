import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Stack;

public class main {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create root dir
				
				Directory parentDir = new Directory("root", new Date());
				Stack<Entry> s;
				Stack<EntryWithSpace> sws;
			

				// create the Scanner
				Scanner sc = new Scanner(System.in);

				int pressed, fileSize;
				String parentDirName, dirName,  fileName, entryName;

				System.out.println(
						"Hello , Bellow You Will See The Instruction To The File System \n 0 - Exit \n 1 - Show File System \n 2 - Add Dir \n 3 - Add File \n 4 - Delete Object");

				pressed = sc.nextInt();
				while (pressed != 0) {
					s = new Stack<Entry>();
					s.push(parentDir);
					switch (pressed) {

					//print fs
					case 1:
						sws= new Stack<EntryWithSpace>();
						sws.push(new EntryWithSpace(parentDir, ""));
						Entry.printFileSystem(sws);
						break;

					//add dir
					case 2:
						
						System.out.println("Insert DirName");
						dirName = sc.next();
						//if the name is already taken or too long, try again
						while(dirName.length()>32 || !Entry.checkUnique(s, dirName) )
						{
							if (dirName.length()>=32)
							{
								System.out.println("The name is too long, try again please");
								dirName = sc.next();
							}
							else
							{
								System.out.println("The name is already taken, try again please");
								dirName = sc.next();
							}
							s.push(parentDir);
						}
						s.push(parentDir);
						Directory dir = new Directory(dirName, new Date());
					
						System.out.println("Insert parentDirName");
						parentDirName = sc.next();
						while(!Entry.addEntry(s, dir, parentDirName))
						{
							//keep trying parent dir
							System.out.println("Insert parentDirName");
							parentDirName = sc.next();
							s.push(parentDir);
						}
						break;

					//add file to folder
					case 3:
						
						
						

						System.out.println("Insert fileName");
						fileName = sc.next();
						
						//if the name is already taken, try again
						while(!Entry.checkUnique(s, fileName) || fileName.length()>=32)
						{
							if (fileName.length()>=32)
							{
								System.out.println("The name is too long, try again please");
								fileName = sc.next();
							}
							else
							{
								System.out.println("The name is already taken, try again please");
								fileName = sc.next();
							}
							s.push(parentDir);
						}
						s.push(parentDir);
						  System.out.println("Insert fileSize"); 
						  fileSize = sc.nextInt();
						  File file = new File(fileName,new Date(),fileSize);
						 
						  System.out.println("Insert parentDirName");
							parentDirName = sc.next();
						while(!Entry.addEntry(s,file , parentDirName)) {
							//keep trying parent dir
							System.out.println("Insert parentDirName");
							parentDirName = sc.next();
							s.push(parentDir);
						}
						break;
						
					//delete object
					case 4:
						System.out.println("Insert entryName");
						entryName = sc.next();
						if (!(Entry.delete(s, entryName)))
						{
							System.out.println("Entry was not found");
						}
						

					default:
						break;
					}

					System.out.println(
							"Hello Spotnist, Bellow You Will See The Instruction To The File System \n 0 - Exit \n 1 - Show File System \n 2 - Add Dir \n 3 - Add File \n 4 - Delete Object");
					pressed = sc.nextInt();

				}
				sc.close();
				System.out.println("Hope you enjoyed :)");
			}
	
	
}
