package pimco.com.codetask;

public class ProfitLossTestImpl implements IObjectTest<Double>{

	public boolean test(Double profit) {
		if(profit>0){
			return true;
		}
		return false;
	}

}
