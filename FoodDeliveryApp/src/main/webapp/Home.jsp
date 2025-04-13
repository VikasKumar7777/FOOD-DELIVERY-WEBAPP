<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.fda.pojo.user" %>
<%@ page import="com.fda.pojo.restaurant" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.HashSet" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
    <title>DeliByte - Food Delivery App</title>
    <style>
        /* Reset and Base Styles */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: "Poppins", sans-serif;
            background-color: #FFF8E7;
            padding: 18px;
        }

        /* Container */
        .container {
            background: white;
            border-radius: 24px;
            padding: 20px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        /* Header Styles */
        header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            flex-wrap: wrap;
            gap: 16px;
            margin-bottom: 20px;
        }

        .logo h1 {
            font-size: 1.5rem;
            margin: 0;
        }

        .search-bar {
            position: relative;
            min-width: 250px;
            flex: 1;
            max-width: 400px;
        }

        .search-bar input {
            width: 100%;
            padding: 10px 40px 10px 16px;
            border: 1px solid #ccc;
            border-radius: 20px;
            font-size: 1rem;
        }

        .search-bar svg {
            position: absolute;
            right: 12px;
            top: 50%;
            transform: translateY(-50%);
        }

        .user-info {
        	background-color: #E6F7F1;
        	border-radius:24px;
        	padding:5px;
            display: flex;
            align-items: center;
            gap: 12px;
        }
        
        .user-info img{
        	width:25px;
        	height:25px;
        }
        
        .user-info:hover{
        	border:1px #00A082 solid;
        	cursor:pointer;
        }

        .avatar {
            width: 40px;
            height: 40px;
            border-radius: 50%;
            object-fit: cover;
        }

        /* Banner Styles */
        .banner {
            background-color: #E6F7F1;
            color: #00A082;
            border-radius: 24px;
            padding: 24px;
            margin: 20px 0;
        }

        .banner-content {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
            align-items: center;
            gap: 24px;
        }

        .banner-text {
            flex: 1;
            min-width: 280px;
        }

        .banner h2 {
            font-size: clamp(1.5rem, 4vw, 1.875rem);
            margin-bottom: 12px;
        }
        
        .banner h2 span{
        	color:black;
        }
        
		.banner p {
            color:black;
         }

        .banner-image {
            max-width: 300px;
            height: auto;
            border-radius: 24px;
        }

        /* Categories Styles */
        .categories {
            display: flex;
            gap: 12px;
            padding-bottom: 16px;
            margin-bottom: 20px;
            overflow-x: auto;
            scrollbar-width: none;
            -ms-overflow-style: none;
        }

        .categories::-webkit-scrollbar {
            display: none;
        }

        .category {
            padding: 8px 16px;
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 20px;
            white-space: nowrap;
            cursor: pointer;
            transition: all 0.3s ease;
        }

        .category.active {
            background-color: #E6F7F1;
            border-color: #00A082;
            color: #00A082;
        }
        
        .category:hover{
        	background-color: #E6F7F1;
        }

        /* Restaurant Grid */
        .restaurant-grid {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(280px, 1fr));
            gap: 20px;
            margin-top: 20px;
        }

        .restaurant-card {
            position: relative;
            background-color: #fff;
            border-radius: 16px;
            overflow: hidden;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            transition: transform 0.2s;
        }

        .restaurant-card:hover {
            transform: translateY(-5px);
        }

        .restaurant-card img {
            width: 100%;
            height: 200px;
            object-fit: cover;
        }

        .restaurant-info {
            padding: 16px;
        }

        .restaurant-name {
            font-weight: 600;
            margin-bottom: 8px;
        }

        .restaurant-address {
            font-size: 0.9rem;
            color: #666;
            font-style: italic;
            margin-bottom: 8px;
        }

        .restaurant-details {
            color: #666;
            font-size: 0.9rem;
        }

        /* Status Badge */
        .status-badge {
            position: absolute;
            top: 12px;
            right: 12px;
            width: 12px;
            height: 12px;
            border-radius: 50%;
            z-index: 1;
        }

        .status-badge.active {
            background-color: #00A082;
        }

        .status-badge.inactive {
            background-color: #DC2626;
        }

        /* Inactive Restaurant State */
        .restaurant-card.inactive {
            filter: grayscale(100%);
            opacity: 0.7;
        }

        /* Media Queries */
        @media screen and (max-width: 768px) {
            body {
                padding: 8px;
            }

            .container {
                padding: 16px;
            }

            header {
                align-items: stretch;
            }

            .search-bar {
                order: 2;
                max-width: none;
            }

            .user-info {
                order: 1;
                justify-content: flex-end;
            }

            .banner {
                padding: 16px;
            }

            .banner-content {
                flex-direction: column-reverse;
            }

            .banner-image {
                width: 100%;
                margin: 0 auto;
            }

            .restaurant-grid {
                grid-template-columns: 1fr;
            }
        }

        @media screen and (max-width: 480px) {
            .user-info span {
                display: none;
            }

            .banner h2 {
                font-size: 1.25rem;
                padding:0;
                margin:0;
            }
            
            .banner h2 span {
                color:black;
            }

            .banner p {
                font-size: 0.9rem;
                color:black;
            }
            
            .banner-image{
            	height:300px;
            	width:550px;
            	margin-top:20px;
            }
            .restaurant-details {
            	color: #666;
            	font-size: 0.9rem;
            	float:right;
            	padding-bottom:10px;
        	}
        }
    </style>
