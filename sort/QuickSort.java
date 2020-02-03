package sort;

import java.util.Random;

import util.Util;

public class QuickSort extends Util{

	public QuickSort(int[] array) {
		super(array);
	}

	public void sort() { // ������ ������ ������ ��ü
		sort(0, array.length - 1);
	}

	public void sort(int left, int right) { // left ~ right��° ���Ҹ� ����
		int a = left + 1, b = right;
		int p = findMedian(left, left + (right - left) / 2, right); // �Ǻ� ��ġ ����
		if (left != p) {
			swap(left, p); // �Ǻ��� ó�� ��ġ�� �̵�
			p = left;
		}

		do { // �Ǻ����� ���� ���ڸ� ����, ū ���ڸ� ���������� �̵�
//			printArray();

			// ���ʿ� �Ǻ����� ū ���ڰ� �ִ��� Ȯ��
			while (a < right && array[a] <= array[p]) {
				a++;
			}
			// �����ʿ� �Ǻ����� ���� ���ڰ� �ִ��� Ȯ��
			while (b > left + 1 && array[p] < array[b]) {
				b--;
			}
			if (a <= b)
				swap(a++, b--); // ���ʰ� ������ �̵�
		} while (a <= b);

		if (array[p] > array[a - 1])
			swap(a - 1, p); // �Ǻ��� ���� ��ġ�� �̵�

		// ��� �Լ��� �Ǻ��� ���ʰ� �������� ������ ȣ��
		if (left < a - 2)
			sort(left, a - 2);
		if (a < right)
			sort(a, right);
	}

	public int findMedian(int l, int m, int r) { // �߾Ӱ� Ȯ��
		int L = array[l], M = array[m], R = array[r];

		if (L > R) {
			if (M > L)
				return l; // M > L > R
			else if (M > R)
				return m; // L > M > R
			else
				return r; // L > R > M
		} else {
			if (M > R)
				return r; // M > R > L
			else if (L > M)
				return l; // R > L > M
			else
				return m; // R > M > L
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
		QuickSort s = new QuickSort(array);

		System.out.println("Quick Sort Using Median as Pivot\n");
		System.out.println("before sorting");
		s.printArray();
		
		s.sort();
		
		System.out.println("\nafter sorting");
		s.printArray();
		
		System.out.println("\nverification : " + s.verify(0, size) + ", swap : " + s.getSwapN());
	}
}
