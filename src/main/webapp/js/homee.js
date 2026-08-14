// ============================
// Mobile Navigation
// ============================

const menuIcon = document.querySelector(".menu-icon");
const navLinks = document.querySelector(".nav-links");

menuIcon.addEventListener("click", () => {

    navLinks.classList.toggle("show");

});


// ============================
// Navbar Shadow on Scroll
// ============================

const navbar = document.querySelector(".navbar");

window.addEventListener("scroll", () => {

    if (window.scrollY > 50) {

        navbar.style.boxShadow = "0 4px 18px rgba(0,0,0,0.15)";

    } else {

        navbar.style.boxShadow = "0 2px 12px rgba(0,0,0,0.08)";
    }

});


// ============================
// Explore Restaurants Button
// ============================

function goToRestaurants() {

    window.location.href = "restaurant";

}


// ============================
// Smooth Scroll
// ============================

document.querySelectorAll('a[href^="#"]').forEach(anchor => {

    anchor.addEventListener("click", function (e) {

        e.preventDefault();

        document.querySelector(this.getAttribute("href")).scrollIntoView({

            behavior: "smooth"

        });

    });

});