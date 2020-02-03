package sort;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import util.Util;

public class RadixSortLSD extends Util {
	final static int decimal = 10; // 10진수
	final static int maxDigit = 3; // 최대 자릿수 (0 ~ 999)
	Queue<Integer>[] q = new LinkedList[decimal]; // 기수 별 0 ~ 9 까지 저장할 큐

	public RadixSortLSD(int[] array) {
		super(array);
	}

	public void sort(int d) { // 인수가 없으면 전체 정렬
		sort(d, 0);
	}

	public void sort(int d, int r) { // d = 최대 자릿수, r = 계산할 자릿수
		int size = array.length;
		int i;
		for (i = 0; i < decimal; i++) { //
			q[i] = new LinkedList<Integer>(); // 기수 별 큐 생성
		}

		int currentR;
		for (i = 0; i < size; i++) {
			currentR = (int) ((array[i] % Math.pow(10, r + 1)) / Math.pow(10, r)); // array[i]의 기수
			q[currentR].add(array[i]); // 해당 기수에 값 저장
		}

		int radix = 0;
		i = 0;
		while (i < size) {
			while (q[radix].isEmpty() == true) { // 기수가 비었는지 확인
				radix++;
			}
			if (radix < decimal)
				array[i++] = q[radix].poll(); // 기수별로 정렬해서 배열에 다시 저장
		}
		
		printArray();
		if (r < maxDigit - 1)
			sort(d, r + 1); // 함수 재귀호출
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int size = 10;
		int array[] = new int[size];

		Random rand = new Random();
		for (int i = 0; i < size; i++) {
			array[i] = rand.nextInt((int) Math.pow(10, maxDigit)); // 정렬할 배열 생성
		}
		RadixSortLSD s = new RadixSortLSD(array);

		System.out.println("Radix Sort\n");
		System.out.println("before sorting");
		s.printArray();

		System.out.println("\nSorting...");
		s.sort(maxDigit);

		System.out.println("\nafter sorting");
		s.printArray();

		System.out.println("\nverification : " + s.verify(0, size));
	}

}
