(function() {
	'use strict'
	const forms = document.querySelectorAll('.needs-validation')

	Array.prototype.slice.call(forms).forEach(function(form) {
		const originalValues = {};
		const isEditMode = form.querySelector('input[name="id"]').value !== '';

		if (isEditMode) {
			form.querySelectorAll('input[type="text"], input[type="tel"], input[type="number"]').forEach(function(input) {
				originalValues[input.name] = input.value;
			});
		}

		form.addEventListener('submit', function(event) {
			// Remove any existing warning message
			const existingWarning = form.querySelector('.no-changes-warning');
			if (existingWarning) {
				existingWarning.remove();
			}

			if (!form.checkValidity()) {
				event.preventDefault()
				event.stopPropagation()
				form.classList.add('was-validated')
				return;
			}

			if (isEditMode) {
				let hasChanges = false;
				form.querySelectorAll('input[type="text"], input[type="tel"], input[type="number"]').forEach(function(input) {
					if (input.value !== originalValues[input.name]) {
						hasChanges = true;
					}
				});

				if (!hasChanges) {
					event.preventDefault();

					// Highlight inputs
					form.querySelectorAll('input[type="text"], input[type="tel"], input[type="number"]').forEach(function(input) {
						input.classList.add('border-warning');
						input.style.boxShadow = '0 0 0 0.25rem rgba(255, 193, 7, 0.25)';
						setTimeout(function() {
							input.classList.remove('border-warning');
							input.style.boxShadow = '';
						}, 2000);
					});

					// Add warning message
					const actionWrapper = form.querySelector('.action-wrapper');
					const warningMsg = document.createElement('div');
					warningMsg.className = 'no-changes-warning text-warning small mb-2';
					warningMsg.textContent = 'Modifica almeno un campo per salvare';
					actionWrapper.parentNode.insertBefore(warningMsg, actionWrapper);

					// Remove message after 3 seconds
					setTimeout(function() {
						warningMsg.remove();
					}, 5000);

					return;
				}
			}

			form.classList.add('was-validated')
		}, false)
	})
})()