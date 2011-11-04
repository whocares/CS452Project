package os;

import java.util.ArrayList;

public class PageTable {

    //the place in the array list is the page number and then the content is the frame number
    private ArrayList<Integer> pages; 

    /*Create an array list which will act like the page number*/
    public PageTable() {
        pages = new ArrayList<Integer>();
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

}