package solution61_80;

/**
 * @Author: yhj
 * @Description:
 * @Date: Created in 2019/2/26.
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        String[] paths = new String[dirs.length+1];
        int p = 0;
        for(int i = 0;i < dirs.length;i++){
            if(dirs[i].equals("..")){
                if(p > 0){
                    p--;
                }
            }else if(dirs[i].equals("") || dirs[i].equals(".")){
                continue;
            }else {
                paths[p++] = dirs[i];

            }
        }
        if(p == 0){
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < p;i++){
            sb.append("/");
            sb.append(paths[i]);
        }
        return sb.toString();
    }
}
