/**
  * 题目Id：225
  * 题目：Implement Stack using Queues
  * 日期：2022-01-14 15:50:48
*/
//Implement a last-in-first-out (LIFO) stack using only two queues. The 
//implemented stack should support all the functions of a normal stack (push, top, pop, 
//and empty). 
//
// Implement the MyStack class: 
//
// 
// void push(int x) Pushes element x to the top of the stack. 
// int pop() Removes the element on the top of the stack and returns it. 
// int top() Returns the element on the top of the stack. 
// boolean empty() Returns true if the stack is empty, false otherwise. 
// 
//
// Notes: 
//
// 
// You must use only standard operations of a queue, which means that only push 
//to back, peek/pop from front, size and is empty operations are valid. 
// Depending on your language, the queue may not be supported natively. You may 
//simulate a queue using a list or deque (double-ended queue) as long as you use 
//only a queue's standard operations. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["MyStack", "push", "push", "top", "pop", "empty"]
//[[], [1], [2], [], [], []]
//Output
//[null, null, null, 2, 2, false]
//
//Explanation
//MyStack myStack = new MyStack();
//myStack.push(1);
//myStack.push(2);
//myStack.top(); // return 2
//myStack.pop(); // return 2
//myStack.empty(); // return False
// 
//
// 
// Constraints: 
//
// 
// 1 <= x <= 9 
// At most 100 calls will be made to push, pop, top, and empty. 
// All the calls to pop and top are valid. 
// 
//
// 
// Follow-up: Can you implement the stack using only one queue? 
// Related Topics 栈 设计 队列 👍 428 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
    public static void main(String[] args) {
        Solution solution = new ImplementStackUsingQueues().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class MyStack {

    private Queue<Integer> inQueue;
    private Queue<Integer> outQueue;

    public MyStack() {
        this.inQueue = new LinkedList<>();
        this.outQueue = new LinkedList<>();
    }
    
    public void push(int x) {
        inQueue.offer(x);
        while(!outQueue.isEmpty()) {
            inQueue.offer(outQueue.poll());
        }
        Queue<Integer> temp = inQueue;
        inQueue = outQueue;
        outQueue = temp;
    }
    
    public int pop() {
        return outQueue.remove();
    }
    
    public int top() {
        if (!outQueue.isEmpty()) {
            return outQueue.peek();
        } else {
            return 0;
        }
    }
    
    public boolean empty() {
        return outQueue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)

} 
