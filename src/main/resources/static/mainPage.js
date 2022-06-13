'use strict';


const addNewArtwork = function(){
    // const inputName = document.querySelector('#newArtworkName').value;
    // const inputArtist = document.querySelector('#newArtworkArtist').value;
    // const inputDate = document.querySelector('#newArtworkDate').value;
    // const inputImage = document.querySelector('#newArtworkURL').value;


    let xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/api/v1/artwork/");
    xhr.setRequestHeader("Content-Type", "application/json");

    xhr.onload = function() {
        if (xhr.status !== 200) { // analyze HTTP status of the response
            alert(xhr.response); // e.g. 404: Not Found
            xhr.onerror = () => console.log(`Loaded: ${xhr.status} ${xhr.response}`);
        } else { // show the result
            alert(`Artwork has been added!`); // response is the server response
        }
    };



    let data = `{
            "name":"${document.querySelector('#newArtworkName').value}",
            "artist":"${document.querySelector('#newArtworkArtist').value}",
            "date":"${document.querySelector('#newArtworkDate').value}",
            "image":"${document.querySelector('#newArtworkURL').value}"
        }`;

    xhr.send(data);
    document.getElementById("addArtworkForm").reset();


    var element = document.getElementById("successArtwork");
    element.style.display = "block";

}

function changeStyle(){
    var element = document.getElementById("myDiv");
    //    element.style.display = "none";
    window.location.reload();
}
