import java.io.IOException;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {


        // podciag2("abaabbaaa", "babab");
        podciag("POLITECHNIKA", "TOALETA");
        podciag("RABARBAR", "LABRADOR");
        //  podciag("markotny", "romantyk");
        //  podciag("123", "543");
/*
        String[] file1;
        String[] file2;

        FileArrayProvider fileArrayProvider = new FileArrayProvider();
        try {
            file1 = fileArrayProvider.readLines("src/main/resources/file1.txt");
            file2 = fileArrayProvider.readLines("src/main/resources/file2.txt");

            for (String line : file1) {
                System.out.println(line);
            }

            for (String line : file2) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
*/

    }

    private static void podciag(String a, String b) {
        int[][] d = new int[a.length() + 1][b.length() + 1];

        for (int n = 0; n <= a.length(); n++) {
            for (int k = 0; k <= b.length(); k++) {
                if (n == 0 || k == 0) {
                    d[n][k] = 0;
                } else if (a.charAt(n - 1) == b.charAt(k - 1)) {
                    d[n][k] = d[n - 1][k - 1] + 1;

                } else {
                    d[n][k] = Math.max(d[n][k - 1], d[n - 1][k]);
                }
            }
        }

        for (int n = 0; n <= a.length(); n++) {
            for (int k = 0; k <= b.length(); k++) {
                System.out.print(d[n][k] + "");
            }
            System.out.print("\n");
        }

        int n = a.length();
        int k = b.length();

        Stack<Character> r = new Stack<>();

        while (n != 0 && k != 0) {
            if (a.charAt(n - 1) == b.charAt(k - 1)) {
                r.push(a.charAt(n - 1));
                n = n - 1;
                k = k - 1;
            } else if (d[n][k] == d[n][k - 1]) {
                k = k - 1;
            } else {
                n = n - 1;
            }
        }
        String result = "Najdłuższy wspólny podciąg: ";
        while (!r.empty()) {
            result += r.pop();
        }
        System.out.println(result);
    }
  /*
    private static void podciag2(String a, String b) {
        int n = a.length();
        int m = b.length();

        int[][] C = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i <= n; i++) {
            C[i][0] = 0;
        }

        for (int i = 0; i <= m; i++) {
            C[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    C[i][j] = C[i - 1][j - 1] + 1;
                } else {
                    C[i][j] = Math.max(C[i - 1][j], C[i][j - 1]);
                }
            }
        }
        for (int i = 0; i <= a.length(); i++) {
            for (int k = 0; k <= b.length(); k++) {
                System.out.print(C[i][k] + " ");
            }
            System.out.print("\n");
        }
    }

        private static String[] przygotujTabliceWynikow(String[] file1, String[] file2) {

            int[][] tab = new int[file2.length + 1][file1.length + 1];


            for (int i = 0; i <= file2.length; i++)
                tab[i][0] = 0;

            for (int i = 0; i <= file1.length; i++)
                tab[0][i] = 0;

            for (int i = 1; i <= file2.length; i++) {
                for (int k = 1; k <= file1.length; k++) {
                    if (!file1[k - 1].equals(file2[i - 1])) {
                        tab[i][k] = tab[i - 1][k - 1] + 1;
                    } else {
                        tab[i][k] = Math.max(tab[i - 1][k], tab[i][k - 1]);
                    }
                }
            }

            List<Pair<Integer, Integer>> lista = new ArrayList<>();
            while (lista.size() < tab[file2.length][file1.length]){
                lista.add(new Pair(0,0));
            }

            // lista = new pair<int,int>[tab[file2.length][file1.length]];

            int i = file2.length, k = file1.length;
            int pozycja = tab[file2.length][file1.length] - 1;

            while (i != 0 && k != 0) {
                if (tab[i][k] == tab[i - 1][k])
                    i--;
                else if (tab[i][k] == tab[i][k - 1])
                    k--;
                else {
                   // lista.set(pozycja, new Pair(k - 1, i - 1));
                    lista.add(pozycja, new Pair(k - 1, i - 1));
                    pozycja--;
                    k--;
                    i--;
                }
            }

            System.out.println("DIFF: ");
            // pair<int,int> * pomocnicza = lista;
            List<Pair<Integer, Integer>> pomocnicza = lista;
            k = i = 0;
            for (Pair<Integer, Integer> p : pomocnicza)
                for (int j = 0; j < tab[file2.length][file1.length]; j++) {
                    while (i < p.first) {
                        System.out.println("- " + file1[i]);
                        i++;
                    }
                    while (k < p.second) {
                        System.out.println("+ " + file2[i]);
                        k++;
                    }

                    System.out.println(" " + file1[i]);

                    k++;
                    i++;
                }
            while (i < file1.length) {
                System.out.println("- " + file1[i]);
                i++;
            }

            while (k < file2.length) {
                System.out.println("+ " + file2[i]);
                k++;
            }

            return null;
        }
    */

}
