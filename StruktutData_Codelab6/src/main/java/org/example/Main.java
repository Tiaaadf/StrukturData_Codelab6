package org.example;

import java.util.*;

class GraphLogistik {
    private int jumlahVertex;
    private LinkedList<Integer>[] adjList;

    public GraphLogistik(int jumlahVertex) {
        this.jumlahVertex = jumlahVertex;
        adjList = new LinkedList[jumlahVertex];
        for (int i = 0; i < jumlahVertex; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void tambahEdge(int asal, int tujuan) {
        adjList[asal].add(tujuan); // karena directed graph
    }

    public void tampilkanAdjacencyMatrix() {
        int[][] matrix = new int[jumlahVertex][jumlahVertex];
        for (int i = 0; i < jumlahVertex; i++) {
            for (int j : adjList[i]) {
                matrix[i][j] = 1;
            }
        }
        System.out.println("Adjacency Matrix:");
        for (int[] baris : matrix) {
            for (int val : baris) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public void bfs(int mulai) {
        boolean[] dikunjungi = new boolean[jumlahVertex];
        Queue<Integer> antrian = new LinkedList<>();

        dikunjungi[mulai] = true;
        antrian.add(mulai);

        System.out.print("BFS traversal dari gudang " + (char)(mulai + 'A') + ": ");
        while (!antrian.isEmpty()) {
            int saatIni = antrian.poll();
            System.out.print((char)(saatIni + 'A') + " ");

            for (int tetangga : adjList[saatIni]) {
                if (!dikunjungi[tetangga]) {
                    dikunjungi[tetangga] = true;
                    antrian.add(tetangga);
                }
            }
        }
        System.out.println();
    }

    public void dfs(int mulai) {
        boolean[] dikunjungi = new boolean[jumlahVertex];
        System.out.print("DFS traversal dari gudang " + (char)(mulai + 'A') + ": ");
        dfsRekursif(mulai, dikunjungi);
        System.out.println();
    }

    private void dfsRekursif(int vertex, boolean[] dikunjungi) {
        dikunjungi[vertex] = true;
        System.out.print((char)(vertex + 'A') + " ");

        for (int tetangga : adjList[vertex]) {
            if (!dikunjungi[tetangga]) {
                dfsRekursif(tetangga, dikunjungi);
            }
        }
    }

    public static void main(String[] args) {
        GraphLogistik graf = new GraphLogistik(5);

        // Misal 7 jalur pengiriman: A→B, A→C, B→D, C→D, C→E, D→E, E→A
        graf.tambahEdge(0, 1); // A -> B
        graf.tambahEdge(0, 2); // A -> C
        graf.tambahEdge(1, 3); // B -> D
        graf.tambahEdge(2, 3); // C -> D
        graf.tambahEdge(2, 4); // C -> E
        graf.tambahEdge(3, 4); // D -> E
        graf.tambahEdge(4, 0); // E -> A

        graf.tampilkanAdjacencyMatrix();
        graf.bfs(0); // mulai dari A
        graf.dfs(0); // mulai dari A
    }
}