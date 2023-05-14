const performer = document.getElementById("performer");
const concertDate = document.getElementById("concertDate");
const price = document.getElementById("price");
const venue = document.getElementById("venue");
const errorMessage = document.getElementById("errorMessage");


form.addEventListener("submit", (e) => {
    const errors = [];

    if (performer.value.trim() === "") {
        errors.push("performer required")
    }

    if (concertDate.value.trim() === "") {
        errors.push("concertDate required")
    }

    if (venue.value.trim() === "") {
        errors.push("venue required")
    }

    if (price.value.trim() === "") {
        errors.push("price required")
    }



    if (errors.length > 0) {
        e.preventDefault();
        errorMessage.toggleAttribute('hidden');
        errorMessage.innerText = errors.join(",\r\n");
    }
})