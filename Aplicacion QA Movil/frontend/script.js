document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('productForm');

    form.addEventListener('submit', async (e) => {
        e.preventDefault();

        const formData = {
            nombre: document.getElementById('nombre').value,
            descripcion: document.getElementById('descripcion').value,
            defectuoso: document.getElementById('defectuoso').value // "false" o "true" como string
        };

        try {
            const response = await fetch('http://localhost:3000/productos', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(formData)
            });

            const responseBody = await response.text(); // para debug

            if (response.status === 201) {
                const isDefectuoso = formData.defectuoso;
                window.location.href = `confirmacion.html?defectuoso=${isDefectuoso}`;
                form.reset();
            } else {
                console.error('Respuesta no esperada:', response.status, responseBody);
                alert('Error al agregar producto');
            }
        } catch (error) {
            console.error('Error al enviar:', error);
            alert('Fallo de red o error en la solicitud');
        }
    });
});
