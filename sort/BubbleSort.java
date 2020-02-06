package sort;

import java.util.Random;

import util.Util;

public class BubbleSort extends Util {
	int maxSwapIndex; // swap�� �ؾ��ϴ� ������ �ε���

	public BubbleSort(int[] array) {
		super(array);
		maxSwapIndex = array.length - 1;
	}

	public void sort() { // ������ ������ ������ ��ü
		sort(0, array.length - 1);
	}

	public void sort(int left, int right) { // left ~ right���� ���� ����
		int i, lastSwap = maxSwapIndex;
		boolean isSwap = false; // ������ �ѹ��� �������� ���ȣ�� X

		for (i = left; i < right; i++) {
			if (array[i] > array[i + 1] && i < maxSwapIndex) { // i�� i+1��
				lastSwap = i;
				isSwap = true;
				swap(i, i + 1); // i < i+1 �� �ǰ� �ڸ� �ٲ�
			}
		}
		maxSwapIndex = lastSwap;

		if (right - left > 1 && isSwap == true) {
			printArray();
			sort(left, right - 1); // ���ȣ��
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