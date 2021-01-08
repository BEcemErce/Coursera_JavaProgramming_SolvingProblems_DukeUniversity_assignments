
/**
 * Write a description of BabyBirths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class BabyBirths {
    public void printNames () {
        FileResource fr = new FileResource();
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            if (numBorn <= 100) {
                System.out.println("Name " + rec.get(0) +
                           " Gender " + rec.get(1) +
                           " Num Born " + rec.get(2));
            }
        }
    }

    public void totalBirths (FileResource fr) {
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        int nameGirl=0;
        int nameBoy=0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            if (rec.get(1).equals("M")) {
                totalBoys += numBorn;
                nameBoy+=1;
            }
            else {
                totalGirls += numBorn;
                nameGirl+=1;
            }
        }
        System.out.println("total births = " + totalBirths);
        System.out.println("female  = " + totalGirls);
        System.out.println("male  = " + totalBoys);
        
        int totalName= nameBoy+nameGirl;
        System.out.println("total name number = " + totalName);
        System.out.println("female name number = " + nameGirl);
        System.out.println("male name number = " + nameBoy);
        
    }

    public void testTotalBirths (){
        
        FileResource fr = new FileResource();
        totalBirths(fr);
    }
    
   public int getRank(int year, String name, String gender){
       int rank=0;
        int find=0;
       FileResource fr = new FileResource("us_babynames_by_year/yob"+year+".csv");
       for (CSVRecord currentRow : fr.getCSVParser(false)){
          
           if (currentRow.get(1).equals(gender)){
               rank+=1;
               if (currentRow.get(0).equals(name)){
                
                find=1;
                break;
               }
               
           }
        }
       if (find==1){
          return rank;
       }
       else{
           return -1;
       }
    }
    
    public String getName(int year, int rank, String gender){
       FileResource fr = new FileResource("us_babynames_by_year/yob"+year+".csv");
       int rankCurrent=0;
       String name=null;
       int find=0;
       for (CSVRecord currentRow : fr.getCSVParser(false)){
          if (currentRow.get(1).equals(gender)){
               rankCurrent+=1;
               if (rankCurrent==rank){
                   name= currentRow.get(0);
                   find=1;
                   break;
                }            
          }

        }
        if (find==1){
          return name;
       }
       else{
           return "NO NAME";
       }
    }
    
    public String whatIsNameInYear(String name, int year,int newYear,String gender){
        int currentRank=getRank(year,name,gender);
        String optimalName=getName(newYear,currentRank,gender);
        return name+ " born in "+ year+" would be "+ optimalName+ " if this person was born in "+ newYear;
    }
    
    public void testWhatIsNameInYear(){
        
        System.out.println(whatIsNameInYear("Susan",1972,2014,"F"));
    }
    
    public int yearOfHighestRank(String name, String gender){
       DirectoryResource dr= new DirectoryResource();
       int highestRank=999999999;
       int find=0;
       String file=null;
       for (File f : dr.selectedFiles()){
           FileResource fr =new FileResource(f);
           int currentRank=0;
           for (CSVRecord currentRow : fr.getCSVParser(false)){
               
               if (currentRow.get(1).equals(gender)){
                   currentRank+=1;
                   if (currentRow.get(0).equals(name)){
                       find+=1;
                       break;
               }
               
               }
           }
           if(currentRank<highestRank){
               highestRank=currentRank;
               file=f.getName();
            }

    
            
        }
        if(find!=0){ 
            int index=file.indexOf("b");
            int year=Integer.parseInt(file.substring(index+1,index+5));
            return year ;
        }
        else{
            return -1;
        }
        }
        
        
   public double getAverageRank (String name, String gender){
       DirectoryResource dr= new DirectoryResource();
       int fileNumber=0;
       double total=0;
       for (File f : dr.selectedFiles()){
           FileResource fr =new FileResource(f);
           int rank=0;           
           for (CSVRecord currentRow : fr.getCSVParser(false)){          
               if (currentRow.get(1).equals(gender)){
                   rank+=1;
                   if (currentRow.get(0).equals(name)){
                       total+=rank;
                       fileNumber+=1;
                       break;
                    }            
           }
           }
        }
       if (fileNumber!=0){
          return total/fileNumber;
       }
       else{
          return -1.0;
       }
       
    }  
   public int getTotalBirthsRankedHigher (int year,String name, String gender){
       int totals=0;
       int find=0;
       FileResource fr = new FileResource("us_babynames_by_year/yob"+year+".csv");
       for (CSVRecord currentRow : fr.getCSVParser(false)){
          
          
          if (currentRow.get(1).equals(gender)){
                totals+=Integer.parseInt(currentRow.get(2));
                   
          }
          if (currentRow.get(0).equals(name)){
               find=1;
               totals-=Integer.parseInt(currentRow.get(2));
               break;
          }    
           
        }
       if (find==1){
          return totals;
       }
       else{
           return -1;
       }
    
    
   }
}  
