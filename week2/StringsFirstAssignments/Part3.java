
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public boolean twoOccurrences(String stringa,String stringb){
        int indx= stringb.indexOf(stringa);
        if (indx!=-1){
            int indx2=stringb.indexOf(stringa,indx + stringa.length());
            if (indx2!=-1){
                return true;      
            }
        }
        return false;
    }
    
    public void testing(){
        String a= "by";
        String b= "aabyaby";
        System.out.println(a);
        System.out.println(b);
        boolean result=twoOccurrences(a,b);
        System.out.println(result);
        
        a= "by";
        b= "aaaaby";
        System.out.println(a);
        System.out.println(b);
        result=twoOccurrences(a,b);
        System.out.println(result);
        
        
        
        a= "by";
        b= "aaaaaa";
        System.out.println(a);
        System.out.println(b);
        result=twoOccurrences(a,b);
        System.out.println(result);
        
        a= "an";
        b= "banana";
        System.out.println(a);
        System.out.println(b);
        String result2=lastPart(a,b);
        System.out.println(result2);
        
        a= "zoo";
        b= "forest";
        System.out.println(a);
        System.out.println(b);
        result2=lastPart(a,b);
        System.out.println(result2);
        
    }
    
    
    public String lastPart(String stringa,String stringb){
        int indx= stringb.indexOf(stringa);
        if (indx==-1){
            return stringb;
        }
        String result= stringb.substring(indx+stringa.length(),stringb.length());
        return result;
    } 
    
    
}
