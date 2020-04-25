package com.open.learncode.剑指offer.test;

/**
 * 题目：
 * 重建二叉树：输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如：输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建此二叉树并输出它的根节点
 */
public class TestMethod7 {

    //二叉树节点
    public static class TreeNode<E>{
        E val;
        TreeNode left;
        TreeNode rigth;

        TreeNode(E val){
            this.val=val;
        }

        public void setLeftAndRight(TreeNode left,TreeNode rigth){
            this.left=left;
            this.rigth=rigth;
        }
    }

    public static void main(String[] args) {

        int[] preorder={1,2,4,7,3,5,6,8};
        int[] inorder={4,7,2,1,5,3,8,6};


        System.out.println("重建二叉树：");
        System.out.print("根节点："+method(preorder,inorder,preorder.length).val);

    }

    private static TreeNode method(int[] preorder,int[] inorder,int length){

        //鲁棒性
        if (preorder==null || inorder==null||length<=0)
            return null;

        //重建根节点
        TreeNode<Integer> root=new TreeNode(preorder[0]);

        //找到根节点在中序数组中的位置i
        int rootVal=root.val;
        int i;
        for ( i = 0; i <length ; i++) {
            if(inorder[i]==rootVal)
                break;
        }

        //重建左子树
        if(i>0) {
            int[] pre = new int[i];
            int[] in = new int[i];
            for (int j = 0; j < i; j++) {
                pre[j] = preorder[j + 1];
                in[j] = inorder[j];
            }
            root.left=method(pre,in,pre.length);
        }

        //重建右子树
        if(length-i-1>0){
            int[] pre=new int[length-i-1];
            int[] in=new int[length-i-1];
            for (int j = i+1; j <length ; j++) {
                pre[j-i-1]=preorder[j];
                in[j-i-1]=inorder[j];
            }
            root.rigth=method(pre,in,pre.length);
        }

        return root;
    }


}

