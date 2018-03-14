package Maven;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser extends Thread {
	static int lastUser = 1;
	static int dem = 0;

	public static void main(String[] args) throws Exception {
		Runnable runnable = new Runnable() {
			public void run() {
				JSONParser parser = new JSONParser();
				final Logger logger = LoggerFactory.getLogger(JsonParser.class);
				try {
					URL oracle = new URL("http://news.admicro.vn:10002/api/realtime?domain=kenh14.vn"); // URL
																										// to
																										// Parse
					URLConnection yc = oracle.openConnection();
					BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

					String inputLine;
					StringBuilder builder = new StringBuilder();

					while ((inputLine = in.readLine()) != null) {
						builder.append(inputLine);
					}

					in.close();

					final JSONObject o = (JSONObject) parser.parse(builder.toString());
					int user = Integer.parseInt(o.get("user").toString());
					System.out.println(user);
					dem++;
					if (user > lastUser * 1.0) {
						dem = 0;
						lastUser = user;
						logger.info("User  :{}", lastUser);
						System.out.println("info :"+lastUser);
					} else if (dem >= 6) {
						dem = 0;
						lastUser = user;
						logger.debug("User  :{}", lastUser);
						System.out.println("debug :"+lastUser);
					}

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