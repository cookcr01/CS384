import java.math.BigDecimal;

public class SecantMethod{
    public static void main(String[] args) {
        BigDecimal one = new BigDecimal(".0000001");
        Secant(6,7,10000,one);
    }
    public static void Secant(double p0, double p1, int maxSteps, BigDecimal accuracy){
        int i = 0;
        double q0 = sixF(p0);
        double q1 = sixF(p1);
        double p;
        while( i < maxSteps){
            p = p1 - q1*(p1-p0)/(q1-q0);
            System.out.println("step: " + i + " value: " + tableRound(p, (countDecimalPlaces(accuracy))));
            if(Math.abs(p1-p0) < accuracy.doubleValue()){
                System.out.println("------------------------------");
				System.out.println("Total Number of Steps: " + i);
				System.out.println("The root of the function is: " + tableRound(p1,(countDecimalPlaces(accuracy))));
                return;
            }
            i++;
            p0 = p1;
            q0 =q1;
            p1 = p;
            q1 = sixF(p);
        }
    }
    
    
    public static int countDecimalPlaces(BigDecimal num) {
		String string = num.stripTrailingZeros().toPlainString();
	    int index = string.indexOf(".");
	    return index < 0 ? 0 : string.length() - index - 1;
	}
	public static double sixA(double x) {
	    return (Math.pow(Math.E, x) + Math.pow(2, -x) + 2 * Math.cos(x) - 6);
	}
	public static double sixB(double x) {
	    return (Math.log(x-1) + Math.cos(x-1));
	}
	public static double sixC(double x) {
	    return (2*x*Math.cos(2*x) - Math.pow(x-2,2));
	}
	public static double sixD(double x) {
	    return (Math.pow((x-2),2) - Math.log(x));
	}
	public static double sixE(double x) {
	    return (Math.pow(Math.E,x) - 3*Math.pow(x,2));
	}
	public static double sixF(double x) {
	    return (Math.sin(x) - Math.pow(Math.E,-x));
	}
	public static double tableRound(double n, int digits) {
	    return BigDecimal.valueOf(n).setScale(digits,BigDecimal.ROUND_HALF_DOWN).doubleValue();
	}
}