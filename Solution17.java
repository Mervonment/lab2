import java.util.*;

/*
 * @Description
 * 重复 DNA 序列
 * DNA 序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'.。
 * 例如，"ACGAATTCCG" 是一个 DNA 序列 。
 * 在研究 DNA 时，识别 DNA 中的重复序列非常有用。
 * 给定一个表示 DNA 序列 的字符串 s ，返回所有在DNA分子中出现不止一次的长度为10的序列(子字符串)。你可以按任意顺序返回答案。
 *
 *
 * 示例 1：
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * 示例 2：
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 */

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 10) {
            return result; // 如果长度小于10，直接返回空列表
        }

        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        for (int i = 0; i <= s.length() - 10; i++) {
            String subStr = s.substring(i, i + 10);
            if (seen.contains(subStr)) {
                repeated.add(subStr); // 如果已经见过，加入重复集合
            } else {
                seen.add(subStr); // 否则加入见过集合
            }
        }

        result.addAll(repeated); // 将结果添加到列表中
        return result;
    }
}

class TestSolution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        System.out.println(solution.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")); // 输出: ["AAAAACCCCC", "CCCCCAAAAA"]
        System.out.println(solution.findRepeatedDnaSequences("AAAAAAAAAAAAA")); // 输出: ["AAAAAAAAAA"]
        System.out.println(solution.findRepeatedDnaSequences("ACGTACGTACGT")); // 输出: []
        System.out.println(solution.findRepeatedDnaSequences("GAGAGAGAGAGAGAGA")); // 输出: ["GAGAGAGAGA"]
        System.out.println(solution.findRepeatedDnaSequences("A")); // 输出: []
        System.out.println(solution.findRepeatedDnaSequences("ACGTACGTACGTACGT")); // 输出: ["ACGTACGTAC"]
    }
}
