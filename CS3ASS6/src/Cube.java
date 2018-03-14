public class Cube extends Square
{       
    private double depth, surfaceArea, volume;
    public Cube(double lngth, double wdth, double deph){
        super(lngth, wdth);
        depth=deph ;
    }
    
    public void setDepth(double dep){
        depth = dep;
    }
    
    public double getDepth(){
        return depth;
    }
    
    public double getSurfaceArea(){
        return surfaceArea = 2 * (width+length) + 2*(width+depth) + 2*(length+depth);
    }
    
    public double getVolume(){
        return volume = super.getSurfaceArea()*depth;
    }
    
    public String getDisplay()
    {
        if (getSurfaceArea()>0){
            return String.format ("\nThe total surface area of the cube is %.2f, \n\n The volume of this cube is %.2f" , getSurfaceArea(), getVolume());
        }
        else {
            return String.format ("This Cube can not exist.");
        }
    }
    
}
