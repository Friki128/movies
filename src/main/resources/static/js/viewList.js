let listDiv = document.getElementById("list")
let type = document.getElementById("title")
let input = document.getElementById("input")
let button = document.getElementById("btn")
let page = document.getElementById("page")
let label = document.getElementById("label")
let pageLabel = document.getElementById("pageLabel")
let next = document.getElementById("next");
let prev = document.getElementById("prev");
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

async function loadList(){
    let url = "/find"+type.textContent;
    if(input.value!=""){
        url += "By" + label.textContent + "?" + label.textContent.toLowerCase() + "=" + input.value + "&page=" + page.value;
    }else{
        url += "?page=" + page.value;
    }
    let pagin = await getList(url)
    let list = pagin.content
    pageLabel.textContent = "Page " + (pagin.number + 1) + " of " + pagin.totalPages
    page.value = pagin.number
    listDiv.innerHTML = ""
    for(let element of list){
        if(type.textContent == "Movies"){
            listDiv.innerHTML += "<a href=\"view" + type.textContent.slice(0,-1) + "?id="+ element.id +"\">" + element.title + "</a>"
        }else{
            listDiv.innerHTML += "<a href=\"view" + type.textContent.slice(0,-1) + "?id="+ element.id +"\">" + element.name + "</a>"
        }
        
    }
    if(pagin.last){
        next.classList.add("hidden")
    }else{
        next.classList.remove("hidden")
    }

    if(pagin.first){
        prev.classList.add("hidden")
    }else{
        prev.classList.remove("hidden")
    }
}

async function loadAutocomple(){
    let list = await getList("/findAll"+type.textContent)
    $( function() {
        $( "#input" ).autocomplete({
          source: list,
          minLength: 3
        });
      } );
}

button.onclick = function(){
    page.value = 0
    loadList()
}
prev.onclick = function(){
    page.value = parseInt(page.value) - 1
    loadList()
}
next.onclick = function(){
    page.value = parseInt(page.value) + 1
    loadList()
}

loadList();
loadAutocomple();

