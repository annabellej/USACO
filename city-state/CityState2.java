import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Map;

public class CityState2 {
    public static void getfirst(String[] t, TreeMap<String, int[]> p, String c, String s, String k)
    {
        if (t[0].equals(c))
        {
            p.get(k)[0]++;
        }
        if (t[0].equals(s))
        {
            p.get(k)[1]++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("9.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("9.out")));

        StringTokenizer stk = new StringTokenizer(f.readLine());
        int pairs = Integer.parseInt(stk.nextToken());

        int special = 0;

        TreeMap<String, int[]> places = new TreeMap<>();

        for (int i = 0; i < pairs; i++) {
            StringTokenizer s = new StringTokenizer(f.readLine());
            String city = s.nextToken().substring(0, 2);
            String state = s.nextToken();

            String[] toSort = new String[2];
            toSort[0] = city;
            toSort[1] = state;

            Arrays.sort(toSort);

            String key = toSort[0] + toSort[1];

            if (city.equals(state)) {
                continue;
            }

            if (!places.containsKey(key)) {
                places.put(key, new int[2]);
            }

            getfirst(toSort, places, city, state, key);
        }

        for (Map.Entry<String,int[]> entry: places.entrySet())
        {
            special += entry.getValue()[0] * entry.getValue()[1];
        }

        out.println(special);
        out.close();
    }
}
