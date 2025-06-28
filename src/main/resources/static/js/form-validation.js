// form-validation.js
function validateForm() {
  const email = document.querySelector('#email').value;
  const password = document.querySelector('#password').value;
  if (!email || !password) {
    alert('Email and Password are required!');
    return false;
  }
  return true;
}
