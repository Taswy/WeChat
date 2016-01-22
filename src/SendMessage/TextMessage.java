package SendMessage;

public class TextMessage extends BaseMessage{
	public TextMessage(String FromUserName, String ToUserName) {
		super(FromUserName, ToUserName);
	}
	private String MsgType = "text";
	private String Content;
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
}
