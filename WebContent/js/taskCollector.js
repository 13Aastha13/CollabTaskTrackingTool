function OnRefreshClick()
{
	console.log("refreshing......");
	var userId =document.getElementById('userId').value;
	//console.log(Email);
	$.ajax({
		url : "TaskCollectorServlet",
		type : "post",                      
		cache : false,
		dataType: "json",
		data:'action=getTasks&userId='+userId,

		success : function(list) 
		{
			if(list && list.length)
			{
				//return list;
				CreateTableFromJSON(list);
				/*var $table = $( "<table></table>" );

				for ( var i = 0; i < list.length; i++ )
				{
				    var task = list[i];
				    var $line = $( "<tr></tr>" );
				    $line.append( $( "<td></td>" ).html( task.taskId) );
				    $line.append( $( "<td></td>" ).html( task.taskName) );
				    $line.append( $( "<td></td>" ).html( task.taskDescription) );
				    $table.append( $line );
				}

				$table.appendTo( document.body );*/
			}
			else
			{
				console.log("something went wrong...");
			}

		},

		error : function(xhr, textStatus, errorThrown)
		{
			console.log(xhr.responseText);
		}
	});
}

function CreateTableFromJSON(list)
{
	// EXTRACT VALUE FOR HTML HEADER. 
	// ('Book ID', 'Book Name', 'Category' and 'Price')
	var MyTasks=list;
	var col = [];
	for (var i = 0; i < MyTasks.length; i++) {
		for (var key in MyTasks[i]) {
			if (col.indexOf(key) === -1) {
				col.push(key);
			}
		}
	}

	// CREATE DYNAMIC TABLE.
	var table = document.createElement("table");

	// CREATE HTML TABLE HEADER ROW USING THE EXTRACTED HEADERS ABOVE.

	var tr = table.insertRow(-1);                   // TABLE ROW.

	for (var i = 0; i < col.length; i++) {
		var th = document.createElement("th");      // TABLE HEADER.
		th.innerHTML = col[i];
		tr.appendChild(th);
	}

	// ADD JSON DATA TO THE TABLE AS ROWS.
	for (var i = 0; i < MyTasks.length; i++) {

		tr = table.insertRow(-1);

		for (var j = 0; j < col.length; j++) {
			var tabCell = tr.insertCell(-1);
			tabCell.innerHTML = MyTasks[i][col[j]];
		}
	}

	// FINALLY ADD THE NEWLY CREATED TABLE WITH JSON DATA TO A CONTAINER.
	var divContainer = document.getElementById("showData");
	divContainer.innerHTML = "";
	divContainer.appendChild(table);
	$('#showData table,td,th').css({
	    border: '1px solid black',
	    background:'#fff',
	});
}
//OnRefreshClick();
