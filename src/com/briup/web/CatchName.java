package com.briup.web;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
	private static String jsonPath;
	private static BufferedReader reader;
	private static URL url;

	@SuppressWarnings("rawtypes")
	public static List<String> getNames() throws Exception {
		jsonPath = "https://ddragon.leagueoflegends.com/cdn/9.23.1/data/ja_JP/champion.json";

		String json = getJson();

		JSONObject champion = new JSONObject(json);
		JSONObject heros = (JSONObject) champion.get("data");
		Set keySet = heros.keySet();
		List<String> heroNames = new ArrayList<>();
		for (Object obj : keySet) {
			heroNames.add(obj.toString());
		}
		return heroNames;
	}

	public static String getSkinsName(String heroName, int i) throws Exception {

		jsonPath = "https://ddragon.leagueoflegends.com/cdn/9.23.1/data/ja_JP/champion/" + heroName + ".json";

		String json = getJson();

		JSONObject jsonObj = new JSONObject(json);
		JSONObject data = (JSONObject) jsonObj.get("data");
		JSONObject hero = (JSONObject) data.get(heroName);
		JSONArray skins = (JSONArray) hero.get("skins");
		JSONObject skin = (JSONObject) skins.get(i);
		String skinName = skin.getString("name");
		return skinName;
	}

	public static String getJson() throws Exception {
		url = new URL(jsonPath);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setConnectTimeout(5 * 1000);

		InputStream is = conn.getInputStream();
		reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		String str = null;
		StringBuilder buf = new StringBuilder();
		while ((str = reader.readLine()) != null) {
			buf.append(str);
		}
		return buf.toString();
	}
}
