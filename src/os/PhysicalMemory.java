package os;

import java.util.*;

public class PhysicalMemory { 

    private ArrayList<Frame> frames;
    
    public PhysicalMemory() {
        frames = new ArrayList<Frame>();
    }
    
    /*Add something to logical memory*/
    public void addFrame(int pID, String seg, int pNum) {
        if (frames.isEmpty()) {
            Frame f = new Frame(pID, seg, pNum);
            frames.add(f); //add the frame to it to the first frame
        }
    }
    
    /*Clear a frame (halt)*/
    public void clearFrame(int pID) {
        for (int i = 0; i < frames.size(); i++) {
             if (frames.get(i) != null) {
                Frame f = frames.get(i);
                if (f.getProcID() == pID) {
                    frames.set(i, null); 
                }
             }
        }
    }
    

}