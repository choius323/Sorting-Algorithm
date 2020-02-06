package sort;

import java.util.Random;

import util.Util;

public class BubbleSort extends Util {
	int maxSwapIndex; // swap을 해야하는 마지막 인덱스

	public BubbleSort(int[] array) {
		super(array);
		maxSwapIndex = array.length - 1;
	}

	public void sort() { // 범위를 정하지 않으면 전체
		sort(0, array.length - 1);
	}

	public void sort(int left, int right) { // left ~ right까지 버블 정렬
		int i, lastSwap = maxSwapIndex;
		boolean isSwap = false; // 스왑을 한번도 안했으면 재귀호출 X

		for (i = left; i < right; i++) {
			if (array[i] > array[i + 1] && i < maxSwapIndex) { // i와 i+1비교
				lastSwap = i;
				isSwap = true;
				swap(i, i + 1); // i < i+1 이 되게 자리 바꿈
			}
		}
		maxSwapIndex = lastSwap;

		if (right - left > 1 && isSwap == true) {
			printArray();
			sort(left, right - 1); // 재귀호출
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

		s.startSort();

		System.out.println("\nverification : " + s.verify(0, size) + ", swap : " + s.getSwapN());
	}
}