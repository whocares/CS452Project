package os;

import java.util.*;

public class PhysicalMemory { 
	 
	public static final int MAXMEM = 4096;
	public static final int MAXFRAMES = 8;
	
    private ArrayList<PCB> frames;
    
    public PhysicalMemory() {
        frames = new ArrayList<PCB>();
        makeFrames();
    }
    
    private void makeFrames() {
    	while (frames.size() < MAXFRAMES) 
    		frames.add(null); 
    		//make the frames but never add anything to them
    }
    
    /*Clear a frame (halt)*/
    public void clearFrame(int frameNum) {
    	//sets that frame number to null
        frames.set(frameNum, null);
    }
    
    private boolean checkForNull(int frameNum) {
    	if (frames.get(frameNum) == null)
    		return true;
    	else
    		return false;	
    }
    
    private int findEmptyFrame() {
    	int freeFrame = -1;
    	
    	for (int i = 0; i < frames.size(); i++) {
    		if (checkForNull(i)) {
    			freeFrame = i;
    			break;
    		}
    	}
    	
    	return freeFrame;
    }
    
    public void addToMemory(PCB toAdd) {
    	int frameFree = findEmptyFrame();
    	
    	if (frameFree == -1) {
    		System.out.println("Memory is overload!");
    		System.exit(1);
    	} else
    		frames.set(frameFree, toAdd);
    }
}