package os;

import java.util.Scanner;
import java.util.ArrayList;

public class RunIt {
	
	public static void main (String[] args) {
		System.out.println("This program simulates the MMU.");
		System.out.println("Please enter in a file name to run through");
		
		Scanner scan = new Scanner(System.in);
		String fileName = scan.next();
		
		MemoryManager mmu = new MemoryManager(fileName);
		boolean end = false;
		
		System.out.println("Created MMU, type step to proceed or exit to leave");
		String action = scan.next();
		
		if (action.equals("end")) {
			System.out.println("Good bye");
			System.exit(0);
		} else {
			while (end == false) {
				int result = mmu.step();
				if (result == 1) {
					System.out.println("No more to read now exiting");
					break;
				} else {
					PhysicalMemory phys = mmu.getPhysMemory();
					ArrayList<PCB> frames = phys.getFrames();
					LogicMemory log = mmu.getLogicMemory();
					
					for (int i = 0; i < frames.size(); i++) {
						if (frames.get(i) != null) {
						System.out.println("Frame: " + i + " Process: " + frames.get(i).getpNum() + " Size: " + frames.get(i).getSize());
						System.out.println("Page number: " + log.getPageNum(frames.get(i).getpNum())
								+ " Segment Type: " + frames.get(i).getSegType());
						} else {
							System.out.println("Frame: " + i + " is empty.");
						}
					}
					
					System.out.println("\n");
					System.out.println("Would you like to step or exit?");
					action = scan.next();
					if (action.equals("exit"))
						end = true;
				}
			}
			System.exit(0);
		}
	}
	
}