public class CourseSchedule {
    
    private Map<Integer, List<Integer>> map = new HashMap<>();
    private Set<Integer> visiting = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for(int i = 0; i < numCourses; i++){
            map.put(i, new ArrayList<>());
        }
        for(int[] prereq : prerequisites){
            map.get(prereq[0]).add(prereq[1]);
        }

        for(int c = 0; c < numCourses; c++){
            if (!dfs(c)) {
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int course){
        if(visiting.contains(course)){
            return false;
        }

        if(map.get(course).isEmpty()){
            return true;
        }

        visiting.add(course);

        for(int pre : map.get(course)){
            if (!dfs(pre)) {
                return false;
            }
        }

        visiting.remove(course);

        map.put(course, new ArrayList<>());
        return true;
    }
}
