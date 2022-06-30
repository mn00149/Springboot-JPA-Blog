let index = {
	init:function(){
		$("#btn-save").on("click", ()=>{
			this.save()//화살표 함수를 사용하는 이유는 this를 바인딩 하기 위해서이다
		})
		
		$("#btn-delete").on("click", ()=>{
			this.deleteById()//화살표 함수를 사용하는 이유는 this를 바인딩 하기 위해서이다
		})
		
		$("#btn-update").on("click", ()=>{
			this.update()//화살표 함수를 사용하는 이유는 this를 바인딩 하기 위해서이다
		})
	
	},
	save:function(){
		let data = {
			title: $("#title").val(),
			content: $("#content").val()
		}
		
		$.ajax({
			type:"POST",
			url:"/api/board",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType:"json"//서버의 응답이 json이면 자바스크립트 object로 바꾸어진다
			
		}).done(function(resp){
			alert('글쓰기 완료')
			console.log(resp)
			location.href="/"
		}).fail(function(error){
			alert(JSON.stringify(error))
			
		})//에이잭스 통신을 활용해서 3개의 데이터를 json으로 변경하여 insert요청!!!
	},
	
	deleteById:function(){
		
		let id = $("#id").text()
	
		$.ajax({
			type:"DELETE",
			url:"/api/board/"+id,
			dataType:"json"//서버의 응답이 json이면 자바스크립트 object로 바꾸어진다
			
		}).done(function(resp){
			alert('삭제 완료')
			console.log(resp)
			location.href="/"
		}).fail(function(error){
			alert(JSON.stringify(error))
			
		})//에이잭스 통신을 활용해서 3개의 데이터를 json으로 변경하여 insert요청!!!
	},
	update:function(){
		let id = $('#id').val()
		let data = {
			title: $("#title").val(),
			content: $("#content").val()
		}
		
		$.ajax({
			type:"PUT",
			url:"/api/board/"+id,
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType:"json"//서버의 응답이 json이면 자바스크립트 object로 바꾸어진다
			
		}).done(function(resp){
			alert('글수정 완료')
			console.log(resp)
			location.href="/"
		}).fail(function(error){
			alert(JSON.stringify(error))
			
		})//에이잭스 통신을 활용해서 3개의 데이터를 json으로 변경하여 insert요청!!!
	}
	
}

index.init();