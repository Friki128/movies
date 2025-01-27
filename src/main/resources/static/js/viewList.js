let listDiv = document.getElementById("list")
let type = document.getElementById("title")
let input = document.getElementById("input")
let button = document.getElementById("btn")
let page = document.getElementById("page")
let label = document.getElementById("label")
let pageLabel = document.getElementById("pageLabel")
let next = document.getElementById("next")
let prev = document.getElementById("prev")
let selected = document.getElementById("select")
let selector = null
let currentId
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
    if(currentId != undefined){
            url += "By" + label.textContent + "?" + label.textContent.toLowerCase() + "=" + currentId + "&page=" + page.value 
    }else{
        if(input.value!=""){
            url += "By" + label.textContent + "?" + label.textContent.toLowerCase() + "=" + input.value + "&page=" + page.value;
        }else{
            url += "?page=" + page.value;
        }
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
function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

async function loadAutocomple(url){
    let list = ""
    if(localStorage.getItem(url) != null) list = JSON.parse(localStorage.getItem(url))
    else{
        list = await getList(url)
        localStorage.setItem(url, JSON.stringify(list))
    }
    $( function() {
        $( "#input" ).autocomplete({
          source: list,
          minLength: 3,
          select: async function (event, ui) {
            if(ui.item.id != undefined) currentId = ui.item.id
            page.value = 0;
            await sleep(10)
            loadList();
        }
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
localStorage.clear()
loadList();
loadAutocomple("/findAll"+type.textContent);

if(selected!=undefined){
    selected.onchange = function(){
        input.value = ""
        currentId = undefined
        if(selected.value != "Movies"){
            label.textContent = selected.value.slice(0,-1)
            button.classList.add("hidden")
        }else {
            label.textContent = "Name"
            button.classList.remove("hidden")
        }
        url = "/findAll" + selected.value
        loadAutocomple(url)
    }
}
