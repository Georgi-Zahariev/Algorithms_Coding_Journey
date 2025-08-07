public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals == null){
            return null;
        }

        if(intervals.length == 1){
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i-1][1] < intervals[i][0]){
                result.add(intervals[i-1]);
            }else if(intervals[i-1][1] >= intervals[i][0]){
                intervals[i][0] = intervals[i-1][0];
                if(intervals[i-1][1] >= intervals[i][1]){
                    intervals[i][1] = intervals[i-1][1];
                }
            }

            if(i == intervals.length - 1){
                result.add(intervals[i]);
            }

        }
        return result.toArray(new int[result.size()][]);
    }
}
