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
                form.action = "search_view.html";
                form.submit();
            }

        } else if (this.getAttribute('data-result') == 'del') {
            message = "가게 정보를 삭제하시겠습니까?";
            result = getMessage(message);
            if (result) {
                const form = this.closest('form');
                form.action = "main.html";
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
        /*form.action = "main.html";*/
        form.submit();
    }
})

/*유저 자신 리뷰 수정 삭제 버튼*/
const uBtn = document.querySelectorAll(".coment_user_button");


uBtn.forEach(function (btn) {
    btn.addEventListener('click', function (e) {
        e.preventDefault();
        let result = false;
        if (this.getAttribute('data-result') == 'u-modify') {
            message = "리뷰 댓글을 수정하시겠습니까?";
            result = getMessage(message);
            if (result) {
                sessionStorage.setItem('scrollPosition', window.pageYOffset);
//                let content = document.getElementById('re-coment').textContent;
//                document.getElementById('u-coment-write').focus();
                const comentTextElement = this.closest('li').querySelector('.text_coment span');
                const comentText = comentTextElement.textContent.trim();

                // 특정 textarea 요소에 값을 설정
                const textarea =  document.getElementById('u-coment-write');
                textarea.value = comentText;
                textarea.focus();
                
                const form = this.closest('form');
                /*form.action = "search_view.html";*/
                /*form.submit();*/
                
            }

        } else if (this.getAttribute('data-result') == 'u-del') {
            message = "리뷰 댓글을 삭제하시겠습니까?";
            result = getMessage(message);
            if (result) {
                const form = this.closest('form');
                sessionStorage.setItem('scrollPosition', window.pageYOffset);
                /* form.action = "main.html";*/
                form.submit();
            }

        }
    })
})

/*사장 댓글 관련 기능*/

/*답글 클릭 시*/
function pWriteBox() {
    let box = document.createElement("li");
    box.className = 'reply_coment_list';
    box.innerHTML =
        `<a href="#none" class="reply_img">
                                        <img width="16" height="16" src="https://img.icons8.com/small/16/down-right.png" alt="down-right" class="icon_reply" />
                                    </a>
                                    <div class="unit_info_admin">
                                        <em class="screen_out">사장 : </em>
                                        <div class="coment_info_reply">
                                           <textarea class="coment_write" name="" id="p-coment" type="text"></textarea>
                                        
                                            <div class="pro_write">
                                    <button class="select_button" type="reset">다시쓰기</button>
                                    <button class="select_button" id="p-write" type="submit">작성완료</button>
                                </div>
                                        </div>

                                    </div>`;
    let reviewBox = document.querySelector(".review_list");
    reviewBox.appendChild(box);
}

/*답글 작성, 수정, 삭제 메세지*/
const pBtn = document.querySelectorAll(".coment_pd_button");

pBtn.forEach(function (btn) {
    btn.addEventListener('click', function (e) {
        e.preventDefault();
        let result = false;
        
        const replyContainer = btn.closest('.reply_coment_list');
        
        if (this.getAttribute('data-result') == 'p-reply') {
            message = "해당 리뷰에 답글을 작성하시겠습니까?";
            result = getMessage(message);
            if (result) {
                btn.style.display = 'none';
                pWriteBox(replyContainer);
                pWritecoment(replyContainer);
            }
        } else if (this.getAttribute('data-result') == 'p-modify') {
            message = "해당 답글을 수정하시겠습니까?";
            result = getMessage(message);
            if (result) {
                btn.style.display = 'none';
                let tagContent = removeTag(replyContainer);
                modifyReply(replyContainer);
                setTextarea(tagContent, replyContainer);
                pWritecoment(replyContainer);
            }
        } else if (this.getAttribute('data-result') == 'p-del') {
            message = "해당 답글을 삭제하시겠습니까?";
            result = getMessage(message);
            if (result) {
                sessionStorage.setItem('scrollPosition', window.pageYOffset);
                const form = this.closest('form');
                form.submit();
            }
        }
    });
});

/*답글 수정 클릭 시*/
function removeTag(replyContainer) {
    let replyText = replyContainer.querySelector('.text_coment');
    let content = replyText.innerText.trim();
    replyText.remove(); // 클릭한 답글을 삭제
    return content;
}

function modifyReply(replyContainer) {
    let reviewBox = replyContainer.querySelector(".coment_info_reply");
    reviewBox.insertAdjacentHTML('beforeend', `
        <textarea class="coment_write" name="" type="text"></textarea>
        <div class="pro_write">
            <button class="select_button" type="reset">다시쓰기</button>
            <button class="select_button" id="p-write" type="submit">작성완료</button>
        </div>
    `);
}

function setTextarea(data, replyContainer) {
    const textarea = replyContainer.querySelector('.coment_write');
    textarea.value = data;
    textarea.focus();
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
