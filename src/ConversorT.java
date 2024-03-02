
public class ConversorT {
	public double redondeo(double n) {
		return (Math.floor(n) + (Math.round((n-Math.floor(n))*10000)/10000.0));
	}
	public double CAF(double c) {
		return redondeo((c*9/5)+32);
	}
	public double CAK(double c) {
		return redondeo(c+273.15);
	}
	public double CAR(double c) {
		return redondeo((c*9/5)+491.67);
	}
	public double FAC(double f) {
		return redondeo((f-32)*5/9);
	}
	public double FAK(double f) {
		return redondeo(((f-32)*5/9)+273.15);
	}
	public double FAR(double f) {
		return redondeo(f+459.67);
	}
	public double KAC(double k) {
		return redondeo(k-273.15);
	}
	public double KAF(double k) {
		return redondeo(((k-273.15)*9/5)+32);
	}
	public double KAR(double k) {
		return redondeo(k*9/5);
	}
	public double RAC(double r) {
		return redondeo((r-491.67)*5/9);
	}
	public double RAF(double r) {
		return redondeo(r-459.67);
	}
	public double RAK(double r) {
		return redondeo(r*5/9);
	}
}
