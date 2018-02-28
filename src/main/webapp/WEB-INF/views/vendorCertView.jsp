<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script><!--Navbar-->

  
  <script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>

<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round|Open+Sans">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


	 
        <title>Vendor certificates</title>
        </head>
		 <body>

<!--Navbar-->
<div class ="title-header">
          <h1 align="center">Vendor Page View</h1>
	</div>	<!--end of top header title-->	

<div class="navbar-header">
 
<nav class="navbar navbar-default navbar-inverse" role="navigation">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
     
	  <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
	  
	  <li class="dropdown"><a data-toggle="dropdown" class="dropdown-toggle">Vendors<span class="caret"></span></a>
									<ul class=" dropdown-menu">
										<li><a href="#">View Application Status</a></li>			
	</ul>
	
	 <li class="dropdown"><a data-toggle="dropdown" class="dropdown-toggle">Tender Projects<span class="caret"></span></a>
									<ul class=" dropdown-menu">
										<li><a href="#">Apply for Tender Project</a></li>
										<li><a href="#">View All Completed Tenders</a></li>
										<li><a href="#">View Tenders List</a></li>
	</ul>
	
	 <li class="dropdown"><a data-toggle="dropdown" class="dropdown-toggle">Company<span class="caret"></span></a>
									<ul class=" dropdown-menu">
										<li><a href="#">View All Companies</a></li>
			
	</ul>
	
	</div>

	</ul>
	</li>
	
	 <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <span class="glyphicon glyphicon-user"></span> 
                        <strong>User</strong>
                        <span class="glyphicon glyphicon-chevron-down"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                                    
                                        <p>
                                            <a href="#" class="btn btn-danger btn-block">Logout</a>
                                        </p>
										
										<p>
                                           <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Change Password</button>
                                        </p>
                           
                          
							</li>
		</ul>
		
		</div>
	
	</nav>
	
	
	 <div class="container">
    <div class="row">    
        <div class="col-xs-8 col-xs-offset-2">
		    <div class="input-group">
                <div class="input-group-btn search-panel">
                    <!-- <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    	<span id="search_concept">Filter by</span> <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu">
                      <li><a href="#">Registration Number</a></li>
                      <li><a href="#">Name</a></li>
                      <li><a href="#">Location Address</a></li>
                      <li><a href="#">Email Address </a></li>
                    </ul> -->
                </div>      
               
				<form id='searchBar' method="get" action="allCerts">
				 <span class="input-group-btn">  
				 <input type="text" class="form-control" name="search" placeholder="Search item">  
					<button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search"></span></button>
                </span>
				</form>
            </div>
        </div>
	</div>
</div>



	 
	 <!--- pagination table--->
	<div class="container">
    <div class="row">
      <div class="table-responsive">
        <table class="table table-hover">
          <thead>
            <tr>
              <th>ID</th>
              <th>Vendor Id</th>
              <th>Certificate Location</th>
            </tr>
          </thead>
          <tbody >
           <c:forEach var="venC" items="${vendorCert}">
			<tr>
				<td>${venC.certificate_Id}</td>
				<td>${venC.vendor_Id}</td>
				<td>${venC.certificate_path}</td>
			</tr>
			</c:forEach>
          </tbody>
        </table>   
      </div>
      <div class="col-md-12 text-center">
      <ul class="pagination pagination-lg pager" id="myPager"></ul>
      </div>

	  
	  

	
	
	<!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-sm">
	
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Change Password</h4>
        </div>
        <div class="modal-body">
          <!--- content of modal here--->
      
           <label>Old Password<span class="mandatory">*</span></label>
			<input type="password" class="form-control" id="oldPassword" name="oldPassword" value="" required="true" placeholder="Old Password">
			 <label>New Password<span class="mandatory">*</span></label>
			<input type="password" class="form-control" id="newPassword" name="newPassword" value="" required="true" placeholder="New Password">
			 <label>Confirm new Password<span class="mandatory">*</span></label>
			<input type="password" class="form-control" id="confirmNewPassword" name="confirmNewPassword" value="" required="true" placeholder="confirm New Password">
			
			
        </div>
        <div class="modal-footer">
		<button type="submit" class="btn btn-success btn-block" onclick="validateChangePassword()">Change Paasword</button>
		<!--Cancel button -->
					 <button type="cancel" class="btn btn-danger btn-block">Cancel</button>
        </div>
      </div>
      
    </div>
  </div>
  
  
  <script>
  
  
  <!--vaildate change password in modal-->
  
   function validateChangePassword(){

		var oldPassword = $('#oldPassword').val();
  var newPassword = $('#newPassword').val();
  var confirmNewPassword = $('#confirmNewPassword').val();
 
			if(oldPassword== newPassword) {
				alert("old and new passwords match, please choose a new password")
	}
	else{
		if(newPassword!= confirmNewPassword) {
				alert("passwords confirmations dont match, please re-enter a new password")
	}
	}
	}
  
  <!--filter bar-->
  
  $(document).ready(function(e){
    $('.search-panel .dropdown-menu').find('a').click(function(e) {
		e.preventDefault();
		var param = $(this).attr("href").replace("#","");
		var concept = $(this).text();
		$('.search-panel span#search_concept').text(concept);
		$('.input-group #search_param').val(param);
	});
});