</head>
<body>
    <div class="container">
        <header>
            <div class="logo">
                <h1>DeliByte</h1>
            </div>
            <div class="search-bar">
                <input type="text" id="search-input" placeholder="Search restaurants..." onkeyup="searchRestaurants()">
                <svg width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                    <circle cx="11" cy="11" r="8"></circle>
                    <line x1="21" y1="21" x2="16.65" y2="16.65"></line>
                </svg>
            </div>
            <div class="user-info">
                <% user loggedinuser=(user)session.getAttribute("loggedInUser"); %>
                <img src="https://avatar.iran.liara.run/public/1" alt="User Avatar" class="avatar">
                <span><%=loggedinuser.getUsername() %></span>
            </div>
        </header>

        <div class="banner">
            <div class="banner-content">
                <div class="banner-text">
                    <h2>Order with <span>DeliByte</span></h2>
                    <p>Get your favorite meals delivered straight to your door!</p>
                </div>
                <img src="https://res.cloudinary.com/drc2ky0yw/image/upload/v1731736317/download_xpeqi0.jpg" 
                     alt="Food delivery" 
                     class="banner-image">
            </div>
        </div>

        <% 
        List<restaurant> allrestaurant = (List<restaurant>)session.getAttribute("restaurantList"); 
        Set<String> uniqueCategories = new HashSet<>();
        for (restaurant rest : allrestaurant) {
            uniqueCategories.add(rest.getCusineType());
        }
        %>

        <div class="categories">
            <div class="category active" onclick="filterRestaurants('All')">🍽️ All</div>
            <% for (String category : uniqueCategories) { %>
                <div class="category" onclick="filterRestaurants('<%= category %>')"><%= category %></div>
            <% } %>
        </div>

        <div class="restaurants">
            <h2>Popular Restaurants</h2>
            <div class="restaurant-grid">
                <% for(restaurant rest : allrestaurant) { %>
                    <div class="restaurant-card <%= rest.getIsActive() == 1 ? "active" : "inactive" %>" 
                         data-category="<%= rest.getCusineType() %>">
                        <div class="status-badge <%= rest.getIsActive() == 1 ? "active" : "inactive" %>"></div>
                        <% 
                        String imageSource = rest.getRestaurantImage() != null && rest.getRestaurantImage().length > 0
                            ? "data:image/webp;base64," + java.util.Base64.getEncoder().encodeToString(rest.getRestaurantImage())
                            : "https://www.caspianpolicy.org/no-image.png";
                        %>
                        <img src="<%= imageSource %>" alt="<%= rest.getName() %>">
                        <div class="restaurant-info">
                            <div class="restaurant-name"><%= rest.getName() %></div>
                            <p class="restaurant-address"><%= rest.getAddress() %></p>
                            <div class="restaurant-details">
                                <%= rest.getRating() %>⭐ • <%= rest.getCusineType() %> • <%= rest.getDeliveryTime() %> min
                            </div>
                        </div>
                    </div>
                <% } %>
            </div>
        </div>
    </div>

    <script>
        function filterRestaurants(category) {
            const categoryButtons = document.querySelectorAll('.category');
            categoryButtons.forEach(button => button.classList.remove('active'));
            
            const selectedButton = Array.from(categoryButtons)
                .find(button => button.textContent.includes(category));
            if (selectedButton) {
                selectedButton.classList.add('active');
            }

            document.querySelectorAll('.restaurant-card').forEach(card => {
                const cardCategory = card.dataset.category;
                card.style.display = (category === 'All' || cardCategory === category) ? '' : 'none';
            });
        }

        function searchRestaurants() {
            const searchTerm = document.getElementById('search-input').value.toLowerCase();
            document.querySelectorAll('.restaurant-card').forEach(card => {
                const restaurantName = card.querySelector('.restaurant-name').textContent.toLowerCase();
                card.style.display = restaurantName.includes(searchTerm) ? '' : 'none';
            });
        }
    </script>
</body>
</html>