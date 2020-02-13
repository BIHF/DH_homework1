<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
	<style>
		form {
		    display: inline-block;
		    max-width:500px;
		    width:50%;
		}
		.form-group {
		    text-align: center;
		    padding-bottom: 25px;
		}
		#todo {
		    margin: 0 auto;
		    max-width: 700px;
		    width:70%;
		}
		
		a.close {
		  float : right;
		  margin-right: 20px;
		}
		.form-control {
		}
		ul ul, ol ul, ul ol, ol ol{
			position:relative;
			margin: 10px 0;
			background: rgba(12, 12, 12, .1);
			border-radius: 4px;
		}
	</style>
</head>



<body>
    <div class="form-group">
      <h1>Board <small>List</small></h1>
    <form role="form" >
        <input type="text" class="form-control" placeholder="Your Board" name="content">
    </form>
    <button type="button" class="btn btn btn-primary add_btn">Add</button>
        </div>
        <div></div>
    <ul class="list-unstyled" id="todo">
    	<c:forEach items="${boardList }" var="item">
    		<ul><c:out value="${item.content }" ></c:out><a href='#' data-no="${item.no }" class='close' aria-hidden='true'>&times;</a></ul>
    	</c:forEach>
    </ul>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
    <script  src="https://code.jquery.com/jquery-3.4.1.min.js"
			  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
			  crossorigin="anonymous"></script>
    <script>
	    /* $(document).ready(function () {
	        $('button').click(function () {
	            $('#todo').append("<ul>" + $("input[name=task]").val() + " <a href='#' class='close' aria-hidden='true'>&times;</a></ul>");
	        });
	        $("body").on('click', '#todo a', function () {
	            $(this).closest("ul").remove();
	        });
	    }); */
	    
	    function ajaxGoGo(content){
	    	$.ajax({
    			url:"/project/board",
    			dataType:"json",
    			type:"POST",
    			data:{'content': content},
    			error:function() {
    				alert("히발 안해");
    			},
    			success:function(json) {
    				$('#todo').append("<ul>" + content + " <a href='#' data-no='"+json.no+"' class='close' aria-hidden='true'>&times;</a></ul>");
    			}
    		})
	    }
	    
	    $('.form-control').keydown(function(e){
	    	if(e.keyCode === 9){
	    		return ;	
	    	}
	    	if(e.keyCode === 13){
	    		e.preventDefault();
	    		var content = $(this).val();
	    		ajaxGoGo(content);
	    		$(this).val('').focus();;
	    	}
	    });
	    $('.add_btn').click(function(){
	    	var $input = $('.form-control'); 
	    	var content = $input.val();
    		ajaxGoGo(content);
    		$input.val('').focus();;
	    });
	    $('#todo').on('click', '.close', function(e){
	    	e.preventDefault();
	    	var no = $(this).data('no');
	    	console.log(no);
	    	var $remove = $(this).parent();
	    	var data = {'no' : no};
	    	console.log(data);
	    	$.ajax({
    			url:"/project/board?no="+no,
    			dataType:"json",
    			type:"delete",
    			data:data,
    			error:function() {
    				alert("히발 안해");
    			},
    			success:function(json) {
    				console.log(json);
    				$remove.remove();
    			}
    		})
	    })
    </script>
</body>
</html>
