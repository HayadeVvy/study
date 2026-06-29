package kr.a28.network;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlMain01 {
	public static void main(String[] args) {
		try {
			URL url = new URL(
					"http://java.sun.com/index.jsp?name=park#content");
			String protocol = url.getProtocol();
			System.out.println(
					"프로토콜 : " + protocol);
			
			String host = url.getHost();
			System.out.println(
					"호스트 : " + host);
			
			int port = url.getDefaultPort();
			System.out.println(
					"포트 : " + port);
			
			String path = url.getPath();
			System.out.println(
					"패스 : " + path);
			
			String query = url.getQuery();
			System.out.println(
					"쿼리 : " + query);
			
			String ref = url.getRef();
			System.out.println(
					"ref : " + ref);
			
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}
	}
}




