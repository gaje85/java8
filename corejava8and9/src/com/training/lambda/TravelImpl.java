package com.training.lambda;

public class TravelImpl{
	
	public TravelImpl(){
		
		/*Travel travel = new Travel() {
			
			@Override
			public int count() {
				return 100;
			}
		};*/
		
		//int count  = travel.count();
		// 1 Lamdba expression for an SAM interface
		
		Travel travelLambda = (len,desc) -> len + 100 ;
		int result = travelLambda.count(100, "simple");
		System.out.println(result);
	/*	Travel travelLambdaOne = () -> {
			return 100;
		};*/
		
	}
public static void main(String[] args) {
	TravelImpl impl = new TravelImpl();
}
}
