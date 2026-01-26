import java.util.*;

public class RangeQueries {

    static void build(int[] arr, int[] seg, int i, int left, int right) {
        if (left == right) {
            seg[i] = arr[left];
            return;
        }

        int mid = left + (right - left) / 2;
        build(arr, seg, 2 * i + 1, left, mid);
        build(arr, seg, 2 * i + 2, mid + 1, right);
        seg[i] = Math.min(seg[2 * i + 1], seg[2 * i + 2]);
    }

    static int findMin(int[] seg, int i, int left, int right, int l, int r) {
        if (left >= l && right <= r)
            return seg[i];

        if (right < l || left > r)
            return Integer.MAX_VALUE;

        int mid = left + (right - left) / 2;
        int vleft = findMin(seg, 2 * i + 1, left, mid, l, r);
        int vright = findMin(seg, 2 * i + 2, mid + 1, right, l, r);

        return Math.min(vleft, vright);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements to insert into the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements....");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int[] seg = new int[4 * n];
        build(arr, seg, 0, 0, n - 1);
        System.out.print("Enter the value of l: ");
        int l = sc.nextInt();
        System.out.print("Enter the value of r: ");
        int r = sc.nextInt();
        System.out.println("The minimum element within the given range is "+findMin(seg, 0, 0, n - 1, l, r));
    }
}
