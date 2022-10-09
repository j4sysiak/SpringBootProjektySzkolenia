package pl.jaceksysiak.spring.basics.springin5steps;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BubbleSortAlgorithm implements SortAlgorithm {
	public int[] sort(int[] numbers) {
		// Logic for Bubble Sort
		System.out.println("Logic for BubbleSortAlgorithm");
		return numbers;
	}
}
