//1281. Subtract the Product and Sum of Digits of an Integer
class Solution {
    public int subtractProductAndSum(int n) {
        int tmp = n;
        int i = 0;
        int pod = 1;
        int sod = 0;
        Map<Integer , Integer> map = new HashMap<Integer, Integer>();
        while(tmp != 0){
            map.put(i,tmp%10);
            i++;
            tmp = tmp/10;
        }
        for (int j = 0 ; j <= i ;j++){
            if(map.get(j) != null){
                pod = pod * map.get(j);
                sod = sod + map.get(j);
            }
        }
        return pod - sod;
    }
}
