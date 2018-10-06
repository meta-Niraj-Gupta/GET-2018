/**
Stack Class or Constructor via function
*/
function Stack() {
    this.size = 0;
    this.storage = {}; 
}

/**
Method to add or push data into the stack
*/
Stack.prototype.push = function(data) {
    var size = ++this.size; 
    this.storage[size] = data;
};

/**
Method to delete or pop data from the stack
*/
Stack.prototype.pop = function() {
    var size = this.size, deleteData;
    if (size) {
       deleteData = this.storage[size];
       delete this.storage[size];
       this.size--;
       return deleteData; 
    }
};