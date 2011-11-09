package os;

/*Finished*/
public class PCB {

    String segType;
    int size = 0;
    int processNum = -1;

    public PCB(int s, int pNum, String seg) {
            size = s;
            processNum = pNum;
            segType = seg;
    }

    public String getSegType() {
             return segType;
    }

    public int getpNum() {
             return processNum;
    }

    public int getSize() {
              return size;  
    }

}
