/*
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
*/


/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
	//init state is important
	//syc orgCur and copyCur
    Set<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
    Map<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode start = new UndirectedGraphNode(node.label);
        map.put(node, start);
        queue.add(node);
        visited.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode nodeOrg  = queue.poll();
            UndirectedGraphNode nodeCpy = map.get(nodeOrg);
            //visited.add(nodeOrg);//put here only is wrong such as, 3 connect to 4, (2 edges)
            
            for (UndirectedGraphNode nbs : nodeOrg.neighbors) {
                if (!visited.contains(nbs)) {
                    queue.add(nbs);
                    UndirectedGraphNode temp = new UndirectedGraphNode(nbs.label);
                    map.put(nbs, temp);
                    //connect
                    nodeCpy.neighbors.add(temp);
                    
                    //visited here
                    visited.add(nbs);
                } else {
                    //connect
                    nodeCpy.neighbors.add(map.get(nbs));
                }
            }
        }

        return start;
    }
}