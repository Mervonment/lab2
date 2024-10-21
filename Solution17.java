import java.util.*;

/*
 * @Description
 * 重复 DNA 序列
 * DNA 序列由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'。
 * 该程序识别在给定 DNA 序列中出现不止一次的长度为 10 的子字符串。
 */

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        // 创建一个存储结果的列表，结果为重复的 DNA 序列
        List<String> result = new ArrayList<>();
        
        // 如果输入字符串长度小于 10，返回空列表，因为无法形成长度为 10 的子串
        if (s.length() < 10) {
            return result; 
        }

        // 创建两个集合，一个用于存储已见过的子字符串，另一个用于存储重复的子字符串
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        // 遍历字符串，从头到尾提取所有长度为 10 的子字符串
        for (int i = 0; i <= s.length() - 10; i++) {
            // 提取长度为 10 的子字符串
            String subStr = s.substring(i, i + 10);
            
            // 检查该子字符串是否已经在 seen 集合中
            if (seen.contains(subStr)) {
                // 如果已经见过，则加入 repeated 集合
                repeated.add(subStr);
            } else {
                // 如果没有见过，则加入 seen 集合
                seen.add(subStr);
            }
        }

        // 将所有重复的子字符串添加到结果列表中
        result.addAll(repeated);
        return result; // 返回包含重复序列的列表
    }
}

class TestSolution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例，输出应该与预期一致
        System.out.println(solution.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")); // 输出: ["AAAAACCCCC", "CCCCCAAAAA"]
        System.out.println(solution.findRepeatedDnaSequences("AAAAAAAAAAAAA")); // 输出: ["AAAAAAAAAA"]
        System.out.println(solution.findRepeatedDnaSequences("ACGTACGTACGT")); // 输出: []
        System.out.println(solution.findRepeatedDnaSequences("GAGAGAGAGAGAGAGA")); // 输出: ["GAGAGAGAGA"]
        System.out.println(solution.findRepeatedDnaSequences("A")); // 输出: []
        System.out.println(solution.findRepeatedDnaSequences("ACGTACGTACGTACGT")); // 输出: ["ACGTACGTAC"]
    }
}
