package StringsSecondAssignment;

import edu.duke.*;
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public int findStopCodon(String dna, int startIndex, String stop){
        int stopIndex= dna.indexOf(stop,startIndex+3);
        while (stopIndex!= -1){
            if ((stopIndex- startIndex)%3==0){
                return stopIndex;
            }
            else{
                stopIndex= dna.indexOf(stop,stopIndex+1);
            }
        }          
        return dna.length();
        
    }
    
    public String findGene(String dna, int fromHere){
        dna=dna.toUpperCase();
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
    
    public void findAllGenes(String dna){
        dna=dna.toUpperCase();
        int startIndex = 0;
        
        while (true){
            String gene= findGene(dna,startIndex);
            if (gene.length()==0){
                break;
            }
            
            System.out.println(gene);
            System.out.println(dna.indexOf(gene));
             System.out.println(dna.indexOf(gene.length()));
            startIndex= dna.indexOf(gene,startIndex)+gene.length();
            System.out.println(startIndex);
                      
        }
        
    
    }
    
    public int countGenes(String dna){
        int startIndex = 0;
        int count=0;
        dna=dna.toUpperCase();
        while (true){
            String gene= findGene(dna,startIndex);
            if (gene.isEmpty()){
                break;
            }
            count=count+1;
            startIndex= dna.indexOf(gene,startIndex)+gene.length();
                      
        }
        
        return count;
       
    }
     public void testCountGenes(){
        String dna="oneAtGMyGeneOneAAACCCGGYGGGGTAGGGCTGCCCATGendTAAnonCodingDNATAGTGAZZZTAAtwoATGMyGeneTwoCCCCCCatgCCCFalseStartTAATGATGendtwoTAGnonCodingDNATAACCCCCCthreeATGMyGeneThreeTAAATGcendTAAnonCodingDNAccTAAfalseCCCfourATGMyGeneFourCCendTAGnonCodingDNAfiveAtgMyGeneFIVECCCCCAAACCCendTGAnonCodingDNAsiCATGmyGeneSiCATCAAAendTAAnoncodingDNAsevenATGMyGeneSevenCCCCTheNeCtGeneIsShortTooEndtaAnoncodingDNAeightATGmyGeneightCCendtaAnoncodingDNACCCCWrongCCCtgaCtaaCtagCCCeightATgmyGeneNinecccgggCCcTAAccTAAnonCodingDNACCCCtenATGmyGeneTengTAACCHasFakeATGFAKEatgcendtaanonCodingDNACtagCtgaelevenATGmyGeneElevenCCTheLastGeneIsATGTAGendtgaATGTAGC";
        System.out.println(countGenes(dna));
        
    
        
    }
    
}
