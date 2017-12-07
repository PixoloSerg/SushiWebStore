    
    function trueMod(a, b) {
	return ( (a % b) + b ) % b;
    }

    function moveThree() {
	var startIdx = 0;
	return function(what, pos) {
	    var i;
	    var length = 0;
	    var items = document.getElementById(what).getElementsByTagName('li');
	    length = items.length;
	    startIdx += pos * 3;
	    startIdx = trueMod(startIdx, length);
	    for(i=0; i<length; i++) {
		items[i].setAttribute('class', 'goodsCard_li hide fade');
	    }
	    for(i=0; i<3; i++) {
		items[(startIdx + i) % length].setAttribute('class', 'goodsCard_li visible fade');
	    }    	
	};
    }
    
    var popularCarousel = moveThree();
    var newCarousel = moveThree();
    
    function moveTwo() {
	var startIdx = 0;
	return function(what, pos) {
	    var i; var length; 
	    var list = document.getElementById(what);
	    var items = list.getElementsByTagName('li');
	    length = items.length;
	    var save;
	    for(i=0; i<length; i++) {
		if(items[i].className === 'goodsCard_li steady') {
		    save = items[i];
		    break;
		}
	    }
	    list.removeChild(save);
	    length = items.length;
	    startIdx += pos * 2;
	    startIdx = trueMod(startIdx, length);
	    for(i=0; i<length; i++) {
		if(items[i] !== save) {
		    items[i].setAttribute('class', 'goodsCard_li hide fade');
		}
	    }
	    var before = -1; var cur;
	    for(i=0; i<2; i++) {
		cur = (startIdx + i) % length;
		if(before < cur) before = cur;
		items[cur].setAttribute('class', 'goodsCard_li visible fade');
	    }
	    list.insertBefore(save, items[before]);	    
	};
    }
    
    var recommendCarousel = moveTwo();
    var saleCarousel = moveTwo();
    
    
   function addGoods(elem, goodsId) {
       var goodsToolsBlock = elem.parentElement;
       var counter = goodsToolsBlock
	       .getElementsByClassName("goodsCard_Pic_Tools_CountBlock")[0]
	       .getElementsByClassName("goodsCard_Pic_Tools_InpCount")[0];
       var qnt = Number.parseInt(counter.textContent);
       var xhttp = new XMLHttpRequest();
       xhttp.onreadystatechange = function() {
	    if(this.readyState == 4 && this.status == 200) {
		updateShopCartStatus();
                updateOrderColumn();
            }
       };
       xhttp.open('POST', '/shopcart', true);
       xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
       xhttp.send("addGoods=1&goodsId=" + goodsId + "&goodsQnt="+qnt);       
   }
   
   function updateShopCartStatus() {
       var req = new XMLHttpRequest();
       req.onreadystatechange = function() {
	   if(this.readyState == 4 && this.status == 200) {
	       document.getElementById("bandHeadInfo_ShopStatus").innerHTML = this.responseText;
	   }
       };
       req.open('GET', '/cartstatus', true);
       req.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
       req.send();
   }
   
   function updateOrderColumn() {       
       var req = new XMLHttpRequest();
       req.onreadystatechange = function() {
	   if(this.readyState == 4 && this.status == 200) {
               var orderCol = document.getElementById("bandCategoryBody_Content_Data_Order_Block");
               if(orderCol !== undefined) {
                    orderCol.innerHTML = this.responseText;
                }
	   }
       };
       req.open('GET', '/ordercolumn', true);
       req.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
       req.send();
   }
   
   function changeCount(elem, direction) {
       var countBlock = elem.parentElement;
       var counter = countBlock.getElementsByClassName("goodsCard_Pic_Tools_InpCount")[0];
       var qnt = Number.parseInt( counter.textContent);
       direction ? ++qnt : --qnt;
       if(qnt <= 0) return;
       counter.textContent = qnt;
   }
   
   function changeItemCount(lineItem, elem, dir) {
       var counterElem = elem.parentElement.getElementsByClassName('lineItem_GoodsQnt_Value')[0];       
       var qnt = Number.parseInt( counterElem.textContent );
       dir ? ++qnt : --qnt;
       if(qnt <= 0) return;
       updateLineItem(lineItem, qnt);
   }
   
   function updateLineItem(lineItem, qnt) {
       var req = new XMLHttpRequest();
       req.onreadystatechange = function() {
	    if(this.readyState == 4 && this.status == 200) {
		updateShopCartStatus();
                updateOrderColumn();
            }
       };
       req.open('POST', '/shopcart', true);
       req.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
       req.send("setItem=1&itemId=" + lineItem + "&itemQnt="+qnt);            
   }
   
   function deleteItem(lineItem, elem) {
       var req = new XMLHttpRequest();
       req.onreadystatechange = function() {
	   if(this.readyState == 4 && this.status == 200) {
		updateShopCartStatus();
                updateOrderColumn();
	   }
       }
       req.open('POST', '/shopcart', true);
       req.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
       req.send("delItem=1&itemId=" + lineItem);   
   }