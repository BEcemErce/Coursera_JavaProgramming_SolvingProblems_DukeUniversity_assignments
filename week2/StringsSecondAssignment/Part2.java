package StringsSecondAssignment;


/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public int howMany(String stringa, String stringb){
  
        int count=0;
        int currentIndex= stringb.indexOf(stringa);       
        while(currentIndex!=-1){
            count=count+1;
            currentIndex= stringb.indexOf(stringa,currentIndex+stringa.length());
        }
        return count; 
    }
    
    public void testHowMany(){
        String b="ATGAACGAATTGAATC";
        String a="GAA";
        System.out.println("b=" + b);
        System.out.println("a=" + a);
        System.out.println(howMany(a,b));
        
        b="ATAAAA";
        a="AA";
        System.out.println("b=" + b);
        System.out.println("a=" + a);
        System.out.println(howMany(a,b));
        
    }
}
