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

public class MeetingRooms {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() <= 1){
            return true;
        }
        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));

        for(int i = 1; i < intervals.size(); i++){
            if(intervals.get(i-1).end > intervals.get(i).start){
                return false;
            }
        }

        return true;

    }
}
