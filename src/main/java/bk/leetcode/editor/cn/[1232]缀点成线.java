//在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为
// x、纵坐标为 y 的点。 
//
// 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
//输出：true
// 
//
// 示例 2： 
//
// 
//
// 输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 2 <= coordinates.length <= 1000 
// coordinates[i].length == 2 
// -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4 
// coordinates 中不含重复的点 
// 
// Related Topics 几何 数组 数学 
// 👍 55 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * y = kx+b
     *
     * @param coordinates
     * @return
     */
    public boolean checkStraightLine(int[][] coordinates) {
        int dx = coordinates[1][0] - coordinates[0][0];
        int dy = coordinates[1][1] - coordinates[0][1];

        if (dx == 0) {
            for (int i = 2; i < coordinates.length; i++) {
                if (coordinates[0][0] != coordinates[i][0]) {
                    return false;
                }
            }
        } else {
            double k = dy * 1.0 / dx;

            for (int i = 2; i < coordinates.length; i++) {
                int dxi = coordinates[i][0] - coordinates[0][0];
                int dyi = coordinates[i][1] - coordinates[0][1];
                if (dyi * 1.0 / dxi != k) {
                    return false;
                }
            }
        }
        return true;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
