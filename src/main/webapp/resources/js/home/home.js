const thumbs_up = document.querySelectorAll('.bi-hand-thumbs-up');
const thumbs_up_fill = document.querySelectorAll('.bi-hand-thumbs-up-fill');
const thumbs_down = document.querySelectorAll('.bi-hand-thumbs-down');
const thumbs_down_fill = document.querySelectorAll('.bi-hand-thumbs-down-fill');

const $modal_body = document.querySelector('.modal-body');
const $modal_body_childs = $modal_body.childNodes;
const $modal_foodContainer = $modal_body_childs[5];
const $comment_modal_body = document.querySelector('.commentModalBody');

//좋아요 버튼
for(let i = 0; i< thumbs_up.length; i++) {
	thumbs_up[i].addEventListener('click', function(e){
		thumbs_up[i].style.display="none";
		thumbs_up_fill[i].style.display="inline";
	});
}

//싫어요 버튼 
for(let i = 0; i< thumbs_down.length; i++) {
	thumbs_down[i].addEventListener('click', function(e){
		thumbs_down[i].style.display="none";
		thumbs_down_fill[i].style.display="inline";
	});
}

//좋아요 버튼 취소
for(let i = 0; i< thumbs_up_fill.length; i++) {
	thumbs_up_fill[i].addEventListener('click', function(e){
		thumbs_up_fill[i].style.display="none";
		thumbs_up[i].style.display="inline";
	});
}

//싫어요 버튼 취소
for(let i = 0; i< thumbs_down_fill.length; i++) {
	thumbs_down_fill[i].addEventListener('click', function(e){
		thumbs_down_fill[i].style.display="none";
		thumbs_down[i].style.display="inline";
	});
}

function reactDown(){
	$thumbs_down.style.display = "none";
	$thumbs_down_fill.style.display = "inline";
}

//댓글 업로드 함수 테스트
function commentUpload(){
	alert('upload comment');
}

function addFood() {
	var inputFood = prompt("임시, 음식 이름 입력");
	const foodElement = `<div class="food" onclick="deleteFood()">${inputFood}</div>`
	$modal_foodContainer.insertAdjacentHTML('beforeend', foodElement);
}
 
function displayReply(e){
	
	
	var list = e.querySelectorAll('.replyAll');
	
	for (i = 0; i < list.length; i++) {
		var replyObj = list.item(i);
		
		var writer = replyObj.querySelector('.replyWriter').value;
		var date = replyObj.querySelector('.replyTime').value;
		var reply = replyObj.querySelector('.reply').value;
		
		const comment = `
            <div class="commentContainer">
               <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="rgba(0,0,0,.75)" class="bi bi-person-circle" viewBox="0 0 16 16">
                  <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                  <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
               </svg>
               <div class="commentText">
                  <span class="commentWriter">${writer}</span>
                  <span class="commentTime">${date}</span>
                  <div class="comment">${reply}</div>
               </div>
            </div>
      `;
      
      $comment_modal_body.insertAdjacentHTML('beforeend', comment);
	}
} 
 
$(document).ready(function() {
    $('#commentModal').on('show.bs.modal', function (event) {
        while ($comment_modal_body.hasChildNodes()) 	// 부모노드가 자식이 있는지 여부를 알아낸다
		  $comment_modal_body.removeChild($comment_modal_body.firstChild);
    })
});

$(".likeimg").on("click", function () {
	$.ajax({
      url: '/reactController',
      type: 'POST',
      data: { 'b_number': b_number, 'm_id': m_id },	//반응식별자, 추가인지 삭제인지, 유저아이디, 피드아이디
      success: function (data) {
          if (data == 1) {
              $("#likeimg").attr("src", "/resources/img/좋아요후.png");
              location.reload();
          } else {
              $("#likeimg").attr("src", "/resources/img/좋아요전.png");
              location.reload();
          }
      }, error: function () {
          $("#likeimg").attr("src", "/resources/img/좋아요후.png");
          console.log('오타 찾으세요')
      }

  });

});