function reviewAddModal() {
    document.getElementById('reviewAddModal').style.display = 'flex';
}

function countText(){
    const textArea = document.getElementById("text");
    const cntSpan = document.querySelector(".cntSpan");
    if (cntSpan) {
        cntSpan.innerText = textArea.value.length;
    }
}
