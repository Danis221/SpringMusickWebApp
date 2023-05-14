const username = document.getElementById("login");
const password = document.getElementById("password");
const lastname = document.getElementById("lastname");
const firstname = document.getElementById("firstname");
const form = document.querySelector("form");
const errorMessage = document.getElementById("errorMessage");
const passw = /(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{6,}/g;
const name = /^[a-zA-Zа-яА-Я'][a-zA-Zа-яА-Я-' ]+[a-zA-Zа-яА-Я']?$/u;
form.addEventListener("submit", (e) => {
    const errors = [];

    if (username.value.trim() === "") {
        errors.push("login required")
    }

    if (!password.value.match(passw)) {
        errors.push("пароль должен содержать хотябы 1 цифру 1 заглавную латнску букву и 1 обыную латинску букву ");
    }

    if(!firstname.value.match(name)) {
        errors.push("firstname is too weird")
    }

    if(!lastname.value.match(name) ) {
        errors.push("lastname is too weird")
    }

    if (errors.length > 0) {
        e.preventDefault();
        errorMessage.toggleAttribute('hidden');
        errorMessage.innerText = errors.join(",\r\n");
    }
})