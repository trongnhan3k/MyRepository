/*package Maven;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Time;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static java.util.concurrent.TimeUnit.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.LoggerFactory;

public class Thread1 {

	static class ThreadA extends Thread {

		@Override
		public void run() {
			Runnable runnable = new Runnable() {
				public void run() {
					JSONParser parser = new JSONParser();
					final Logger logger = LoggerFactory.getLogger(Thread1.class);
						try {
							URL oracle = new URL("http://news.admicro.vn:10002/api/realtime?domain=kenh14.vn"); // URL
																												// to
																												// Parse
							URLConnection yc = oracle.openConnection();
							BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

							String inputLine;
							while ((inputLine = in.readLine()) != null) {
								JSONObject o = (JSONObject) parser.parse(inputLine);
								logger.info("User   :{}", o.get("user"));
							}
							in.close();
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						} catch (ParseException e) {
							e.printStackTrace();
						}
				}
			};
			ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
			service.scheduleAtFixedRate(runnable, 0, 2, TimeUnit.SECONDS);
		}
	}

	static class ThreadB extends Thread {

		@Override
		public void run() {
			Runnable runnable = new Runnable() {
				public void run() {
					JSONParser parser = new JSONParser();
					final Logger logger = LoggerFactory.getLogger(Thread1.class);
					while (true) {
						try {
							URL oracle = new URL("http://news.admicro.vn:10002/api/realtime?domain=kenh14.vn"); // URL
																												// to
																												// Parse
							URLConnection yc = oracle.openConnection();
							BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

							String inputLine;
							while ((inputLine = in.readLine()) != null) {
								JSONObject o = (JSONObject) parser.parse(inputLine);
								logger.debug("User   :{}", o.get("user"));
							}
							in.close();
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						} catch (ParseException e) {
							e.printStackTrace();
						}
					}
				}
			};
			ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
			service.scheduleAtFixedRate(runnable, 0, 12, TimeUnit.SECONDS);
		}
	}

	public static void main(String[] args) {
		int dem = 0;
		while (true) {
			{
				while(dem<=6)
				{
					dem++;
					if(dem == 1){
						new ThreadA().start();
					}
					else if(dem == 6)
					{
						new ThreadB().start();
					}
					dem = 0;
				}
			}
		}

	}
}*/