/**
Queue Class or Constructor via function
*/
function Queue() {
    this.oldestIndex = 1;
    this.newestIndex = 1;
    this.storage = {};
}

/**
Method to get the size of the queue
*/
Queue.prototype.size = function () {
    return this.newestIndex - this.oldestIndex;
};

/**
Method to add or enqueue data in the queue
*/
Queue.prototype.enqueue = function (data) {
    this.storage[this.newestIndex] = data;
    this.newestIndex++;
};

/**
Method to remove data or dequeue from the queue
**/
Queue.prototype.dequeue = function () {
    var oldestIndex = this.oldestIndex,
        newestIndex = this.newestIndex,
        deletedData;
    if (oldestIndex !== newestIndex) {
        deletedData = this.storage[oldestIndex];
        delete this.storage[oldestIndex];
        this.oldestIndex++;
        return deletedData;
    }
};
