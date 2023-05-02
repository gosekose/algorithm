package dijkstra;

import java.util.ArrayList;

public class Dijkstra {

    static class Node {
        int x;
        int cost;

        Node (int x, int cost) {
            this.x = x;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {

        int v = 5; // 노드 개수
        int e = 6; // 간선 개수
        int start = 1; // 시작 노드

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 입력
        graph.get(5).add(new Node(1, 1));
        graph.get(1).add(new Node(2, 2));
        graph.get(1).add(new Node(3, 3));
        graph.get(2).add(new Node(3, 4));
        graph.get(2).add(new Node(4, 5));
        graph.get(3).add(new Node(4, 6));

        boolean[] visited = new boolean[v + 1]; // 방문 노드
        int[] dist = new int[v + 1]; // 최소 거리 배열

        for (int i = 0; i < v + 1; i++) {
            dist[i] = Integer.MAX_VALUE; // 최소 거리 할당
        }

        dist[start] = 0; // 시작 노드는 최소 거리가 0

        for (int i = 0; i < v; i++) {
            int nodeValue = Integer.MAX_VALUE; // 해당 노드의 비용
            int nodeIdx = 0; // 노드 인덱스

            for (int j = 1; j < v + 1; j++) {
                // j = 1이었을 때, dist[1] = 0
                if (!visited[j] && dist[j] < nodeValue) {
                    nodeValue = dist[j]; // nodeValue = 0
                    nodeIdx = j; // nodeIdx = 1
                }
            }

            visited[nodeIdx] = true; // nodeIdx => visited

            // j = 1 -> adjacent = 2, 3
            // ad = 2, cost = 2
            // ad = 3, cost = 3
            for (int j = 0; j < graph.get(nodeIdx).size(); j++) {
                Node adjNode = graph.get(nodeIdx).get(j);

                if (dist[adjNode.x] > dist[nodeIdx] + adjNode.cost) {
                    dist[adjNode.x] = dist[nodeIdx] + adjNode.cost;
                    // dist[2] > dist[1] + 2
                    // dist[2] = 0 + 2 = 2

                    // dist[3] = 3
                }
            }
        }

        for (int i = 1; i < v + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println("dist[" + i + "] = " + dist[i]);
            }
        }


    }


}
