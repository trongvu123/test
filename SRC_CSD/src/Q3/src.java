/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q3;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class src {
    
        int deg(int i) {
        int s, j;
        s = 0;
        for (j = 0; j < n; j++) {
            s += a[i][j];
        }
        s += a[i][i];
        return (s);
    }
    int count = 0;
    boolean[] visited = new boolean[20];

    void depth2(int v, RandomAccessFile f) throws Exception {

        visited[v] = true;
        // if print 3 vertex last modify count>=n-3
        if (count >=2&& count <= n) {
            fvisit(v, f);

            f.writeBytes("(" + deg(v) + ") ");
        }
        count++;
        for (int j = 0; j < n; j++) {

            if (a[v][j] == 1 && !visited[j]) {

                depth2(j, f);

            }
        }
    }
        void f1() throws Exception {
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        depth(3, f);
        f.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
   for (int i = 3; i < n; i++) {
            if (!visited[i]) {
                depth2(i, f);
            }
        }
        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }
  //===================================================================
        
           int deg(int i) {
        int s, j;
        s = 0;
        for (j = 0; j < n; j++) {
            s += a[i][j];
        }
        s += a[i][i];
        return (s);
    }
    int count = 0;
boolean [] en = new boolean[20];
int[] queue = new int[20];
int front = 0, rear = -1;

void breadth2(int v, RandomAccessFile f) throws Exception {
    queue[++rear] = v;
    en[v] = true;

    while (front <= rear) {
        int node = queue[front++];
        // if print 3 vertex last modify count>=n-3
        if (count >=1 && count <= 6) {
            fvisit(node, f);
            f.writeBytes("(" + deg(node) + ") ");
        }
        count++;

        for (int j = 0; j < n; j++) {
            if (a[node][j] == 1 && !en[j]) {
                queue[++rear] = j;
                en[j] = true;
            }
        }
    }
}
    void f1() throws Exception {
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(4, f);
        f.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
         for (int i = 4; i < n; i++) {
            if (!en[i]) {
                breadth2(i, f);
            }
        }
     //=============================================
     
        int fro = 0;
        int to = 6;
        int INF = 99;
        boolean[] S = new boolean[n];
        int[] d = new int[n];
        int[] p = new int[n];
        int i, j, k, x;
        String line1 = "";
        String lineX = "";
        String line2 = "";
        for (i = 0; i < n; i++) {
            S[i] = false;
            d[i] = a[fro][i];
            p[i] = fro;
        }
        ArrayList<Integer> lastSelected1 = new ArrayList<>();
        S[fro] = true;
        lastSelected1.add(fro);
        while (true) {
            // find k so that d[k]=min
            x = INF;
            k = -1;
            for (i = 0; i < n; i++) {
                if (S[i]) {
                    continue;
                }
                if (d[i] < x) {
                    x = d[i];
                    k = i;
                }
            }
            if (k == -1) {
                System.out.println("no solution");
                return;
            }
            S[k] = true;
            lastSelected1.add(k);
            if (k == to) {
                break;
            }
            for (i = 0; i < n; i++) {
                if (S[i]) {
                    continue;
                }
                if (d[i] > d[k] + a[k][i]) {
                    d[i] = d[k] + a[k][i];
                    p[i] = k;
                }
            }
        }
        i = to;
        Stack s = new Stack();
        s.push(i);
        while (true) {
            i = p[i];
            s.push(i);
            if (i == fro) {
                break;
            }
        }
        i = s.pop();
        line1 += v[i];

        while (!s.isEmpty()) {
            i = s.pop();
            line1 += " " + v[i];
        }
//===============================
        for (i = 0; i < n; i++) {
            S[i] = false;
            d[i] = a[fro][i];
            p[i] = fro;
        }
        ArrayList<Integer> lastSelectedX = new ArrayList<>();
        S[fro] = true;
        lastSelected1.add(fro);
        while (true) {
            x = INF;
            k = -1;
            for (i = 0; i < n; i++) {
                if (S[i]) {
                    continue;
                }
                if (d[i] < x) {
                    x = d[i];
                    k = i;
                }
            }
            if (k == -1) {
                System.out.println("no solution");
                return;
            }
            S[k] = true;
            lastSelectedX.add(k);
            if (k == to) {
                break;
            }
            for (i = 0; i < n; i++) {
                if (S[i]) {
                    continue;
                }
                if (d[i] > d[k] + a[k][i]) {
                    d[i] = d[k] + a[k][i];
                    p[i] = k;
                }
            }
        }
        i = to;
        Stack s1 = new Stack();
        s.push(i);
        while (true) {
            i = p[i];
            s.push(i);
            if (i == fro) {
                break;
            }
        }
        i = s.pop();
        for (i = lastSelectedX.size() - 4; i <= lastSelectedX.size() - 1; i++) {
            if (i == lastSelectedX.size() - 4) {
                line2 += v[lastSelectedX.get(i)];
            } else {
                line2 += " " + v[lastSelectedX.get(i)];
            }
        }
//        ===========================
        String linex1 = "";
        int fro1 = 2;
        int to1 = 5;

        for (i = 0; i < n; i++) {
            S[i] = false;
            d[i] = a[fro1][i];
            p[i] = fro1;
        }
        ArrayList<Integer> lastSelectedOne1 = new ArrayList<>();
        S[fro1] = true;
        lastSelectedOne1.add(fro);
        while (true) {
            // find k so that d[k]=min
            x = INF;
            k = -1;
            for (i = 0; i < n; i++) {
                if (S[i]) {
                    continue;
                }
                if (d[i] < x) {
                    x = d[i];
                    k = i;
                }
            }
            if (k == -1) {
                System.out.println("no solution");
                return;
            }
            S[k] = true;
            lastSelectedOne1.add(k);
            if (k == to1) {
                break;
            }
            for (i = 0; i < n; i++) {
                if (S[i]) {
                    continue;
                }
                if (d[i] > d[k] + a[k][i]) {
                    d[i] = d[k] + a[k][i];
                    p[i] = k;
                }
            }
        }
//        System.out.println("The shortest distance is: "+ d[to]);
//        System.out.println("The path is: ");
        i = to1;
        Stack s2 = new Stack();
        s2.push(i);
        while (true) {
            i = p[i];
            s2.push(i);
            if (i == fro1) {
                break;
            }
        }
        i = s2.pop();
//        System.out.print(i); 
        linex1 += v[i];

        while (!s2.isEmpty()) {
            i = s2.pop();
//            System.out.print(" --> " +i);
            linex1 += " " + v[i];
        }
        f.writeBytes(line1 + "\r\n");
        f.writeBytes(line2 + "\r\n");

        f.writeBytes(linex1 + "\r\n");
 //==================================================================================
    
 int fro=2;int to=5;
        int INF = 99;
        boolean[] S = new boolean[n];
        int[] d = new int[n];
        int[] p = new int[n];
        int i, j, k, x;
        String line1 = "";
        String lineX = "";
        String line2 = "";
        for (i = 0; i < n; i++) {
            S[i] = false;
            d[i] = a[fro][i];
            p[i] = fro;
        }
        ArrayList<Integer> lastSelected1 = new ArrayList<>();
        S[fro] = true;
        lastSelected1.add(fro);
        while (true) {
            // find k so that d[k]=min
            x = INF;
            k = -1;
            for (i = 0; i < n; i++) {
                if (S[i]) {
                    continue;
                }
                if (d[i] < x) {
                    x = d[i];
                    k = i;
                }
            }
            if (k == -1) {
                System.out.println("no solution");
                return;
            }
            S[k] = true;
            lastSelected1.add(k);
            if (k == to) {
                break;
            }
            for (i = 0; i < n; i++) {
                if (S[i]) {
                    continue;
                }
                if (d[i] > d[k] + a[k][i]) {
                    d[i] = d[k] + a[k][i];
                    p[i] = k;
                }
            }
        }
        i = to;
        Stack s = new Stack();
        s.push(i);
        while (true) {
            i = p[i];
            s.push(i);
            if (i == fro) {
                break;
            }
        }
        i = s.pop();
        line1 += v[i];

        while (!s.isEmpty()) {
            i = s.pop();
            lineX +=  v[i]+" ";
        }
        
  //      line1 += ":" + d[to]; neu muon in tat ca deg
line1 = v[fro] + "-->" + v[to] + ":" + d[to]; // ouput: C-->F:12
// line1 =""+ d[to]; // ouput:  12

//===================================================
 int fro1=0;int to1=6;
   for (i = 0; i < n; i++) {
            S[i] = false;
            d[i] = a[fro1][i];
            p[i] = fro1;
        }
        ArrayList<Integer> lastSelectedX = new ArrayList<>();
        S[fro1] = true;
        lastSelected1.add(fro1);
        while (true) {
            x = INF;
            k = -1;
            for (i = 0; i < n; i++) {
                if (S[i]) {
                    continue;
                }
                if (d[i] < x) {
                    x = d[i];
                    k = i;
                }
            }
            if (k == -1) {
                System.out.println("no solution");
                return;
            }
            S[k] = true;
            lastSelectedX.add(k);
            if (k == to1) {
                break;
            }
            for (i = 0; i < n; i++) {
                if (S[i]) {
                    continue;
                }
                if (d[i] > d[k] + a[k][i]) {
                    d[i] = d[k] + a[k][i];
                    p[i] = k;
                }
            }
        }
        i = to1;
        Stack s1 = new Stack();
        s.push(i);
        while (true) {
            i = p[i];
            s.push(i);
            if (i == fro1) {
                break;
            }
        }
        i = s.pop();
        for (i = lastSelectedX.size() - 4; i <= lastSelectedX.size() - 1; i++) {
            if (i == lastSelectedX.size() - 4) {
                line2 += v[lastSelectedX.get(i)] + "-" + d[lastSelectedX.get(i)];
            } else {
                line2 += " " + v[lastSelectedX.get(i)] + "-" + d[lastSelectedX.get(i)];
            }
        }
       f.writeBytes(lineX+"\r\n");
f.writeBytes(line1+"\r\n");
 f.writeBytes(line2+"\r\n");
}
