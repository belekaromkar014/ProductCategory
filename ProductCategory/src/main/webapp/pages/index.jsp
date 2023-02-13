<html>
<head>
<title>page</title>
<script> 
           
           var xmlhttp;
           function getall(){
         	  xmlhttp=new XMLHttpRequest();
         	  xmlhttp.onload=display;
         	  xmlhttp.open("get" , "http://localhost:8080/product");
         	  xmlhttp.send();
           }
           
           function show1(){
         	  alert(xmlhttp.responseText);
         	  document.getElementById("heading1").innerHTML=xmlhttp.responseText;
           }
           
                    function get(){
                    	xmlhttp=new XMLHttpRequest();
                    	xmlhttp.onload=save;
                    	var pid=document.form1.pid.value;
                    	xmlhttp.open("get" , "http://localhost:8080/product/" + pid);
                    	xmlhttp.send();
                    }
                    function ss(){
                    	alert(xmlhttp.responseText);
                    }
                    function save(){
                    	alert(xmlhttp.responseText);
                 	   var obj=JSON.parse(xmlhttp.responseText);
                 	   alert("hello")
                 	   document.form1.pid.value=obj.pid;
                 	   document.form1.pname.value=obj.pname;
                 	   document.form1.price.value=obj.peice;
                 	   document.form1.cid.value=obj.cid;
                 	   document.form1.name.value=obj.name;
                    }
                    
                    function post(){
                    	xmlhttp=new XMLHttpRequest();
                    	xmlhttp.onload=show3;
                    	var cid=document.form1.cid.value;
                    	xmlhttp.open("post" , "http://localhost:8080/product/"+cid);
                    	var pid=document.form1.pid.value;
                    	var pname=document.form1.pname.value;
                    	var price=document.form1.price.value;
                    	var obj = {"pid": pid , "pname": pname , "price": price};
                    	xmlhttp.setRequestHeader('Content-type' , 'application/json');
                    	xmlhttp.send(JSON.stringify(obj));
                    }
                    
                    function show3(){
                    	alert(xmlhttp.responseText);
                    }
                    
                    function update(){
                    	xmlhttp=new XMLHttpRequest();
                    	xmlhttp.onload=show4;
                    	xmlhttp.open("put" , "http://localhost:8080/product");
                    	var pid=document.form1.pid.value;
                    	var pname=document.form1.pname.value;
                    	var price=document.form1.price.value;
                    	var obj={"pid":pid , "pname":pname , "price":price};
                    	xmlhttp.setRequestHeader('Content-type' , 'application/json');
                    	xmlhttp.send(JSON.stringify(obj));
                    }
                    
                    function show4(){
                    	alert(xmlhttp.responseText);
                    }
                    
                    function deletep(){
                    	xmlhttp=new XMLHttpRequest();
                    	xmlhttp.onload=show5;
                    	var pid=document.form1.pid.value;
                    	xmlhttp.open("delete" , "http://localhost:8080/product/"+pid);
                    	xmlhttp.send();
                    }
                    
                    function show5(){
                    	alert(xmlhttp.responseText);
                    }
                    
                    function display(){
                    	var table = document.getElementById("table1");
                    	table.innerHTML="";
                    	
                    	var headingrow = document.createElement("tr"); 
                    	
                    	var pidth = document.createElement("th");
                    	var pnameth = document.createElement("th");
                    	var priceth = document.createElement("th");
                    	var cidth   = document.createElement("th");
                    	var nameth  = document.createElement("th");
                    	
                    	var heading1 = document.createTextNode("pid");
                    	var heading2 = document.createTextNode("pname");
                    	var heading3 = document.createTextNode("price");
                    	var heading4 = document.createTextNode("cid");
                    	var heading5 = document.createTextNode("name");
                    	
                    	pidth.appendChild(heading1);                    	
                    	pnameth.appendChild(heading2);                    	
                    	priceth.appendChild(heading3);                    	
                    	cidth.appendChild(heading4);                    	
                    	nameth.appendChild(heading5);
                    	
                    	headingrow.appendChild(pidth);                    	
                    	headingrow.appendChild(pnameth);                    	
                    	headingrow.appendChild(priceth);                    	
                    	headingrow.appendChild(cidth);                    	
                    	headingrow.appendChild(nameth);
                    	
                    	table.appendChild(headingrow);
                    	
                    	var data = xmlhttp.responseText;
                    	alert(data);
                    	var data = data.substring(1 , data.length-1);
                    	alert(data);
                    	
                    	var newstr = "";
                    	for(var i=0; i<data.length; i++){
                    		var character = data[i];
                    		if(character == "," && data[i+1] == "["){
                    			newstr = newstr + "#";
                    			}
                    		else
                    			newstr = newstr + character;
                    	}
                    	alert(newstr);
                    	var jsonstr = newstr.split("#");
                    	
                    	for(var j=0; j<jsonstr.length; j++){
                    		var jsobj = jsonstr[i];
                    		var ojb = JSON.parse(jsobj);
                    		
                    		
                    		var row = document.createElement("tr");
                    		var pidtd = document.createElement("td");
                    		var pnametd = document.createElement("td");
                    		var pricetd = document.createElement("td");
                    		var cidtd = document.createElement("td");
                    		var nametd = document.createElement("td");
                    		
                    		var pid = document.createTextNode(obj.pid);
                    		var pname = document.createTextNode(obj.pname);
                    		var price = document.createTextNode(obj.price);
                    		var cid = document.createTextNode(obj.cid);
                    		var name = document.createTextNode(obj.name);
                    		
                    		pidtd.appendChild(pid);
                    		pnametd.appendChild(pname);
                    		pricetd.appendChild(price);
                    		cidtd.appendChild(cid);
                    		nametd.appendChild(name);
                    		
                    		row.appendChild(pidtd);
                    		row.appendChild(pnametd);
                    		row.appendChild(pricetd);
                    		row.appendChild(cidtd);
                    		row.appendChild(nametd);
                    		
                    		table.appendChild(row);
                    	}
                    }
           </script>
</head>
<body>
	<form name="form1">
		<h1 id="heading1">Product List</h1>
		<input type="text" name="pid" placeholder="Product ID"> <br>
		<br> <input type="text" name="pname" placeholder="Product Name"><br>
		<br> <input type="text" name="price" placeholder="Product Price"><br>
		<br> <input type="text" name="cid" placeholder="Category ID"><br>
		<br> <input type="text" name="name" placeholder="Category Name"><br>
		<br> 
		
		<input type="button" value="Get" onclick="get()"> 
		<input type="button" value="Post" onclick="post()"> 
		<input type="button" value="Update" onclick="update()"> 
		<input type="button" value="Delete" onclick="deletep()"> 
		<input type="button" value="Get ALL" onclick="getall()">
	</form>
	
	<table id="table1">
	</table>
	
</body>

</html>