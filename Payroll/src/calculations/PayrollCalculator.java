package calculations;

public class PayrollCalculator{
	public static double prsi, tc, scop, paye, usc;
	public static double usc1, usc2, usc3, usc4;
	
	public static double payeCalculate(double pay, String status){
		if(status.equals("married")){
			tc = 4950.00;
			scop = 44300.00;
			
			if(pay > scop){
				paye = ((scop * 0.2) + ((pay - scop) * 0.4)) - tc;
			}
			if(pay < scop){
				paye = (pay * 0.2) - tc;
			}
		}
		if(status.equals("single")){
			tc = 3300.00;
			scop = 35300.00;
			
			if(pay > scop){
				paye = ((scop * 0.2) + ((pay - scop) * 0.4)) - tc;
			}
			if(pay < scop){
				paye = (pay * 0.2) - tc;
			}
		}
		return paye;
	}
	
	public static double uscCalculate(double pay){
		if(pay < 13000.00){
			return 0;
		}
		if(pay < 70044.00 && pay < 20687){
			usc1 = (12012 / 100) * 0.5;
			usc2 = (pay - 12012) * 0.02;
			usc4 = usc1 + usc2;
		}
		if(pay < 70044.00 && pay > 20687){
			usc1 = (12012 / 100) * 0.5;
			usc2 = (20687 - 12012) * 0.02;
			usc3 = (pay - 20687 - 12012) * 0.045;
			usc4 = usc1 + usc2 + usc3;
		}
		if(pay > 70044.00){
			usc1 = (12012 / 100) * 0.5;
			usc2 = (20687 - 12012) * 0.02;
			usc3 = (70044 - 20687 - 12012) * 0.045;
			pay = (pay - (70044 - 20687 - 12012)) * 0.08;
			usc4 = pay + usc1 + usc2 + usc3;
		}
		return usc4;
	}
	
	public static double prsiCalculate(double pay){
		return pay * 0.04;
	}

	public static void main(String[] args) throws Exception{
		String status = "married";
		double pay = 55000.00;
		double prsi = PayrollCalculator.prsiCalculate(pay);
		double paye = PayrollCalculator.payeCalculate(pay, status);
		double usc = PayrollCalculator.uscCalculate(pay);
		System.out.println("Status : " + status);
		System.out.println("Salary : €" + pay);
		System.out.println("PRSI   : €" + prsi);
		System.out.println("PAYE   : €" + paye);
		System.out.println("USC    : €" + usc);
	}
}