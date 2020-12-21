package StringsThirdAssignment;
import edu.duke.*;

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
    
      
    
    
    public StorageResource getAllGenes(String dna){
        StorageResource geneList= new StorageResource();
        int startIndex = 0;
        
        while (true){
            String gene= findGene(dna,startIndex);
            if (gene.isEmpty()){
                break;
            }
            geneList.add(gene);
            startIndex= dna.indexOf(gene,startIndex)+gene.length();
                      
        }
        
        return geneList;
    }
    
    public void testFindAllGenes(){
        String DNA="AATGCTAACTAGCTGACTAAT";
        StorageResource result= getAllGenes(DNA);
        for (String g: result.data()){
            System.out.println(g);
        }
               
     
    }
    
    public float cgRatio(String dna){
              
        int count=0;
        int cIndex= dna.indexOf("C");
        int gIndex= dna.indexOf("G");
        while(cIndex!=-1 || gIndex!=-1){          
                      
           if    (cIndex!=-1){
               count=count+1;
               cIndex=dna.indexOf("C",cIndex+1);
            } 
           if    (gIndex!=-1){
               count=count+1;
               gIndex=dna.indexOf("G",gIndex+1);
            }  
           System.out.println(cIndex);
           System.out.println(gIndex);
           //cIndex=dna.indexOf("C",cIndex+1);
           //gIndex=dna.indexOf("G",gIndex+1);
        }
            
            
        System.out.println(count);
        System.out.println("***");
        float ratio=(float)(count)/dna.length();
        return ratio;
    
    
    }
    
    public void testCgRatio(){
        String DNA="AC";
        float result= cgRatio(DNA);
        System.out.println(result);
        }
 }
    
    



