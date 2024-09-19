class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Boolean> atoms = new Stack<>();
        Stack<Character> ops = new Stack<>(), triggers = new Stack<>();
        for(char ch: expression.toCharArray()){
            if(ch=='t') atoms.push(true);
            else if(ch=='f') atoms.push(false);
            else if(ch=='!' || ch=='&' || ch=='|') ops.push(ch);
            else if(ch=='(' || ch==',') triggers.push(ch);
            else{
                char op = ops.pop();
                char trigger = triggers.pop();
                boolean res = atoms.pop();
                while(trigger!='('){
                    if(op=='&') res &= atoms.pop();
                    else res |= atoms.pop();
                    trigger = triggers.pop();
                }
                atoms.push(op=='!' ? !res : res);
            }
        }

        return atoms.pop();
    }
}