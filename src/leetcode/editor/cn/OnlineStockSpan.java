/**
  * 题目Id：901
  * 题目：Online Stock Span
  * 日期：2022-02-23 00:32:28
*/
//Design an algorithm that collects daily price quotes for some stock and 
//returns the span of that stock's price for the current day. 
//
// The span of the stock's price today is defined as the maximum number of 
//consecutive days (starting from today and going backward) for which the stock price 
//was less than or equal to today's price. 
//
// 
// For example, if the price of a stock over the next 7 days were [100,80,60,70,
//60,75,85], then the stock spans would be [1,1,1,2,1,4,6]. 
// 
//
// Implement the StockSpanner class: 
//
// 
// StockSpanner() Initializes the object of the class. 
// int next(int price) Returns the span of the stock's price given that today's 
//price is price. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
//[[], [100], [80], [60], [70], [60], [75], [85]]
//Output
//[null, 1, 1, 1, 2, 1, 4, 6]
//
//Explanation
//StockSpanner stockSpanner = new StockSpanner();
//stockSpanner.next(100); // return 1
//stockSpanner.next(80);  // return 1
//stockSpanner.next(60);  // return 1
//stockSpanner.next(70);  // return 2
//stockSpanner.next(60);  // return 1
//stockSpanner.next(75);  // return 4, because the last 4 prices (including 
//today's price of 75) were less than or equal to today's price.
//stockSpanner.next(85);  // return 6
// 
//
// 
// Constraints: 
//
// 
// 1 <= price <= 10⁵ 
// At most 10⁴ calls will be made to next. 
// 
// Related Topics 栈 设计 数据流 单调栈 👍 162 👎 0

package leetcode.editor.cn;
public class OnlineStockSpan {
    public static void main(String[] args) {
        Solution solution = new OnlineStockSpan().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class StockSpanner {

    public StockSpanner() {

    }
    
    public int next(int price) {

    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
//leetcode submit region end(Prohibit modification and deletion)

} 