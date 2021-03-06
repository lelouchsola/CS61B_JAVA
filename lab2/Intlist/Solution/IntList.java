public class IntList {
	public int first;
	public IntList rest;

	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}

	/** Return the size of the list using... recursion! */
	public int size() {
        if (rest == null){
            return 1;
        }
        return 1 + this.rest.size();
	}

	/** Return the size of the list using no recursion! */
	public int iterativeSize() {
        IntList p = this;
        int totalSize = 0;
        while (p != null){
            totalSize += 1;
            p = p.rest;
        }
		return totalSize;
	}

	/** Returns the ith value in this list.*/
	public int get(int i) {
        if (i == 1){
            return first;
        }
		return this.rest.get(i - 1);
    }

    /** Returns an IntList identical to L, but with
      * each element incremented by x. L is not allowed
      * to change. */
    public static IntList incrList(IntList L, int x) {
        /* Your code here. */
        if (L == null){
            return null;
        }
        IntList Q = new IntList(L.first + x, null);
        Q.rest = incrList(L.rest, x); //incrList is static method, so there is no "this" before the method name.
        return Q;        
    }

    /** Returns an IntList identical to L, but with
      * each element incremented by x. Not allowed to use
      * the 'new' keyword. */
    public static IntList dincrList(IntList L, int x) {
        /* Your code here. */
        if (L == null){
            return null;
        }
        L.first  = L.first + x;
        dincrList(L.rest, x);
        return L;
    }

	public static void main(String[] args) {
		IntList L = new IntList(15, null);
		L = new IntList(10, L);
		L = new IntList(5, L);

        System.out.println(L.iterativeSize());
        System.out.println(L.size());
        System.out.println(L.get(2));
        System.out.println(IntList.incrList(L, 2).get(2));
        System.out.println(L.get(2));
        System.out.println(IntList.dincrList(L, 2).get(2));
        System.out.println(L.get(2));

	}
} 