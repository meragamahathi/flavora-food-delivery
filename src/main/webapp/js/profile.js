// =======================================
// FLAVORA PROFILE PAGE JAVASCRIPT
// =======================================


// =======================================
// MOBILE MENU
// =======================================

const menuIcon = document.querySelector(".menu-icon");
const navLinks = document.querySelector(".nav-links");

if(menuIcon && navLinks){

    menuIcon.addEventListener("click", () => {

        navLinks.classList.toggle("show");

    });

}


// =======================================
// EDIT / VIEW TOGGLE FOR PERSONAL INFO
// =======================================

const profileForm = document.getElementById("profileForm");
const formActions = document.getElementById("formActions");
const editToggleBtn = document.getElementById("editToggleBtn");

let isEditing = false;

function toggleEdit(){

    isEditing = !isEditing;

    const inputs = profileForm.querySelectorAll("input");

    inputs.forEach(input => {

        input.disabled = !isEditing;

    });

    formActions.classList.toggle("show", isEditing);

    editToggleBtn.innerHTML = isEditing
        ? '<i class="fa-solid fa-xmark"></i> Editing'
        : '<i class="fa-solid fa-pen"></i> Edit';

    if(isEditing && inputs.length > 0){

        inputs[0].focus();

    }

}


// =======================================
// CHANGE PASSWORD POPUP
// =======================================

function openChangePasswordPopup(){

    document.getElementById("changePasswordOverlay").classList.add("show");

}

function closeChangePasswordPopup(){

    document.getElementById("changePasswordOverlay").classList.remove("show");

}

document.addEventListener("DOMContentLoaded", () => {

    const overlay = document.getElementById("changePasswordOverlay");

    if(overlay){

        overlay.addEventListener("click", (e) => {

            if(e.target === overlay){

                closeChangePasswordPopup();

            }

        });

    }

});


// =======================================
// QUICK STATS (placeholder values)
// =======================================
// Replace this block with a real fetch() call to an endpoint like
// GET /ProfileStatsServlet once that's available, and populate the
// three numbers below from the response instead of hardcoding them.

document.addEventListener("DOMContentLoaded", () => {

    const statOrders = document.getElementById("statOrders");
    const statFavourites = document.getElementById("statFavourites");
    const statReviews = document.getElementById("statReviews");

    if(statOrders) statOrders.textContent = "0";
    if(statFavourites) statFavourites.textContent = "0";
    if(statReviews) statReviews.textContent = "0";

});