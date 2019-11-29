package com.briup.web;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 
 * @ClassName: CatchService
 * @Description: 主要功能类，完成对应网站内容的获取和本地存储
 * @author y2312
 * @date Nov 26, 2019
 *
 */

public class CatchService {

	public void getImg(String imgUrl, String path, String skinName) throws Exception {

		URL url = new URL(imgUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setConnectTimeout(5 * 1000);
		InputStream is = conn.getInputStream();
		byte[] data = readInputStream(is);

		File imageFile;
		imageFile = new File(path, skinName + ".jpg");
		if (!imageFile.getParentFile().exists()) {
			try {
				imageFile.getParentFile().mkdirs();
				imageFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		FileOutputStream fos = new FileOutputStream(imageFile);
		System.out.println("DEBUG:" + data.length);
		fos.write(data);
		fos.flush();
		fos.close();
		conn.disconnect();
	}

	public static byte[] readInputStream(InputStream inStream) throws Exception {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024 * 8];
		int len = 0;
		while ((len = inStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, len);
		}
		outStream.flush();
		outStream.close();
		inStream.close();
		return outStream.toByteArray();
	}
}
