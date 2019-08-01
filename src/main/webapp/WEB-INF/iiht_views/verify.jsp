<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.assessment.data.*, java.text.*, java.util.*" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>IIHT</title>
        <link href='http://fonts.googleapis.com/css?family=Roboto:300,400,700' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Muli:300,400,700' rel='stylesheet' type='text/css'>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="css/font-awesome.css" rel="stylesheet" type="text/css">
        <link href="css/style.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="css/bootstrap_only_login_new.css">
        <link href="css/responsive.css" rel="stylesheet" type="text/css">
         <link href="css/font-awesome_new.css" rel="stylesheet" type="text/css">
         <link href="css/style_new.css" rel="stylesheet" type="text/css">
        <link href="css/responsive_new.css" rel="stylesheet" type="text/css">
        
        
       
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
 <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="scripts/custom.js"></script>

	<script type="text/javascript" src="scripts/pnotify.custom.min.js"></script>

<script type="text/javascript" src="scripts/pnotify.nonblock.js"></script>
<script type="text/javascript" src="scripts/pnotify.buttons.js"></script>




<link href="css/pnotify.custom.min.css" media="all" rel="stylesheet" type="text/css">
			
    </head>
    <body>

        <div class="header">
            <div class="col-md-12">
                <div class="col-md-6">
                    <div class="logo">
                        <a href="#"><img src="images/logoiiht.png"></a>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="userheader headerinfos">
                        <ul>
                            <li><i class="fa fa-envelope"></i>reachus@iiht.com</li>
                            <li><i class="fa fa-phone"></i>1800-123-321-5</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>


        <div class="creationtimeline">
            <div class="col-md-12">
                
                <div class="col-md-6">
                    <div class="starttestinfo loginformnew">
                        <h3>Checker Tool for Questions Data</h3>
                         <form:form method="post" action="verifydata" enctype="multipart/form-data">  
							<p><label for="image">Choose Questions File</label></p>  
							<p><input name="fileToUpload" id="fileToUpload" type="file" /></p>  
							<p><input type="submit" value="Upload"></p>  
						</form:form>  
                    </div>
                </div>
            </div>
        </div>

        

        <div class="logincopyright">
            <div class="col-md-12">
                <p>Copyrigh © 2018 IIHT. All Rights Reserved – Privacy Policy For enterprise solutions</p>
            </div>
        </div>

        <!-- <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script> -->
		<script>
		function notify(text){
				 var notification = 'Information';
				 $(function(){
				 	new PNotify({
				 	title: notification,
					 text: text,
					 type: 'Information',
					 width: '20%',
					 hide: false,
					 buttons: {
            					closer: true,
            					sticker: false
       					 },
					 history: {
            					history: false
        				 }
					 });
				 
				 }); 	
			}
			
			</script>

    </body>
</html>
