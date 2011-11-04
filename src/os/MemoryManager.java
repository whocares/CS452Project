package os;

import java.io.*;
import java.util.ArrayList;

public class MemoryManager {

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
				while ((strLine = br.readLine()) != null) {
					fileContents.add(strLine);
				}
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
		
		if (parsed.length > 2) {
			halt(parsed);
		} else {
			addToLogic(parsed);
		}
		
	}
	
	public void halt(String[] command) {
		int process = Integer.parseInt(command[0]);
		
	}
	
	public void addToLogic(String[] command) {
		
	}
	
}
