
/**
 * Write a description of export here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class export {
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        parser = fr.getCSVParser();
        countryInfo(parser,"Nauru");
        parser = fr.getCSVParser();
        listExportersTwoProducts(parser,"gold","diamonds");
        parser = fr.getCSVParser();
        System.out.println(numberOfExporters(parser,"sugar"));
        parser = fr.getCSVParser();
        bigExporters(parser,"$999,999,999,999");
    }
    
    public void countryInfo(CSVParser parser, String country){
        for(CSVRecord record: parser){
            String countryInfo=record.get("Country");
            if (countryInfo.contains(country)) {
                System.out.print(country + ": ");
                System.out.print(record.get("Exports") + ": ");
                System.out.println(record.get("Value (dollars)") + ": ");
            }
        }
       
    }
    public void listExportersTwoProducts (CSVParser parser, String exportItem1, String exportItem2 ){
        for (CSVRecord record : parser){
            String item=record.get("Exports");
            if (item.contains(exportItem1)&& item.contains(exportItem2)){
                String country=record.get("Country");
                System.out.println(country);
            }
            
        }
    }
    
    public int numberOfExporters(CSVParser parser, String exportItem){
        int count=0;
        for (CSVRecord record: parser){
            String item=record.get("Exports");
            if(item.contains(exportItem)){
                count+=1;
            }
        }
        return count;
    }
    
    public void bigExporters(CSVParser parser,String amount){
        int lenAmount=amount.length();
        for (CSVRecord record: parser){
            String value= record.get("Value (dollars)") ;
            if (value.length()>lenAmount)
            {
                System.out.print(record.get("Country") + " ");
                System.out.println(record.get("Value (dollars)"));
            }
        }
    }


}
