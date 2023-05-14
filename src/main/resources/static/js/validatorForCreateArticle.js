const name = document.getElementById("name");
const link = document.getElementById("videoFromYouTube");
const form = document.querySelector("form");
const errorMessage = document.getElementById("errorMessage");
const regex = /http(?:s?):\/\/(?:www\.)youtube*/g;
const text = document.getElementById("text");
const button = document.getElementById("button");

let msg



text.addEventListener('focusout', event => {
    let length = text.value.split(" ");

    if (length.length > 420) {
        msg = 'the number of words in the article should not exceed 420!';
        button.style.display = "none";
        alert(msg);
    } else {
        button.style.display = "block"
    }
})

form.addEventListener("submit", (e) => {
    const errors = [];

    if (!link.value.match(regex)) {
        errors.push("this link is not from youtube")
    }


    if (name.value.trim() === "" || name.value.trim() == null ) {
        errors.push("name article required")
    }

    if (text.value.trim() === "" || text.value.trim() == null) {
        errors.push("text required")
    }


    if (errors.length > 0) {
        e.preventDefault();
        errorMessage.toggleAttribute('hidden');
        errorMessage.innerText = errors.join(",\r\n");
    }
})