<!--bootstrap pagination-->

     $.fn.pageMe = function(opts){
    var $this = this,
        defaults = {
            perPage: 7,
            showPrevNext: false,
            hidePageNumbers: false
        },
        settings = $.extend(defaults, opts);
    
    var listElement = $this;
    var perPage = settings.perPage; 
    var children = listElement.children();
    var pager = $('.pager');
    
    if (typeof settings.childSelector!="undefined") {
        children = listElement.find(settings.childSelector);
    }
    
    if (typeof settings.pagerSelector!="undefined") {
        pager = $(settings.pagerSelector);
    }
    
    var numItems = children.size();
    var numPages = Math.ceil(numItems/perPage);

    pager.data("curr",0);
    
    if (settings.showPrevNext){
        $('<li><a href="#" class="prev_link">«</a></li>').appendTo(pager);
    }
    
    var curr = 0;
    while(numPages > curr && (settings.hidePageNumbers==false)){
        $('<li><a href="#" class="page_link">'+(curr+1)+'</a></li>').appendTo(pager);
        curr++;
    }
    
    if (settings.showPrevNext){
        $('<li><a href="#" class="next_link">»</a></li>').appendTo(pager);
    }
    
    pager.find('.page_link:first').addClass('active');
    pager.find('.prev_link').hide();
    if (numPages<=1) {
        pager.find('.next_link').hide();
    }
      pager.children().eq(1).addClass("active");
    
    children.hide();
    children.slice(0, perPage).show();
    
    pager.find('li .page_link').click(function(){
        var clickedPage = $(this).html().valueOf()-1;
        goTo(clickedPage,perPage);
        return false;
    });
    pager.find('li .prev_link').click(function(){
        previous();
        return false;
    });
    pager.find('li .next_link').click(function(){
        next();
        return false;
    });
    
    function previous(){
        var goToPage = parseInt(pager.data("curr")) - 1;
        goTo(goToPage);
    }
     
    function next(){
        goToPage = parseInt(pager.data("curr")) + 1;
        goTo(goToPage);
    }
    
    function goTo(page){
        var startAt = page * perPage,
            endOn = startAt + perPage;
        
        children.css('display','none').slice(startAt, endOn).show();
        
        if (page>=1) {
            pager.find('.prev_link').show();
        }
        else {
            pager.find('.prev_link').hide();
        }
        
        if (page<(numPages-1)) {
            pager.find('.next_link').show();
        }
        else {
            pager.find('.next_link').hide();
        }
        
        pager.data("curr",page);
      	pager.children().removeClass("active");
        pager.children().eq(page+1).addClass("active");
    
    }
};

$(document).ready(function(){
    
  $('#empList').pageMe({pagerSelector:'#myPager',showPrevNext:true,hidePageNumbers:false,perPage:4});
    
});
<!--end of pagination function-->
  </script>
  
 <style>
 
 .title-header{
  margin:10px;
  
  margin-bottom:30px;
  align:center;
 }
 .sidenav {
    height: 100%;
    width: 0;
    position: fixed;
    z-index: 1;
    top: 0;
    left: 0;
    background-color: #111;
    overflow-x: hidden;
    transition: 0.5s;
    padding-top: 60px;
}


.vendorSearch {
margin-top: 100px;
margin-left:50px;
}
 </style>