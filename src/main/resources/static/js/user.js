let index = {
	init:function(){
		$("#btn-save").on("click", ()=>{
			this.save()//화살표 함수를 사용하는 이유는 this를 바인딩 하기 위해서이다
		})
	},
	save:function(){
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		}
		
		$.ajax({
			type:"POST",
			url:"/blog/api/user",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType:"json"
			
		}).done(function(resp){
			alert('회원 가입 완료')
			console.log(resp)
		}).fail(function(error){
			alert(JSON.stringify(error))
			
		})//에이잭스 통신을 활용해서 3개의 데이터를 json으로 변경하여 insert요청!!!
	}
}

index.init();