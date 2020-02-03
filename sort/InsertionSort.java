package sort;

import java.util.Random;

import util.Util;

public class InsertionSort extends Util { // ���� ����
	
	public InsertionSort(int[] array) {
		super(array);
	}

	public void sort() { // �μ��� ������ ��ü ����
		sort(0, array.length - 1);
	}

	public void sort(int left, int right) { // left ~ right ���� ����
		sort(left, right, left + 1);
	}

	public void sort(int left, int right, int compareI) { // i�� �����ؾ� �Ǵ� �ε���
		for (int i = compareI; i > left; i--) {
			if (array[i] < array[i - 1]) {
				swap(i, i - 1);
			}
		}

		if (compareI < right)
			sort(left, right, compareI + 1); // �Լ� ��� ȣ��
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size = 10;
		int array[] = new int[size];

		Random rand = new Random();
		for (int i = 0; i < size; i++) {
			array[i] = rand.nextInt(100);
		}
		InsertionSort s = new InsertionSort(array);

		System.out.println("Insertion Sort\n");
		System.out.println("before sorting");
		s.printArray();

		s.sort();

		System.out.println("\nafter sorting");
		s.printArray();

		System.out.println("\nverification : " + s.verify(0, size) + ", swap : " + s.getSwapN());
	}
}
