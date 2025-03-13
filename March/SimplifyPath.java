package March;

import java.util.Stack;

public class SimplifyPath {
    
    private String simplify(String path){
        String[] pathChar = path.split("/");
        Stack<String> st = new Stack<>();
        for(String s: pathChar){
            if(s.equals("") || s.equals("."))
                continue;
            else if(s.equals("..")){
                if(!st.isEmpty())
                    st.pop();
            }else{
                st.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        if(st.isEmpty()){
            sb.append("/");
        }
        for(String p: st){
            sb.append("/"+p);
        }
       // System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        String path1 = "/home/user//Documents/../Pictures";
        String path2 = "/../";
        String path3 = "/.../a/../b/c/../d/./";
        SimplifyPath s = new SimplifyPath();
        System.out.println(s.simplify(path2));
        System.out.println(s.simplify(path1));
        System.out.println(s.simplify(path3));
        
    }

}
