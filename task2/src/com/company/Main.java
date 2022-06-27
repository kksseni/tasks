package com.company;

import java.util.Arrays;
import java.util.Scanner;

//This program finds the shortest paths from a given vertex to other vertices.
public class Main {
    // Entering all required data
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number of tests: ");
        int tests = in.nextInt();
        for (int i = 0; i < tests; i++) {
            System.out.print("Input a number of cities: ");
            int cities = in.nextInt();
            String[] city_name = new String[cities];
            int[][] mas_dist = new int[cities][cities];
            //Assume that all vertices are separated from each other
            for (int i1 = 0; i1 < cities; i1++) {
                for (int i2 = 0; i2 < cities; i2++) {
                    mas_dist[i1][i2] = 100000;
                }
            }
            int num_find;
            String start_name, finish_name;
            for (int j = 0; j < cities; j++) {
                System.out.print("Input a name of a city: ");
                city_name[j] = in.next();
                System.out.print("Input a number of neighbors: ");
                int neighbors = in.nextInt();
                for (int t = 0; t < neighbors; t++) {
                    System.out.print("Input a neighbor number: ");
                    int num_neighbor = in.nextInt();
                    System.out.print("Input distance: ");
                    mas_dist[j][num_neighbor - 1] = in.nextInt();
                }

            }
            System.out.print("Input number of searches: ");
            num_find = in.nextInt();
            for (int n = 0; n < num_find; n++) {
                System.out.print("Input name of a start city: ");
                start_name = in.next();
                System.out.print("Input name of a finish city: ");
                finish_name = in.next();
                int dist = find_short_way(Arrays.asList(city_name).indexOf(start_name), Arrays.asList(city_name).indexOf(finish_name), mas_dist);
                System.out.println("distance: " + dist);
            }
        }
    }

    // To solve this problem, we will use Dijkstra's algorithm.The distance array will store
    // the shortest paths from the starting vertex to the others. Массив visited определяет в каких вершинах мы уже побывали
    //start_name - the index of the vertex where we are. finish_name - the index of the vertex to which we need to find the shortest path.
    private static int find_short_way(int start_name, int finish_name, int[][] mas_dist) {
        int len = mas_dist[0].length;
        int[] distance = new int[len];
        int index = 0, i, u, m = start_name + 1;
        boolean[] visited = new boolean[len];
        //Assume that all vertices are separated from each other and we haven't visited more than one vertex yet.
        for (i = 0; i < len; i++) {
            distance[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        // If we start from some vertex, then the path to it is 0.
        distance[start_name] = 0;
        //Find the shortest paths from the current vertex to the rest.
        for (int count = 0; count < len; count++) {
            int min = Integer.MAX_VALUE;
            for (i = 0; i < len; i++)
                if (!visited[i] && distance[i] <= min) {
                    min = distance[i];
                    index = i;
                }
            u = index;
            visited[u] = true;

            //Change the value of the distance at the vertices, if there is a shorter path
            for (i = 0; i < len; i++)
                if (!visited[i] && distance[u] + mas_dist[u][i] < distance[i])
                    distance[i] = distance[u] + mas_dist[u][i];
        }
        return distance[finish_name];
    }
}
