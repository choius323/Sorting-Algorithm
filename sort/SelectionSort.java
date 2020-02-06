package sort;

import java.util.Random;

import util.Util;

public class SelectionSort extends Util {
	
	public SelectionSort(int[] array) {
		super(array);
	}

	public void sort() { // �μ��� ������ ��ü ����
		sort(0, array.length - 1);
	}

	public void sort(int left, int right) { // left ~ right ���� ����
		int min = left; // �ּڰ�

		for (int i = left + 1; i <= right; i++) { // left ~ right ���� ��
			if (array[min] > array[i]) { // �ּڰ� ����
				min = i;
			}
		}
		swap(left, min); // left�� right�� �ڸ� �ٲ�

		if (right - left > 1) {
			printArray();
			sort(left + 1, right); // left ������ �迭 ����
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
