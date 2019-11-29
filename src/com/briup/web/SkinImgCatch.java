package com.briup.web;

import java.util.List;

/**
 * 
 * @ClassName: SkinImgCatch
 * @Description: 针对LOL日服官网所有英雄的原画进行获取
 * @author y2312
 * @date Nov 26, 2019
 *
 */

public class SkinImgCatch {

	public void catchSkin(String basePath) throws Exception {
		List<String> heroNames;
		String imgUrl = null;
		String path = null;
		CatchService service = new CatchService();

		heroNames = CatchName.getNames();
		for (String heroName : heroNames) {
			for (int i = 0; i < 20; i++) {
				try {
					imgUrl = "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/" + heroName + "_" + i
							+ ".jpg";
					System.out.print(imgUrl + "\t");
					path = basePath + "/" + heroName;
					String skinsName = CatchName.getSkinsName(heroName,i);
					service.getImg(imgUrl, path, skinsName);

					System.out.print(i + "\t");
				} catch (Exception e) {
					System.out.println("DEBUG:" + "jump--" + e.getMessage());
					break;
				}
			}
		}
	}

}
