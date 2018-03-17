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
 * �������
 * @author jverice
 *
 */
public class ValveTest {

	public static void main(String[] args) throws Exception {
		long currentTimeMillis = System.currentTimeMillis();
		// ��ַ
		int page=0;
		String url = "https://book.douban.com/tag/%E7%BC%96%E7%A8%8B?start=";
		String url2 = "&type=S";
		// ץȡ������
		List<Valve> bookDatas = new ArrayList<Valve>();
		while (bookDatas.size()<=40) {
			bookDatas=getBookDatas(url+String.valueOf(page*20)+url2,bookDatas);
			page++;
		}
		// ����������
		Comparator<Valve> comparator = new Comparator<Valve>() {
			public int compare(Valve v1, Valve v2) {
				return v2.getScore().compareTo(v1.getScore());
			}
		};
		Collections.sort(bookDatas, comparator);
		//���excel���
		CreatePoi.builtPoi(bookDatas);
		//�鿴����ʱ��
		long currentTimeMillis2 = System.currentTimeMillis();
		System.out.println(currentTimeMillis2-currentTimeMillis);
	}

	
	public static List<Valve> getBookDatas(String url, List<Valve> bookDatas) throws Exception {
		// ��ʼ��һ��httpclient
		HttpClient httpClient = HttpClients.createDefault();
		bookDatas = URLFecter.uRLParser(httpClient, url, bookDatas);
		return bookDatas;
	}
}
