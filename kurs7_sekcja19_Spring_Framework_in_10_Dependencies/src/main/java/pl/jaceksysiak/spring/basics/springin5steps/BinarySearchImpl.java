package pl.jaceksysiak.spring.basics.springin5steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl  {

	@Autowired
	private SortAlgorithm sortAlgorithm;
	
	// constructor injection
//	public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
//		this.sortAlgorithm = sortAlgorithm;
//	}
	
	public int binarySearch(int[] numbers, int numberToSearchFor) {
 
		int[] sortedNumbers = sortAlgorithm.sort(numbers);
		System.out.println(sortAlgorithm);
		// Search the array
		return 3;
	}

	//setter injection
	//
//	public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
//		this.sortAlgorithm = sortAlgorithm;
//	}
	
//	public SortAlgorithm getSortAlgorithm() {
//		return sortAlgorithm;
//	}


}