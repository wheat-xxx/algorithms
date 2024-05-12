package algorithms_01;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/03/09  22:11
 */
public class Solution_68 {

    public List<String> fullJustify(String[] words, int maxWidth) {

        // 保存最终结果
        List<String> res = new ArrayList<String>();

        // 记录单行字符总数
        int count = 0;
        // 记录某一行起始单词的位置
        int start = 0;

        for(int i = 0; i < words.length; i++){
            // 满足保存一行的要求
            if((count + (i - start) + words[i].length()) > maxWidth){
                StringBuilder sb = new StringBuilder();
                int spaceCount = maxWidth - count;
                int wordsCount = i - start;
                // 计算单词之间分配的空格个数
                //如果只有一个单词
                if(wordsCount == 1){
                    sb.append(words[i - 1]);
                    for(int j = 0; j < maxWidth - words[i - 1].length(); j++) sb.append(' ');
                    res.add(sb.toString());
                    count = words[i].length();
                    start = i;
                    continue;
                }
                int radix = spaceCount / (wordsCount - 1);
                // 多余个空格数
                int rest = spaceCount % (wordsCount - 1);
                // 拼接字符串
                for(int j = start; j < i - 1; j++){
                    if(rest != 0){
                        sb.append(words[j]);
                        // 填充空白字符
                        for(int k = 0; k < radix + 1; k++) sb.append(' ');
                        rest--;
                    }else{
                        sb.append(words[j]);
                        for(int k = 0; k < radix; k++) sb.append(' ');
                    }
                }
                // 拼接每一行最后一个单词
                sb.append(words[i - 1]);

                res.add(sb.toString());

                // 相关中间变量进行更新
                count = 0;
                start = i;
            }

            count += words[i].length();
        }

        // 对最后一行进行处理
        StringBuilder sb = new StringBuilder();
        for(int i = start; i < words.length; i++){
            sb.append(words[i]);
            if(i != words.length - 1) sb.append(' ');
        }
        for(int i = 0; i < maxWidth - count - (words.length - start - 1); i++){
            sb.append(' ');
        }
        res.add(sb.toString());


        return res;
    }

}
