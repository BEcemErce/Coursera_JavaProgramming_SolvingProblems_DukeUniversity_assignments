
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
        FileResource fr = new FileResource("nc_weather/2015/weather-2015-01-02.csv");
        CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
        System.out.println("coldest temperature was " + coldest.get("TemperatureF") +
                   " at " + coldest.get("TimeEST"));
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
            }
            String humadity= currentRow.get("Humidity");
            if (humadity != "N/A"){
                int currentHumadity= Integer.parseInt(humadity);
                int lowestHumadity=Integer.parseInt(lowestHum.get("Humidity"));
                if (currentHumadity< lowestHumadity){
                    lowestHum=currentRow;
                }
            } 
        return lowestHum;
    
    }
    public CSVRecord lowestHumidityInManyFiles(){
        CSVRecord lowestHum = null;
        DirectoryResource dr = new DirectoryResource();
        
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            
            CSVRecord currentRow = lowestHumidityInFile(fr.getCSVParser());
            lowestHum=getLowest(currentRow,lowestHum);
        }

        return lowestHum;
    
    
    }
    
    public void testLowestHumidityInManyFiles(){
        CSVRecord csv = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was "+ csv.get("Humidity")+" at " + csv.get("DateUTC"));
    }
    
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
        
    }
    
}


