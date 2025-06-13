class Solution {
    public int[] topKFrequent(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int num = entry.getKey();
            int freq = entry.getValue();

            if(buckets[freq] == null){
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(num);
        }

        List<Integer> result = new ArrayList<>();
        for(int i = buckets.length - 1; i >= 0 && result.size() < k; i--){
            if(buckets[i] != null){
                result.addAll(buckets[i]);
            }
        }

        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = result.get(i);
        }

        return res;
    }
}
