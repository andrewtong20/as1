/*
 This class takes the user's inputted radius and finds the area, circumference if it is a circle and the volume and surface area if it is a sphere.
 */
package as1;

public class circle {
    //instance field declarations
    private double radius;
    private double x;
    private double y;
    private double area;
    private double circum;
    private double volume;
    private double surface;
    
    //default constructor
    public circle ()
    {
    radius=0;
    }
    
     //Mutator
    public void  setRadius (double inRadius)  
    {
        radius = inRadius;
    }
    
    //Parameter Constructor
    public circle(double inRadius)
    {
        radius=inRadius;
    }
    
    //Accessors
    public double getArea ()
    {
        area=Math.PI*Math.pow(radius, 2);//instructions say to calculate math in class
        return area;
           
    }
    
    public double getCircum ()
    {
        circum=2*Math.PI*radius;//instructions say to calculate math in class
        return circum;
    }        
    
    public double getVolume() 
    {
       volume=4*Math.PI*Math.pow(radius, 3)/3;//instructions say to calculate math in class
       return volume;
    }
    
    public double getSurface()
    {
        surface=4*Math.PI*Math.pow(radius, 2);//instructions say to calculate math in class
        return surface;
    }
}

