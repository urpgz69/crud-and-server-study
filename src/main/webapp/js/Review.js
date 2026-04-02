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
$(function (){
//바디가 로드된 뒤 시행
    searchReview();

})
function searchReview(){
    $("#search-btn").click( () => {
    const reviewTitle = $("#search-input").val();
    console.log(reviewTitle);
    $.ajax({
       url:'review-search',
        data : {reviewTitle } // ===param
    }).done(function (resData){
        console.log(resData);
        showResult(resData);
    }).fail((xhr,status,error )=>{
        console.log(xhr);
        console.log(status);
        console.log(error);

    } )

    })

}

function showResult(resData){
    $.each(resData, (i,r)=>{
        console.log(i);
        console.log(r);
        let content =  `<div class="review-row">
                    <div>
                        <span onclick="location.href='review-detail?no=${r.reNo}'">${r.reTitle }</span>
                    </div>
                    <div>${r.reDate }</div>
                </div>
         `;
        $("#result").append(content);

    })
}