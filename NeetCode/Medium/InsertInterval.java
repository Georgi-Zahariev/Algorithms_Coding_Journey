public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        for(int i = 0; i < intervals.length; i++){
            if(newInterval == null || intervals[i][1] < newInterval[0]){
                res.add(intervals[i]);
            }else if(intervals[i][0] > newInterval[1]){
                res.add(newInterval);
                res.add(intervals[i]);
                newInterval = null;
            }else{
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            }
        }

        if(newInterval != null){
            res.add(newInterval);
        }

        return res.toArray(new int[res.size()][]);
    }
}