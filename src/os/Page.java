package os;

public class Page {

	int processNum;
	String type; 
	
	public Page(int pNum, String t) {
		type = t;
		processNum = pNum;
	}

	public int getProcessNum() {
		return processNum;
	}

	public void setProcessNum(int processNum) {
		this.processNum = processNum;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
