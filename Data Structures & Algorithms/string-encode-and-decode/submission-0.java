class Solution {

    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();
        char separator = (char)257;

        for(String s : strs){
            sb.append(s);
            sb.append(separator);
        }

        return sb.toString();
    }


    public List<String> decode(String str) {

        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(char c : str.toCharArray()){

            if(c == (char)257){
                res.add(sb.toString());
                sb = new StringBuilder();
            }
            else{
                sb.append(c);
            }
        }

        return res;
    }
}