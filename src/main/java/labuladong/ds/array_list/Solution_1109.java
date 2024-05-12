package labuladong.ds.array_list;

/**
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
 * 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi]
 * 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
 * 请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。
 * @author wheat
 * @date 2024/04/12  8:25
 */
public class Solution_1109 {

    /**
     * 利用差分数组求解
     * @param bookings
     * @param n
     * @return
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        DifferenceArray differenceArray = new DifferenceArray(new int[n]);
        for (int[] booking : bookings) {
            differenceArray.increment(booking[0] - 1, booking[1] - 1, booking[2]);
        }
        return differenceArray.result();
    }

}
