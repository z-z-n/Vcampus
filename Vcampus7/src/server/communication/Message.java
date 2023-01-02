package server.communication;

public class Message implements java.io.Serializable{
	private static final long serialVersionUID = 1L; // 这个不用管
	public String instruction = null;
	public String status = "100";
	public Object data = null;
	public Object[] response = null;
	public int num = 1;
	public Message(String ins, Object d){
		this.data = d;
		this.instruction = ins;
	}
}
