require("./item.service.js");
require("../cart/cart.service.js");

(function () {
    angular.module("MetaMarket").controller("ItemController", ["$scope", "Item", "Cart", function ($scope, Item, Cart) {

        $scope.categories = ["", "1", "2", "3", "4"];
        $scope.cart = Cart;

        $scope.refresh = function () {
            Item.getAll().then(function (data) {
                $scope.items = [];
                for (var property in data)
                    $scope.items.push(data[property]);
            });
        };
        
        $scope.$on('$viewContentLoaded', function () {
            $("button.list-group-item").click(function (event) {
                var button = event.delegateTarget;
                $(button.parentNode).find(".active").removeClass("active");
                button.classList.add("active");
            });
        });
        
        $scope.refresh();
    }]);
}());
