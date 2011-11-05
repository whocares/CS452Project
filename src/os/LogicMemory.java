package os;

import java.util.ArrayList;

/*The logical memory data structure*/
public class LogicMemory {

    private ArrayList<Page> memory;

    /*This makes logical memory nothing but an easy to use */
    public LogicMemory() {
        memory = new ArrayList<Page>();
    }

    /*Add something to the memory, pretty much it will simply contain the page number*/
    public void addToVIM(int pageNum) {
        
    }
    
    /*Returns the page number stored in the virtual memory*/
    private int getPageNum(int pNum) {
    	int answer = -1;
    	
    	for (int i = 0; i < memory.size(); i++) {
    		if (pNum == memory.get(i).getProcessNum()) {
    			answer = i;
    		}
    	}
    	
    	return answer;
    }
    
    public void halt(int process) {
    	int pNum = getPageNum(process);
    	
    	
    }

}