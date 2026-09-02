class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Build graph
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prerequisite = pair[1];

            graph.get(prerequisite).add(course);
        }

        // 0 = not visited
        // 1 = currently visiting
        // 2 = completely visited
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

        // We found a node currently in our DFS path
        if (state[course] == 1) {
            return true;
        }

        // Already completely checked
        if (state[course] == 2) {
            return false;
        }

        // Mark as currently visiting
        state[course] = 1;

        for (int next : graph.get(course)) {
            if (hasCycle(graph, next, state)) {
                return true;
            }
        }

        // Finished checking this course
        state[course] = 2;

        return false;
    }
}