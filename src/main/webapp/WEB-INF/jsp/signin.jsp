<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="signin">
    <c:choose>
        <c:when test="${sessionScope.customerFirstName==null}">
        <a href="#" class="big-link " data-reveal-id="myModal" data-animation="fade">
        <img src="images/sign-in.png" alt="Sign In" title="Sign In" class="delv-disblock" />
        <span class="signin_inn" > Hi, Sign In &nbsp;&nbsp;&nbsp;<font color="red"><b>${requestScope.loginResult}${requestScope.registerResult}</b></font><br/> </span></a>
        </c:when>
        <c:otherwise>
        <img src="images/sign-in.png" alt="Sign In" title="Sign In" class="delv-disblock" />
        <span class="signin_inn" > Hi,${sessionScope.customerFirstName} <a href="logout.jsp"><font colour="blue">logout</font></a> <br/> </span>
        </c:otherwise>
    </c:choose>
    
    <a href="#"><span class="signin_inn">Your Account</span></a>      
    <div id="myModal" class="reveal-modal large">
        <div class="popup_login_main">
            <div class="popup_login">
                <div class="fac_google_login">
                    <a href="#">  <img src="images/facebook_popup.jpg" alt="google" /></a>
                    <a href="#">  <img src="images/google_popup.jpg" alt="google" /></a>

                </div>
                <div class="popup_or"><img src="images/or_popup.jpg"  alt="or" /></div>
                <div class="popup_login_form">
                    <form name="loginForm" action="authorize.htm" method="post">
                    <h3>Already a member?</h3>
                    <h4>You can use FNP login id and password</h4>
                    <div class="popup_login_form_row">
                        
                        <input type="hidden" name="action" value="authorizeUser"/>
                        <label>Email / Login*</label>
                        <input name="userid" type="text" value="Enter user id" class="pop_login_inp" onfocus="if(this.value==this.defaultValue)this.value='';" onblur="if(this.value=='')this.value=this.defaultValue;" />
                        <label>Password</label>
                        <input name="userpassword" type="password" value="Enter password" class="pop_login_inp" onfocus="if(this.value==this.defaultValue)this.value='';" onblur="if(this.value=='')this.value=this.defaultValue;" />
                        
                    </div>
                    <div class="popup_login_form_row">
                        <p>Forgot password 
                            <a data-reveal-id="divForgetPassword"  data-animation="fade" class="close-reveal-modal" style="background:none; padding:0px;color: #3C4B95; position: relative; font-size:12px;font-weight: normal; top: 0px; right: 0px;">
                                Click here
                            </a></p>

                    </div>
                    <div class="popup_login_form_row">
                        <input name="" type="submit"  class="button_signin_popup" value="LOGIN"/>
                        <div class="error_message">Text invalid</div>
                    </div>
                    <div class="popup_login_form_row">
                        <p>Don't have an account? <a data-reveal-id="divsingin"  data-animation="fade" class="close-reveal-modal" style="background:none; padding:0px;color: #3C4B95; position: relative; font-size:12px;font-weight: normal; top: 0px; right: 0px;">
                                Create One
                            </a></p>
                    </div>
                    </form>
                </div>
            </div>

        </div>
        <a class="close-reveal-modal"><img src="images/close.png" alt="closed" /></a>
    </div>
    <div id="divForgetPassword" class="reveal-modal medium">
        <div class="forget_passwod">
            <div class="forget_passwod_heading">FORGET PASSWORD</div>
            <div class="forget_passwod_reset">
                <h3>Reset Password</h3>
                <p>Create an account or <a href="#">sign in</a> to continue</p>
                <p><label>Email ID</label>
                    <input type="text" class="inp-forget_password" value="Enter your email id" onfocus="if(this.value==this.defaultValue)this.value='';" onblur="if(this.value=='')this.value=this.defaultValue;"/></p>
                <input name="" type="button" value="RESET PASSWORD" class="button_forget_passwod"/>
                <div class="error_message">Text invalid</div>
            </div>    

        </div>
        <a class="close-reveal-modal"><img src="images/close.png" alt="closed" /></a>
    </div>


    <div id="divsingin" class="reveal-modal medium">
        <form name="form1" action="userregister.htm" method="post" onsubmit="return checkEmpty()">
        <div class="popup_create-acc_main">
            <div class="popup_create-acc_heading">New User? Sign up</div>
            <div class="popup_create-acc_main_row">
                <label>First Name<span>*</span></label><input name="FIRSTNAME" type="text" class="inp-creat-acc"  value="" onchange="checkEmpty(this)" onfocus="if(this.value==this.defaultValue)this.value='';" onblur="if(this.value=='')this.value=this.defaultValue;"/>
            </div>
            <div class="popup_create-acc_main_row">
                <label>Last Name<span>*</span></label>
                <input name="LASTNAME" type="text" class="inp-creat-acc"  value=""  onchange="checkEmpty(this)" onfocus="if(this.value==this.defaultValue)this.value='';" onblur="if(this.value=='')this.value=this.defaultValue;"/>
            </div>
            <div class="popup_create-acc_main_row">
                <label>Phone No<span>*</span></label><input name="MOBILENO" onchange="checkEmpty(this)"  type="text" length="10" class="inp-creat-acc"  value="" onfocus="if(this.value==this.defaultValue)this.value='';" onblur="if(this.value=='')this.value=this.defaultValue;"/>
            </div>
            <div class="popup_create-acc_main_row">
                <label>Email ID<span>*</span></label><input name="EMAILADDRESS"  onchange="checkEmpty(this)" type="text" class="inp-creat-acc"  value="" onfocus="if(this.value==this.defaultValue)this.value='';" onblur="if(this.value=='')this.value=this.defaultValue;"/>
            </div>
            <div class="popup_create-acc_main_row">
                <label>Passowrd<span>*</span></label><input name="USERPASSWORD" onchange="checkEmpty(this)" type="password" class="inp-creat-acc"  value="" onfocus="if(this.value==this.defaultValue)this.value='';" onblur="if(this.value=='')this.value=this.defaultValue;"/>
            </div>
            <div class="popup_create-acc_main_row">   
                <input name="" type="submit" value="SUBMIT" class="button_creat-acc"/>
                <div id="errormess" class="error_message">Text invalid</div>
            </div>

        </div>
        </form>
        <a class="close-reveal-modal"><img src="images/close.png" alt="closed" /></a>
    </div>
</div>