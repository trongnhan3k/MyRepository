import java.util.concurrent.ExecutionException;
import com.google.common.cache.LoadingCache;
public class GuavaRun {
	public static void main(String[] args) {
		GuavaRun guava = new GuavaRun();
		try {
			guava.getGuava(1);
		} catch (ExecutionException e) {
		}
	}
 
	private Guava getGuava(int k) throws ExecutionException {
		LoadingCache<Integer, Guava> cache = GuavaCache.getLoadingCache();
		System.out.println("Cache Size:" + cache.size());
		return cache.get(k);
	}
 
}