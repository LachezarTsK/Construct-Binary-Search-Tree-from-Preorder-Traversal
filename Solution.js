
/**
 * @param {number[]} preorder
 * @return {TreeNode}
 */
var bstFromPreorder = function (preorder) {

    const root = new TreeNode(preorder[0]);
    const monotoneIncreasingStack = [];
    monotoneIncreasingStack.push(root);
    let n = preorder.length;

    for (let i = 1; i < n; i++) {
        var next = null;

        while (monotoneIncreasingStack.length > 0 && preorder[i] > monotoneIncreasingStack[monotoneIncreasingStack.length - 1].val) {
            next = monotoneIncreasingStack.pop();
        }

        if (next !== null) {
            next.right = new TreeNode(preorder[i]);
            monotoneIncreasingStack.push(next.right);
        } else {
            next = monotoneIncreasingStack[monotoneIncreasingStack.length - 1];
            next.left = new TreeNode(preorder[i]);
            monotoneIncreasingStack.push(next.left);
        }
    }
    return root;
};


function TreeNode(val, left, right) {
    this.val = (val === undefined ? 0 : val);
    this.left = (left === undefined ? null : left);
    this.right = (right === undefined ? null : right);
}
