// Wait until the page is completely loaded
document.addEventListener("DOMContentLoaded", () => {

    const searchInput = document.getElementById("searchInput");
    const sortSelect = document.getElementById("sortSelect");
    const restaurantContainer = document.querySelector(".restaurants");

    // Get all restaurant cards
    let cards = Array.from(document.querySelectorAll(".restaurant-card"));

    /* ==========================
          LIVE SEARCH
    ========================== */

    searchInput.addEventListener("keyup", function () {

        const searchValue = this.value.toLowerCase();

        let found = false;

        cards.forEach(card => {

            const restaurantName = card.querySelector(".restaurant-name").textContent.toLowerCase();

            const cuisine = card.querySelector(".cuisine").textContent.toLowerCase();

            if (restaurantName.includes(searchValue) || cuisine.includes(searchValue)) {

                card.style.display = "block";
                found = true;

            }
            else {

                card.style.display = "none";

            }

        });

        // No Restaurants Found Message

        let noData = document.querySelector(".no-data");

        if (!found) {

            if (!noData) {

                noData = document.createElement("div");

                noData.className = "no-data";

                noData.innerHTML = "<h2>No Restaurants Found 😔</h2>";

                restaurantContainer.appendChild(noData);

            }

        }
        else {

            if (noData) {

                noData.remove();

            }

        }

    });


    /* ==========================
            SORTING
    ========================== */

    sortSelect.addEventListener("change", function () {

        const option = this.value;

        cards = Array.from(document.querySelectorAll(".restaurant-card"));

        cards.sort((a, b) => {

            if (option === "rating") {

                const ratingA = parseFloat(
                    a.querySelector(".rating").textContent.replace("⭐", "").trim()
                );

                const ratingB = parseFloat(
                    b.querySelector(".rating").textContent.replace("⭐", "").trim()
                );

                return ratingB - ratingA;

            }

            if (option === "delivery") {

                const timeA = parseInt(
                    a.querySelector(".details span:first-child").textContent
                );

                const timeB = parseInt(
                    b.querySelector(".details span:first-child").textContent
                );

                return timeA - timeB;

            }

            if (option === "price") {

                const priceA = parseInt(
                    a.querySelector(".details span:last-child").textContent.replace("₹", "")
                );

                const priceB = parseInt(
                    b.querySelector(".details span:last-child").textContent.replace("₹", "")
                );

                return priceA - priceB;

            }

            return 0;

        });

        cards.forEach(card => restaurantContainer.appendChild(card));

    });

});