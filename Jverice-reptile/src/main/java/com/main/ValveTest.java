package com.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;

import com.model.Valve;
import com.poi.CreatePoi;
import com.util.URLFecter;
/**
 * 程序起点
 * @author jverice
 *
 */
public class ValveTest {

	public static void main(String[] args) throws Exception {
		long currentTimeMillis = System.currentTimeMillis();
		// 地址
		int page=0;
		String url = "https://book.douban.com/tag/%E7%BC%96%E7%A8%8B?start=";
		String url2 = "&type=S";
		// 抓取的数据
		List<Valve> bookDatas = new ArrayList<Valve>();
		while (bookDatas.size()<=40) {
			bookDatas=getBookDatas(url+String.valueOf(page*20)+url2,bookDatas);
			page++;
		}
		// 按评分排序
		Comparator<Valve> comparator = new Comparator<Valve>() {
			public int compare(Valve v1, Valve v2) {
				return v2.getScore().compareTo(v1.getScore());
			}
		};
		Collections.sort(bookDatas, comparator);
		//输出excel表格
		CreatePoi.builtPoi(bookDatas);
		//查看运行时间
		long currentTimeMillis2 = System.currentTimeMillis();
		System.out.println(currentTimeMillis2-currentTimeMillis);
	}

	
	public static List<Valve> getBookDatas(String url, List<Valve> bookDatas) throws Exception {
		// 初始化一个httpclient
		HttpClient httpClient = HttpClients.createDefault();
		bookDatas = URLFecter.uRLParser(httpClient, url, bookDatas);
		return bookDatas;
	}
}
