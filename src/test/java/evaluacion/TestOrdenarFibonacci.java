package evaluacion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestOrdenarFibonacci {

	@Test
	public void test() {
		int[] numToOrder = new int[] { 89, 5, 21, 7, 144, 7, 34, 233, 55 };
		Arrays.parallelSort(numToOrder);
		List<Integer> numsFibonacci = new ArrayList<Integer>();
		genNum(numsFibonacci, 0, 1);
		numsFibonacci.forEach(item->{
			System.out.println("fibonacci="+item);
		});
		List<Integer> finalList = new ArrayList<Integer>();
		for (int num : numToOrder) {
			if (foundInList(num, numsFibonacci)) {
				finalList.add(num);
			}
		}
		
		finalList.forEach(item -> {
			System.out.println("list item is=" + item);
		});
	}

	private void genNum(List<Integer> nums, int base, int next) {
		int newNum = base + next;
		nums.add(newNum);
		if (newNum > 233) {
			return;
		}
		genNum(nums, next, newNum);
	}

	private boolean foundInList(int num, List<Integer> fibonacci) {
		return fibonacci.parallelStream().filter(item -> item == num).count() > 0;
	}
}
