package exercises.exercise13;

public class VisitorPostFix implements VisitorTree {
	@Override
	public void visitTree(final Tree tree) {
		tree.root.accept(this);
		System.out.println();
	}

	@Override
	public void visitPlusNode(final PlusNode n) {
		n.leftNode.accept(this);
		n.rightNode.accept(this);
		System.out.print("+");
	}

	@Override
	public void visitSubNode(final SubNode n) {
		n.leftNode.accept(this);
		n.rightNode.accept(this);
		System.out.print("-");
	}

	@Override
	public void visitValueNode(final ValueNode n) {
		System.out.print(n.val + " ");
	}
}
