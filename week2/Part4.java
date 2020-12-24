
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class Part4 {
    public void mtd(){
        URLResource ur = new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
        for (String s : ur.words()) {
            s=s.toLowerCase();
            System.out.println(s);
            String youtube="youtube.com";
            int youtubeIndex= s.indexOf(youtube);
            if (youtubeIndex!=-1){
                int doublequote1=s.lastIndexOf("\"", youtubeIndex);
                int doublequote2=s.indexOf("\"",doublequote1);
                String URL=s.substring(doublequote1,doublequote2+1);
                System.out.println(URL);
            }
                       
        }
}
}

