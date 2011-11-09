package os;

import java.io.*;
import java.util.ArrayList;

public class MemoryManager {

	public static final int PAGESIZE = 512;
	
	private LogicMemory logicMemory; 
	private ArrayList<ArrayList<PageTable>> pageTable;
	private PhysicalMemory physMemory;
	private ArrayList<String> fileContents;
	private int counter;
	
	public MemoryManager(String fileName) {
		
		physMemory = new PhysicalMemory();
		pageTable = new ArrayList<ArrayList<PageTable>>();
		fileContents = new ArrayList<String>();
		logicMemory = new LogicMemory();
		counter = 0;
		
		try { 
			File file = new File("data/" + fileName + ".data");
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
	
	public PhysicalMemory getPhysMemory() {
		return physMemory;
	}
	
	public LogicMemory getLogicMemory() {
		return logicMemory;
	}

	public int step() {
		if (counter < fileContents.size()) {
			String command = fileContents.get(counter);
			System.out.println(command);
			counter++;
			
			String[] parsed = command.split(" ");
			
			if (parsed.length == 2)
				halt(parsed);
			else 
				addToLogic(parsed);
			
			return 0;
		} else
			return 1;
	}
	
	public void halt(String[] command) {
		int process = Integer.parseInt(command[0]);
		
		if (pageTable.get(process) != null) {
			
			for (int i = 0; i < pageTable.get(process).size(); i++) {
				for (int j = 0; j < pageTable.get(process).get(i).getPages().size(); j++) {	
					int frameNum = pageTable.get(process).get(i).getFrameNum(j);
					physMemory.clearFrame(frameNum);//clears this from frame
				}
			}
			
			pageTable.set(process, null);
			
		} else {
			System.out.println("Trying to delete something that isn't there.");
			System.exit(1);
		}
		
	}
	
	/*It's worth noting that this is an assumption I take
	 * from the sample input given*/
	public void addToLogic(String[] command) {
		int process = Integer.parseInt(command[0]);
		int sizeOfText = Integer.parseInt(command[1]);
		int sizeOfData = Integer.parseInt(command[2]);
		
		PageTable dataTable = new PageTable(process); 
		PageTable textTable = new PageTable(process);
		
		//determines how many pages needed
		int pagesOfText = numberOfPages(sizeOfText);
		int pagesOfData = numberOfPages(sizeOfData);
		
		int count = 0; 
		do {
			
			if (sizeOfText > 512) {
				sizeOfText = sizeOfText - 512;
				PCB toAdd = new PCB(512, process, "text");
				logicMemory.addToMemory(toAdd);
				int frameNum = physMemory.addToMemory(toAdd);
				textTable.addToTable(frameNum);
			} else {
				PCB toAdd = new PCB(sizeOfText, process, "text");
				logicMemory.addToMemory(toAdd);
				int frameNum = physMemory.addToMemory(toAdd);
				textTable.addToTable(frameNum);
			}
			count++;
		} while (count < pagesOfText);
		
		count = 0; 
		System.out.println("\n pages of data = " + pagesOfData);
		do {
			
			if (sizeOfData >512) {
				sizeOfData = sizeOfData - 512;
				PCB toAdd = new PCB(512, process, "data");
				logicMemory.addToMemory(toAdd);
				int frameNum = physMemory.addToMemory(toAdd);
				dataTable.addToTable(frameNum);
			} else {
				PCB toAdd = new PCB(sizeOfData, process, "data");
				logicMemory.addToMemory(toAdd);
				int frameNum = physMemory.addToMemory(toAdd);
				dataTable.addToTable(frameNum);
			}
			count++;
		} while (count < pagesOfData);
		
		ArrayList<PageTable> proc = new ArrayList<PageTable>();
		
		proc.add(textTable);
		proc.add(dataTable);
		pageTable.add(proc);
	}
	
	private int numberOfPages(int size) {
		int pages;
		int totalPageMemory = PAGESIZE;
		
		/*Says you find how many pages you need till the 
		 * number of pages is greater then or equal to the
		 * size of the incoming file, either its text or its
		 * data size*/
		for (pages = 1; totalPageMemory < size; pages++)
			totalPageMemory = totalPageMemory * pages;
			
		return pages - 1;
	}
	
}
