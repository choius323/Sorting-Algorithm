package sort;

import java.util.Random;

import util.Util;

public class SelectionSort extends Util {
	
	public SelectionSort(int[] array) {
		super(array);
	}

	public void sort() { // 인수가 없으면 전체 정렬
		sort(0, array.length - 1);
	}

	public void sort(int left, int right) { // left ~ right 까지 정렬
		int min = left; // 최솟값

		for (int i = left + 1; i <= right; i++) { // left ~ right 까지 비교
			if (array[min] > array[i]) { // 최솟값 저장
				min = i;
			}
		}
		swap(left, min); // left와 right의 자리 바꿈

		if (right - left > 1) {
			printArray();
			sort(left + 1, right); // left 이후의 배열 정렬
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
		SelectionSort s = new SelectionSort(array);

		s.startSort();
		
		System.out.println("\nverification : " + s.verify(0, size) + ", swap : " + s.getSwapN());
	}

}
