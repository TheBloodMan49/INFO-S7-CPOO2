package exercises.exercise13;

import java.util.ArrayDeque;
import java.util.Deque;

public class VisitorCompute implements VisitorTree {
    public Deque<Integer> res = new ArrayDeque<>();

    @Override
    public void visitTree(Tree tree) {
        res.clear();
        tree.root.accept(this);
        System.out.println(res.pop());
    }

    @Override
    public void visitPlusNode(PlusNode n) {
        n.leftNode.accept(this);
        n.rightNode.accept(this);
        int right = res.pop();
        int left = res.pop();
        res.push(left + right);
    }

    @Override
    public void visitSubNode(SubNode n) {
        n.leftNode.accept(this);
        n.rightNode.accept(this);
        int right = res.pop();
        int left = res.pop();
        res.push(left - right);
    }

    @Override
    public void visitValueNode(ValueNode n) {
        res.push(n.val);
    }
}
