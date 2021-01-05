
/**
 * Write a description of weather here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class weather {
    public CSVRecord coldestHourInFile(CSVParser parser) {
        //start with largestSoFar as nothing
        CSVRecord coldestSoFar = null;
        //For each row (currentRow) in the CSV File
        for (CSVRecord currentRow : parser) {
            
            coldestSoFar=getColdest(currentRow,coldestSoFar);
        }
        //The largestSoFar is the answer
        return coldestSoFar;
    }

    public void testColdestInDay () {
        FileResource fr = new FileResource();
        CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
        System.out.println("coldest temperature was " + coldest.get("TemperatureF") +
                   " at " + coldest.get("DateUTC"));
    }

    public CSVRecord coldestInManyDays() {
        CSVRecord coldestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        // iterate over files
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            // use method to get largest in file.
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
            coldestSoFar=getColdest(currentRow,coldestSoFar);
        }
        //The largestSoFar is the answer
        return coldestSoFar;
    }
    public CSVRecord getColdest(CSVRecord currentRow, CSVRecord coldestSoFar){
        if (coldestSoFar == null) {
            coldestSoFar = currentRow;
	}
			
	else {
	       double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
	       double coldestTemp = Double.parseDouble(coldestSoFar.get("TemperatureF"));
				
	       if (currentTemp < coldestTemp && currentTemp!=-9999) {
	         coldestSoFar = currentRow;
	       }
	}
        return coldestSoFar;
       }
    
    public void testColdestInManyDays () {
        CSVRecord coldest = coldestInManyDays();
        System.out.println("coldest temperature was " + coldest.get("TemperatureF") +
                   " at " + coldest.get("DateUTC"));
    }
    
    public File fileWithColdestTemperature(){
        File fileName=null;
        CSVRecord coldestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        // iterate over files
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            // use method to get largest in file.
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
            coldestSoFar=getColdest(currentRow,coldestSoFar);
            //fileName= f.getName();
            fileName=f;
        }
        //The largestSoFar is the answer
        return fileName;
    }
    
    public void testFileWithColdestTemperature(){
        File file=fileWithColdestTemperature();
        String fileName= file.getName();
        System.out.println("Coldest day was in file" + fileName);
        CSVRecord coldestTemp= coldestInManyDays();
        System.out.println("Coldest temperature on that day was " +coldestTemp.get("TemperatureF") );
        
        FileResource fr = new FileResource(file);
        CSVParser parser= fr.getCSVParser();
        
        
        for (CSVRecord record : parser){
            System.out.print(record.get("DateUTC"));
            System.out.println(Double.parseDouble(record.get("TemperatureF")));
        }
        
    }
    
    public CSVRecord lowestHumidityInFile (CSVParser parser){
        CSVRecord lowestHum=null;
        for(CSVRecord currentRow: parser){
            lowestHum=getLowest(currentRow, lowestHum);
        }
        return lowestHum;
    }
    
    public void testLowestHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.println("Lowest Humidity was "+ csv.get("Humidity")+" at " + csv.get("DateUTC"));
    }
    public CSVRecord getLowest(CSVRecord currentRow, CSVRecord lowestHum){
        if (lowestHum == null) {
                lowestHum = currentRow;
        }else{
        String humidity= currentRow.get("Humidity");
        String lowHumidity= lowestHum.get("Humidity");
        if (!humidity.equals("N/A") && !lowHumidity.equals("N/A")){
            int currentHumidity= Integer.parseInt(humidity);
        
            int lowestHumidity=Integer.parseInt(lowestHum.get("Humidity"));
            if (currentHumidity< lowestHumidity){
                lowestHum=currentRow;
            }
        } }
        return lowestHum;
    
    }
    public CSVRecord lowestHumidityInManyFiles(){
        CSVRecord lowestHum = null;
        DirectoryResource dr = new DirectoryResource();
        
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVParser parser=fr.getCSVParser();
            CSVRecord currentRow = lowestHumidityInFile(parser);
            lowestHum=getLowest(currentRow,lowestHum);
        }

        return lowestHum;
    
    
    }
    
    public void testLowestHumidityInManyFiles(){
        CSVRecord csv = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was "+ csv.get("Humidity")+" at " + csv.get("DateUTC"));
    }
    
    public double averageTemperatureInFile (CSVParser parser){
        int count=0;
        double total=0;
        for (CSVRecord currentRow : parser){
            double Temp=Double.parseDouble(currentRow.get("TemperatureF"));
            total+=Temp;
            count+=1;
                
            }
        double Average=total/count;
        return Average;
    }
    
    public void testAverageTemperatureInFile(){
        FileResource f=new FileResource();
        CSVParser parse= f.getCSVParser();
        double average=averageTemperatureInFile(parse);
        System.out.println("Average temperature in file is "+ average);
    }    
     
        
    
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
        int count=0;
        double total=0;
        for (CSVRecord currentRow : parser){
            int humVal=Integer.parseInt(currentRow.get("Humidity"));
            
            if (humVal>=value){
                double Temp=Double.parseDouble(currentRow.get("TemperatureF"));
                total+=Temp;
                count+=1;
                
            }
        }
        
        if (count==0){
            return 0.0;
        }
        else {double Average=total/count;return Average;}
        
    }
    
    public void testAverageTemperatureWithHighHumidityInFile(){
        FileResource f=new FileResource();
        CSVParser parse= f.getCSVParser();
        int value=80;
        double Average=averageTemperatureWithHighHumidityInFile(parse,value);
        if (Average==0.0){
            System.out.println("No temperatures with that humidity");
            
        }else{
            System.out.println("Average Temp when high Humidity is "+ Average);
        }
    }
    
    
}


