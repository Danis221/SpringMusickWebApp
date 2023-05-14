const startDate = document.getElementById("startDate");
const endDate = document.getElementById("endDate");
const price = document.getElementById("price");
const form = document.querySelector("form");
const errorMessage = document.getElementById("errorMessage");

form.addEventListener("submit", e => {
    const errors = [];


    if (startDate.value !== "" && endDate.value === "") {
        errors.push("you did not enter a start date");
    }


    if (startDate.value === "" && endDate.value !== "") {
        errors.push("you did not enter a end date");
    }

    if (errors.length > 0) {
        e.preventDefault();
        errorMessage.toggleAttribute('hidden');
        errorMessage.innerText = errors.join(",\r\n");
    }

})