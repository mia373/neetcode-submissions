class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        // Build the graph with destinations sorted lexicographically.
        for (List<String> ticket : tickets) {
            adj.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        LinkedList<String> itinerary = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");

        while (!stack.isEmpty()) {
            String currentAirport = stack.peek();
            // If there are destinations from the current airport, explore the next one.
            if (adj.containsKey(currentAirport) && !adj.get(currentAirport).isEmpty()) {
                // Fly to the next lexicographically smallest airport.
                stack.push(adj.get(currentAirport).poll());
            } else {
                // If we are stuck, this must be the end of a path segment.
                // Add it to the front of our result list.
                itinerary.addFirst(stack.pop());
            }
        }
        return itinerary;
    }
}
