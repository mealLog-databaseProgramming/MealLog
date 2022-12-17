function readImage(input) {
	if(input.files && input.files[0]) {
		const reader = new FileReader();
		
		console.log(input.files[0]);
		
		reader.onload = (e) => {
			console.log("load!!");
            const previewImage = document.querySelector(".preview");
            previewImage.src = e.target.result;
            
            if(previewImage.width > previewImage.height) previewImage.style.height = "200px";
            else previewImage.style.width = "200px";
        }
		reader.readAsDataURL(input.files[0]);
		console.log(input.files[0]);
		
		var form = document.querySelector("#profile_edit");
		form.setAttribute("enctype", "multipart/form-data");
	}
}

var fileInput = document.querySelector('#file');
fileInput.onchange = (e) => {
	readImage(e.target);
}

function profile_edit_submit(e) {
	
}