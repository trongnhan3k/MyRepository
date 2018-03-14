import static spark.Spark.get;

import java.util.HashMap;
import java.util.Map;


public class HelloWorld {
    	public static void main(String[] args) {

    		get("/prime/:n", (req, res) ->	{
    			Map<Object, Integer> map = new HashMap<Object, Integer>();
    			int m = Integer.parseInt(req.params(":n"));
    			int n = 0;
    			for(int i=1;i<=m;i++) {
    				n++;
    				map.put(i,n);
    			}
    			return map;
    		});
    		
    	}
}