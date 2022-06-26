let index = {
	init:function(){
		$("#btn-save").on("click", ()=>{
			this.save()//화살표 함수를 사용하는 이유는 this를 바인딩 하기 위해서이다
		})
		
		/*$("#btn-login").on("click", ()=>{
			this.login()//화살표 함수를 사용하는 이유는 this를 바인딩 하기 위해서이다
		})*/
	},
	save:function(){
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		}
		
		$.ajax({
			type:"POST",
			url:"/auth/joinProc",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType:"json"//서버의 응답이 json이면 자바스크립트 object로 바꾸어진다
			
		}).done(function(resp){
			alert('회원 가입 완료')
			console.log(resp)
			location.href="/"
		}).fail(function(error){
			alert(JSON.stringify(error))
			
		})//에이잭스 통신을 활용해서 3개의 데이터를 json으로 변경하여 insert요청!!!
	}
	/*login:function(){
		let data = {
			username: $("#username").val(),
			password: $("#password").val()
		}
		
		$.ajax({
			type:"POST",
			url:"/api/user/login",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType:"json"//서버의 응답이 json이면 자바스크립트 object로 바꾸어진다
			
		}).done(function(resp){
			alert('로그인 완료')
			//console.log(resp)
			location.href="/"
		}).fail(function(error){
			alert(JSON.stringify(error))
			
		})//에이잭스 통신을 활용해서 3개의 데이터를 json으로 변경하여 insert요청!!!
	}*/
}

index.init();