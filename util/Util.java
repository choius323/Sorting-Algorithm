package util;

public abstract class Util {
	protected int[] array;
	private int swapN; // swap Ƚ��

	public Util(int[] array) {
		swapN = 0;
		this.array = array;
	}

	public void printArray() { // �迭 ���
		for (int i = 0; i < array.length - 1; i++) {
			System.out.print(array[i] + ", ");
		}
		System.out.println(array[array.length - 1]);
	}

	protected void swap(int a, int b) { // �ڸ� �ٲ�
		int temp;

		temp = array[a];
		array[a] = array[b];
		array[b] = temp;

		swapN++;
	}

	public int getSwapN() {
		return swapN;
	}

	public int[] getArray() {
		return array;
	}

	public boolean verify(int left, int right) { // ������ ����� �ƴ��� ����
		for (int i = left; i < right - 1; i++) {
			if (array[i] > array[i + 1]) { // ���� ����
				System.out.println("false!!!! Value : " + array[i]);
				printArray();
				return false;
			}
		}
		return true;
	}

	public abstract void sort();

	public void startSort() {
		System.out.println("Shell Sort\n");
		System.out.println("before sorting");
		printArray();

		System.out.println("\nsorting...");
		sort();

		System.out.println("\nafter sorting");
		printArray();
	}
}
