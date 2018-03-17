package com.parse;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.model.Valve;
import com.util.StringUtils;
/**
 * �õ�������
 * @author jverice
 *
 */
public class ValveParse {
    public static List<Valve> getData (String html,List<Valve> bookDatas) throws Exception{
        //����Jsoup����
        Document doc =Jsoup.parse(html);
        //��ȡhtml��ǩ�е�����
        Elements elements=doc.select("ul[class=subject-list]").select("li[class=subject-item]");
        for (Element ele:elements) {
            String bookName=ele.select("div[class=info]").select("h2").select("a").text();
            String score=ele.select("div[class=info]").select("div[class=star clearfix]").select("span[class=rating_nums]").text();
            String number=ele.select("div[class=info]").select("div[class=star clearfix]").select("span[class=pl]").text();
            String authorAndPressAndDateAndPrice=ele.select("div[class=info]").select("div[class=pub]").text();
            //�õ���Ҫ��ֵ
            String[] arr = authorAndPressAndDateAndPrice.split("/");
            
            Valve valve=new Valve();
            //�����ֵ
            valve.setBookName(bookName);
            valve.setScore(score);
            valve.setNumber(StringUtils.getNum(number));
            if(arr.length==5){
	            valve.setAuthor(arr[0]);
	            valve.setPress(arr[2]);
	            valve.setDate(arr[3]);
	            valve.setPrice(arr[4]);
            }
            if(arr.length==4){
	            valve.setAuthor(arr[0]);
	            valve.setPress(arr[1]);
	            valve.setDate(arr[2]);
	            valve.setPrice(arr[3]);
            }
            //��ÿһ�������ֵ�����浽List������
            if(Integer.parseInt(valve.getNumber())>1000)
            	bookDatas.add(valve);
        }
        //��������
        return bookDatas;
    }
}