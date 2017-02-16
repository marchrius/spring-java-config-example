<header class="main-header">
             <!-- Header Navbar -->
        <nav class="navbar navbar-static-top" style="margin-left: 0px;" role="navigation">
     	<a role="button"  class="logo" href="#" style="width:163px;background-color: #3c8dbc;">
            <span class="logo-lg">HMS</span>
          </a>     
        <div class="navbar-custom-menu pull-left">
        <ul class="nav navbar-nav">
        <li class="messages-menu" id="room-tab">
        <a  href="<%=request.getContextPath() %>/auth/rooms" >
                 
                  <span class="user user-menu "><B>Rooms</B></span>
                   
                </a>
                      
        </li>
        
        <li class="messages-menu" id="payment-tab">
        <a  href="<%=request.getContextPath() %>/auth/payments" >
                 
                  <span class="user user-menu "><B>Payments</B></span>
                   
                </a>
                      
        </li>
        
        <li class="messages-menu" id="candidatesDetails-tab">
        <a  href="<%=request.getContextPath() %>/auth/candidates" >
                 
                  <span class="user user-menu "><B>Candidate Details</B></span>
                   
                </a>
                      
        </li>
        
         <li class="messages-menu" id="regCandidate-tab">
        <a  href="<%=request.getContextPath() %>/auth/candidateForm" >
                 
                  <span class="user user-menu "><B>Register Candidate</B></span>
                   
                </a>
                      
        </li>
        
        <li class="dropdown tasks-menu" id="admin-tab">
        <a  href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
                 
                  <span class="user user-menu "><B>Administration</B></span>
                   
                </a>
          <ul class="dropdown-menu">
          	<li>
          		<ul class="menu">
          			<li>
          				<a href="<%=request.getContextPath() %>/auth/showRoomTypePage">Room Types</a>
          			</li>
          			<li>
          				<a href="<%=request.getContextPath() %>/auth/">Floors</a>
          			</li>
          			<li>
          				<a href="<%=request.getContextPath() %>/auth/">Rooms</a>
          			</li>
          			
          		</ul>
          	</li>
          </ul>            
        </li>
        
        </ul>
        </div>
        
        </nav>
      </header>