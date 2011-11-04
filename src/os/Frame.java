package os;

public class Frame {

    private int procID;
    private String seg;
    private int pageNum;
    
    /*Instantiate a frame*/
    public Frame(int pID, String seg, int pN) {
        procID = pID;
        this.seg = seg;
        pageNum = pN;
    }

/******************************************************************************************
 * Everything below this line is something to just edit the frame.
 *****************************************************************************************/
    
    public void setProcID(int pID) {
        procID = pID;
    }
    
    public int getProcID() {
        return procID;
    }
    
    public void setSegID(String seg) {
        this.seg = seg;
    }
    
    public String getSeg() {
        return seg;
    }
    
    public void setPageNum(int pN) {
        pageNum = pN;
    }
    
    public int getPageNum() {
        return pageNum;
    }
}