package pl.jaceksysiak.spring.basics.springin5steps;

import org.springframework.stereotype.Component;

@Component
public class QuickSortAlgorithm implements SortAlgorithm {
	public int[] sort(int[] numbers) {
		// Logic for Quick Sort
		System.out.println("Logic for QuickSortAlgorithm");
		return numbers;
	}
}
