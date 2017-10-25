package test;

import java.math.BigDecimal;

public class merge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String AcqPayFee="0100";
		String AcqIncFee="0200";
		String PaymentFee="0300";
		String IncomeFee="0400";
		String CardholderFee="C0400";
		BigDecimal serviceFee=BigDecimal.valueOf(Double.valueOf(AcqPayFee)/100)
            	.subtract(BigDecimal.valueOf(Double.valueOf(AcqIncFee)/100))
            	.add(BigDecimal.valueOf(Double.valueOf(PaymentFee)/100))
            	.subtract(BigDecimal.valueOf(Double.valueOf(IncomeFee)/100))
            	.add(BigDecimal.valueOf(Double.valueOf(CardholderFee.substring(0,1).equals("D")?"+"+CardholderFee.substring(2):"-"+CardholderFee.substring(2))/100));

		System.out.println(BigDecimal.valueOf(Double.valueOf(0)).subtract(serviceFee));
		String stra="商户类型                        1-公司商户 2-个体商户 3-无执照商户，必填         ";
		String strb=stra.replace(" ", "");
		System.out.println(stra.trim()+"end");
		System.out.println(strb+"end");
	}

}
