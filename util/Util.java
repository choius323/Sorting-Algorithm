package util;

public class Util {
	protected int[] array;
	private int swapN; // swap 횟수

	public Util(int[] array) {
		swapN = 0;
		this.array = array;
	}

	public void printArray() { // 배열 출력
		for (int i = 0; i < array.length - 1; i++) {
			System.out.print(array[i] + ", ");
		}
		System.out.println(array[array.length - 1]);
	}

	protected void swap(int a, int b) { // 자리 바꿈
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

	public boolean verify(int left, int right) { // 정렬이 제대로 됐는지 검증
		for (int i = left; i < right - 1; i++) {
			if (array[i] > array[i + 1]) { // 정렬 실패
				System.out.println("false!!!! Value : " + array[i]);
				printArray();
				return false;
			}
		}
		return true;
	}
}
