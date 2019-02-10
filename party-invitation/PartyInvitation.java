import java.io.*;
import java.util.*;

public class PartyInvitation {
    public static void takeOut(ArrayList<TreeSet<Integer>> a, ArrayList<Integer> c, int x)
    {
        for (int i = 0; i < a.size(); i++) {
            TreeSet<Integer> t = a.get(i);
            if (t.contains(x)) {
                t.remove(x);
                c.set(i, c.get(i)-1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("10.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("10.out")));

        StringTokenizer stk = new StringTokenizer(f.readLine());
        int numCows = Integer.parseInt(stk.nextToken());
        int numGroups = Integer.parseInt(stk.nextToken());

        int invite = 0;

        ArrayList<Integer> count = new ArrayList<>(); //stores the number of cows in each group
        ArrayList<TreeSet<Integer>> groups = new ArrayList<>(); //stores all the groups

        for (int i = 0; i < numGroups; i++) {
            groups.add(new TreeSet<>());
            
            StringTokenizer st = new StringTokenizer(f.readLine());
            int c = Integer.parseInt(st.nextToken());

            count.add(i,c);

            while (st.hasMoreTokens()) {
                groups.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        //check to make sure 1 is in at least one of the groups
        for (TreeSet<Integer> t: groups) {
            if (t.contains(1))
                takeOut(groups, count, 1); //take a certain number out from all the groups
        }
        invite++;

        while (count.contains(1)) {
            int i = count.indexOf(1);
            TreeSet<Integer> g = groups.get(i);

            int num = g.first();
            takeOut(groups, count, num);
            invite++;
        }
        out.println(invite);
        out.close();
    }
}
