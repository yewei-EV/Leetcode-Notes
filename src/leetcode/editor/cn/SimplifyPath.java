/**
  * 题目Id：71
  * 题目：Simplify Path
  * 日期：2022-03-01 20:41:12
*/
//Given a string path, which is an absolute path (starting with a slash '/') to 
//a file or directory in a Unix-style file system, convert it to the simplified 
//canonical path. 
//
// In a Unix-style file system, a period '.' refers to the current directory, a 
//double period '..' refers to the directory up a level, and any multiple 
//consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, 
//any other format of periods such as '...' are treated as file/directory names. 
//
// The canonical path should have the following format: 
//
// 
// The path starts with a single slash '/'. 
// Any two directories are separated by a single slash '/'. 
// The path does not end with a trailing '/'. 
// The path only contains the directories on the path from the root directory 
//to the target file or directory (i.e., no period '.' or double period '..') 
// 
//
// Return the simplified canonical path. 
//
// 
// Example 1: 
//
// 
//Input: path = "/home/"
//Output: "/home"
//Explanation: Note that there is no trailing slash after the last directory 
//name.
// 
//
// Example 2: 
//
// 
//Input: path = "/../"
//Output: "/"
//Explanation: Going one level up from the root directory is a no-op, as the 
//root level is the highest level you can go.
// 
//
// Example 3: 
//
// 
//Input: path = "/home//foo/"
//Output: "/home/foo"
//Explanation: In the canonical path, multiple consecutive slashes are replaced 
//by a single one.
// 
//
// 
// Constraints: 
//
// 
// 1 <= path.length <= 3000 
// path consists of English letters, digits, period '.', slash '/' or '_'. 
// path is a valid absolute Unix path. 
// 
// Related Topics 栈 字符串 👍 453 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class SimplifyPath {
    public static void main(String[] args) {
        Solution solution = new SimplifyPath().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String simplifyPath(String path) {
       // build a deque
        Deque<String> stack = new LinkedList<>();
        String[] names = path.split("/");
        for (String name : names) {
            if ("..".equals(name)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (name.length() > 0 && !".".equals(name)) {
                stack.offerLast(name);
            }
        }
        StringBuffer ans = new StringBuffer();
        if (stack.isEmpty()) {
            ans.append('/');
        } else {
            while (!stack.isEmpty()) {
                ans.append('/');
                ans.append(stack.pollFirst());
            }
        }
        return ans.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 
