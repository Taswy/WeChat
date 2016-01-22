package util;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.http.client.ClientProtocolException;

import Wechat_interface.AccessToken;

public class Test {

	/**
	 * @throws IOException 
	 * @throws ClientProtocolException    
	 * @Title: main   
	 * <p>Description: </p>
	 * @param: @param args      
	 * @return: void      
	 * @throws   
	 */
	public static void main(String[] args) throws ClientProtocolException, IOException {
//		JSONObject jsonObject =WeChatUtil.getInfor(WeChatUtil.getOpenid("001438762e46199ead05fdcb769d81c5"));
//		System.out.println(jsonObject.getString("openid"));
//		System.out.println(jsonObject.getString("nickname"));
//		System.out.println(jsonObject.getString("sex"));
//		System.out.println(jsonObject.getString("city"));
//		System.out.println(jsonObject.getString("province"));
//		System.out.println(jsonObject.getString("country"));
//		System.out.println(jsonObject.getString("headimgurl"));
		AccessToken accessToken = WeChatUtil.getAccessToken();
//		System.out.println(accessToken.getAccess_token());
//		System.out.println(accessToken.getExpires_in());
//		//String id = WeChatUtil.upload("D:/1.jpg", accessToken.getAccess_token(), "image");
		String menu = JSONObject.fromObject(WeChatUtil.initMenu()).toString();
		int result = WeChatUtil.createMenu(accessToken.getAccess_token(), menu);
		if (result==0) {
			System.out.println("创建成功");
		}
		

	}

}
