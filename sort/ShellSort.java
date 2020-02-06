package sort;

import java.util.Random;

import util.Util;

public class ShellSort extends Util {

	public ShellSort(int[] array) {
		super(array);
	}

	public void sort() { // 인수가 없으면 전체 정렬
		sort(0, array.length - 1);
	}

	public void sort(int left, int right) { // left ~ right 까지 정렬
		sort(left, right, (int) array.length / 2);
	}

	public void sort(int left, int right, int gap) {
		int i, currentV;

		for (i = gap; i <= right; i++) {
			currentV = i;

			// 간격보다 내려가지 않게 조정, 같은 그룹의 이전 값과 비교
			while (currentV >= gap && array[currentV - gap] > array[currentV]) {
				swap(currentV, currentV - gap);
				currentV = currentV - gap;
			}
		}

		if (gap > 1) { // 갭이 1이 될때까지 반복
			printArray();
			sort(left, right, gap / 2); // 재귀함수
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

		s.startSort(); // 정렬 시작

		System.out.println("\nverification : " + s.verify(0, size) + ", swap : " + s.getSwapN());
	}

}
