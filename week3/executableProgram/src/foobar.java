import java.util.Scanner;

public class foobar {
    public static void main(String[] args) {
        Scanner snc = new Scanner(System.in);

        int number =  snc.nextInt();

        if(number % 2 == 0){
            System.out.println("foo");
        }else{
            System.out.println("bar");
        }
    }
}
