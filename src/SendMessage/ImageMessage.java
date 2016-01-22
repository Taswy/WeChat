package SendMessage;

public class ImageMessage extends BaseMessage{

	public ImageMessage(String FromUserName, String ToUserName) {
		super(FromUserName, ToUserName);
	}
	
	private String MsgType = "image";
	private Image Image;
	public Image getImage() {
		return Image;
	}
	public void setImage(Image image) {
		Image = image;
	}
	
	
			

}
