/**
  * 题目Id：68
  * 题目：Text Justification
  * 日期：2022-01-11 18:28:58
*/
//Given an array of strings words and a width maxWidth, format the text such 
//that each line has exactly maxWidth characters and is fully (left and right) 
//justified. 
//
// You should pack your words in a greedy approach; that is, pack as many words 
//as you can in each line. Pad extra spaces ' ' when necessary so that each line 
//has exactly maxWidth characters. 
//
// Extra spaces between words should be distributed as evenly as possible. If 
//the number of spaces on a line does not divide evenly between words, the empty 
//slots on the left will be assigned more spaces than the slots on the right. 
//
// For the last line of text, it should be left-justified and no extra space is 
//inserted between words. 
//
// Note: 
//
// 
// A word is defined as a character sequence consisting of non-space characters 
//only. 
// Each word's length is guaranteed to be greater than 0 and not exceed 
//maxWidth. 
// The input array words contains at least one word. 
// 
//
// 
// Example 1: 
//
// 
//Input: words = ["This", "is", "an", "example", "of", "text", "justification."]
//, maxWidth = 16
//Output:
//[
//   "This    is    an",
//   "example  of text",
//   "justification.  "
//] 
//
// Example 2: 
//
// 
//Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 
//16
//Output:
//[
//  "What   must   be",
//  "acknowledgment  ",
//  "shall be        "
//]
//Explanation: Note that the last line is "shall be    " instead of "shall     
//be", because the last line must be left-justified instead of fully-justified.
//Note that the second line is also left-justified becase it contains only one 
//word. 
//
// Example 3: 
//
// 
//Input: words = ["Science","is","what","we","understand","well","enough","to",
//"explain","to","a","computer.","Art","is","everything","else","we","do"], 
//maxWidth = 20
//Output:
//[
//  "Science  is  what we",
//  "understand      well",
//  "enough to explain to",
//  "a  computer.  Art is",
//  "everything  else  we",
//  "do                  "
//] 
//
// 
// Constraints: 
//
// 
// 1 <= words.length <= 300 
// 1 <= words[i].length <= 20 
// words[i] consists of only English letters and symbols. 
// 1 <= maxWidth <= 100 
// words[i].length <= maxWidth 
// 
// Related Topics 字符串 模拟 👍 253 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public static void main(String[] args) {
        Solution solution = new TextJustification().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int max = 0;
    public List<String> fullJustify(String[] words, int maxWidth) {
        max = maxWidth;
        List<String> result = new ArrayList<>();
        int n = words.length;
        int count = 0;
        List<String> line = new ArrayList<>();
        for(int i = 0; i < n; ++i) {
           if (count + words[i].length() + line.size() <= maxWidth) {
                count += words[i].length();
                line.add(words[i]);
           } else {
               result.add(saveLine(line));
               line.clear();
               line.add(words[i]);
               count = words[i].length();
           }
        }
        //handle last line, left-justified and no extra space
        StringBuilder lastRow = new StringBuilder(line.get(0));
        for(int i = 1; i < line.size(); i++) {
            lastRow.append(" ").append(line.get(i));
        }
        lastRow.append(getSpace(maxWidth - lastRow.length()));
        result.add(lastRow.toString());

        return result;
    }

    public String saveLine(List<String> line) {
        StringBuilder sb = new StringBuilder();
        int count = line.size();
        int len = 0;
        for (String s : line) {
            len += s.length();
        }
        //handle if only one word in this line
        if(count == 1) {
            sb.append(line.get(0));
            while(sb.length() < max) {
                sb.append(" ");
            }
        }else {
            //the last word will be not followed by space
            int num = (max - len) / (count - 1);
            int remainder = (max - len) % (count - 1);
            for(int i = 0; i < count; i++) {
                sb.append(line.get(i));
                if (i == count - 1) continue;
                if (remainder-- > 0) {
                    sb.append(getSpace(num + 1));
                } else {
                    sb.append(getSpace(num));
                }
            }
        }
        return sb.toString();
    }

    public String getSpace(int num) {
        String s = "";
        while(num-- > 0) {
            s += " ";
        }
        return s;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
