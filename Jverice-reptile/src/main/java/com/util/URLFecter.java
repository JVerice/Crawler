package com.util;

import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.util.EntityUtils;

import com.model.Valve;
import com.parse.ValveParse;
/**
 * 根据返回响应得到html
 * @author jverice
 *
 */
public class URLFecter {
    public static List<Valve> uRLParser (HttpClient client, String url,List<Valve> bookDatas) throws Exception {
        
        //获取网站响应的html，这里调用了HTTPUtils类
        HttpResponse response = HTTPUtils.getRawHtml(client, url);      
        //获取响应状态码
        int StatusCode = response.getStatusLine().getStatusCode();
        //如果状态响应码为200，则获取html实体内容
        if(StatusCode == 200){
            String entity = EntityUtils.toString (response.getEntity(),"utf-8");    
            bookDatas = ValveParse.getData(entity,bookDatas);
            EntityUtils.consume(response.getEntity());
        }else {
            //否则，消耗掉实体
            EntityUtils.consume(response.getEntity());
        }
        return bookDatas;
    }
}