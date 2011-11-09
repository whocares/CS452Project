package os;

import java.util.ArrayList;

/*Finished*/
public class PageTable {

    //the place in the array list is the page number and then the content is the frame number
    private ArrayList<Integer> pages;
    private int processNum;

    /*Create an array list which will act like the page number*/
    public PageTable(int pNum) {
        pages = new ArrayList<Integer>();
        processNum = pNum;
    }
    
    public int getProcNum() {
    	return processNum;
    }
    
    public ArrayList<Integer> getPages() {
    	return pages;
    }
   
    /* Add the frame number to the page table which 
     * automatically increments to the right page number*/
    public void addToTable(int frameNum) {
        pages.add(frameNum);
    }
    
    /*Send the page number and you get the frame number!*/
    public int getFrameNum(int pageNum) {
        return pages.get(pageNum);
    }
    
    /*Null because if you remove you'd cascade the page numbers*/
    public void removeFromTable(int pageNum) {
    	pages.set(pageNum, null);
    }

}
