public class Lagrange{
    public static void main(String[] args) {
        double [][] values = {{-1,.86199480},{-0.5,.95802009},{0,1.0986123},{0.5,1.2943767}};
        
        thridDegree(values);
        
    }
    
    public static void thridDegree(double [][] values){
        String l0 = lx("x0","x","x1", "x2", "x3");
        String l1 = lx("x1","x","x0", "x2", "x3");
        String l2 = lx("x2","x","x0", "x1", "x3");
        String l3 = lx("x3","x","x0", "x1", "x2");
        System.out.println("L0: "+l0);
        System.out.println("L1: "+l1);
        System.out.println("L2: "+l2);
        System.out.println("L3: "+l3);
        String y0 ="y0";
        String y1 ="y1";
        String y2 ="y2";
        String y3 ="y3";
        String p = px(l0,l1,l2,l3,y0,y1,y2,y3);
        System.out.println("p3:"+p);
        
        System.out.println("");
        System.out.println("Step 2:");
        
         l0 = lx("-1",".25","-.5", "0", ".5");
         l1 = lx("-.5",".25","-1", ".5", ".5");
         l2 = lx("0",".25","-1", "-.5", ".5");
         l3 = lx(".5",".25","-1", "-.5", "0");
        System.out.println("L0: "+l0);
        System.out.println("L1: "+l1);
        System.out.println("L2: "+l2);
        System.out.println("L3: "+l3);
         y0 =".86199480";
         y1 =".95802009";
         y2 ="1.0986123";
         y3 ="1.2943767";
         p = px(l0,l1,l2,l3,y0,y1,y2,y3);
        System.out.println("p3: "+p);
        
        
        System.out.println("");
        System.out.println("Step 3:");
        double dx = .25;
        double dx0 = -1;
        double dx1 = -0.5;
        double dx2 = 0;
        double dx3 = 0.5;
        double dy0 = .86199480;
        double dy1 = .95803009;
        double dy2 = 1.0986123 ;
        double dy3 = 1.2943767 ;
        System.out.println("p(.25) = "+ px1(dx,dx0,dx1,dx2,dx3,dy0,dy1,dy2,dy3));
     
        

    }
    public static String fx(String x, String xn, String x1){
        return "("+x+"-"+x1+")/("+xn+"-"+x1+")"; 
    }
    public static String lx(String xn, String x, String x1, String x2,String x3){
        
        return "("+fx(x,xn,x1)+" * " + fx(x,xn,x2)+" * "+ fx(x,xn,x3)+")";
    }
    public static String px(String l0, String l1, String l2, String l3, String y0, String y1, String y2, String y3){
        
        return "( ("+l0+" * "+y0+") + ("+l1+" * "+y1+") + ("+l2+" * "+y2+") + ("+l2+" * "+y2+") + "+l3+" (* "+y3+" ))";
    }
    public static double px1(double x,double x0, double x1, double x2, double x3, double y0, double y1, double y2, double y3){
        return  (((x-x1)/(x0-x1) * (x-x2)/(x0-x2) * (x-x3)/(x0-x3)) * y0) + (((x-x0)/(x1-x0) * (x-x2)/(x1-x2) * (x-x3)/(x1-x3)) * y1) + (((x-x0)/(x2-x0) * (x-x1)/(x2-x1) * (x-x3)/(x2-x3)) * y2) + (((x-x0)/(x3-x0) * (x-x1)/(x3-x1) * (x-x2)/(x3-x2)) * y3);
    }
}