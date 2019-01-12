$.func = {
    getCartInfo : function() {
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
        skuIdList = [24, 35];
        skuNumList = [2, 3];
        if (cartItemsNum === 0) return;
        console.log("skus in cart are: " + skuIdList);
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

    getLeftSideCategories : function() {
        // 左侧边栏的分类
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

    getCategoriesItems: function (current_category_name) {
        // 显示所有商品
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
    }
};
