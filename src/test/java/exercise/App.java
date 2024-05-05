package exercise;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello world");
//Arrays
        String[] colors = {"Red", "Green", "Blue", "Red", "Yelow" };
        System.out.println(colors[0]);
        colors[4] = "Violet";
        System.out.println(colors[4]);

        double[] temps = {50.3, 40.5, 60.1, 35, 3};
        System.out.println(temps[1]);

        char[] letters = {'a', 'r', 'c', 'd'};
        System.out.println(letters[3]);
        System.out.println(letters[letters.length - 1]);
        boolean[] results = {true, 56 > 78, 6 == 7, false, true};
        System.out.println(results[results.length - 1]);
        ///Loops
//        for(int i=0;i<3;i=i+1){
//            System.out.println("Hello");
//            System.out.println("i="+i);
        for (int i = 6; i >= 0; i = i - 1) {
            System.out.println(":hi");
            System.out.println("i=" + i);
        }
        for (int i = 0; i < 7; i++) {
            System.out.println(i);
        }

    }
}




