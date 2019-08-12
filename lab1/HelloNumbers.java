public class HelloNumbers {
    public static void main(String[] args) {
        int x = 0;
        int res = 0;
        while (x < 10) {
            res = res + x;
            System.out.println(res + "10"); // print function treat the parameters as string type
            x = x + 1;
        }
    }
}

/*
1. Our print statement is just System.out.print instead of System.out.println. 
   This means we should not include a newline (a return).
*/