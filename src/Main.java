//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int num = 5;

        for (int i = 1; i <= num; i++) {
            print(i);
            System.out.println();
        }

        for (int j = (num-1); j >= 1; j--) {
            print(j);
            System.out.println();
        }
        String w ="b";
        String x = "a" + w;
        String y = "a"+ w;
        if(x == y)
            System.out.println("t");
        else
            System.out.println("f");
    }

    public static void print(int j){
        for (int i = 1; i <= j; i++) {
            System.out.print(i);
        }
    }
}