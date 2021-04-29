/**
 * @Author: Parsa Rahimi <par5ul1>
 * @Date:   2021-04-29T10:13:57-07:00
 * @Filename: Judge.java
 * @Last modified by:   par5ul1
 * @Last modified time: 2021-04-29T11:16:23-07:00
 */

public class Judge {

  public int findJudge(int N, int [][] trust) {

    // Conceptually, I am building an adjacency matrix for an unweighted, directed graph.
    // Actually, I only care about the sum of the rows and the sum of the columns (which is the number of incoming and outgoing connections for each node).

    int [] rows = new int[N]; // how many people each person trusts
    int [] cols = new int[N]; // how many people trust each person

    for (int [] t: trust) { // for every trust relationship...
      rows[t[0]-1]++; // the first element symbolizes the act of trusting "someone"
      cols[t[1]-1]++; // the second element symbolizes the act of being trusted by someone
    }

    for (int i = 0; i < N; i++) { // Attempt to find the judge by checking connections

      // if there's a person with 0 incoming connections and N-1 outgoing connections, it must be the judge (by the Pigeonhole Principle there can only be one who satisfies both this conditions)
      if ((rows[i] == 0) && (cols[i] == (N-1))) {
        return i+1; // Return the judge
      }

    }

    return -1; // There's no judge

  }

}
