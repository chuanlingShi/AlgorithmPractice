package DFS;

/***
 * Given an integer n, print/output all possible ways of writing n pairs of if blocks with correct indentation.
 *
 * Say n=2 output should be
 *
 *
 *
 * if {
 *
 * }
 *
 * if {
 *
 * }
 *
 * <newline>
 *
 * if {
 *
 *   if {// here should exist two spaces before each inner block
 *
 *   }
 *
 * }
 */
public class ValidIfBlock {
    public void printBlocks (int n) {
        if(n <= 0) {
            return;
        }
        char[] cur = new char[2 * n];
        helper(n, n, 0, cur);
    }

    private void helper(int leftRemain, int rightRemain, int index, char[] cur) {
        if (leftRemain == 0 && rightRemain == 0) {
            printBlock(cur);
            return;
        }
        if (leftRemain > 0){
            cur[index] = '{';
            helper(leftRemain - 1, rightRemain, index + 1, cur);
        }
        if(rightRemain > leftRemain) {
            cur[index] = '}';
            helper(leftRemain, rightRemain -1, index + 1, cur);
        }
    }

    private void printBlock(char[] cur) {
        int space = 0;
        for(int i = 0; i < cur.length; i++) {
            if(cur[i] == '{') {
                printSpace(space);
                System.out.println("if {");
                space += 2;
            }else {
                space -= 2;
                printSpace(space);
                System.out.println("}");
            }
            System.out.println();
        }
    }

    private void printSpace(int space){
        for(int i = 0; i < space; i++){
            System.out.print(" ");
        }
    }

}
