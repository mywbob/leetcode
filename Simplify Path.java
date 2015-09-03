public class Solution {
    public String simplifyPath(String path) {
        if (path == null) return null;
        String[] arr = path.split("/+");
        String res = "";
        for (int i=0; i< arr.length; i++) {
            if (arr[i].length() != 0) {
                if (arr[i].equals(".")) continue;
                else if (arr[i].equals("..")) {
                    int index = res.length()-1;
                    while (index >= 0 && res.charAt(index) != '/') {
                        index--;
                    }
                    if (index < 0) continue;
                    res = res.substring(0,index);
                } else {
                    res = res + '/' + arr[i];
                }
                
                
            }
        }
        
        if (res.length() == 0) return "/";
        return res;
        
    }
}