'use strict';

function greet(name,element){
    console.log(`Hey, ${name}!`);
    element.$server.greet("server");
}

      document.addEventListener("DOMContentLoaded", function(event) {
        document.querySelector('.add').addEventListener("click",myFunction);
        function myFunction(){
        const artworkName = document.querySelector('.artwork').value;
        const artistName = document.querySelector('.name').value;
        const link = document.querySelector('.link').value;

         alert("Artwork has been added" + artworkName + artistName+link);



         document.querySelector('.artwork').value = "";
         document.querySelector('.name').value = "";
         document.querySelector('.link').value = "";

        }
      });

