<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
	
    	$("#email").blur(function()
        {
    		var value1=document.getElementById("email").value;
    		var data = 'email='+ value1;
    		alert("Stage1: "+data);
    		$.ajax({type:'post',url:'AjaxForEmail.jsp',success:function(html)
				{
        			  alert("Stage2");
        			  var result=html.split("#");
        				var email=document.getElementById("email").value;
        				
        			 alert("this email is already exist : "+email);
        		for(var i=1;i<result.length;i++)
        			{
      //   			 alert("this email is already exist : "+result[i]);  			
        			if(result[3].equals(email))
        				{
        				alert("this email is already exist : "+result[i]);
          				}
        			}

//        		      $('#output').append(msg);
        		  }
        		});
       });
    }); 

</script>
  
  
  
  
        <h1>Add New Employee</h1>  
       <form:form method="post" action="save" modelAttribute="studentModel">    
        <table >    
         <tr>    
          <td>Name : </td>   
          <td><form:input path="name" id="name"  /></td>  
         </tr>    
         <tr>    
          <td>Email :</td>    
          <td><form:input path="email" id="email"/></td>  
         </tr>   
         <tr>    
          <td>Profession :</td>    
          <td><form:input path="profession"  id="profession"/></td>  
         </tr>   
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>