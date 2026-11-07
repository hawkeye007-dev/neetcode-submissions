class Solution {
    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();

        for(String log : logs){
            if("../".equals(log)){
                if(!stack.isEmpty()) 
                    stack.pop();
            } else if(!"./".equals(log)) {
                stack.add(log);
            }
        }

        return stack.size();
    }
}