class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prerequisite = pair[1];

            graph.get(prerequisite).add(course);
        }

        int[] state = new int[numCourses];

        for (int course = 0; course < numCourses; course++) {
            if (state[course] == 0) {
                if (hasCycle(graph, course, state)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean hasCycle(
        List<List<Integer>> graph,
        int course,
        int[] state
    ) {

        if (state[course] == 1) {
            return true;
        }

        if (state[course] == 2) {
            return false;
        }

        state[course] = 1;

        for (int next : graph.get(course)) {
            if (hasCycle(graph, next, state)) {
                return true;
            }
        }

        state[course] = 2;

        return false;
    }
}