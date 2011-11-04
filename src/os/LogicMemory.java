package os;

import java.util.ArrayList;

/*The logical memory data structure*/
public class LogicMemory {

    private ArrayList<Integer> memory;

    /*This makes logical memory nothing but an easy to use */
    public LogicMemory() {
        memory = new ArrayList<Integer>();
    }

    /*Add something to the memory, pretty much it will simply contain the page number*/
    public void addToVIM(int pageNum) {
        memory.add(pageNum);
    }
    
    /*Returns the page number stored in the virtual memory*/
    public int getPageNum(int pNum) {
    	if (memory.isEmpty() || memory.get(pNum) == null) {
    		return -1; //ERROR!!!
    	} else {
    		return memory.get(pNum);
    	}
    }
    
    public void halt(int process) {
    	
    }

}