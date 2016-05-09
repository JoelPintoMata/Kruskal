import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	static int path[];
	static int numberOfCities, numberOfPossibleRoutes, i, j;
	static double mincost, totalCost;

	public static void main(String args[]) throws Exception {

		// Creating graph of 'n' vertices & 'm' edges
		Scanner stdin = new Scanner(System.in);
		
		numberOfCities = new Integer(String.valueOf(stdin.next()));
		numberOfPossibleRoutes = new Integer(String.valueOf(stdin.next()));

		path = new int[numberOfCities + 1];

		Edge e[] = new Edge[numberOfPossibleRoutes];
		Edge t = new Edge();

		for (i = 0; i < numberOfPossibleRoutes; i++) {
			e[i] = new Edge();
			e[i].u = Integer.parseInt(stdin.next());
			e[i].v = Integer.parseInt(stdin.next());
			e[i].wt = Double.valueOf(stdin.next());
		}

		// Sorting the edges in ascending order of weights
		for (i = 0; i <= numberOfPossibleRoutes - 1; i++) {
			for (j = 0; j < numberOfPossibleRoutes - i - 1; j++) {
				if (e[j].wt > e[j + 1].wt) {
					t = e[j];
					e[j] = e[j + 1];
					e[j + 1] = t;
				}
			}
		}

		// Initializing the path array
		for (i = 1; i <= numberOfCities; i++) {
			path[i] = 0;
		}

		// Counts the number of edges selected in the tree
		i = 0;

		// Counts the number of edges selected or discarded
		j = 0;

		mincost = 0;
		System.out.println();
		while ((i != numberOfCities - 1) && (j != numberOfPossibleRoutes)) {
			if (checkCycle(e[j])) {
				System.out.println("Route (" + e[j].u + ", " + e[j].v + ") "
						+ "with operational cost of " + e[j].wt + " ");
				mincost = mincost + e[j].wt;
				i++;
				totalCost = totalCost + e[j].wt;
			}
			j++;
		}
		System.out.println("Total operational cost "+totalCost);
		if (i != numberOfCities - 1) {
			System.out.println("Minimum spanning tree cannot be formed ");
		}
	}

	public static boolean checkCycle(Edge e) {
		int u = e.u, v = e.v;

		while (path[u] > 0)
			u = path[u];

		while (path[v] > 0)
			v = path[v];

		if (u != v) {
			path[u] = v;
			return true;
		}
		return false;
	}

	static class Edge {
		int u, v;
		double wt;
	}
}