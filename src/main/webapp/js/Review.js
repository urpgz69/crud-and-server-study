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
function deleteReview(no){
    let ok = confirm("Are you sure you want to delete this review?");
    if(ok){
        location.href = "review-delete?no="+no;

    }

}