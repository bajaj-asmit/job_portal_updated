package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


public class SendSms {

	public static void sendSms(String message,String number) throws IOException
	{
	//	System.out.println(message+" "+number);
		
		String APIkey="OMSQamUXfwWB7g4TA0nK6hzbZkjyC2p5HqP9NevuoIx1rid8GVPDvSOUtpE8s2RFjXxdyknfYHqLQ5Zw";
		String sender_id="FSTSMS";
		
		message=URLEncoder.encode(message,"UTF-8");
		
		String language="english";
		String route="q";
		
		String myURL="https://www.fast2sms.com/dev/bulkV2?authorization="+APIkey+"&message="+message+"&language="+language+"&route="+route+"&numbers="+number;
		
		//sending get request
		
		URL url = new URL(myURL);
		
		HttpURLConnection con=(HttpURLConnection) url.openConnection();
		
		con.setRequestMethod("GET");
		
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setRequestProperty("cache-control", "no-cache");
		System.out.println("wait........");
		 
		int code=con.getResponseCode();
		
		System.out.println("Responce code "+code);
		
		StringBuffer responce=new StringBuffer();
		
		BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		while(true)
		{
			String line=br.readLine();
			if(line==null)
			{
				break;
			}
			responce.append(line);
		}
		
		System.out.println(responce);
		
		
		
//		System.out.println(myURL);
//		System.out.println(message);
	}
	
//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//		System.out.println("Program started.....");
//	//	SendSms.sendSms("hello java this is java message system", "9588145081");
//
//	}

}
