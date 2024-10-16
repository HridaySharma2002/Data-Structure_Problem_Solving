import java.util.List;
import java.util.ArrayList;
class Solution {
    public List<String> validStrings(int n) {
        List<String> result=new ArrayList<>();
        generate_string(n,"",result);
        return result;
    }
    public void generate_string(int n,String current,List<String> result){
        if(current.length()==n){
            result.add(current);
            return;
        }

        generate_string(n,current+'1',result);

        if(current.length()==0 || current.charAt(current.length()-1)!='0'){
            generate_string(n,current + '0',result);
        }
    }
}
