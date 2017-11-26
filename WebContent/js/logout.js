function OnLogoutClick()
{
	$.ajax({
	    url : "SecurityServlet",
	    type : "post",                      
	    cache : false,
	    async : false,
	    data:'action=logout',
	    success : function(data)
	    {
	    	console.log("logout is processed");

	    	
	    	//if(sessionValidator)clearInterval(sessionValidator);
	    	window.location.replace("http://localhost:8080/CollabTaskTrackingTool/index.html");
	    },
	    error: function(xhr, textStatus, errorThrown)
	    {
	    	console.log("something bad happened while logout");
	    }
	});
	
}
function ValidateChange()
{
		$.ajax({
		    url : "SecurityServlet",
		    type : "post",                      
		    cache : false,
		    async : false,
		    data:'action=validate',
		    success : function(result, status, xhr)
		    {
		    	if(DEBUG){
		    		log("sessions is valid");
		    		log(result, status, xhr);
		    	}
		    },
		    error: function(xhr, textStatus, errorThrown){
		    	if(DEBUG)log(xhr, textStatus, errorThrown);
		    	window.location.replace("index.jsp");
		    	var msg ="Apologies, we have detected an update on the website." +
		    	"\nYour session will be terminated so that the updates are taken into effect.";
		    	alert(msg);
		    }
		});
}

//setInterval(ValidateChange, 6000);
	