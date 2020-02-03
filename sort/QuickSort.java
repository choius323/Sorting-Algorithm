package sort;

import java.util.Random;

import util.Util;

public class QuickSort extends Util{

	public QuickSort(int[] array) {
		super(array);
	}

	public void sort() { // 범위를 정하지 않으면 전체
		sort(0, array.length - 1);
	}

	public void sort(int left, int right) { // left ~ right번째 원소를 정렬
		int a = left + 1, b = right;
		int p = findMedian(left, left + (right - left) / 2, right); // 피봇 위치 지정
		if (left != p) {
			swap(left, p); // 피봇을 처음 위치로 이동
			p = left;
		}

		do { // 피봇보다 작은 숫자를 왼쪽, 큰 숫자를 오른쪽으로 이동
//			printArray();

			// 왼쪽에 피봇보다 큰 숫자가 있는지 확인
			while (a < right && array[a] <= array[p]) {
				a++;
			}
			// 오른쪽에 피봇보다 작은 숫자가 있는지 확인
			while (b > left + 1 && array[p] < array[b]) {
				b--;
			}
			if (a <= b)
				swap(a++, b--); // 왼쪽과 오른쪽 이동
		} while (a <= b);

		if (array[p] > array[a - 1])
			swap(a - 1, p); // 피봇을 원래 위치로 이동

		// 재귀 함수로 피봇의 왼쪽과 오른쪽을 나눠서 호출
		if (left < a - 2)
			sort(left, a - 2);
		if (a < right)
			sort(a, right);
	}

	public int findMedian(int l, int m, int r) { // 중앙값 확인
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
