let autos = document.getElementsByClassName("auto");
let form = document.getElementById("form")
for(let input of autos){
    loadAutocomple(input)
}

form.action = window.location.href.split('?')[0];

async function loadAutocomple(input) {
    let url = input.value
    input.value = ""
    let list = await getList(url)
    $( function() {
        $("#" + input.getAttribute("id")).autocomplete({
          source: list,
          minLength: 3,
          select: async function (event, ui) {
            let id = input.getAttribute("id").substring(6)
            let numericInput = document.getElementById(id) 
            numericInput.value = ui.item.id
        }
        });
      } );
}

function getList(url){
    return new Promise((resolve, reject) =>{
       fetch(url)
       .then((response) => {
       return response.json();
       })
        .then((data) => {
           resolve(data);
       });
});
}