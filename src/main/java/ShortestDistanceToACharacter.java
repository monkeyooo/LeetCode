package src.main.java;


//821. Shortest Distance to a Character
public class ShortestDistanceToACharacter {
    public static void main(String[] args) {
        String s = "loveleetcode";
        char c = 'e';
        int[] res = shortestToChar(s, c);
        for (int r : res) {
            System.out.print(r + ",");
        }
    }
    public static int[] shortestToChar(String s, char c) {
        int size = s.length();
        int[] res = new int[size];
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            if (s.charAt(i) == c) {
                res[i] = 0;
            } else {
                res[i] = -1;
            }
        }
        for(int i = 0; i < res.length; i++) {
            if(res[i] != 0) {
                int offset = 1;
                while (true) {
                    if (i + offset < size) {
                        if (res[i + offset] == 0) {
                            break;
                        }
                    }
                    if (i - offset >= 0) {
                        if (res[i - offset] == 0) {
                            break;
                        }
                    }
                    offset++;
                }
                res[i] = offset;
            }
        }
        return res;
    }
}
