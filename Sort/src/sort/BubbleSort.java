package sort;

import java.util.Random;

import util.Util;

public class BubbleSort extends Util {

	public BubbleSort(int[] array) {
		super(array);
	}

	public void sort() { // ������ ������ ������ ��ü
		sort(0, array.length - 1);
	}

	public void sort(int left, int right) { // left ~ right���� ���� ����
		int i;
		for (i = left; i < right; i++) {
//			printArray();
			if (array[i] > array[i + 1]) { // i�� i+1��
				swap(i, i + 1); // i < i+1 �� �ǰ� �ڸ� �ٲ�
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