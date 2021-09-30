/**
 * APCS Problem Set 2-A
 *
 * Victor Yao
 * 9/29/2021
 **/

class Calculator
{   
    //store arguments in arrays
    int[] qdrtcArgs = {1, 5, 6},
          coords1 = {0, 0, 2, 3},
          coords2 = {0, 0, 2, 3},
          aSrsArgs = {5, 1, 1},
          gSrsArgs = {3, 3, 2};
          
    public void display()
    {
        /** calculate results and store in variables **/
        
        double slope = slope(coords1),
               aSrs = arithmeticSeries(aSrsArgs),
               gSrs = geometricSeries(gSrsArgs);
               
        double[] qdrtcRoots = quadratic(qdrtcArgs),
                 midpointCoords = midpoint(coords2);
        
        /** print results in expected format **/
        
        System.out.println("QUADRATIC FORMULA\n" +
                           "The solutions for " + qdrtcArgs[0] + "x^2 + " + qdrtcArgs[1] + "x + " + qdrtcArgs[2] +" are " + qdrtcRoots[0] + " and " + qdrtcRoots[1] + ".\n\n" +
                           
                           "SLOPE FORMULA\n" +
                           "A line connecting the points (" + coords1[0] + ", " + coords1[1] + ") and (" + coords1[2] + ", " + coords1[3] + ") has a slope of " + slope + "\n\n" +
                           
                           "MIDPOINT FORMULA\n" +
                           "The midpoint between (" + coords2[0] + ", " + coords2[1] + ") and (" + coords2[2] + ", " + coords2[3] + ") is (" + midpointCoords[0] + ", " + midpointCoords[1] + ")\n\n" +
                           
                           "SUM OF AN ARITHMETIC SERIES\n" + 
                           "The sum of the first " + aSrsArgs[0] + " terms of an arithmetic series that starts with " + aSrsArgs[1] + "\n" +
                           "and increases by " + aSrsArgs[2] + " is " + aSrs + "\n\n" +
                           
                           "SUM OF A FINITE GEOMETRIC SERIES\n" + 
                           "The sum of the first " + gSrsArgs[0] + " terms of a finite geometric series that starts with " + gSrsArgs[1] + "\n" +
                           "and increases by a rate of " + gSrsArgs[2] + " is " + gSrs);
    }
    
    private double[] quadratic(int[] args)
    {
        //the polynomial is ax^2 + bx + c
        double a = args[0], b = args[1], c = args[2];
        //apply the quadratic formula to determine the roots and return as an array
        return new double[] { (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a),
                              (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a) };        
    }
    
    private double slope(int[] coords)
    {
        //the two points are (x1, y1) and (x2, y2)
        double x1 = coords[0], y1 = coords[1], x2 = coords[2], y2 = coords[3];
        //apply slope formula to determine and return the slope
        return (y2 - y1) / (x2 - x1);
    }
    
    private static double[] midpoint(int[] coords)
    {
        //the two points are (x1, y1) and (x2, y2)
        double x1 = coords[0], y1 = coords[1], x2 = coords[2], y2 = coords[3];
        //apply midpoint formula to determine the midpoint (x, y) and return as an array        
        return new double[] { (x1 + x2) / 2, (y1 + y2) / 2 };
    }
    
    private static double arithmeticSeries(int[] args)
    {
        //                         k
        //the arithmetic series is Σ(a + d * (n - 1))
        //                        n=1
        double k = args[0], a = args[1], d = args[2];
        //apply the arithmetic series formula to determine and return the sum        
        return k / 2 * (2 * a + (k - 1) * d);
    }
    
    private static double geometricSeries(int[] args)
    {
        //                        k
        //the geometric series is Σ(g * r^(n - 1)), where:
        //                       n=1
        double k = args[0], g = args[1], r = args[2];
        //apply the geometric series formula to determine and return the sum        
        return g * (Math.pow(r, k) - 1) / (r - 1);
    }
}
