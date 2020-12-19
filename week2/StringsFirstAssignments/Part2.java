
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public String findSimpleGene(String dna,int startCodon,int stopCodon) {
        
        startCodon = dna.indexOf("ATG");              
        if (startCodon==-1){
            String stringLow= dna.toLowerCase();
            startCodon = dna.indexOf("atg"); 
            if (startCodon==-1){
                return "";
            }
            dna=dna.toLowerCase();
            stopCodon=dna.indexOf("taa",startCodon+3);
            if (stopCodon ==-1){
                return "";
            }
            if ((stopCodon-startCodon)%3==0){
                String result=dna.substring(startCodon,stopCodon+3);
                return result;
            }
        }
        
        stopCodon=dna.indexOf("TAA",startCodon+3);
        if (stopCodon ==-1){
            return "";
        }
        
        if ((stopCodon-startCodon)%3==0){
            String result=dna.substring(startCodon,stopCodon+3);
            return result;
        }
        return "";
    
    }

    
    public void testSimpleGene(){
        String dna= "CGCGCGTAA";
        System.out.println(dna);
        int startIndex = 0;
        int stopIndex= 0;
        String result= findSimpleGene(dna,startIndex,stopIndex);
        System.out.println("Gene="+ result);
        
        dna= "CGCATGTTTGCG";
        System.out.println(dna);
        result= findSimpleGene(dna,startIndex,stopIndex);
        System.out.println("Gene="+ result);
        
        dna= "CGCGCGTAA";
        System.out.println(dna);
        result= findSimpleGene(dna,startIndex,stopIndex);
        System.out.println("Gene="+ result);
        
        dna= "ATGGGTTAAGTC";
        System.out.println(dna);
        result= findSimpleGene(dna,startIndex,stopIndex);
        System.out.println("Gene="+ result);
        
        dna= "gatgctataat";
        System.out.println(dna);
        result= findSimpleGene(dna,startIndex,stopIndex);
        System.out.println("Gene="+ result);
        
    }
    
    public void testSimpleGene2(){
        String dna= "CGCGCGTAA";
        System.out.println(dna);
        int indx= dna.indexOf("ta");
        System.out.println(indx);
    }
        
}
