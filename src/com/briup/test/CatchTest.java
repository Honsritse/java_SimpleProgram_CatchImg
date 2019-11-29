package com.briup.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class CatchTest {

	public void test01() throws Exception {
		String path = "https://game.gtimg.cn/images/lol/act/img/js/hero/555.js";
		URL url = new URL(path);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setConnectTimeout(5 * 1000);
		InputStream is = conn.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		String str = null;
		StringBuilder buf = new StringBuilder();
		while ((str = reader.readLine()) != null) {
			buf.append(str);
		}

		JSONObject json = new JSONObject(buf.toString());
		JSONArray jsonArray = json.getJSONArray("skins");
		JSONObject obj = (JSONObject) jsonArray.get(0);
		String name = (String) obj.get("heroName");
		System.out.println(name);

		System.out.println(json);
		System.out.println(jsonArray);
		reader.close();
		is.close();
		conn.disconnect();
	}

	public static void main(String[] args) throws Exception {
		new CatchTest().test01();
	}
}
