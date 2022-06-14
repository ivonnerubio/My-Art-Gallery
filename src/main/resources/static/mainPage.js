'use strict';


const btnAddArtwork = document.querySelector(".btnAddArtwork")

const addNewArtwork = function(){
    const inputName = document.querySelector('#newArtworkName').value;
    const inputArtist = document.querySelector('#newArtworkArtist').value;
    const inputDate = document.querySelector('#newArtworkDate').value;
    const inputImage = document.querySelector('#newArtworkURL').value;

    if(inputName === "" || inputArtist === "" || inputDate === "" || inputImage === ""){
        alert("Please fill out all fields");
    }
    else{
        let xhr = new XMLHttpRequest();
        xhr.open("POST", "https://the-art-gallery.herokuapp.com/api/v1/artwork/");
        xhr.setRequestHeader("Content-Type", "application/json");

        let data = `{
            "name":"${inputName}",
            "artist":"${inputArtist}",
            "date":"${inputDate}",
            "image":"${inputImage}"
        }`;
        xhr.send(data);

        xhr.onload = function() {
            if (xhr.status !== 200) { // analyze HTTP status of the response
                alert("Artwork is already in database"); // e.g. 404: Not Found
                xhr.onerror = () => console.log(`Loaded: ${xhr.status} ${xhr.response}`);
            } else { // show the result
                alert(`Artwork has been added!`); // response is the server response
                document.getElementById("addArtworkForm").reset();
            }
        };
    }
}

const closeModal = function (){
    window.location.reload();
}

