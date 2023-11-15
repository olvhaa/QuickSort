import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wybierz ile tablica ma mieć miejsc");
        int wybor_size = scanner.nextInt();
        System.out.println("Czy tablicę wygenerować? Czy podajesz wartości z klawiatury?");
        System.out.println("Wpisz 1 lub 2");
        int wybor = scanner.nextInt();

        double[] numberArray = new double[wybor_size];
        double[] sorterArray = new double[wybor_size];

        if (wybor == 1) {
            System.out.println("Podaj dolny zakres tablicy");
            int dolny = scanner.nextInt();
            System.out.println("Podaj górny zakres tablicy");
            int gorny = scanner.nextInt();
            System.out.println("Tablica jest nie posortowana.");
            for (int i = 0; i < wybor_size; i++) {
                numberArray[i] = (int) (Math.random() * (gorny - dolny)) * dolny;
                System.out.print(numberArray[i] + ", ");
            }
            System.out.println();
            System.out.println("Posortowana tablica.");

            sorterArray = sortArray(numberArray, 0, numberArray.length - 1);
            for (int i = 0; i < wybor_size; i++) {
                System.out.print(sorterArray[i] + ", ");
            }
        } else if (wybor == 2) {
            System.out.println("Wprowadź kolejno " + wybor_size + " liczb.");
            for (int i = 0; i < wybor_size; i++) {
                numberArray[i] = scanner.nextInt();
            }
            System.out.println("Nieposortowana tablica");
            for (int i = 0; i < wybor_size; i++) {
                System.out.print(numberArray[i] + ", ");
            }
            System.out.println();
            System.out.println("Posortowana tablica");
            double[] sortedArray = sortArray(numberArray, 0, numberArray.length - 1);

            for (int i = 0; i < wybor_size; i++) {
                System.out.print(sortedArray[i] + ", ");
            }
        }
    }


    public static double[] sortArray(double[] arrayNumber, int left, int right){
        int i = left;
        int j= right;
        double middle = arrayNumber[(left + right) / 2];
        do {
            while (arrayNumber[i] < middle) i++;
            while (arrayNumber[j] > middle) j--;
            if (i <= j) {
                double temp = arrayNumber[i];
                arrayNumber[i] = arrayNumber[j];
                arrayNumber[j] = temp;
                i++;
                j--;

            }
        }
            while (i<=j);
            if(left < j) sortArray(arrayNumber, left, j);
            if(right > i) sortArray(arrayNumber, i, right);
            return arrayNumber;

        }
    }
