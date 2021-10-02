import java.util.*;
class graph{
    int v,r=0;
    stackk st ;
    List<List<Integer>> al ;
    graph(int v){
        this.v=v;
        st = new stackk();
        al = new ArrayList<>();
        for(int i=0;i<v;i++){
            al.add(new ArrayList<Integer>());
        }
    }
    public void add(int v,int e){
        al.get(v).add(e);
        al.get(e).add(v);
    }
    public void adde(int v,int e){
        al.get(v).add(e);
       // al.get(e).add(v);
    }
    public void dfs(boolean[] vis,int v){
        vis[v]=true;
        System.out.print(v);
        for(int i=0;i<al.get(v).size();i++){
            if(!vis[al.get(v).get(i)]){
                dfs(vis,al.get(v).get(i));
            }
        }
    }
    public int  cc(){
        boolean[] vis = new boolean[v];
        for(int i=0;i<v;i++){
            if(!vis[i]){
                dfs(vis,i);
                System.out.println();
                r++;
            }
        }
        return r;
    }
    public boolean isdfscycle(boolean[] vis,int v,int par){
        vis[v]=true;
        for(int i=0;i<al.get(v).size();i++){
            if(!vis[al.get(v).get(i)]){
                if(isdfscycle(vis, al.get(v).get(i), v))
                    return true;
            }
            else{
                if(par!=al.get(v).get(i)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isundcycle(){
        boolean[] vis = new boolean[v];
       for(int i=0;i<v;i++){
            if(!vis[i]){
                if(isdfscycle(vis,i,-1))
                    return true;
            }
       }
       return false;
    }
    public void topoutil(boolean[] vis,int v){
        vis[v]=true;
        for(int i=0;i<al.get(v).size();i++){
            if(!vis[al.get(v).get(i)]){
                topoutil(vis,al.get(v).get(i));
            }
        }
        st.push(v);
    }
    public void topo(){
        boolean[] vis = new boolean[v];
        for(int i=0;i<v;i++){
            if(!vis[i])
            topoutil(vis,i);
        }
          
       while(!st.isEmpty()){
            System.out.println(st.pop());
       }
    }
    public void topo2(){
        int indegree[] = new int[v];
        for(int i=0;i<v;i++){
            for(int j=0;j<al.get(i).size();j++){
                indegree[al.get(i).get(j)]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<v;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        ArrayList<Integer> al1 = new ArrayList<Integer>();
        int c=0;
        while(!q.isEmpty()){
            int ch=q.poll();
            al1.add(ch);
            for(int i=0;i<al.get(ch).size();i++){
                indegree[al.get(ch).get(i)]--;
                if(indegree[al.get(ch).get(i)]==0){
                    q.add(al.get(ch).get(i));
                }
            }
            c++;
        }
        if(c!=v){
            System.out.println("cyclic graph");
        }
        else{
            System.out.print(al1);
        }
    }
}
class stackk{
    int t ,c;
    int[] arr;
    stackk(){
        t=-1;
        c=10000;
        arr= new int[c];
    }
    public void push(int v){
        if(t+1==c){
            System.out.println("Stack Overflow");
        }
        else{
            arr[++t]=v;
        }
    }
    public int pop(){
        if(t!=-1){
            return arr[t--];
        }
        else{
            System.out.println("Stack empty");
            return -9999;
        }
    }
    public boolean isEmpty(){
        if(t==-1){
            return true;
        }
        return false;
    }
}
class tp{
public static void main(String[] args){
        graph g = new graph(5);
        g.add(1,0);
        g.add(2,3);
        g.add(3,4);
        System.out.println(g.cc());
        graph g1 = new graph(3);
        g1.add(1, 0);
        g1.add(0, 2);
        g1.add(2, 1);
        System.out.println(g1.isundcycle());
        graph g2 = new graph(6);
        g2.adde(5, 2);
        g2.adde(5, 0);
        g2.adde(4, 0);
        g2.adde(4, 1);
        g2.adde(2, 3);
        g2.adde(3, 1);
        g2.topo();
        g2.topo2();

    }
}