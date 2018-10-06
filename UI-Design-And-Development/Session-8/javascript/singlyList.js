/**
Node Class or Constructor via function to store the data and the next pointer
*/
function Node(data) {
    this.data = data;
    this.next = null;
}

/**
Singly link list Class or Constructor via function
*/
function SinglyList() {
    this.length = 0;
    this.head = null;
}

/**
Method to add new node at the end of the singly link list
*/
SinglyList.prototype.add = function (value) {
    var node = new Node(value),
        currentNode = this.head;
    if (!currentNode) {
        this.head = node;
        this.length++;
        return node;
    }

    while (currentNode.next) {
        currentNode = currentNode.next;
    }

    currentNode.next = node;
    this.length++;
    return node;
};

/**
Method to search node by accepting position as the parameter
if position is invalid then it thorws an error message.
*/
SinglyList.prototype.searchNodeAt = function (position) {
    var currentNode = this.head,
        length = this.length,
        count = 1,
        message = {
            'failure': 'Failure: Non-existent node in this list.'
        };
    if (length === 0 || position < 1 || position > length) {
        throw new Error(message.failure);
    }

    while (count < position) {
        currentNode = currentNode.next;
        count++;
    }

    return currentNode;
};

/**
Method to delete the node at the given poistion.
*/
SinglyList.prototype.remove = function (position) {
    var currentNode = this.head,
        length = this.length,
        count = 0,
        message = {
            failure: 'Failure: non-existent node in this list.'
        },
        beforeNodeToDelete = null,
        nodeToDelete = null,
        deletedNode = null;

    if (position < 0 || position > length) {
        throw new Error(message.failure);
    }

    if (position === 1) {
        this.head = currentNode.next;
        deletedNode = currentNode;
        currentNode = null;
        this.length--;

        return deletedNode;
    }

    while (count < position) {
        beforeNodeToDelete = currentNode;
        nodeToDelete = currentNode.next;
        count++;
    }

    beforeNodeToDelete.next = nodeToDelete.next;
    deletedNode = nodeToDelete;
    nodeToDelete = null;
    this.length--;

    return deletedNode;
};
