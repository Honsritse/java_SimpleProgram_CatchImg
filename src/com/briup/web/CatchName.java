package com.briup.web;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.briup.bean.ChampionsInfo;
import com.briup.bean.HeroAndSkins;
import com.briup.bean.Skin;

/**
 * 
 * @ClassName: CatchName
 * @Description: 工具类，获取英雄名、皮肤名
 * @author y2312
 * @date Nov 29, 2019
 *
 */
public class CatchName {
	private static BufferedReader reader;
	private static URL url;

	public static List<String> getNames() throws Exception {
		String jsonPath = "https://ddragon.leagueoflegends.com/cdn/9.23.1/data/ja_JP/champion.json";

		ChampionsInfo info = JSON.parseObject(getJson(jsonPath),ChampionsInfo.class);

		Map<String,HeroAndSkins> data = info.getData();
		
		Set<String> heroNames = data.keySet();
		
		List<String> list = new ArrayList<String>(heroNames);
		return list;
	}
	
	public static String getSkinsName(String heroName, int i) throws Exception {

		String jsonPath = "https://ddragon.leagueoflegends.com/cdn/9.23.1/data/ja_JP/champion/" + heroName + ".json";

		ChampionsInfo heroInfo = JSON.parseObject(getJson(jsonPath),ChampionsInfo.class);
		Map<String,HeroAndSkins> data = heroInfo.getData();
		HeroAndSkins hero =  data.get(heroName);
		List<Skin> skins = hero.getSkins();
		Skin skin = skins.get(i);
		
		return skin.getName();
	}

	
	public static String getJson(String jsonPath) throws Exception {
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
