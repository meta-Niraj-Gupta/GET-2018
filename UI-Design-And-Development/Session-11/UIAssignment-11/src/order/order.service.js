(function () {
    angular.module("MetaMarket")
        .factory("Order", [function () {

            var orders = {};
            var lastId = 1;

            var add = function (cart, userDetail) {
                var id = lastId++;
                orders[id] = {};
                orders[id].id = id;
                orders[id].date = Date.now();
                orders[id].cart = cart;
                orders[id].userDetail = userDetail;
            }
            
            var getAll = function () {
                return orders;
            }
            
            return {
                "add": add,
                "getAll": getAll
            }
    }]);
}());
