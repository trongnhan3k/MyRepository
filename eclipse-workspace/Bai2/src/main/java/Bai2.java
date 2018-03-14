import java.io.IOException;  
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
 
public class Bai2 {  
 
   public static void main( String[] args ) throws IOException{  
       Document doc = Jsoup.connect("http://dantri.com.vn/").get();  
       Elements title = doc.getAllElements();  
       System.out.println("Title : " + title);  
   }  
 
}