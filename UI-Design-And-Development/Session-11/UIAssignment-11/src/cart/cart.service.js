require("../item/item.service.js");


(function () {

    angular.module("MetaMarket")
        .factory("Cart", ["Item", function (Item) {

            var items = {};
            var totalItems = 0;
            var totalPrice = 0;
            var itemsInStore = null;
            
            Item.getAll().then(function (data) {
                itemsInStore = data;
            });

            var add = function (id) {
                if (!items[id]) {
                    items[id] = {};
                    items[id].id = id;
                    items[id].quantity = 0;
                }
                items[id].quantity++;
                totalItems++;
                totalPrice += itemsInStore[id].price;
            }

            var remove = function (id) {
                items[id].quantity--;
                if (!items[id].quantity)
                    delete items[id];
                totalItems--;
                totalPrice -= itemsInStore[id].price;
            }

            var getCount = function (id) {
                if (!items[id])
                    return 0;
                return items[id].quantity;
            }

            var getTotalCount = function () {
                return totalItems;
            }

            var getItems = function () {
                return items;
            }

            var getTotalPrice = function () {
                return totalPrice;
            }

            var empty = function () {
                items = {};
                totalItems = 0;
                totalPrice = 0;
            }

            var getCartDelegate = function () {
                return {
                    "items": items
                }
            }

            var createCartFromDelegate = function (cart) {
                var totalPrice = 0;
                var totalCount = 0;

                for (var id in cart.items) {
                    totalCount += cart.items[id].quantity;
                    totalPrice += cart.items[id].quantity * itemsInStore[id].price;
                }

                return {
                    "getCount": function (id) {
                        return cart.items[id].quantity;
                    },
                    "getTotalCount": function () {
                        return totalCount;
                    },
                    "getItems": function () {
                        return cart.items;
                    },
                    "getTotalPrice": function () {
                        return totalPrice;
                    }
                }
            }

            return {
                "add": add,
                "remove": remove,
                "getCount": getCount,
                "getTotalCount": getTotalCount,
                "getItems": getItems,
                "getTotalPrice": getTotalPrice,
                "getCartDelegate": getCartDelegate,
                "empty": empty,
                "createCartFromDelegate": createCartFromDelegate
            }

    }]);


}());
