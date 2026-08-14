
// =======================================
// AAHARADHAAN HOME PAGE JAVASCRIPT
// =======================================


// =======================================
// MOBILE MENU
// =======================================

const menuIcon = document.querySelector(".menu-icon");
const navLinks = document.querySelector(".nav-links");

menuIcon.addEventListener("click", () => {

    navLinks.classList.toggle("show");

});



// =======================================
// NAVBAR SCROLL EFFECT
// =======================================

const navbar = document.querySelector(".navbar");

window.addEventListener("scroll", () => {

    if (window.scrollY > 70) {

        navbar.classList.add("scrolled");

    }

    else {

        navbar.classList.remove("scrolled");

    }

});




// =======================================
// HERO VIDEO
// =======================================
// Single looping background clip — the <video> tag itself handles
// looping via the "loop" attribute in index.jsp, so no JS needed here.




// =======================================
// EXPLORE RESTAURANTS BUTTON
// =======================================

function goToRestaurants(){

    window.location.href = "restaurant";

}




// =======================================
// SMOOTH SCROLL
// =======================================

document.querySelectorAll('a[href^="#"]').forEach(anchor=>{

    anchor.addEventListener("click",function(e){

        e.preventDefault();

        document.querySelector(this.getAttribute("href")).scrollIntoView({

            behavior:"smooth"

        });

    });

});




// =======================================
// HERO TITLE TYPING EFFECT
// =======================================

const heading = document.querySelector(".hero-content h1");

if(heading){

const text = heading.innerHTML;

heading.innerHTML = "";

let i = 0;

function typing(){

    if(i < text.length){

        // If we're at the start of an HTML tag (like <br>), append
        // the whole tag in one go instead of typing it character by
        // character — otherwise a half-typed "<b" or "<br" renders
        // as literal visible text instead of a line break.
        if(text.charAt(i) === "<"){

            const tagEnd = text.indexOf(">", i);

            heading.innerHTML += text.substring(i, tagEnd + 1);

            i = tagEnd + 1;

        }

        else{

            heading.innerHTML += text.charAt(i);

            i++;

        }

        setTimeout(typing,40);

    }

}

typing();

}




// =======================================
// SCROLL REVEAL ANIMATION
// =======================================

const revealElements = document.querySelectorAll(

".category-card,.restaurant-card,.feature-card,.review-card"

);

window.addEventListener("scroll", reveal);

function reveal(){

    const trigger = window.innerHeight - 120;

    revealElements.forEach((element)=>{

        const top = element.getBoundingClientRect().top;

        if(top < trigger){

            element.style.opacity="1";

            element.style.transform="translateY(0px)";

            element.style.transition="0.8s";

        }

    });

}

reveal();




// =======================================
// PARALLAX HERO
// =======================================

window.addEventListener("scroll",()=>{

    const hero=document.querySelector(".hero");

    let offset=window.pageYOffset;

    hero.style.backgroundPositionY=offset*0.5+"px";

});




// =======================================
// SEARCH BOX ENTER KEY
// =======================================

const searchInput=document.querySelector(".search-box input");

if(searchInput){

searchInput.addEventListener("keypress",(e)=>{

    if(e.key==="Enter"){

        goToRestaurants();

    }

});

}




// =======================================
// RESTAURANT CARD HOVER SOUND (Optional)
// =======================================

const cards=document.querySelectorAll(".restaurant-card");

cards.forEach(card=>{

card.addEventListener("mouseenter",()=>{

card.style.transition=".35s";

});

});




// =======================================
// AUTO CLOSE MOBILE MENU
// =======================================

document.querySelectorAll(".nav-links a").forEach(link=>{

link.addEventListener("click",()=>{

navLinks.classList.remove("show");

});

});




// =======================================
// CURRENT YEAR IN FOOTER
// =======================================

const year=document.getElementById("year");

if(year){

year.innerHTML=new Date().getFullYear();

}




// =======================================
// PRELOADER (Optional)
// =======================================

window.onload=()=>{

document.body.style.opacity="1";

};