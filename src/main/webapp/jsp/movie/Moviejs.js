function postTo(action,params){
    let form = document.createElement('form');
    form.method = 'POST';
    form.action = action;

    for (let [key, value] of Object.entries(params)){

        let hiddenField = document.createElement('input');
        hiddenField.type = 'hidden';
        hiddenField.name = key;
        hiddenField.value = value;

        form.appendChild(hiddenField);

    }
    document.body.appendChild(form);
    form.submit();
}



function deleteAl(num){
    let ok = confirm("Are you sure you want to delete?");
    if(ok){
        postTo("movie",{num:num , crud : "d"});
    }
}
function addModal(){

document.getElementById('addModal').style.display = 'flex';
}
function  updateModal(el){

    const card = el.closest('.movie-card');
    document.getElementById('updateNum').value= card.dataset.num;
    document.getElementById('updateTitle').value= card.dataset.title;
    document.getElementById('updateActor').value= card.dataset.actor;
    document.getElementById('updateStory').value= card.dataset.story;
    document.getElementById('updateModal').style.display = 'flex';

}

function detailModal(el){
    const card = el.closest('.movie-card');
    document.getElementById('detailTitle').innerText = card.dataset.title;
    document.getElementById('detailActor').innerText = card.dataset.actor;
    document.getElementById('detailImg').src = 'movieFile/' + card.dataset.img;
    document.getElementById('detailStory').innerText = card.dataset.story;
    document.getElementById('detailModal').style.display = 'flex';


}