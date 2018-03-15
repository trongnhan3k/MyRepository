import static spark.Spark.get;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
public class GuavaCache {
	private static LoadingCache<Integer, Guava> cache;
    static {
		cache = CacheBuilder.newBuilder()
		       .maximumSize(10000) //set size
		       .expireAfterWrite(10, TimeUnit.SECONDS) //set time expire
		       .build(
		           new CacheLoader<Integer, Guava>() {
						@Override
						public Guava load(Integer k) throws Exception {
							return getGuava(k);
						}
		           }
		       );
    }
    public static LoadingCache<Integer, Guava> getLoadingCache() {
		return cache;
    }
    // this method demo get data from database or file
	public static Guava getGuava(Integer k) {

		get("/prime/:n", (req, res) ->	{
			Map<Object, Integer> map = new HashMap<Object, Integer>();
			int m = Integer.parseInt(req.params(":n"));
			int n = 0;
			for(int i=0;i<m;i++) {
				n++;
				map.put(i+1,n);
			}
			return map;
		});
		return getGuava(k);
	}
}
class Guava {
}