package os;

import java.util.*;

public class PhysicalMemory { 
	 
	public static final int MAXMEM = 4096;
	public static final int MAXFRAMES = 8;
	
    private ArrayList<Frame> frames;
    
    public PhysicalMemory() {
        frames = new ArrayList<Frame>();
        makeFrames();
    }
    
    private void makeFrames() {
    	while (frames.size() < MAXFRAMES) 
    		frames.add(null); 
    		//make the frames but never add anything to them
    }
   
    public Frame getFrame(int frameNum) {
    	return frames.get(frameNum);
    }
    
    /*Add something to logical memory*/
    public void editFrame(int frameNum, int pID, String seg, int pNum) {
        if (frames.isEmpty()) {
            Frame f = new Frame(pID, seg, pNum);
            frames.set(frameNum, f); //add the frame to it to the first frame
        }
    }
    
    /*Clear a frame (halt)*/
    public void clearFrame(int frameNum) {
    	//sets that frame number to null
        frames.set(frameNum, null);
    }
    
    public boolean checkForNull(int frameNum) {
    	if (frames.get(frameNum) == null)
    		return true;
    	else
    		return false;
    }
    
    public void takeAction(String action, int processNum) {
    	int process = -1;
    	int count = 0;
    	
    	//search for the correct process
    	while (process != processNum && count < frames.size()) {
    		process = frames.get(count).getProcID();
    		
    		count++;
    	}
    }
}