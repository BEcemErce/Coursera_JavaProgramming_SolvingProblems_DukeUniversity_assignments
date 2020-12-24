package StringsThirdAssignment;
import edu.duke.*;
import java.io.File;

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
    
      
    
    /* ************PART1************ */
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
    /* ****************PART2***************** */
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
        
     /* ***************PART3************* */   
    public void processGenes(StorageResource sr){
        //int count=0;
        //System.out.println(" STRINGS ");
        /* for (String s: sr.data()) {
            System.out.println("!!!!!!!!!"); 
            int currentLength = s.length();
            System.out.println("length: " +currentLength );
            if (currentLength > 60)
            {
               System.out.println("!!!!!!!!!"); 
               System.out.println("the String"+ s); 
               count=count+1;
            }
        }*/
       
        //System.out.println("THE NUMBER OF STRINGS (character >60 ) ="+ count);
        
        System.out.println("STRINGS C-G Ratio >0.35");
        int countCG=0;
        int count60=0;
        for (String s: sr.data()){
            if (cgRatio(s)>0.35){
               
               countCG=countCG+1;
            }
             if (s.length() > 60)
            {
               count60=count60+1;
            }
        }
        System.out.println("THE NUMBER OF STRINGS (CG>0.35) ="+ countCG);
        System.out.println("THE NUMBER OF STRINGS (character >60 ) ="+ count60);
        String longestSt= "";
        for (String s: sr.data()){
            if (s.length()>longestSt.length()){
               longestSt=s;
            }
        }
        System.out.println("THE LONGEST STRING= "+ longestSt);
        System.out.println("THE LONGEST STRING LENGTH= "+ longestSt.length());
        
    }   
        
        
        
      
    
    public void testProcessGenes(){
        FileResource fr = new FileResource();
        String dna = fr.asString().toUpperCase();
        StorageResource genes= getAllGenes(dna);
        
        processGenes(genes);
        System.out.println("genes number"+ genes.size());
    
    }
        public void GTC(){
        FileResource fr = new FileResource();
        String dna = fr.asString().toUpperCase();
        int count=0;
        int indexGTC=dna.indexOf("CTG");
        while(true){
            if (indexGTC==-1){
            break;
            }
            count+=1;
            dna=dna.substring(indexGTC+3,dna.length());
            indexGTC=dna.indexOf("CTG");
        }
        
        System.out.println(count);
 }
}
    




