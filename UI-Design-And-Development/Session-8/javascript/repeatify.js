/**
Method to repeat a string n number of times where n is a positive number
'string'.repeatify(times);
*/

String.prototype.stringify = function(times) {
    var string = '';
    if (times < 0) {
        console.log('Range Error');
    } else {
        while (times) {
            string += this;
            times--;
        }
    }
    return string;
}
