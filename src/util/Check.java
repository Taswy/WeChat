package util;

import java.util.Arrays;
import org.apache.commons.codec.digest.DigestUtils;

import po.WeixinTbl;
public class Check {
	public static final String token ="token";
	public static boolean checkSignature(String signature , String timestamp, String nonce){
	//将token、timestamp、nonce三个参数进行字典序排序
	String[] arr = new String[]{token , timestamp , nonce};
	Arrays.sort(arr);
	
	//将三个参数字符串拼接成一个字符串进行sha1加密
	StringBuffer content = new StringBuffer();
	for (String string : arr) {
		content.append(string);
	}
	
	// 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
	return signature.equals(DigestUtils.sha1Hex(content.toString()));
		
	}
	public static WeixinTbl checkBind(String openid){
		return DataUtil.findWeixin(openid);
	}
}
