package sort;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import util.Util;

public class RadixSortLSD extends Util {
	final static int decimal = 10; // 10����
	final static int maxDigit = 3; // �ִ� �ڸ��� (0 ~ 999)
	Queue<Integer>[] q = new LinkedList[decimal]; // ��� �� 0 ~ 9 ���� ������ ť

	public RadixSortLSD(int[] array) {
		super(array);
	}

	public void sort(int d) { // �μ��� ������ ��ü ����
		sort(d, 0);
	}

	public void sort(int d, int r) { // d = �ִ� �ڸ���, r = ����� �ڸ���
		int size = array.length;
		int i;
		for (i = 0; i < decimal; i++) { //
			q[i] = new LinkedList<Integer>(); // ��� �� ť ����
		}

		int currentR;
		for (i = 0; i < size; i++) {
			currentR = (int) ((array[i] % Math.pow(10, r + 1)) / Math.pow(10, r)); // array[i]�� ���
			q[currentR].add(array[i]); // �ش� ����� �� ����
		}

		int radix = 0;
		i = 0;
		while (i < size) {
			while (q[radix].isEmpty() == true) { // ����� ������� Ȯ��
				radix++;
			}
			if (radix < decimal)
				array[i++] = q[radix].poll(); // ������� �����ؼ� �迭�� �ٽ� ����
		}
		
		printArray();
		if (r < maxDigit - 1)
			sort(d, r + 1); // �Լ� ���ȣ��
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int size = 10;
		int array[] = new int[size];

		Random rand = new Random();
		for (int i = 0; i < size; i++) {
			array[i] = rand.nextInt((int) Math.pow(10, maxDigit)); // ������ �迭 ����
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
