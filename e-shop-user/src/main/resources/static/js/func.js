$.func = {
    // 更新购物车信息
    getCartInfo : function() {
        //console.log("call getCartInfo");
        var skuIdList = [];
        var skuNumList = [];
        var cartItemsNum = 0;
        $.get("http://www.doperj.top:8081/api/cart",
        //$.get("http://localhost:8081/api/cart",
            {},
            function(data, status) {
                skuIdList = new Array(data.length);
                skuNumList = new Array(data.length);
                //console.log(data);
                for (var i = 0; i < data.length; i++) {
                    cartItemsNum += data[i].skuNum;
                    skuIdList[i] = data[i].skuId;
                    skuNumList[i] = data[i].skuNum;
                }
                $("#cart-num").text(cartItemsNum);
                $("#cart-items-number1").text(cartItemsNum);
            }
        );
/*        skuIdList = [24, 35];
        skuNumList = [2, 3];*/
        if (cartItemsNum === 0) return;
        console.log("skus in cart are: " + skuIdList);
        //var url = "http://www.doperj.top:8082/api/sku/List";
        var url = "http://www.doperj.top:8082/api/sku/List";
        var plainPrice = 0;
        var shippingPrice = 0;
        for (var i = 0; i < skuIdList.length; i++) {
            if (i === 0) {
                url += "?";
            }
            url += "skuId=";
            url += skuIdList[i];
            if (i !== skuIdList.length - 1) {
                url += "&";
            }
        }
        $.get(url,
            {},
            function (data, status) {
                $("#cart-list1").children().remove();
                console.log(data);
                for (var i = 0; i < data.length; i++) {
                    plainPrice += data[i].salePrice;
                    var singleCartItem = $("<div class='single-cart-item'></div>");
                    var productImageAddress = $("<a href='#' class='product-image'></a>");
                    var productImage = $("<img class='cart-thumb' alt=''>").attr("src", data[i].photoUrl.replace(/^\/+/, ''));

                    var cartItemDesc = $("<div class='cart-item-desc'></div>");
                    //var productRemove = $("<span class='product-remove'><i class='fa fa-close' aria-hidden='true'></i></span>");
                    var productRemove = $("<span class='product-remove'><i class='fa fa-minus-circle' aria-hidden='true'></i></span>");
                    var badge = $("<span class='badge'></span>").text(data[i].brandName);
                    var skuName = $("<h6></h6>").text(data[i].skuName);
                    var skuNum = $("<p class='size'></p>").text("数量：" + skuNumList[i]);
                    cartItemDesc.append(productRemove).append(badge).append(skuName).append(skuNum);

                    productImageAddress.append(productImage).append(cartItemDesc);
                    singleCartItem.append(productImageAddress);
                    $("#cart-list1").append(singleCartItem);
                }
                $("#plain-price").text("$" + plainPrice);
                $("#shipping-price").text("$" + shippingPrice);
                $("#total-price").text("$" + (plainPrice - shippingPrice));
            }
        );
    },

    // 左侧边栏的分类
    getLeftSideCategories : function() {
        var current_category = $(".page-title").first();
        var current_category_name = $(".page-title").first().text().trim();
        $.get("http://www.doperj.top:8082/api/category/2/" + current_category_name,
            {},
            function (data, status) {
                categories = new Array(data.length);
                var menuContent2 = $("#menu-content2");
                for (var i = 0; i < data.length; i++) {
                    var item = $("<li data-toggle='collapse' class='collapsed'></li>").attr("data-target", data[i].categoryName);
                    //console.log(data[i]);
                    var subCategoryName = data[i].categoryName;
                    var subCategory = $("<a href='#'>" + subCategoryName + "</a>").click(function (event) {
                        event.preventDefault();
                        var text = $(this).text();
                        console.log(text);
                        $("#cur-category-title").text(text);
                        $.func.getCategoriesItems(text);
                    });
                    item.append(subCategory);
                    menuContent2.append(item);
                }
            }
        );
        return current_category_name;
    },

    // 显示所有商品
    getCategoriesItems: function (current_category_name) {
        console.log("current category name: " + current_category_name);
        $.get("http://www.doperj.top:8082/api/sku/" + current_category_name,
            {},
            function (data, status) {
                console.log(data);
                $("#product-row").children().remove();
                $("#products-num").text(data.length);
                for (var i = 0; i < data.length; i++) {
                    var product = $("<div class='col-12 col-sm-6 col-lg-4'></div>");
                    var productWrapper = $("<div class='single-product-wrapper'></div>");
                    var productImageWrapper = $("<div class='product-img'></div>");
                    var productImage = $("<img alt=''>").attr("src", data[i].photoUrl.replace(/^\/+/, ''));
                    var hoverImage = $("<img class='hover-img' src='img/product-img/product-2.jpg' alt=''>");
                    var productBadge = $("<div class='product-badge offer-badge'>").append($("<span></span>").text("-" + data[i].discount + "%"));
                    var productFavorite = $("<div class='product-favourite'>\n" + "<a href='#' class='favme fa fa-heart'></a>\n" + "</div>");
                    productImageWrapper.append(productImage);
                    productImageWrapper.append(hoverImage);
                    if (data[i].discount > 0) {
                        productImageWrapper.append(productBadge);
                    }
                    productImageWrapper.append(productFavorite);
                    productWrapper.append(productImageWrapper);

                    var productDescription = $("<div class='product-description'></div>");
                    var brand = $("<span></span>").text(data[i].productName);
                    var productNameAddress = $("<a href='single-product-details.html'></a>");
                    var skuName = $("<h6></h6>").text(data[i].skuName);
                    productNameAddress.append(skuName);

                    var originalPricce = $("<span class='old-price'></span>").text(" $" + data[i].originalPrice);
                    var productPrice = $("<p class='product-price'></p>");
                    if (data[i].originalPrice != data[i].salePrice) {
                        productPrice.append(originalPricce);
                    }
                    productPrice.text(" $" + data[i].salePrice);

                    var hoverContent = $("<div class='hover-content'></div>");
                    var addToCart = $("<div class='add-to-cart-btn'></div>");
                    var addToCartAddress = $("<a class='btn essence-btn'>加入购物车</a>").attr("href", data[i].skuId).click(function (event) {
                        event.preventDefault();
                        console.log($(this).attr("href"));
                        $.get("http://www.doperj.top:8081/api/cart/addItem?skuId=" + $(this).attr("href"));
                        //$.get("http://localhost:8081/api/cart/addItem?skuId=" + $(this).attr("href"));
                        console.log("ooops");
                        //$.get("http://www.doperj.top:8081/api/cart",
                        $.func.getCartInfo();
                    });
                    addToCart.append(addToCartAddress);
                    hoverContent.append(addToCart);

                    productDescription.append(brand);
                    productDescription.append(productNameAddress);
                    productDescription.append(productPrice);
                    productDescription.append(hoverContent);

                    productWrapper.append(productDescription);

                    product.append(productWrapper);

                    $("#product-row").append(product);
                }
            }
        );
    },

    // 根据购物车内容生成订单页面提交信息
    getOrderInfoFromCart: function() {
        var items = {};
        $.get("http://www.doperj.top:8081/api/cart",
        //$.get("http://localhost:8081/api/cart",
            {},
            function(data, status) {
                var skuIdList = [];
                var skuNumList = [];
                var cartItemsNum = 0;
                skuIdList = new Array(data.length);
                skuNumList = new Array(data.length);
                //console.log(data);
                for (var i = 0; i < data.length; i++) {
                    skuIdList[i] = data[i].skuId;
                    skuNumList[i] = data[i].skuNum;
                }
/*                skuIdList = [24, 35];
                skuNumList = [2, 3];*/
                var url = "http://www.doperj.top:8082/api/sku/List";
                var plainPrice = 0;
                var shippingPrice = 0;
                for (var i = 0; i < skuIdList.length; i++) {
                    if (i === 0) {
                        url += "?";
                    }
                    url += "skuId=";
                    url += skuIdList[i];
                    if (i !== skuIdList.length - 1) {
                        url += "&";
                    }
                }
                $.get(url,
                    {},
                    function (data, status) {
                        console.log("skulist: ");
                        console.log(data);
                        var sumPrice = 0;
                        var shippingPrice = 0;
                        for (var i = 0; i < data.length; i++) {
                            var skuName = $("<span></span>").text(data[i].skuName + " (x " + skuNumList[i] + ")");
                            var skuPrice = data[i].salePrice;
                            var skuNum = skuNumList[i];
                            var skuSumPrice = $("<span></span>").text(skuPrice * skuNum);
                            var skuRow = $("<li></li>").append(skuName).append(skuSumPrice);
                            sumPrice += (skuPrice * skuNum);
                            $("#order-details").children().first().after(skuRow);
                        }
                        $("#order-sum-price").text("$" + sumPrice);
                        $("#order-shipping-price").text("$" + shippingPrice);
                        $("#order-total-price").text("$" + (sumPrice + shippingPrice));
                    }
                );
                for (var i = 0; i < skuIdList.length; i++) {
                    items[skuIdList[i] + ""] = skuNumList[i];
                }
            }
        );
        return items;
    },

    // 设置用户可选的地址
    getUserAddresses: function () {
        var username = "";
        $.get("http://www.doperj.top:8081/api/login_user", {}, function (data, status) {
            //$.get("http://localhost:8081/api/login_user", {}, function (data, status) {
            var obj = JSON.parse(data);
            console.log(obj);
            username = obj.username;
        });
        //username = "doperj";
        console.log("username: " + username);
        $.get("http://www.doperj.top:8081/api/address/" + username, {}, function(data, status) {
            console.log(data);
            if (data.length === 0) return;
            for (var i = 0; i < data.length; i++) {
                if (data[i].isDefault) {
                    var tmp = data[0];
                    data[0] = data[i];
                    data[i] = tmp;
                }
            }
            for (var i = 0; i < data.length; i++) {
                var add_val = data[i].province + ", " + data[i].city + ", " + data[i].district + ", " + data[i].address + ", " + data[i].zip;
                var add_tag = $("<li></li>").text(add_val).attr("address-id", data[i].addressId)
                    .attr("class", "option selected focus").click(function (event) {
                        event.preventDefault();
                        var address_id = $(this).attr("address-id");
                        console.log(address_id);
                        $("#address").next().attr("tabindex", address_id);
                    });
                console.log(add_tag);
                console.log($("#address"));
                $("#address").next().children("ul").append(add_tag);
            }
        });
    },

    // 设置订单点击提交功能
    getOrderSubmittable: function (items) {
        $("#submit-button").click(function (event) {
            event.preventDefault();
            console.log("address id is: " + $("#address").next().attr("tabindex"));
            var addressId = $("#address").next().attr("tabindex");
            if (addressId === "0" || addressId === null) {
                alert("请选择地址");
                return;
            }
            var firstName = $("#first_name").val();
            if (firstName === "" || firstName === null) {
                alert("请输入收件人姓氏");
                return;
            }
            var lastName = $("#last_name").val();
            if (lastName === "" || lastName === null) {
                alert("请输入收件人名称");
                return;
            }
            var jsonObj = {
                "addressId": addressId,
                "items": items,
                "firstName": firstName,
                "lastName": lastName
            };
            var jsonReq = JSON.stringify(jsonObj);
            console.log(jsonReq);
            $.ajax({
                type: 'post',
                url: 'http://www.doperj.top:8083/api/order',
                contentType:"application/json;charset=utf-8",
                data: jsonReq,
                dataType: "json",
                success: function(data) {
                    console.log(data);
                    alert("订单提交成功");
                }
            });
        });
    }
};
