package com.tw.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Test1 {

	public static void main(String[] args) throws IOException, JSONException, ParseException {
		// TODO Auto-generated method stub
		String url = "http://tw-http-hunt-api-1062625224.us-east-2.elb.amazonaws.com/challenge/input";
		
		//URL obj = new URL(url);
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet get = new HttpGet(url);
		get.setHeader("userId","Skh3ZiAqZ");
		
		HttpResponse responseGet = httpclient.execute(get);
		HttpEntity resEntityGet = responseGet.getEntity();
		InputStream content = resEntityGet.getContent();
        StringBuilder   builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(content));
            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
                content.close();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            int count=0;
            HashMap<String,Integer> map = new HashMap<>();
            int price_total=0;
            try {
            	
            	JSONArray arr = new JSONArray(builder.toString());
            	//count = arr.length();
            	
            	for(int i=0;i<arr.length();i++)
            	{
            		String ss = arr.getJSONObject(i).getString("endDate");
            		String price = arr.getJSONObject(i).getString("price");
            		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
            		Date d = Calendar.getInstance().getTime();
            		//d.setHours(0);
            		Date date=null;
            		Date startdate;
            		if(ss == "null")
            		{
            			//count++;
            			String sd = arr.getJSONObject(i).getString("startDate");
        				startdate = df.parse(sd);
        				if(startdate.before(d))
        				{
//            			if(map.containsKey(category))
//            				map.put(category, map.get(category)+1);
//            			else
//            				map.put(category, 1);
        					price_total+=Integer.parseInt(price);
        				}
            		}
            		else
            		{
            			date = df.parse(ss);
            			
            			
            			if(date.after(d))
            			{
            				String sd = arr.getJSONObject(i).getString("startDate");
            				startdate = df.parse(sd);
            				if(startdate.before(d))
            					{
            					//count++;
//            					if(map.containsKey(category))
//                    				map.put(category, map.get(category)+1);
//                    			else
//                    				map.put(category, 1);
            					price_total+=Integer.parseInt(price);
            					}
            			}
            				//count++;
            		}
            	}
            System.out.println(arr.length());
            } catch (JSONException e) {
                System.out.println("Error parsing data " + e.toString());
            }
            String url_post = "http://tw-http-hunt-api-1062625224.us-east-2.elb.amazonaws.com/challenge/output";
    		
    		//URL obj = new URL(url);
    		//CloseableHttpClient httpclient = HttpClients.createDefault();
    		HttpPost post = new HttpPost(url_post);
    		post.setHeader("userId","Skh3ZiAqZ");
    		post.setHeader("Content-Type", "application/json");
    		
    		JSONObject o = new JSONObject();
    		o.put("totalValue", price_total);
//    		JSONArray output = new JSONArray();
//    		for(String k : map.keySet())
//    		{
//    			o.put(k, map.get(k));
//    			
//    			
//    		}
    		StringEntity obj = new StringEntity(o.toString());
    		post.setEntity(obj);
    		HttpResponse response = httpclient.execute(post);
			//post.setEntity(entity);
    		System.err.println("RESPONSE: " + response.toString());
            
	}

}
