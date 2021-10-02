class Solution {
    //int m =0;
    public Boolean cu(String str){
        Set<Character>  hs = new HashSet<Character>();
        for(int i=0;i<str.length();i++){
             hs.add(str.charAt(i));
        }
        if(hs.size()==str.length())
            return true;
        return false;
        
    }
    public int maxLength(List<String> arr) {
      //  Collections.sort(arr);
        int m=0;
        Set<Character> hs = new HashSet<Character>();
        for(int i=0;i<arr.size();i++){
            if(cu(arr.get(i))){
                m=Math.max(arr.get(i).length(),m);
                    m=Math.max(m,bt(arr,i,arr.get(i)));
            }
        }
        return m;
    }
 public int bt(List<String> arr, int i,String str){
     int m= str.length();
     if(i==arr.size()){
         return 0;
     }
      for(int j=i+1;j<arr.size();j++){
            
          
       String  str1 = str+ arr.get(j);
          
          if(cu(str1)){
              m=Math.max(arr.get(j).length(),m);
            m = Math.max(m,bt(arr,j,str1));
          }
      }
        
           
      return m;   
    }
}
