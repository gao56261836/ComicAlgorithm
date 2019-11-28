package Chapter5_BinaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeNode {
    // 树节点
    int data;
    TreeNode leftChild;
    TreeNode rightChild;

    // 树类的数值域的 构造方法
    public TreeNode(int data) {
        this.data = data;
    }

    /*
        构造二叉树
        @param  inputList   输入序列
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }

        Integer data = inputList.removeFirst();
        if (data != null) {
            // 判空, 如果为空, 则不再进行下一步遍历
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }

        return node;
    }


    /*
        二叉树前序遍历
        @param node 二叉树节点
     */
    public static void preOrderTraveral(TreeNode node) {
        if (node == null)
            return;

        System.out.println(node.data);
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }

    /*
        二叉树中序遍历
        @param node 二叉树节点
     */
    public static void inOrderTraveral(TreeNode node) {
        if (node == null)
            return;

        inOrderTraveral(node.leftChild);
        System.out.println(node.data);
        inOrderTraveral(node.rightChild);
    }

    /*
        二叉树后序遍历
        @param node 二叉树节点
     */
    public static void lastOrderTraveral(TreeNode node) {
        if (node == null)
            return;

        lastOrderTraveral(node.leftChild);
        lastOrderTraveral(node.rightChild);
        System.out.println(node.data);
    }

    /*
        二叉树非递归 -- 前序遍历
        利用stack 的压栈和入栈 , 可以利用栈的 FILO 特性进行 非递归的前序遍历
     */
    public static void preOrderTraveralWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            // 迭代访问节点的左孩子, 并入栈
            while (treeNode != null) {
                System.out.println(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }

            // 如果节点没有左孩子, 则弹出栈顶元素, 访问节点右孩子
            if (!stack.isEmpty()){
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    /*
        二叉树层序遍历
        利用 queue 的 FIFO 特性进行 层序遍历
     */
    public static void levelOrderTraveral(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            System.out.println(node.data);

            if (node.leftChild != null)
                queue.offer(node.leftChild);

            if (node.rightChild != null)
                queue.offer(node.rightChild);
        }
    }


    public static void main(String[] args) {
        LinkedList<Integer> inputList =
                new LinkedList<>(Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4}));

        TreeNode treeNode = createBinaryTree(inputList);

        System.out.println("前序遍历:");
        preOrderTraveral(treeNode);

        System.out.println("中序遍历:");
        inOrderTraveral(treeNode);

        System.out.println("后序遍历:");
        lastOrderTraveral(treeNode);

        System.out.println("非递归方式先序遍历:");
        preOrderTraveralWithStack(treeNode);

        System.out.println("二叉树层序遍历:");
        levelOrderTraveral(treeNode);
    }
}
