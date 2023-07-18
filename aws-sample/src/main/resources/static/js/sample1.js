function passwordCert(flag){
	
	var UserInput = prompt("パスワードを入力して下さい。");
	var data = encodeURI(UserInput) + "," + flag;
	
	if(!UserInput){
		return;
	}
	
	$.ajax({
      url: "/aws-sample/janitor",
      type: "POST",
      data: {
        note: data,
        _csrf: $("*[name=_csrf]").val()  // CSRFトークンを送信
      }
    })
    .done(function(data) {
	
	let element = document.createElement('a');
	
	var arrayStrig = data.split(",");
	//alert(arrayStrig[1]);
	
	if(UserInput == ""){
		alert("パスワードを入力してください。");
		return false;
	}
		
	if(arrayStrig[0] == "%E3%83%80%E3%82%A6%E3%83%B3%E3%83%AD%E3%83%BC%E3%83%89%E5%A4%B1%E6%95%97"){
		alert("パスワードが間違っています。");
		return false;
	}
		
	//a要素のhref属性を設定
	element.href = arrayStrig[1];
	//a要素のdownload属性を設定
	//element.download = 'スキルシート.xlsx';
	//a要素のtarget属性を設定
	//element.target = '_blank';
	//a要素のクリック実行
	element.click();
	//$('#fileId').trigger('click');
	//alert(document.getElementById("fileId").value);
    	
    })
    .fail(function() {
      alert("error!");
    })
    
}
