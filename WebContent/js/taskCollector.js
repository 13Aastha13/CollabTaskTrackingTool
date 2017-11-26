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
	for (var i = 0; i < MyTasks.length; i++)
	{
		for (var key in MyTasks[i])
		{
			if (col.indexOf(key) === -1)
			{
				col.push(key);
			}
		}
	}

	// CREATE DYNAMIC TABLE.
	var table = document.createElement("table");
	table.setAttribute('id', 'empTable'); 

	// CREATE HTML TABLE HEADER ROW USING THE EXTRACTED HEADERS ABOVE.

	var tr = table.insertRow(-1);                   // TABLE ROW.

	for (var i =-1; i < col.length; i++)
	{
		if(i==-1)
		{
			var th = document.createElement("th");
			th.innerHTML ="action";
			tr.appendChild(th);
		}
		else
		{
			var th = document.createElement("th");      // TABLE HEADER.
			th.innerHTML = col[i];
			tr.appendChild(th);
		}
	}

	// ADD JSON DATA TO THE TABLE AS ROWS.
	for (var i = 0; i < MyTasks.length; i++) 
	{

		tr = table.insertRow(-1);

		for (var j = -1; j < col.length; j++)
		{
			var tabCell = tr.insertCell(-1);
			if(j==-1)
			{
				// ADD A BUTTON.
				var button = document.createElement('input');

				// SET INPUT ATTRIBUTE.
				button.setAttribute('type', 'button');
				button.setAttribute('value', 'Remove');

				// ADD THE BUTTON's 'onclick' EVENT.
				button.setAttribute('onclick', 'removeRow(this)');

				tabCell.appendChild(button);
			}
			else
			{

				tabCell.innerHTML = MyTasks[i][col[j]];
			}
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

function addRow() {
	var empTab = document.getElementById('empTable');

	var rowCnt = empTab.rows.length;        // GET TABLE ROW COUNT.
	var tr = empTab.insertRow(rowCnt);      // TABLE ROW.
	tr = empTab.insertRow(rowCnt);

	for (var c = 0; c <4; c++) {
		var td = document.createElement('td');          // TABLE DEFINITION.
		td = tr.insertCell(c);

		if (c == 0) {           // FIRST COLUMN.
			// ADD A BUTTON.
			var button = document.createElement('input');

			// SET INPUT ATTRIBUTE.
			button.setAttribute('type', 'button');
			button.setAttribute('value', 'Remove');

			// ADD THE BUTTON's 'onclick' EVENT.
			button.setAttribute('onclick', 'removeRow(this)');

			td.appendChild(button);
		}
		else {
			if (c!=1)
			{
				// CREATE AND ADD TEXTBOX IN EACH CELL.
				var ele = document.createElement('input');
				ele.setAttribute('type', 'text');
				ele.setAttribute('value', '');

				td.appendChild(ele);
			}
		}
	}
}
//DELETE TABLE ROW.
function removeRow(oButton) {
	var empTab = document.getElementById('empTable');
	empTab.deleteRow(oButton.parentNode.parentNode.rowIndex);       // BUTTON -> TD -> TR.
}
//EXTRACT AND SUBMIT TABLE DATA.
function sumbit() {
	var myTab = document.getElementById('empTable');
	var values = new Array();

	// LOOP THROUGH EACH ROW OF THE TABLE.
	//for (row = 1; row < myTab.rows.length - 1; row++)
	//{
	row=myTab.rows.length-2;
	//console.log("no of rws :"+ values);
	var taskName , taskDescription;
	for (c = 2; c < myTab.rows[row].cells.length; c++)
	{   // EACH CELL IN A ROW.

		var element = myTab.rows.item(row).cells[c];
		if (element.childNodes[0].getAttribute('type') == 'text')
		{
			if(c==2)
			{
				taskName=element.childNodes[0].value;
			}
			if(c==3)
			{
				taskDescription=element.childNodes[0].value;
			}
			
			//values.push("'" + element.childNodes[0].value + "'");
			//console.log(element.childNodes[0].value);
			//console.log(taskName);
			//console.log(taskDescription);
		}
		
	}
	insertTaskToDB(taskName,taskDescription);
	
//	}
	//console.log(values);
}
function insertTaskToDB(taskName,taskDescription)
{

	//console.log("refreshing......");
	var userId =document.getElementById('userId').value;
	//console.log(Email);
	$.ajax({
		url : "TaskCollectorServlet",
		type : "post",                      
		cache : false,
		//dataType: "json",
		//data:'action=login&email='+Email+'&password='+Pwd,
		data:'action=insertNewTask&taskName='+taskName+'&taskDescription='+taskDescription,

		success : function(data) 
		{
			if(data=="SUCCESS")
			{
				OnRefreshClick();
				console.log("task inserted succesfully");
				
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