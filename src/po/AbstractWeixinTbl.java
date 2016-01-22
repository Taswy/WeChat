package po;

/**
 * AbstractWeixinTbl entity provides the base persistence definition of the
 * WeixinTbl entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractWeixinTbl implements java.io.Serializable {

	// Fields

	private Integer idWeixinTb;
	private String name;
	private String password;
	private String openid;
	private String message;

	// Constructors

	/** default constructor */
	public AbstractWeixinTbl() {
	}

	/** minimal constructor */
	public AbstractWeixinTbl(String name, String password, String openid) {
		this.name = name;
		this.password = password;
		this.openid = openid;
	}

	/** full constructor */
	public AbstractWeixinTbl(String name, String password, String openid,
			String message) {
		this.name = name;
		this.password = password;
		this.openid = openid;
		this.message = message;
	}

	// Property accessors

	public Integer getIdWeixinTb() {
		return this.idWeixinTb;
	}

	public void setIdWeixinTb(Integer idWeixinTb) {
		this.idWeixinTb = idWeixinTb;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOpenid() {
		return this.openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}