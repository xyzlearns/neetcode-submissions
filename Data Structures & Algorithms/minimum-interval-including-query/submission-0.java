
class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int n = queries.length;
        int[] ans = new int[n];

        // Store query and original index
        int[][] sortedQueries = new int[n][2];

        for (int i = 0; i < n; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries,
            (a, b) -> Integer.compare(a[0], b[0]));

        // Min heap: [interval length, right endpoint]
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int i = 0;

        for (int[] query : sortedQueries) {

            int q = query[0];
            int index = query[1];

            // Add all intervals starting <= query
            while (i < intervals.length &&
                   intervals[i][0] <= q) {

                int left = intervals[i][0];
                int right = intervals[i][1];

                int length = right - left + 1;

                pq.offer(new int[]{length, right});

                i++;
            }

            // Remove intervals that cannot contain query
            while (!pq.isEmpty() && pq.peek()[1] < q) {
                pq.poll();
            }

            // Minimum valid interval
            if (pq.isEmpty()) {
                ans[index] = -1;
            } else {
                ans[index] = pq.peek()[0];
            }
        }

        return ans;
    }
}
