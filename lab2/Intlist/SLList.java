/** It is recommended to record all invariables in your mind when programming */
public class SLList {
    private static class IntNode{ //IntNode类从来没有使用过SLList的变量和方法，因此可以设为static
        public int item;
        public IntNode next;
    
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;

    /** 创建空列表时，加入虚拟节点sentinel */
    public SLList() {
         sentinel = new IntNode(55, null);
         size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(55, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next); // 括号里面的first相当于一个Node实例
        size += 1;
    }

    public int getFirst() {
        return sentinel.next.item;
    }

    public void addLast(int x) {
        IntNode p = sentinel; //因为后续的while从p.next开始，所以这里是sentinel，而不是sentinel.next

        /** move p until it reaches the end of the list */
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
        size += 1;
    }

    /** 在使用递归时，经常会出现一个private和一个public同名的方法 */
    // private static int size(IntNode p) {
    //     if (p.next == null){
    //         return 1;
    //     }
    //     return 1 + size(p.next);
    // }

    // public int size() {
    //     return size(first);
    // }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        SLList L = new SLList();
        L.addLast(20);
        L.addFirst(10);
        L.addFirst(5);
        System.out.println(L.getFirst());
        System.out.println(L.size());
    }
}