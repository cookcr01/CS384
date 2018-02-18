public class NewtonTri{
    public static void main(String[] args) {
        double [] x = {0.0,0.1,0.3,0.6,1.0,1.1};
        double [] fx = {-6.00000, -5.89483,-5.65014, -5.17788,-4.28172,-3.99583};
        dd(x,fx);
    }
    
    public static void dd (double [] x,  double [] fx){
        int n = x.length;
        double[] result = fx.clone();
        for(int i=1; i<n; i++) {
            System.out.println("Step "+i+": ");
            System.out.println("---------------");
            for(int j=n-1; j>0; j--) {
                if(j-i>=0) {
                    result[j] = (result[j]-result[j-1])/(x[j]-x[j-i]);
                    System.out.println(result[j]);
                }
            }
            System.out.println("");
        }   
    }
}
