function OnLoginClick()
{
	//var UName=document.getElementById('IdUName').value;
	//var LName=document.getElementById('IdLName').value;
	var Email=document.getElementById('IdEmail').value;
	var Pwd=document.getElementById('IdPwd').value;
	var FeedbackMsg = 'Either Email or Password is incorrect..';
	console.log(Email);
	$.ajax({
	    url : "SecurityServlet",
	    type : "post",                      
	    cache : false,
	    async : false,
	    data:'action=login&email='+Email+'&password='+Pwd,
	    
	    success : function(data) 
	    {
	    	if(data=="SUCCESS")
	    	{
	    		window.location="http://localhost:8080/CollabTaskTrackingTool/home.jsp";
	    	}
	    	else
	    	{
	    		if(data=="FAILURE")
	    		{
	    			document.getElementById('IdFeedbackMsg').innerHTML=FeedbackMsg;
	    				
	    		}

	    	}
	    	//location.reload();
	    	//console.log(data);
	    },
	  //  error: function(xhr, textStatus, errorThrown)
	    error : function(xhr, textStatus, errorThrown)
		{
	    	FeedbackMsg = "<span class='rt'>"+ xhr.responseText + "</span>";
			document.getElementById('IdFeedbackMsg').innerHTML=FeedbackMsg;
		}
	});
	
	
		//console.log(document.getElementById('IdEmail').value);
	
}