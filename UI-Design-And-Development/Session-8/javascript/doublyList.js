/**
Node Class or Constructor via function to store the data and the next and previous pointer
*/
function Node(value) {
    this.data = value;
    this.previous = null;
    this.next = null;
}

/**
Doubly link list Class or Constructor via function
*/
function DoublyList() {
    this.length = 0;
    this.head = null;
    this.tail = null;
}

/**
Method to add node at the end of the doubly link list
*/
DoublyList.prototype.add = function (value) {
    var node = new Node(value);

    if (this.length) {
        this.tail.next = node;
        node.previous = this.tail;
        this.tail = node;
    } else {
        this.head = node;
        this.tail = node;
    }

    this.length++;

    return node;
};

/**
Method to search node at a given position.
*/
DoublyList.prototype.searchNodeAt = function (position) {
    var currentNode = this.head,
        length = this.length,
        count = 1,
        message = {
            failure: 'Failure: non-existent node in this list.'
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
Method to delete a node at a given position.
*/
DoublyList.prototype.remove = function (position) {
    var currentNode = this.head,
        length = this.length,
        count = 1,
        message = {
            failure: 'Failure: non-existent node in this list.'
        },
        beforeNodeToDelete = null,
        nodeToDelete = null,
        deletedNode = null;

    if (length === 0 || position < 1 || position > length) {
        throw new Error(message.failure);
    }
    deletedNode = currentNode;
    if (position === 1) {
        this.head = currentNode.next;

        if (this.head) {
            this.head.previous = null;
        } else {
            this.tail = null;
        }
    } else if (position === this.length) {
        this.tail = this.tail.previous;
        this.tail.next = null;
    } else {
        while (count < position) {
            currentNode = currentNode.next;
            count++;
        }

        beforeNodeToDelete = currentNode.previous;
        nodeToDelete = currentNode;
        afterNodeToDelete = currentNode.next;

        beforeNodeToDelete.next = afterNodeToDelete;
        afterNodeToDelete.previous = beforeNodeToDelete;
        deletedNode = nodeToDelete;
        nodeToDelete = null;
    }

    this.length--;

    return deletedNode;
};
