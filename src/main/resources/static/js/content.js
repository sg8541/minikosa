// confirm 출력 함수
function getMessage(message) {
    return window.confirm(message);
}

var message = "";
/*관리자 버튼*/
const aBtn = document.querySelectorAll(".admin_button");

aBtn.forEach(function (btn) {
    btn.addEventListener('click', function (e) {
        e.preventDefault();
        let result = false;
        if (this.getAttribute('data-result') == 'modify') {
            message = "가게 정보를 수정하시겠습니까?";
            result = getMessage(message);
            if (result) {
                const form = this.closest('form');
                form.method = 'get';
                form.action = 'admin/edit';
                form.submit();
            }
        } else if (this.getAttribute('data-result') == 'del') {
            message = "가게 정보를 삭제하시겠습니까?";
            result = getMessage(message);
            if (result) {
                const form = this.closest('form');
                const actionUrl = this.getAttribute('data-action');
                form.method = 'post';
                form.action = actionUrl;
                form.submit();
            }
        }
    })
})

/*유저 리뷰 작성 완료 버튼 클릭*/

const writeBtn = document.getElementById("u-write");

writeBtn.addEventListener('click', function (e) {
    e.preventDefault();
    const form = this.closest('form');
    message = "리뷰 작성을 완료하시겠습니까?"
    let result = getMessage(message);
    sessionStorage.setItem('scrollPosition', window.pageYOffset);
    if (result) {
        form.submit();
    }
})

/*유저 자신 리뷰 수정 삭제 버튼*/
const uBtn = document.querySelectorAll(".comment_user_button");

uBtn.forEach(function (btn) {
    btn.addEventListener('click', function (e) {
        e.preventDefault();
        let result = false;
        if (this.getAttribute('data-result') == 'u-modify') {
            message = "리뷰 댓글을 수정하시겠습니까?";
            result = getMessage(message);
            if (result) {
                sessionStorage.setItem('scrollPosition', window.pageYOffset);
                const commentTextElement = this.closest('li').querySelector('.text_comment span');
                const commentText = commentTextElement.textContent.trim();

                // 특정 textarea 요소에 값을 설정
                const textarea = document.getElementById('u-comment-write');
                textarea.value = commentText;
                textarea.focus();

                // rating 값을 가져와 라디오 버튼 선택
                const ratingTextElement = this.closest('li').querySelector('.text_desc');
                const ratingValue = ratingTextElement.textContent.trim();
                const ratingRadio = document.querySelector(`input[name="rating"][value="${ratingValue}"]`);
                if (ratingRadio) {
                    ratingRadio.checked = true;
                }
                const reviewForm = document.getElementById('userWrite'); // id로 폼 선택
                const reviewId = this.getAttribute('data-review-id'); // data-review-id에서 reviewId 가져오기
                const reviewInput = reviewForm.querySelector('input[name="reviewId"]'); // name으로 숨겨진 input 선택
                reviewInput.value = reviewId; // 숨겨진 input의 값 설정
            }
        } else if (this.getAttribute('data-result') == 'u-del') {
            message = "리뷰 댓글을 삭제하시겠습니까?";
            result = getMessage(message);
            if (result) {
                const form = this.closest('form');
                const reviewId = this.getAttribute("data-review-id");
                const reviewIdInput = form.querySelector('input[name="reviewId"]');
                reviewIdInput.value = reviewId;
                sessionStorage.setItem('scrollPosition', window.pageYOffset);
                form.submit();
            }
        }
    })
})

/*사장 댓글 관련 기능*/

/*답글 클릭 시*/
function pWriteBox(reviewId, replyContainer) {
    let box = document.createElement("li");
    box.className = 'reply_comment_list';
    box.innerHTML =
        `<a href="#none" class="reply_img">
            <img width="16" height="16" src="https://img.icons8.com/small/16/down-right.png" alt="down-right" class="icon_reply" />
         </a>
         <div class="unit_info_admin">
            <em class="screen_out">사장 : </em>
                <div class="comment_info_reply">
                    <textarea class="comment_write" name="replyText" id="p-comment" type="text"></textarea>
                    <div class="pro_write">
                        <button class="select_button" type="reset">다시쓰기</button>
                        <button class="select_button" type="submit" data-result='re-write'>작성완료</button>
                    </div>
                </div>
         </div>`;
    let reviewBox = document.querySelector(".review_list");
    reviewBox.appendChild(box);

    // 작성완료 버튼 선택
    const submitBtn = box.querySelector('button[data-result="re-write"]');

    if (submitBtn) {
        submitBtn.addEventListener('click', function (e) {
            e.preventDefault(); // 기본 폼 제출 동작 방지
            sessionStorage.setItem('scrollPosition', window.pageYOffset);
            const form = document.getElementById('reviewList'); // 폼 선택
            const reviewInput = form.querySelector('input[name="reviewId"]'); // 숨겨진 input 선택
            reviewInput.value = reviewId; // 숨겨진 input에 reviewId 설정

            form.method = 'post';
            form.action = `${reviewId}/reply`; // 엔드포인트에 reviewId 동적으로 추가
            form.submit(); // 폼 전송
        });
    }

}

