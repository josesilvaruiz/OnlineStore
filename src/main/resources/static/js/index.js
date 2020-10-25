      function doAjaxPost() {

           $.ajax({
        	   type : "POST",
               contentType : 'application/json; charset=utf-8',
               dataType : 'json',
               url : "http://localhost:8090/cartcheckout"
               
               }
           });
       }