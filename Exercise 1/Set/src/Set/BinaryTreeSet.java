package Set;

public class BinaryTreeSet extends Set {
    private TreeNode root;
    private int size = 0;

    @Override
    public boolean add(String word){
        if(this.contains(word)){
            return false;
        }else{
            root = this.insert(root, word);
            size++;
            return true;
        }
    }

    public TreeNode insert(TreeNode root, String s){
        if(root == null){
             root = new TreeNode(s);
        }else if(root.str.compareTo(s) < 0){
             root.right = this.insert(root.right, s);
        }else{
             root.left = this.insert(root.left, s);
        }
        return root;
    }

    @Override
    public boolean contains(String word){
        if(search(root, word) == null){
            return false;
        }else{
            return true;
        }
    }

    public TreeNode search(TreeNode root, String s){
        if(root == null) return null;
        if(root.str.equals(s)){
            return root;
        }else if(root.str.compareTo(s) < 0){
            return this.search(root.right, s);
        }else {
            return this.search(root.left, s);
        }
    }

    @Override
    public int size(){
        return size;
    }

    public void printTreeInOrder(){
        printTree(root);
    }

    public void printTree(TreeNode root){
        if(root != null){
            printTree(root.left);
            System.out.print(root.str + " ");
            printTree(root.right);
        }
        System.out.println();
    }

}

class TreeNode{
    String str;
    TreeNode left;
    TreeNode right;

    TreeNode(String str){
        this.str = str;
        this.left = null;
        this.right = null;
    }
}
