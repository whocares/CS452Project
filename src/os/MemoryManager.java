package os;

import java.io.*;
import java.util.ArrayList;

public class MemoryManager {

	public static final int PAGESIZE = 512;
	
	private LogicMemory logicMemory; 
	private PageTable pageTable;
	private PhysicalMemory physMemory;
	private ArrayList<String> fileContents;
	private int counter;
	
	public MemoryManager(String fileName) {
		
		physMemory = new PhysicalMemory();
		pageTable = new PageTable();
		logicMemory = new LogicMemory();
		counter = 0;
		
		try { 
			File file = new File("/data/" + fileName + ".data");
			FileInputStream fis = new FileInputStream(file);
			DataInputStream data = new DataInputStream(fis);
			BufferedReader br = new BufferedReader(new InputStreamReader(data));
			
			String strLine;
			try {
				while ((strLine = br.readLine()) != null) 
					fileContents.add(strLine);
			} catch (IOException e) {
				System.out.println("Cannot read file!");
				e.printStackTrace();
				System.exit(1);
			}
		} catch (FileNotFoundException fx) { 
			System.out.println("File not found!");
			fx.printStackTrace();
			System.exit(1);
		}	
	}
	
	public void step() {
		String command = fileContents.get(counter);
		counter++;
		
		String[] parsed = command.split(" ");
		
		if (parsed.length > 2)
			halt(parsed);
		else 
			addToLogic(parsed);
	}
	
	public void halt(String[] command) {
		int process = Integer.parseInt(command[0]);
		
		int pNum = logicMemory.getPageNum(process);
		int frameNum = pageTable.getFrameNum(pNum);
		pageTable.removeFromTable(pNum);
		physMemory.clearFrame(frameNum);
	}
	
	/*It's worth noting that this is an assumption I take
	 * from the sample input given*/
	public void addToLogic(String[] command) {
		int process = Integer.parseInt(command[0]);
		int sizeOfText = Integer.parseInt(command[1]);
		int sizeOfData = Integer.parseInt(command[2]);
		
		//determines how many pages needed
		int pagesOfText = numberOfPages(sizeOfText);
		int pagesOfData = numberOfPages(sizeOfData);
		
		
	}
	
	private int numberOfPages(int size) {
		int pages;
		int totalPageMemory = PAGESIZE;
		
		/*Says you find how many pages you need till the 
		 * number of pages is greater then or equal to the
		 * size of the incoming file, either its text or its
		 * data size*/
		for (pages = 0; totalPageMemory < size; pages++)
			totalPageMemory = totalPageMemory * pages;
			
		return pages;
	}
	
}
