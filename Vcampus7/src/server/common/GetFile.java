package server.common;

public class GetFile implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	public String downloadPath = null;
	public String card;
	public GetFile(String s,String c) {
		this.downloadPath = s;
		this.card=c;	
	}

}
