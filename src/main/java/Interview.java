package src.main.java;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

public class Interview {
    // you can also use imports, for example:
// import java.util.*;

    // you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
    String[] res;
    List<String> result = new ArrayList<>();
    List<Integer> a = new ArrayList<>();
    Set<String> check;
    Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args) {
//        Set<Thread> threads = ConcurrentHashMap.newKeySet();
//        List<Integer> src = new ArrayList<>();
//        for (int i = 0; i < 10000; i++) {
//            src.add(i);
//        }
//        List<String> strings = new ArrayList<>();
//        src.parallelStream().forEach(integer -> {
//            strings.add(integer + "");
//        });
//        System.out.println("size=>" + strings.size());

        int[] arr = new int[]{1,2,3,4,5,6,1,2,3,4,5,6};
        int start = arr[0];
        int secondArr = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == start) {
                secondArr = i;
                break;
            }
        }



        Interview interview = new Interview();

//        interview.test("the " +
//                "eagle " +
//                "eats " +
//                "snakes");
//        interview.test("snakes " +
//                "seldom " +
//                "munch " +
//                "on " +
//                "north " +
//                "highland " +
//                "ducks");
//
//
//        interview.test("on " +
//                        "north " +
//                        "highland " +
//                        "ducks " +
//                        "snakes " +
//                "seldom " +
//                "munch"
//                );
//        System.out.println(interview.solution(3));
        //....xxx...xx   n+1, n+1
        int[] A = new int[]{16,16};

        boolean[] used = new boolean[A.length];
        List<List<Integer>> tracks = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        backtracking(used, 0, A, tracks, track);
        System.out.println(countTracksResult(tracks));

//        String s = "....xxx...xx";
//        int produce = 5;
//
//        System.out.println(fixPotholes(s, produce));
//        s ="...xxx..x....xxx";
//        produce = 7;
//        System.out.println(fixPotholes(s, produce));
//        //...x..x..x..x
//        s = "..xxxxx"; produce =  4;
//        System.out.println(fixPotholes(s, produce));
//        s = "x.x.xxx...x"; produce = 14;
//        System.out.println(fixPotholes(s, produce));
//        s = ".."; produce = 5;
//        System.out.println(fixPotholes(s, produce));
//        System.out.println(fixPotholes("..xx..xx..", produce));
//        System.out.println(fixPotholes("..x..x..x..", produce));
//        System.out.println(fixPotholes("......x..", produce));
//        System.out.println(fixPotholes("......xxxxx.xxx..", produce));
    }

    private static void backtracking(boolean[] used, int index, int[] A, List<List<Integer>> tracks, List<Integer> track) {
        if (!tracks.containsAll(track)) {
            tracks.add(new ArrayList(track));
            return;
        }
        for (int i = 0; i < A.length; i++) {
            if (used[i]) {
                continue;
            }
            track.add(A[i]);
            used[i] = true;
            backtracking(used, i, A, tracks, track);
            used[i] = false;
            track.remove(track.size() - 1);
        }
    }

    private static int countTracksResult(List<List<Integer>> tracks) {
        int res = 0;
        for (int i = 0; i < tracks.size(); i++) {
            int subAns = 1;
            for (int j = 0; j < tracks.get(i).size(); j++) {
                subAns = subAns & Integer.parseInt(Integer.toBinaryString(tracks.get(i).get(j)));
            }
            if (subAns > 0) res++;
        }
        return res;
    }


    private static int fixPotholes(String s, int consumes) {
        if (consumes <= 1 || s == null || s.length() == 0) return 0;
        var strings = s.split("\\.");
        Arrays.sort(strings);
        int fixPotholes = 0;
        for (int i = strings.length - 1; i >= 0; i--) {
            if (consumes <= 0) return fixPotholes;
            if (!strings[i].equals("")) {
                if (consumes > strings[i].length() + 1) {
                    fixPotholes += strings[i].length();
                } else {
                    fixPotholes += (consumes - 1);
                }
                consumes = consumes - strings[i].length() - 1;
            }
        }
        return fixPotholes;
    }

    private void test(String s) {

        String[] strings = s.split(" ");
        String prev = "";
        int res = 1;
        for (int i = 0; i <strings.length; i++) {
            String head = strings[i].substring(0, 1);
            String tail = strings[i].substring(strings[i].length() - 1);
            if (i > 0 && head.equals(prev)) res++;
            else if (i > 0) break;
            prev = tail;
        }
        System.out.println(res);
    }



    public String[] solution(int n) {
        // write your code in Java 8
        Map<String, Map<String, Integer>> allState = new HashMap<>();
        int nums = 0;

        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(n).map(Map.Entry::getKey).collect(Collectors.toList()).toArray(new String[n]);
        res = new String[n];
        check = new HashSet<>();
        Arrays.fill(res, "");
        backtrack(n, 0, 0, "");
        System.out.println(Arrays.toString(res));

        return (String[]) result.toArray();
    }

    private void backtrack(int n, int right, int left, String s) {
        if (s.length() == n * 2) { //base case, add while string length equals n*2 right and left
            for (int i = 0; i < res.length; i++) {
                if (res[i].equals("")) {
                    res[i] = s;
                    break;
                }
            }
            return;
        }

        if (right < n) {
            s += "(";
            backtrack(n, right + 1, left, s);
            s = s.substring(0, s.length() - 1);
        }

        if (left < right) {
            s += ")";
            backtrack(n, right, left + 1, s);
            s = s.substring(0, s.length() - 1);
        }
    }
}
