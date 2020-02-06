package sort;

import java.util.Random;

import util.Util;

public class ShellSort extends Util {

	public ShellSort(int[] array) {
		super(array);
	}

	public void sort() { // �μ��� ������ ��ü ����
		sort(0, array.length - 1);
	}

	public void sort(int left, int right) { // left ~ right ���� ����
		sort(left, right, (int) array.length / 2);
	}

	public void sort(int left, int right, int gap) {
		int i, currentV;

		for (i = gap; i <= right; i++) {
			currentV = i;

			// ���ݺ��� �������� �ʰ� ����, ���� �׷��� ���� ���� ��
			while (currentV >= gap && array[currentV - gap] > array[currentV]) {
				swap(currentV, currentV - gap);
				currentV = currentV - gap;
			}
		}

		if (gap > 1) { // ���� 1�� �ɶ����� �ݺ�
			printArray();
			sort(left, right, gap / 2); // ����Լ�
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
		ShellSort s = new ShellSort(array);

		s.startSort(); // ���� ����

		System.out.println("\nverification : " + s.verify(0, size) + ", swap : " + s.getSwapN());
	}

}
