import java.math.BigDecimal;

public class NewtonsMethod{
    public static void main(String[] args) {
        BigDecimal one = new BigDecimal(".00000000001");
        Newton(1,10000,one);
    }
    public static void Newton(double p, int maxSteps, BigDecimal accuracy){
        int i = 0;
        double p0 = p;
        double p1;
        while( i < maxSteps){
            p1 = p0 - (doMath(p0) / doMathDer(p0));
            System.out.println("step: " + i + " value: " + tableRound(p1, (countDecimalPlaces(accuracy))));
            if(Math.abs(p1-p0) < accuracy.doubleValue()){
                System.out.println("------------------------------");
				System.out.println("Total Number of Steps: " + i);
				System.out.println("The root of the function is: " + tableRound(p1,(countDecimalPlaces(accuracy))));
                return;
            }
            i++;
            p0 = p1;
        }
    }
    
    
    public static int countDecimalPlaces(BigDecimal num) {
		String string = num.stripTrailingZeros().toPlainString();
	    int index = string.indexOf(".");
	    return index < 0 ? 0 : string.length() - index - 1;
	}
	public static double doMath(double x) {
	    return (Math.pow(Math.E, x) + Math.pow(2, -x) + 2 * Math.cos(x) - 6);
	}
	public static double doMathDer(double x) {
	    return (Math.pow(Math.E, x) - Math.log(2)*Math.pow(2, -x) - 2 * Math.sin(x));
	}
	public static double tableRound(double n, int digits) {
	    return BigDecimal.valueOf(n).setScale(digits,BigDecimal.ROUND_HALF_DOWN).doubleValue();
	}
}