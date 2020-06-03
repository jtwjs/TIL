<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=DM+Sans:wght@400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${cp}/resources/css/grid.min.css">
    <link rel="stylesheet" type="text/css" href="${cp}/resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="${cp}/resources/css/signupModal.css">
    <link rel="stylesheet" type="text/css" href="${cp}/resources/css/reset.css">
    <title>NIKE MAIN</title>
</head>
<body>
    <header id="Header">
        
        <nav class="nav-bar">
            <div class="nav-left">
                <ul>
                    <li>
                        <a href="#">NEW ARRIVALS</a>
                    </li>
                    <li>
                        <a href="#">SHOP</a>
                    </li>
                    <li>
                        <a href="#">COLLECTIONS</a>
                    </li>
                </ul>
            </div>
            <div class="main-logo">
                <img src="./resources/assets/logo.png" alt="nike logo" />
            </div>  
            <div class="nav-right">
                <ul>
                    <li>
                        <a href="#">SEARCH</a>
                    </li>
                    <li>
                        <a id="open" href="#">SIGN IN</a>
                    </li>
                    <li>
                        <a href="#">BAG(0)</a>
                    </li>
                    <li>
                        <button  type="button" id="like-button" value="unlike" onclick="like_toggle()" />
                        </button>
                    </li>
                </ul>
            </div>
        </nav>
        <!-- 모달창 -->
        <div class="signUp-modal hidden">
            <div class="modal-top">
                <h1 class="modal-title">CREATE ACCOUNT</h1>
                <button class="close-icon" type="button"> </button>
            </div>
            <div class="modal-content">
            <form class="modal-form" action="joinForm" method="post" >
                <div class="modal-input">
               	
                        <input class="modal-input-item"type="text" placeholder="First Name" name="firstName" required/>
                        <input class="modal-input-item"type="text" placeholder="Last Name"  name="lastName"required />
                        <input class="modal-input-item"type="email" placeholder="Email" name="account" value="account" required/>
                        <input class="modal-input-item"type="text" placeholder="Password" name="password" value="password" required/>
	                  
                </div>
                <div class="modal-bottom">
                    <div class="promo-subscription">
                        <button id="check-box"tpye="button" value="uncheck" onclick="check_toggle()"></button>
                        <p class="promo-desc">
                            Let's get personal! We'll send you only the good stuff;<br>
                            Exclusive early access to Sale, new Arrivals and promotions. No nasties.
                        </p>
                    </div>
                    <p class="legal-policy">
                        By signing up you agree to <span class="emphasize">Terms of Service</span> and <span class="emphasize">Privacy Policy</span>
                    </p>
                    <button class="signUp-btn" type="submit">SIGN UP</button>
                    <a href="#" class="sign-in-link">I HAVE AN ACCOUNT</a>
    
                
                </div>
              </form>
            </div>
        </div>
        <div class="headr-content">   
            <div class="container">
                <div class="row">                
                    <div class="col-12 col-md-7">
                                    
                        <div class="content">
                            <h1 class="content-title">
                                NEW COLLECTION
                            </h1>
                            <p class="content-desc">
                                Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa.
                            </p>
                            <div class="content-btn">
                                <a href="#">SHOP NEW ARRIVALS</a>
                            </div>
                        </div>
                        
                    </div>
                </div>
            </div>
        </div>
    </header>
    <script type="text/javascript" src="${cp}/resources/js/script.js"></script>
   
</body>
</html>