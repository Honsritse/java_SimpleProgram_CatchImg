package com.briup.web;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * 
 * @ClassName: CatchName
 * @Description: 工具类，获取英雄名
 * @author y2312
 * @date Nov 29, 2019
 *
 */
public class CatchName {
	private static InputStream is;
	private static BufferedReader reader;
	private static HttpURLConnection conn;
	private static JSONObject json;
	private static JSONArray jsonArray;

	public static String init(int seq) throws Exception {
		String path = "https://game.gtimg.cn/images/lol/act/img/js/hero/" + seq + ".js";
		URL url = new URL(path);
		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setConnectTimeout(5 * 1000);
		is = conn.getInputStream();
		reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		String str = null;
		StringBuilder buf = new StringBuilder();
		while ((str = reader.readLine()) != null) {
			buf.append(str);
		}
		
		json = new JSONObject(buf.toString());
		jsonArray = json.getJSONArray("skins");
		JSONObject obj = (JSONObject) jsonArray.get(0);
		String name = (String) obj.get("heroName");
		return name;
	}


	public static String skinsName(int no) throws Exception {
		JSONObject obj = (JSONObject) jsonArray.get(no);
		String skinName = (String) obj.get("name");
		return skinName;
	}

}
