package backtracking;

import dataStructure.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 22. 括号生成
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        StringBuilder builder = new StringBuilder();
        List<String> list = new ArrayList<>();
        appand(builder, 0, 0, n, list);
        return list;

    }

    /**
     * 深度优先遍历
     * @param builder
     * @param left
     * @param right
     * @param n
     * @param list
     */
    public void appand(StringBuilder builder, int left, int right, int n, List<String> list) {
        if (left < n) {
            appand(builder.append('('), left + 1, right, n, list);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (right < left) {
            appand(builder.append(')'), left, right + 1, n, list);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (left == n && right == n) {
            list.add(builder.toString());
            return;
        }
    }

    /**
     * 广度优先遍历
     * @param n
     * @return
     */
    public List<String> generateParenthesis1(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node("", n, n));

        while (!queue.isEmpty()) {

            Node curNode = queue.poll();
            if (curNode.left == 0 && curNode.right == 0) {
                res.add(curNode.res);
            }
            if (curNode.left > 0) {
                queue.offer(new Node(curNode.res + "(", curNode.left - 1, curNode.right));
            }
            if (curNode.right > 0 && curNode.left < curNode.right) {
                queue.offer(new Node(curNode.res + ")", curNode.left, curNode.right - 1));
            }
        }
        return res;
    }



    public static void main(String[] args) {
        GenerateParenthesis g=new GenerateParenthesis();
        System.out.println(  g.generateParenthesis(3));
        System.out.println(  g.generateParenthesis1(3));
    }
}
