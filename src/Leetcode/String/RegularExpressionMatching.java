package Leetcode.String;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {

        char[] schar = s.toCharArray();
        char[] pchar = p.toCharArray();

        int snum = 0;
        int pnum = 0;

        if(schar[0] == '*' || pchar[0] == '*'){
            return false;
        }

        while(snum < schar.length && pnum < pchar.length){
            if(schar[snum] != pchar[pnum] && schar[snum] != '.' && schar[snum] != '*' && pchar[pnum] != '.' && pchar[pnum] != '*'){
                return false;
            }
            if(schar[snum] == pchar[pnum]){
                snum++;
                pnum++;
                continue;
            }
            if((schar[snum] != pchar[pnum]) && (schar[snum] == '.' || pchar[pnum] == '.')){
                snum++;
                pnum++;
                continue;
            }

            if(schar[snum] != pchar[pnum] && schar[snum] == '*'){
                int tep = snum - 1;

                if (schar[tep] == '.') {
                    while(pnum < pchar.length - 1 && pchar[pnum] == pchar[pnum + 1]){
                        pnum++;
                    }
                    if(snum == schar.length - 1) snum++;
                    if(pnum == pchar.length - 1) pnum++;
                    snum++;
                    continue;
                }

                if(pchar[pnum] == schar[tep] ){
                    while(snum < schar.length - 1 && schar[tep] == schar[snum + 1]){
                        snum++;
                    }//极限情况，此时结束的时候 snum == schar.length - 1
                    while(pnum < pchar.length - 1 && pchar[pnum] == schar[snum - 1]){
                        pnum++;
                    }
                    if(snum == schar.length - 1) snum++;
                    if(pnum == pchar.length - 1) pnum++;
                    continue;
                }else{
                    return false;
                }
            }
            if(schar[snum] != pchar[pnum] && pchar[pnum] == '*'){
                int tep = pnum - 1;

                if (pchar[tep] == '.') {
                    while(snum < schar.length - 1 && schar[snum] == schar[snum + 1]){
                        snum++;
                    }
                    if(pnum == pchar.length - 1) pnum++;
                    if(snum == schar.length - 1) snum++;
                    continue;
                }

                if(pchar[tep] == schar[snum] ){
                    while(pnum < pchar.length - 1 && pchar[tep] == pchar[pnum + 1]){
                        pnum++;
                    }
                    while(snum < schar.length - 1&& pchar[pnum - 1] == schar[snum]){
                        snum++;
                    }
                    if(pnum == pchar.length - 1) pnum++;
                    if(snum == schar.length - 1) snum++;
                    continue;
                }else{
                    return false;
                }
            }
        }
        if(snum == schar.length && pnum == pchar.length){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "aaaaa";
        String p = ".*";
        RegularExpressionMatching regularExpressionMatching = new RegularExpressionMatching();
        System.out.println(regularExpressionMatching.isMatch(s, p));
    }
}
