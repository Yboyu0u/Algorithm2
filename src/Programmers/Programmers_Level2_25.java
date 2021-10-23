package Programmers;



// 올바른 괄호 문자열  (), [], {}

// s: 대괄호, 중괄호, 소괄호로 이루어진 문자열 s
// s를 왼쪽으로 0<=x<=s.length() 만큼 회전시켰을 때 s가 올바른 괄호 문자열이 되게 하는 x의 개수 return

import java.util.Stack;

public class Programmers_Level2_25 {

    private static class Solution {
        public int solution(String s) {
            int answer = 0;

            for(int i=0; i<s.length(); i++){
                String ss="";
                if(i==0){
                    ss = s;
                }else{
                    ss = s.substring(i,s.length())+s.substring(0,i);
                }
                if(checkCorStr(ss)){
                    answer++;
                }
            }
            return answer;
        }

        public boolean checkCorStr(String s){
            Stack<Character> stk = new Stack<>();
            for(int i=0; i<s.length(); i++){
                char brc = s.charAt(i);
                if(brc == '(' || brc == '{' || brc == '['){
                    stk.push(s.charAt(i));
                }else{
                    if(stk.empty() && (brc == ')' || brc == '}' || brc == ']')){
                        return false;
                    }
                    if(brc == ')' && stk.peek() == '('){
                        stk.pop();
                    }else if(brc == '}' && stk.peek() == '{'){
                        stk.pop();
                    }else if(brc == ']' && stk.peek() == '['){
                        stk.pop();
                    }else{
                        return false;
                    }
                }
            }
            if(stk.empty()){
                return true;
            }else return  false;
        }
    }
    public static void main(String[] args){
        String s= "}}}";

        System.out.println(new Solution().solution(s));
    }

}
