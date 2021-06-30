package adaptiveHuffman;

public class treeNode {
	// intial public values
	static final public int NYT = 100;
	static final int NODE_IS_PARENT = -1;
	static final int NODE_IS_NYT = -2;

	public int number, weigth;
	public boolean isPearent;
	public treeNode left, right, pearent;
	public char value;
	public String code;
//default constructor
	treeNode() {
		number = weigth = 0;
		isPearent = false;
		left = right = pearent = null;
		code = "";
		value = '\1';
	}

	treeNode(treeNode old) {
		number = old.number;
		weigth = old.weigth;
		isPearent = old.isPearent;
		left = old.left;
		right = old.right;
		pearent = old.pearent;
		code = old.code;
		value = old.value;
	}
//intializing root value
	public void rootInit() {
		isPearent = true;
		number = NYT;
		code = "";
		pearent = null;
	}
//incrementing weigh value
	public void increment() {
		weigth++;
	}
//checking if it is root or not
	public boolean isRoot() {
		return pearent == null ? true : false;
	}
//spliting the tree value:
	//hbda2 mn elymen (99) w b3den elshemal(98) 
	public treeNode split(char newValue) {
		left = new treeNode();
		right = new treeNode();
		isPearent = true;

		right.code = code + "1";
		right.number = number - 1;
		right.pearent = this;
		right.value = newValue;
		right.increment();

		left.code = code + "0";
		left.number = number - 2;
		left.pearent = this;

		return left;
	}

	public String toString() {
		return number + " " + code + " " + value + " " + weigth + " "
				+ isPearent;
	}

	public static void Swap(treeNode x, treeNode y) {
		char tempValue = x.value;
		x.value = y.value;
		y.value = tempValue;

		treeNode templeft = x.left;
		x.left = y.left;
		y.left = templeft;

		boolean tempIsParent = x.isPearent;
		x.isPearent = y.isPearent;
		y.isPearent = tempIsParent;

		treeNode tempRight = x.right;
		x.right = y.right;
		y.right = tempRight;

		if (x.isPearent) {
			x.left.pearent = x;
			x.right.pearent = x;
		}

		if (y.isPearent) {
			y.left.pearent = y;
			y.right.pearent = y;
		}

	}
	
//comparing the number of treeNode with another n of another treeNode
	public boolean equal(treeNode n) {
		return number == n.number ? true : false;
	}

}
