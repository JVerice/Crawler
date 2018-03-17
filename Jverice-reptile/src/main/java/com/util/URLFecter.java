package com.util;

import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.util.EntityUtils;

import com.model.Valve;
import com.parse.ValveParse;
/**
 * ���ݷ�����Ӧ�õ�html
 * @author jverice
 *
 */
public class URLFecter {
    public static List<Valve> uRLParser (HttpClient client, String url,List<Valve> bookDatas) throws Exception {
        
        //��ȡ��վ��Ӧ��html�����������HTTPUtils��
        HttpResponse response = HTTPUtils.getRawHtml(client, url);      
        //��ȡ��Ӧ״̬��
        int StatusCode = response.getStatusLine().getStatusCode();
        //���״̬��Ӧ��Ϊ200�����ȡhtmlʵ������
        if(StatusCode == 200){
            String entity = EntityUtils.toString (response.getEntity(),"utf-8");    
            bookDatas = ValveParse.getData(entity,bookDatas);
            EntityUtils.consume(response.getEntity());
        }else {
            //�������ĵ�ʵ��
            EntityUtils.consume(response.getEntity());
        }
        return bookDatas;
    }
}