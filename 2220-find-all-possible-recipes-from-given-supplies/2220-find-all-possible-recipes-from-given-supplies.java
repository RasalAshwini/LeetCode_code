import java.util.*;

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Integer> indegree = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();
        Set<String> available = new HashSet<>(Arrays.asList(supplies));

        // Initialize graph and indegree for each recipe
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            indegree.put(recipe, ingredients.get(i).size()); // Number of ingredients needed
            
            for (String ingredient : ingredients.get(i)) {
                // If the ingredient is not a supply, it might be a recipe
                graph.computeIfAbsent(ingredient, k -> new ArrayList<>()).add(recipe);
            }
        }

        // Queue for processing recipes that can be made
        Queue<String> queue = new LinkedList<>();
        
        // Start with available supplies
        for (String supply : supplies) {
            queue.offer(supply);
        }

        List<String> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            String item = queue.poll();

            if (indegree.containsKey(item)) { // It's a recipe that we can now make
                result.add(item);
            }

            // Reduce indegree of dependent recipes
            if (graph.containsKey(item)) {
                for (String dependent : graph.get(item)) {
                    indegree.put(dependent, indegree.get(dependent) - 1);

                    // If all ingredients are now available, add to queue
                    if (indegree.get(dependent) == 0) {
                        queue.offer(dependent);
                    }
                }
            }
        }

        return result;
}
}
