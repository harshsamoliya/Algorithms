
    // Time complexity -> O(v + e) 
    // Space complexiry -> O(v)
    // same as  dfs
    public boolean helper(int i,int[][] edges,boolean[] v,boolean[] incall){
        v[i] = true;
        incall[i] = true;
        int[] neighbours = edges[i];
        for(int node : neighbours){
            if(!v[node]){
                boolean iscycle = helper(node,edges,v,incall);
                if(iscycle){
                    return true;
                }
            }else if(incall[node]){
                return true;
            }
        }
        incall[i] = false;
        return false;
    }
    public boolean cycleInGraph(int[][] edges) {
        int len = edges.length;
        boolean[] visited = new boolean[len];
        boolean[] incallstack = new boolean[len];
        for(int i = 0; i < edges.length;i++){
            if(visited[i]){
                continue;
            }
            boolean isCycle = helper(i,edges,visited,incallstack);
            if(isCycle) {
                return true;
            }
        }
        return false;
    }
