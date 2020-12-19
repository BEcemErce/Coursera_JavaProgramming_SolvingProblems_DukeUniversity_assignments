package StringsSecondAssignment;


/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stop){
        int stopIndex= dna.indexOf(stop,startIndex+1);
        if  (stopIndex!= -1){
            if ((stopIndex- startIndex)%3==0){
                return stopIndex;
            }
            else{
                return dna.length();
            }
        }          
        return dna.length();
        
    }
    
    public void testFindStopCodon(){
        String dna="xxxyyyTAAvvvTGAçççTAG";
        System.out.println(dna);
        int r1=findStopCodon(dna,0,"TAA");
        System.out.println(r1);
        
        int r2=findStopCodon(dna,0,"TGA");
        System.out.println(r2);
        
        int r3=findStopCodon(dna,0,"TAG");
        System.out.println(r3);
    
    }
    
    public String findGene(String dna, int fromHere){
        int startIndex= dna.indexOf("ATG", fromHere);
        if (startIndex ==-1){
            return "";
        }
        int taa=findStopCodon(dna,startIndex,"TAA");
        int tga=findStopCodon(dna,startIndex,"TGA");
        int tag=findStopCodon(dna,startIndex,"TAG");
        
        int stopIndex=Math.min(taa,Math.min(tga,tag));
        
        if (stopIndex==dna.length()){
            return "";
        }
        return dna.substring(startIndex,stopIndex+3);
        
    } 
    
    /*public void testFindGene(){
        String DNA="xxxyyyxxxTAAvvv";
        String result= findGene(DNA,0);
        System.out.println(result);
        
        DNA="xxxATGyyyvvv";
        result= findGene(DNA,0);
        System.out.println(result);
        
        DNA="xxxATGyyyxxxTAAvvvTGA";
        result= findGene(DNA,0);
        System.out.println(result);
        
        DNA="xxxATGyxTAAvvvvTGA";
        result= findGene(DNA,0);
        System.out.println(result);
    }*/
    
    
    
    public void findAllGenes(String dna){
        
        int startIndex = 0;
        
        while (true){
            String gene= findGene(dna,startIndex);
            if (gene.isEmpty()){
                break;
            }
            
            System.out.println(gene);
            startIndex= dna.indexOf(gene,startIndex)+gene.length();
                      
        }
        
    
    }
    
    public void testFindAllGenes(){
        String DNA="AATGCTAACTAGCTGACTAAT";
        findAllGenes(DNA);
               
     
    }
    
}
