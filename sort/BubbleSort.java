package sort;

import java.util.Random;

import util.Util;

public class BubbleSort extends Util {

	public BubbleSort(int[] array) {
		super(array);
	}

	public void sort() { // 범위를 정하지 않으면 전체
		sort(0, array.length - 1);
	}

	public void sort(int left, int right) { // left ~ right까지 버블 정렬
		int i;
		for (i = left; i < right; i++) {
//			printArray();
			if (array[i] > array[i + 1]) { // i와 i+1비교
				swap(i, i + 1); // i < i+1 이 되게 자리 바꿈
			}
		}

		if (right - left > 1) {
			sort(left, right - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size = 10;
		int array[] = new int[size];

		Random rand = new Random();
		for (int i = 0; i < size; i++) {
			array[i] = rand.nextInt(100);
		}
		BubbleSort s = new BubbleSort(array);

		System.out.println("Bubble Sort\n");
		System.out.println("before sorting");
		s.printArray();

		s.sort();

		System.out.println("\nafter sorting");
		s.printArray();

		System.out.println("\nverification : " + s.verify(0, size) + ", swap : " + s.getSwapN());
	}
}