/*답글 작성, 수정, 삭제 메세지*/
const pBtn = document.querySelectorAll(".comment_pd_button");

pBtn.forEach(function (btn) {
    btn.addEventListener('click', function (e) {
        e.preventDefault();
        let result = false;
        const replyContainer = btn.closest('.reply_comment_list');

        if (this.getAttribute('data-result') == 'p-reply') {
            message = "해당 리뷰에 답글을 작성하시겠습니까?";
            result = getMessage(message);
            if (result) {
                sessionStorage.setItem('scrollPosition', window.pageYOffset);
                btn.style.display = 'none';
                const reviewId = this.getAttribute('data-review-id');
                pWriteBox(reviewId, replyContainer);
            }
        } else if (this.getAttribute('data-result') === 'p-modify') {
            const reviewId = this.getAttribute('data-review-id'); // 리뷰 ID 가져오기
            const replyId = this.getAttribute('data-reply-id'); // 답글 ID 가져오기

            message = "해당 답글을 수정하시겠습니까?";
            result = getMessage(message);
            if (result) {
                btn.style.display = 'none';
                sessionStorage.setItem('scrollPosition', window.pageYOffset);
                let tagContent = removeTag(replyContainer); // 기존 답글 내용을 가져옴
                modifyReply(replyContainer, tagContent, reviewId, replyId); // 답글 수정 UI 생성
            }

        } else if (this.getAttribute('data-result') == 'p-del') {
            message = "해당 답글을 삭제하시겠습니까?";
            const replyId = this.getAttribute('data-reply-id'); // 답글 ID 가져오기
            result = getMessage(message);
            if (result) {
                sessionStorage.setItem('scrollPosition', window.pageYOffset);
                const form = this.closest('form');
                const replyIdInput = form.querySelector('input[name="replyId"]'); // 숨겨진 input 선택
                replyIdInput.value = replyId;
                form.method = 'post';
                form.action = `reply/${replyId}`;
                form.submit();
            }
        }
    });
});

/*답글 수정 클릭 시*/
function removeTag(replyContainer) {
    let replyText = replyContainer.querySelector('.text_comment');
    let content = replyText.innerText.trim();
    replyText.remove(); // 클릭한 답글을 삭제
    return content;
}

function modifyReply(replyContainer, tagContent, reviewId, replyId) {
    let reviewBox = replyContainer.querySelector(".comment_info_reply");

    reviewBox.insertAdjacentHTML('beforeend', `
        <textarea class="comment_write" name="replyText" type="text"></textarea>
        <div class="pro_write">
            <button class="select_button" type="reset">다시쓰기</button>
            <button class="select_button" type="submit" >작성완료</button>
        </div>
        `);

    let replyText = replyContainer.querySelector('.text_comment');

    const textarea = replyContainer.querySelector('.comment_write');
    textarea.value = tagContent;
    textarea.focus();

    const form = document.getElementById('reviewList'); // 폼 선택
    const reviewInput = form.querySelector('input[name="reviewId"]'); // 숨겨진 input 선택
    reviewInput.value = reviewId;
    const replyInput = form.querySelector('input[name="replyId"]'); // 숨겨진 input 선택
    replyInput.value = replyId; // 숨겨진 input에 reviewId 설정

    const submitButton = replyContainer.querySelector('.select_button[type="submit"]');
    submitButton.addEventListener('click', function () {
        form.method = 'post';
        form.action = `${reviewId}/reply/${replyId}`; // 엔드포인트에 reviewId 동적으로 추가
        form.submit(); // 폼 전송
    });
}

/*
var scroll = sessionStorage.setItem('scrollPosition', window.pageYOffset);
*/
window.onload = function () {
    const scrollPosition = sessionStorage.getItem('scrollPosition');
    if (scrollPosition) {
        window.scrollTo(0, scrollPosition);
        sessionStorage.removeItem('scrollPosition');
    }
}

// 스크롤 포인트 없애는 함수
//sessionStorage.removeItem('scrollPosition');
