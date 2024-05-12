package algorithms_03;

import java.util.Arrays;
import java.util.List;

/**
 * @author wheat
 * @date 2023/12/06  11:44
 */
public class Solution_165 {

    public int compareVersion(String version1, String version2) {
        // 根据“.”对版本号进行划分
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int length = split1.length < split2.length ? split1.length : split2.length;

        // 比较版本号
        for(int i = 0; i < length; i++) {
            int val1 = Integer.parseInt(split1[i]);
            int val2 = Integer.parseInt(split2[i]);
            if(val1 < val2) {
                return -1;
            } else if (val1 > val2) {
                return 1;
            } else {
                continue;
            }
        }

        // 处理序列号长度不相等
        if(split1.length > split2.length) {
            while (length < split1.length) {
                if (Integer.parseInt(split1[length++]) != 0) return 1;
            }
        } else {
            while(length < split2.length) {
                if(Integer.parseInt(split2[length++]) != 0) return -1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {

    }

}
