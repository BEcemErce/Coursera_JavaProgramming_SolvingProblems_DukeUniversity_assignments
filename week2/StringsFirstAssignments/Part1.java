
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    
    public String findSimpleGene(String dna) {
        
        int startIndex = dna.indexOf("ATG");
        
        if (startIndex==-1){
            return "";
        }
        int stopIndex=dna.indexOf("TAA",startIndex+3);
        if (stopIndex ==-1){
            return "";
        }
        
        if ((stopIndex-startIndex)%3==0){
            String result=dna.substring(startIndex,stopIndex+3);
            return result;
        }
        return "";
    
    }

    
    public void testSimpleGene(){
        String dna= "CGCGCGTAA";
        System.out.println(dna);
        String result= findSimpleGene(dna);
        System.out.println("Gene="+ result);
        
        dna= "CGCATGTTTGCG";
        System.out.println(dna);
        result= findSimpleGene(dna);
        System.out.println("Gene="+ result);
        
        dna= "CGCGCGTAA";
        System.out.println(dna);
        result= findSimpleGene(dna);
        System.out.println("Gene="+ result);
        
        dna= "CGCGCGTTT";
        System.out.println(dna);
        result= findSimpleGene(dna);
        System.out.println("Gene="+ result);
        
        dna= "CGATGAAAGGGCCCTAA";
        System.out.println(dna);
        result= findSimpleGene(dna);
        System.out.println("Gene="+ result);
        
    }
    
    
    
}
