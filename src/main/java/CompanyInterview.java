package src.main.java;

import java.util.*;

public class CompanyInterview {







    public static void main(String[] args) {
        CompanyInterview interview = new CompanyInterview();
        String article1 = "”STANYTSIA LUHANSKA, Ukraine - Residents near Ukraine's front line rushed into basements for cover " +
                "Thursday as exchanges of artillery fire with Russian-backed separatists reached their most intense level in months, " +
                "an ominous development amid Western fears that Russia might use the fighting as a pretext to invade Ukraine. " +
                "As the United States and Russia traded conflicting accounts over whether Russian forces were really pulling back from the Ukrainian border, " +
                "as Moscow has insisted, the separatists claimed they had come under fire from the Ukrainians. " +
                "That is precisely the sort of incident Western officials have warned Russia might try to use to justify military action. " +
                "At the White House, President Biden said \"every indication we have is they’re prepared to go into Ukraine , attack Ukraine\". " +
                "He said the United States had \"reason to believe\" that Russia was “engaged in a false flag operation to have an excuse to go in.\"\n" +
                "Secretary of State Antony J. Blinken made an unscheduled trip to New York, " +
                "where he told the United Nations Security Council that " +
                "American intelligence \"indicates clearly\" that Russian forces surrounding the country " +
                "from three sides \"are preparing to launch an attack against Ukraine in the coming days.\"";
//        interview.ans(article1);
        List<Integer> src = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            src.add(i);
        }
        List<String> strings = new ArrayList<>();
        src.parallelStream().forEach(integer -> strings.add(integer + ""));
        System.out.println("size => " + strings.size());

    }


    private void ans(String article) {
        String[] splitArticle = article.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String s : splitArticle) {
            s = s.replaceAll("[^a-zA-Z]", "");
            s = s.toLowerCase();
            if (!s.equals("") && !isNumeric(s)) {
                if (map.containsKey(s)) {
                    map.put(s, map.get(s) + 1);
                } else {
                    map.put(s, 1);
                }
            }
        }
        int [] median = new int[map.size()];
        int i = 0;
        int total = 0;
        List<Word> list = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(new Word(entry.getKey(), entry.getValue()));
            median[i] = entry.getValue();
            total += entry.getValue();
            i++;
        }
        list.sort(new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                return Integer.compare(o1.nums, o2.nums);
            }
        }.reversed());
        System.out.println(list.toString());
        System.out.println(total);
        System.out.println(median.length);
        Arrays.sort(median);
        int[] ans = new int[5];
        for (i = 0; i < 5; i++) {
            ans[i] = median[median.length - 1 - i];
        }
        double res = ans[5/2];
        System.out.println(res);
        res = (ans[5/2 + 1] + ans[5/2]) / 2.0;
        System.out.println(res);
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }



    private class Word {
        public String word;
        public int nums;
        Word(String word, int nums) {
            this.word = word;
            this.nums = nums;
        }

        @Override
        public String toString() {
            return "{" +
                    "word='" + word + '\'' +
                    ", nums=" + nums + "}\n";
        }
    }



}
