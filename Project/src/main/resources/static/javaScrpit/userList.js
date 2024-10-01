function updateField(userId, fieldName, fieldValue) {
    const data = {};
    data[fieldName] = fieldValue;

    fetch(`/updateUserField/${userId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    })
    .then(response => {
        if (response.ok) {
            console.log(`${fieldName} updated successfully.`);
        } else {
            console.error(`Error updating ${fieldName}.`);
        }
    })
    .catch(error => console.error('Error:', error));
}
s