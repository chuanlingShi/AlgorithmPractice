

public class driver {
    public static void main(String[] argv){
//        TreeNode node1 = new TreeNode(10);
//        TreeNode node2 = new TreeNode(5);
//        TreeNode node3 = new TreeNode(13);
//        TreeNode node4 = new TreeNode(3);
//        TreeNode node5 = new TreeNode(6);
//        TreeNode node6 = new TreeNode(4);
//        TreeNode node7 = new TreeNode(15);
//        TreeNode node8 = new TreeNode(14);
//
//        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
////        node2.right = node5;
//        node4.right = node6;
//        node3.right = node7;
//        node3.left = node8;
//        TreeNode root = new TreeNode(20);
//        TreeNode node1 = new TreeNode(10);
//        TreeNode node2 = new TreeNode(3);
//        TreeNode node3 = new TreeNode(4);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(10);
//        TreeNode node6 = new TreeNode(3);
//        TreeNode node7 = new TreeNode(4);
//        TreeNode node8 = new TreeNode(4);
//        TreeNode node9 = new TreeNode(12);
//
//        root.left = node1;
////        root.right = node5;
//        node1.left = node2;
//        node2.left = node3;
//        node2.right = node4;
//        node5.left = node6;
//        node5.right = node9;
//        node6.left = node7;
//        node6.right = node8;
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(16);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(9);


        Height height = new Height();
        BalancedTree tree = new BalancedTree();
        System.out.println("Height: " + height.getHeight(root));
        System.out.println("IS Balanced: " + tree.isBalanced(root));

        SearchBST searchBST = new SearchBST();
        System.out.println("Search BST: " + searchBST.searchBST(root, 11));

        SearchBSTIteration searchBSTIteration = new SearchBSTIteration();
        System.out.println("Search BST Iteration: " + searchBSTIteration.searchI(root, 9));

        InOrderPrint inOrderPrint = new InOrderPrint();
        System.out.println("Original Tree: ");
        inOrderPrint.inOrder(root);
        InsertBST insertBST = new InsertBST();
        System.out.println("\nNew Tree after insert: ");
        inOrderPrint.inOrder(insertBST.insert(root, 3));

        InsertBSTIteration insertBSTIteration = new InsertBSTIteration();
        System.out.println("\nNew Tree after insert(iteration): ");
        inOrderPrint.inOrder(insertBSTIteration.insert(root, 5));

        DeleteBST deleteBST = new DeleteBST();
        System.out.println("\nNew Tree after delete: ");
        inOrderPrint.inOrder(deleteBST.delete(root, 15));


    }

}
