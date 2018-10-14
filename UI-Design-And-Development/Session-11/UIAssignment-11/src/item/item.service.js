require("../app.module.js");

(function () {
    angular.module("MetaMarket")
        .factory("Item", ["$http", function ($http) {
            
        var itemListPromise = null;
        var itemList = {};
            
        var init = function () {
            return $http.get("res/data/item-list.json?ver=3aaas4").then(function (response) {
                response.data.forEach(function (item) {
                    itemList[item.id] = item;
                });
                return itemList;
            });
        }

        var getAll = function () {
            if (!itemListPromise)
                itemListPromise = init();
            return itemListPromise;
        }

        return {
            "getAll": getAll
        }
            
    }]);
}());
