package po;

/**
 * WeixinTbl entity. @author MyEclipse Persistence Tools
 */
public class WeixinTbl extends AbstractWeixinTbl implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public WeixinTbl() {
	}

	/** minimal constructor */
	public WeixinTbl(String name, String password, String openid) {
		super(name, password, openid);
	}
	
	/** full constructor */
	public WeixinTbl(String name, String password, String openid, String message) {
		super(name, password, openid, message);
	}

}
