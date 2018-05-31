package pojo;

public class Message {
	private int  toid;
	private int  from_id;
	private int  to_id;
	private String  content;
	private String isread ;
	private String  sendname;
	public int getToid() {
		return toid;
	}
	public void setToid(int toid) {
		this.toid = toid;
	}
	public int getFrom_id() {
		return from_id;
	}
	public void setFrom_id(int fromId) {
		from_id = fromId;
	}
	public int getTo_id() {
		return to_id;
	}
	public void setTo_id(int toId) {
		to_id = toId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getIsread() {
		return isread;
	}
	public void setIsread(String isread) {
		this.isread = isread;
	}
	public void setSendname(String sendname) {
		this.sendname = sendname;
	}
	public String getSendname() {
		return sendname;
	}
}
