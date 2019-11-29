package com.briup.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * 
 * @ClassName: CatchTest
 * @Description: 测试类
 * @author y2312
 * @date Nov 29, 2019
 *
 */

public class CatchTest {

	public static void main(String[] args) throws Exception {
		URL url = new URL("https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Annie_0.jpg");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setConnectTimeout(5 * 1000);
		InputStream is = conn.getInputStream();
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		File file = new File("D:/awd.jpg");
		FileOutputStream fos = new FileOutputStream(file);
		int i = 0;
		byte[] b = new byte[1024 * 8];
		while ((i = is.read(b)) != -1) {
			bos.write(b, 0, i);
		}
		bos.flush();
		fos.write(bos.toByteArray());
		bos.close();
		fos.close();
		is.close();
		conn.disconnect();
	}

}
