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
		String url1 = "https://book.douban.com/tag/%E7%BC%96%E7%A8%8B?start=0&type=S";
		String url2 = "https://book.douban.com/tag/%E7%BC%96%E7%A8%8B?start=20&type=S";
		// ץȡ������
		List<Valve> bookDatas = new ArrayList<Valve>();
		bookDatas=getBookDatas(url1,bookDatas);
		bookDatas=getBookDatas(url2,bookDatas);
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
