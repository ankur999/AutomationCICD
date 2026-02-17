package ankurgoyal.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	//after failure it will a=come to this block
	int count=0;
	int maxTry=1;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<maxTry) {
			
			count++;
			return true;
		}
		
		return false;
	}
	
	

}
