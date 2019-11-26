package com.briup.web;

/**
 * 
 * @ClassName: SkinImgCatch
 * @Description: 针对LOL官网所有英雄的原画进行获取
 * @author y2312
 * @date Nov 26, 2019
 *
 */

public class SkinImgCatch {

	public void catchSkin(String basePath, boolean flag) {
		String str1;
		String str2;
		String imgUrl;
		String path;
		CatchService service = new CatchService();

		for (int k = 1; k < 555; k++) {
			if (flag == false) {
				break;
			}
			System.out.println("Debug:K=" + k);
			for (int i = 0; i < 50; i++) {
				try {
					str1 = String.format("%03d", i);
					str2 = String.valueOf(k);
					imgUrl = "https://game.gtimg.cn/images/lol/act/img/skin/big" + str2 + str1 + ".jpg";
					System.out.print(imgUrl + "\t");

					path = basePath + "/" + k;
					service.getImg(imgUrl, path);

					System.out.print(i + "\t");
				} catch (Exception e) {
					System.out.println("DEBUG:" + "jump--" + e.getMessage());
					break;
				}
			}
		}
	}

	public void catchSkin(String basePath) {
		catchSkin(basePath, true);
	}

}
