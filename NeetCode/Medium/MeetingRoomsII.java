/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class MeetingRoomsII {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size() == 0){
            return 0;
        }
        
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];

        for(int i = 0; i < intervals.size(); i++){
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int indexStart = 0;
        int indexEnd = 0;
        int cnt = 0;
        int result = 0;

        while(indexStart != start.length && indexEnd != end.length){
            if(start[indexStart] < end[indexEnd]){
                cnt++;
                indexStart++;                
            }else{
                indexEnd++;
                cnt--;
            }
            result = Math.max(result, cnt);
        }

        return result;
    }
}