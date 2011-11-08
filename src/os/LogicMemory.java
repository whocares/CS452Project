package os;

import java.util.ArrayList;

/*The logical memory data structure*/
public class LogicMemory {

    private ArrayList<PCB> memory;

    /*This makes logical memory nothing but an easy to use */
    public LogicMemory() {
        memory = new ArrayList<PCB>();
    }
    
    /*Returns the page number stored in the virtual memory*/
    public int getPageNum(int pNum) {
    	int answer = -1;
    	
    	for (int i = 0; i < memory.size(); i++) {
    		if (pNum == memory.get(i).getpNum()) {
    			answer = i;
    		}
    	}
    	
    	return answer;
    }

    public void addToMemory(PCB p) {
         memory.add(p);
    }
}
