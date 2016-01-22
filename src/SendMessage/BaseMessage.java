package SendMessage;

import java.util.Date;

public class BaseMessage {
	private String ToUserName;
	private String FromUserName;
	private long CreateTime = new Date().getTime();
	public BaseMessage(String FromUserName,String ToUserName) {
		this.ToUserName = FromUserName;
		this.FromUserName = ToUserName;
	}
	

}
