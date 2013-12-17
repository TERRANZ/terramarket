package ru.terra.server.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RequestUtil {
	public static HttpURLConnection prepareConnection(URL url) throws IOException {
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setConnectTimeout(Integer.MAX_VALUE);
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
		// conn.setRequestProperty("Referer", "http://localhost/jbrss/login");
		conn.setRequestProperty("Accept",
				"text/html, application/xml;q=0.9, application/xhtml+xml, image/png, image/webp, image/jpeg, image/gif, image/x-xbitmap, */*;q=0.1");
		conn.setRequestProperty("Accept-Language", "ru-RU,ru;q=0.9,en;q=0.8");
		conn.setRequestProperty("User-Agent", "Opera/9.80 (X11; Linux x86_64; U; ru) Presto/2.10.229 Version/11.60");
		conn.setInstanceFollowRedirects(false);
		conn.setRequestMethod("POST");
		return conn;
	}

	public static String readStreamToString(InputStream in, String encoding) throws IOException {
		StringBuffer b = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(in, encoding));
		String s = "";
		while ((s = br.readLine()) != null) {
			// System.out.println(s);
			b.append(s);
		}
		return b.toString();
	}
}
