package algorithms_02;

import java.util.Arrays;

/**
 * @author wheat
 * @date 2023/11/29  16:54
 */
public class Solution_134 {

//    /**
//     * 超出时间限制
//     * @param gas
//     * @param cost
//     * @return
//     */
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//
//        for (int i = 0; i < gas.length; i++) {
//            // 当前车的状态
//            int gas_car = gas[i];
//            int next_station = (i + 1) % gas.length;
//            while(next_station != i) {
//                if(gas_car < cost[i]) {
//                    break;
//                }else{
//                    gas_car = gas_car - cost[next_station] + gas[next_station];
//                    next_station = (next_station + 1) % gas.length;
//                }
//            }
//            // 判断是否绕了一圈
//            if(next_station == i && gas_car >= cost[i]) return i;
//        }
//
//        return -1;
//
//    }

    /**
     * 每一站的gas和cost可以确定是否可以到达下一站
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalStation = gas.length;
        int startStation = 0;

        // 逐个试每个站点是否可以当作起始站
        while(startStation < totalStation) {
            int sumGas = 0, costGas = 0;
            int hasPassed = 0;
            while(hasPassed < totalStation) {
                int currentStation = (startStation + hasPassed) % totalStation;
                sumGas += gas[currentStation];
                costGas += cost[currentStation];
                if(sumGas < costGas){
                    break;
                }else{
                    hasPassed++;
                }
            }
            if(hasPassed == totalStation){
                return startStation;
            }else{
                startStation += hasPassed + 1;
            }
        }

        return -1;
    }

}
