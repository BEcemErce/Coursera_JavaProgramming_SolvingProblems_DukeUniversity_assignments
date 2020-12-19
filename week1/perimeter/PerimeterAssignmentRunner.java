import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int numPoints=0;
        for (Point currPt : s.getPoints()){
            numPoints= numPoints+1;
        }
        return numPoints;
    }

    public double getAverageLength(Shape s) {
        double avgLength=0;
        avgLength= getPerimeter(s)/getNumPoints(s);
        return avgLength;
    }

    public double getLargestSide(Shape s) {
         Point prevPt = s.getLastPoint();
         double largeSide =0;
        for (Point currPt : s.getPoints()) {
            double dist = prevPt.distance(currPt);
            if (dist > largeSide){
                largeSide= dist;    
        }
        prevPt = currPt;
        
    }
    return largeSide;}

    public double getLargestX(Shape s) {
        Point prevPt = s.getLastPoint();
        double largeX=0.0;
        int prevX = prevPt.getX();
        for (Point currPt : s.getPoints()) {
            int currX = currPt.getX();
            if (currX > prevX){
                largeX= currX;    
        }
        prevPt = currPt;
        
    }
    return largeX;}

    public double getLargestPerimeterMultipleFiles() {
        DirectoryResource dr = new DirectoryResource();
        double largestPer=0;
        for (File f : dr.selectedFiles()) {
             FileResource fr = new FileResource();
             Shape s= new Shape(fr);
             double currPerimeter= getPerimeter(s);
             
             if (currPerimeter > largestPer){
                 largestPer = currPerimeter;
        }
    }
    return largestPer;
    }

    public String getFileWithLargestPerimeter() {
        DirectoryResource dr = new DirectoryResource();
        double largestPer=0.0;
        File temp = null;  
        
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource();
            Shape s= new Shape(fr);
            double currPerimeter= getPerimeter(s);
             if (currPerimeter > largestPer){
                 temp= f;
        }
    }
    return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int pointNum= getNumPoints(s);
        double avgLength= getAverageLength(s);
        double largeSide= getLargestSide(s);
        double largeX= getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("number of points = " + pointNum);
        System.out.println("average length = " + avgLength);
        System.out.println("largest Side = " + largeSide);
        System.out.println("largest x = " + largeX);
    }
    
    public void testPerimeterMultipleFiles() {
        double largestPerimeter= getLargestPerimeterMultipleFiles();
        System.out.println("largest perimeter = " + largestPerimeter);
        String filename= getFileWithLargestPerimeter();
        System.out.println("file name = " + filename);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
