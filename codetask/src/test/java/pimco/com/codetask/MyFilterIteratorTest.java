package pimco.com.codetask;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class MyFilterIteratorTest {

	@Test
	public void myFilterIteratorTest() {
		List<Double> list = new ArrayList<Double>();
		List<Double> filteredList = new ArrayList<Double>();

		list.add(-1d);
		list.add(3d);
		list.add(0d);
		list.add(5d);

		Iterator<Double> itr = list.iterator();
		FilteringIterator<Double> profitLossFiteringIterator = new FilteringIterator<Double>(new ProfitLossTestImpl(),
				itr);

		List<Double> expectedFilteredList = new ArrayList<Double>();
		expectedFilteredList.add(3d);
		expectedFilteredList.add(5d);

		while (profitLossFiteringIterator.hasNext()) {
			filteredList.add(profitLossFiteringIterator.next());
		}

		Assert.assertEquals(filteredList.size(), expectedFilteredList.size());
		for (int i = 0; i < filteredList.size(); i++) {
			Assert.assertEquals(filteredList.get(i), expectedFilteredList.get(i));
		}

	}

}
