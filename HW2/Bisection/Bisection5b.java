import java.math.BigDecimal;

public class Bisection5b {
	public static void main(String[] args) {
		BigDecimal one = new BigDecimal(".00001");
		BisectionAlgo(0,1,one,1000);
	}

	public static void BisectionAlgo(double start, double end, BigDecimal accuracy, int maxSteps) {
		double low = start;
		double high = end;
		double intial = doMath(start);
		int steps = 0;
		double mid = 0;
		double tempAnswer = 0;


		if((intial >= 0 && doMath(high) <= 0 ) || (intial <= 0 && doMath(high) >= 0 )){
		while ((high-low) >= accuracy.doubleValue()) {
			mid = (high + low) / 2;
			tempAnswer = doMath(mid);
			System.out.println("step: "+ steps + "    MidPoint: " + tableRound(mid,(countDecimalPlaces(accuracy))));
			if (tempAnswer == 0 || ((high - low) / 2) < accuracy.doubleValue()) {
				System.out.println("------------------------------");
				System.out.println("Total Number of Steps: " + steps);
				System.out.println("The root of the function is: " + tableRound(mid,(countDecimalPlaces(accuracy))));
				break;
			}
			steps++;
			if (intial * tempAnswer > 0) {
			    low = mid;
			    intial = tempAnswer;
			} else {
			    high = mid;
			}
		}
		}else{
			System.out.println("The interval are not opposite signs, therefore the algorithm can't run");
		}
	}
	
	public static int countDecimalPlaces(BigDecimal num) {
		String string = num.stripTrailingZeros().toPlainString();
	    int index = string.indexOf(".");
	    return index < 0 ? 0 : string.length() - index - 1;
	}
	public static double doMath(double x) {
		return (Math.pow(Math.E, x) - Math.pow(x, 2) + 3 * (x) - 2);
	}
	public static double tableRound(double n, int digits) {
	    return BigDecimal.valueOf(n).setScale(digits,BigDecimal.ROUND_HALF_DOWN).doubleValue();
	}
}