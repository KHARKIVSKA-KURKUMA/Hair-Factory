const CONSULT_URL = 'http://localhost:8080/enroll';
const CONSULT_ID = 'consultation-form';

window.addEventListener('load', async _event => {
  const consultForm = document.getElementById(CONSULT_ID);

  consultForm.addEventListener('submit', async event => {
    event.preventDefault();

    const response = await fetch(CONSULT_URL, {
      method: 'POST',
      headers: {
        'Content-type': 'application/json;charset=UTF-8',
      },
      body: JSON.stringify(Object.fromEntries(new FormData(consultForm))),
    });

    if (!response.ok) {
      return;
    }

    const result = await response.text();

    alert(result);
  });
});
