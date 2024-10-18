<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
    <meta charset="UTF-8">
    <title>[[${content.storeName}]]</title>

    <!--타이틀 옆 이미지 아이콘-->
    <link href="//t1.daumcdn.net/localimg/localimages/07/common/kakaomap_favicon.ico" rel="shortcut icon">
    <link rel="stylesheet" href="/css/content.css">
    <script type="text/javascript" src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=913010ecf61096ff085a9717807d98df&libraries=services"></script>
</head>

<body>

<header class="header">
    <div class="container-inner">
        <div class="logo">
            <a href="/home"><img src="/images/main_logo.png" alt="Main Logo"></a>
        </div>
        <nav class="nav" id="mainNav">
            <form method="get" action="/search" class="search-form d-inline-block">

                <div class="d-flex">
                    <input type="text" class="form-control" placeholder="Search..." data-listener-added_c71bfbd9="true">
                    <button type="submit" class="btn btn-search">
                        <img width="32" height="32" src="/images/icon_search2.png" alt="검색하기" /><span class="icon-search"></span></button>
                </div>
            </form>
            <a href="/home">홈</a>
            <a href="/intro">소개</a>
            <a href="/suggestion">문의</a>
            <!--<a href="search.html">-->


            <!--</a>-->
            <!-- 드롭다운 메뉴 추가 -->
            <div class="dropdown">
                <button id="userMenuButton">▼</button>

                <div class="dropdown-content" id="userMenu">
                    <!-- 로그인 전 메뉴 -->
                    <a href="/login" id="loginLink">로그인</a>
                    <!-- 로그인 후 메뉴 (숨김 상태) -->
                    <a href="myinfo.html" id="profileLink" style="display: none;">내 정보 페이지</a>
                    <a href="home.html" id="logoutLink" style="display: none;">로그아웃</a>
                </div>
            </div>

        </nav>
    </div>
</header>
<div class="wap">
    <div id="" class="container">
        <div class="content_out_line">
            <div class="content_inner">
                <div class="content_top_line">
                    <div class="top_image_line">
                            <span class="image_present" th:style="'background-image: url(' + ${content.storePhoto} + ')'">
                            </span>
                        <span class="frame_g">
                            </span>

                        <!--가게 title(브랜드, 상호명, 평점 등)-->
                        <div class="place_out_line">
                            <!--관리자만 보이는 버튼-->
                            <div class="btn_box">
                                <th:block th:if="${session.loggedInUser.roleId} == 2">
                                    <form>
                                        <input type="hidden" name="storeId" value="${content.storeId}">
                                        <input type="hidden" name="storeName" value="${content.storeName}">
                                        <input type="hidden" name="postCode" value="${content.postCode}">
                                        <input type="hidden" name="roadAddress" value="${content.roadAddress}">
                                        <input type="hidden" name="detailAddress" value="${content.detailAddress}">
                                        <input type="hidden" name="extraAddress" value="${content.extraAddress}">
                                        <input type="hidden" name="storeDescription" value="${content.storeDescription}">
                                        <input type="hidden" name="webSiteInfo" value="${content.webSiteInfo}">
                                        <input type="hidden" name="contactNumber" value="${content.contactNumber}">
                                        <button type="submit" class="admin_button" data-result="modify" th:data-action="|/store/${content.storeId}/locate|">수정</button>
                                        <button type="submit" class="admin_button" data-result="del" th:data-action="|/store/${content.storeId}/close|">삭제</button>
                                    </form>
                                </th:block>
                            </div>
                            <div class="place_inner">
                                <h2 class="restaurant_title" th:text="${content.storeName}"></h2>
                                <div class="evalution_box">
                                    <img width="48" height="48" src="https://img.icons8.com/color/48/filled-star--v1.png" alt="filled-star--v1" class="icon_star" />
                                    <span class="evalution_link">평점 : </span>
                                    <span class="evalution_link" th:text="${content.ratingAvg}">###5</span>
                                    <span class="bar"></span>
                                    <span class="evalution_link">리뷰 : </span>
                                    <a href="#none" class="evalution_link" th:text="${content.countReview}">###1</a>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
                <!--가게 상세 정보(info)-->
                <div class="place_info_box">
                    <h3 class="detail_info_title">상세정보</h3>
                    <div class="place_info_detail">
                        <h4 class="info_title_detail">
                            <span class="place_info_icon address_icon">위치</span>
                            <img src="/images/ico_location.png" class="address_icon">
                        </h4>
                        <div class="place_location">
                                <span class="address_text">
                                    [[${content.roadAddress}]] [[${content.detailAddress}]] (우) [[${content.postCode}]]
                                </span>
                            <span class="address_num_text">
                                    상세주소
                                    <span class="bar"></span>
                                    [[${content.extraAddress}]]
                                </span>
                        </div>
                    </div>
                    <div class="place_info_detail place_homepage">
                        <h4 class="info_title_detail">
                            <span class="place_info_icon">홈페이지</span>
                            <img src="/images/icon-internet.png" width="14px" height="14px;" class="homepage_icon">
                        </h4>
                        <div class="place_location">
                            <div class="homepage_text">
                                <a href="#" class="link_homepage">[[${content.webSiteInfo}]]</a>
                            </div>
                        </div>
                    </div>
                    <div class="place_info_detail place_phone">
                        <h4 class="info_title_detail">
                            <span class="place_info_icon">전화번호</span>
                            <img src="/images/icon_phone.png" class="phone_icon">
                        </h4>
                        <div class="place_location">
                                <span class="phone_text">

                                    <span class="phone_num_text">[[${content.contactNumber}]]</span>
                                    <span></span>
                                </span>
                        </div>
                    </div>
                    <div class="place_info_detail">
                        <h4 class="info_title_detail">
                            <span class="place_info_icon">소개</span>
                            <img src="/images/icon-desc.png" class="icon_desc">
                        </h4>
                        <div class="place_location">
                                <span class="title_info_text">
                                    [[${content.storeDescription}]]
                                </span>
                        </div>
                    </div>
                </div>
            </div>

            <!--메뉴 박스 시작-->
            <div class="menu_info">
                <div class="menu_info_title_box">
                    <h3 class="detail_info_title">메뉴</h3>
                </div>
                <div class="menu_image_wrap">
                    <div class="menu_image_present">
                    </div>
                    <!--메뉴 목록 : 추후 기능 확장 때 고려하기-->
                    <strong class="screen_out">메뉴 목록</strong>
                    <ul class="menu_list">
                        <th:block th:each="menu : ${menu}">
                            <li>
                                <a href="#none" class="link_photo">
                                        <span class="inner_photo">
                                            <img src="/images/%EB%B3%B4%EB%85%B8%EB%B3%B4%EB%85%B8.png" class="img_thumb" width="106" height="90">
                                        </span>
                                </a>
                                <div class="menu_title_box">
                                    <em class="screen_out">명 : </em>
                                    <span class="menu_text" th:text="${menu.menuName}"></span>
                                    <em class="screen_out">가격 : </em>
                                    <span class="price_menu" th:text="${menu.price}"></span>
                                </div>
                            </li>
                        </th:block>
                    </ul>
                </div>
            </div>
            <!--댓글 평가 및 작성-->
            <div class="rate_container">
                <form method="post" th:action="|/store/${content.storeId}/review|" id="userWrite">
                    <input type="hidden" name="memberId" th:value="${session.loggedInUser.memberId}">
                    <input type="hidden" name="storeId" th:value="${content.storeId}">
                    <input type="hidden" name="reviewId" value=0>
                    <div class="rate_box">
                        <div class="rate_intro">
                            <p class="desc_rate_username" th:text="${session.loggedInUser.nickname}">###닉네임</p>
                            <p class="desc_rate">님! 이 장소의 후기를 남겨주세요</p>
                            <div class="user_rate">
                                <div class="grade_star_box">
                                        <span class="ico_star_rate ">
                                            <span class="ico_star_rate inner_star"></span>
                                        </span>
                                </div>
                            </div>
                            <div class="star-rating space-x-4 mx-auto" >
                                <input type="radio" id="5-stars" name="rating" value="5" v-model="ratings" checked/>
                                <label for="5-stars" class="star pr-4">★</label>
                                <input type="radio" id="4-stars" name="rating" value="4" v-model="ratings" checked/>
                                <label for="4-stars" class="star">★</label>
                                <input type="radio" id="3-stars" name="rating" value="3" v-model="ratings" checked/>
                                <label for="3-stars" class="star">★</label>
                                <input type="radio" id="2-stars" name="rating" value="2" v-model="ratings" checked/>
                                <label for="2-stars" class="star">★</label>
                                <input type="radio" id="1-star" name="rating" value="1" v-model="ratings" checked/>
                                <label for="1-star" class="star">★</label>
                            </div>
                        </div>
                        <!--댓글 작성 및 버튼 부분-->
                        <div class="comment_write_box">
                            <textarea class="comment_write" name="reviewText" id="u-comment-write"></textarea>
                            <div class="button_box">
                                <button class="select_button" type="reset">다시쓰기</button>
                                <button class="select_button" id="u-write" type="submit">작성완료</button>
                            </div>
                        </div>
                    </div>
                </form>

            </div>
            <!--유저 댓글 시작-->
            <div class="comments_box">
                <strong class="total_comment">전체
                    <span class="color_b" th:text="${content.countReview}">###20</span></strong>
                <div class="user_grade_box">
                    <strong class="screen_out">후기 요약</strong>
                    <div class="grade_star">
                        <img width="48" height="48" src="https://img.icons8.com/color/48/filled-star--v1.png" alt="filled-star--v1" class="icon_star" />
                        <em class="num_rate" th:text="${content.ratingAvg}">5
                            <span class="text_score">점</span>
                        </em>
                        <span class="ico_star_rate ">
                                <span class="ico_star_rate inner_star" style="width: 100%"></span>
                            </span>
                    </div>
                </div>

                <strong class="screen_out">추천 포인트</strong>
                <!--리뷰 댓글 시작-->
                <form method="post" id="reviewList" th:action="|/store/${content.storeId}/review/${session.loggedInUser.memberId}|">
                    <input type="hidden" name="storeId" th:value="${content.storeId}" />
                    <input type="hidden" name="reviewId" value="" />
                    <input type="hidden" name="replyId" value="" />
                    <input type="hidden" name="ownerId" th:value="${content.ownerId}" />
                    <div class="review_box">
                        <strong class="screen_out">후기 리스트</strong>
                        <th:block th:each="review : ${review}">
                            <ul class="review_list">
                                <li>
                                    <div class="unit_info">
                                        <em class="screen_out">작성자 : </em>
                                        <a href="#none" class="link_user">
                                            <div class="inner_user">
                                                <span class="text_username" th:text="${review.nickname}">###닉네임</span>
                                            </div>
                                        </a>
                                        <span class="bar"></span>
                                        <span class="text_item">별점 : </span>
                                        <span class="text_desc" th:text="${review.rating}">###5</span>
                                        <span class="bar"></span>
                                        <span class="text_item">작성일 : </span>
                                        <span class="time_write" th:text="${#dates.format(review.createdAt, 'yyyy.MM.dd.')}"></span>
                                    </div>
                                    <div class="photo_group">
                                        <ul class="list_photo">
                                        </ul>
                                    </div>
                                    <div class="comment_info">
                                        <p class="text_comment">
                                            <span th:text="${review.reviewText}">### 맛있는 보노 보노의 하트 아주 조았어요!</span>
                                        </p>
                                    </div>

                                    <div class="wrap_util">
                                        <!--나중에 타임리프에서 답글이 하나라도 달려있으면 답글 버튼이 안보이도록 수정하기-->
                                        <th:block th:if="${content.ownerId} == ${session.loggedInUser.memberId}">
                                            <button type="submit" class="comment_pd_button" data-result="p-reply" th:data-review-id="${review.reviewId}">답글</button>
                                        </th:block>
                                        <th:block th:if="${review.memberId} == ${session.loggedInUser.memberId}">
                                            <button type="submit" class="comment_user_button" data-result="u-modify" th:data-review-id="${review.reviewId}">수정</button>
                                            <button type="submit" class="comment_user_button" data-result="u-del" th:data-review-id="${review.reviewId}" >삭제</button>
                                        </th:block>
                                    </div>
                                </li>
                                <li class="reply_comment_list" th:if="${review.replyId != 0}">
                                    <a href="#none" class="reply_img">
                                        <img width="16" height="16" src="https://img.icons8.com/small/16/down-right.png" alt="down-right" class="icon_reply" />
                                    </a>
                                    <div class="unit_info_admin">
                                        <em class="screen_out">사장 : </em>
                                        <div class="comment_info_reply">
                                            <p class="text_comment" id="reply">

                                                <span id="re-comment" th:text="${review.replyText}">### 맛있게 드셔주셔서 감사합니다!</span>

                                            </p>
                                        </div>
                                        <div class="wrap_util">
                                            <th:block th:if="${content.ownerId} == ${session.loggedInUser.memberId}">
                                                <button type="button" class="comment_pd_button" id="p-modify" data-result="p-modify"th:data-review-id="${review.reviewId}" th:data-reply-id="${review.replyId}" >수정</button>
                                                <button type="submit" class="comment_pd_button" data-result="p-del" th:data-reply-id="${review.replyId}">삭제</button>
                                            </th:block>
                                        </div>
                                    </div>

                                </li>
                            </ul>
                        </th:block>
                    </div>
                </form>
                <a href="#none" class="link_more">
                    <span class="txt_more">후기 더보기</span>
                    <span class="ico_comm ico_more"></span>
                </a>
            </div>
        </div>
        <!--지도 시작-->
        <div class="map_container">
            <h3 class="detail_info_title">찾아가는 길</h3>
            <div class="map_box">
                <h4 class="screen_out">지도 보기</h4>
                <div class="view_map" style="overflow: hidden; background: url(/images/256x256.png)">
                    <div style="position: absolute; left: 0px; top: 0px; width: 100%;">
                        <!--cursor: url(/images/)-->
                        <!--style="width:500px;height:400px;"-->
                        <div id="map" style="width:100%;height:350px;"></div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<footer>
    <div class="footer-container">
        <!-- 회사 소개 -->
        <div class="footer-section">
            <h4>프로젝트 소개</h4>
            <p>먹코살코은 최고의 맛집 제공하기 위해 최선을 다하고 있습니다.</p>
        </div>
        <!-- 빠른 링크 -->
        <div class="footer-section">
            <h4>빠른 링크</h4>
            <ul>
                <li><a href="#home">홈</a></li>
                <li><a href="#about">소개</a></li>
                <li><a href="#services">서비스</a></li>
                <li><a href="#contact">문의</a></li>
            </ul>
        </div>
        <!-- 연락처 -->
        <div class="footer-section">
            <h4>연락처</h4>
            <ul>
                <li>전화: 02-112-7777</li>
                <li>이메일: admin@taste_police.com</li>
                <li>주소: 서울특별시 송파구 중대로 135, 서관 12층</li>
            </ul>
        </div>
        <!-- 소셜 미디어 -->
        <div class="footer-section">
            <h4>소셜 미디어</h4>
            <div class="social-icons">
                <a href="https://www.facebook.com/yourprofile" aria-label="페이스북">
                    <img src="/images/facebook_icon.png" alt="Facebook">
                </a>
                <a href="https://www.twitter.com/yourprofile" aria-label="트위터">
                    <img src="/images/twitter_icon.png" alt="Twitter">
                </a>
                <a href="https://www.instagram.com/yourprofile" aria-label="인스타그램">
                    <img src="/images/instagram_icon.png" alt="Instagram">
                </a>
            </div>
        </div>
    </div>
    <!-- 푸터 하단 정보 -->
    <div class="footer-bottom">
        &copy; 2024 먹코살코. All rights reserved.
    </div>
</footer>
<script th:inline="javascript">
    var storeLocation = "|[(${content.roadAddress})] [(${content.detailAddress})]|";
    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
        mapOption = {
            center: new kakao.maps.LatLng(37.564214, 126.977943), // 지도의 중심좌표
            level: 3
        };
    var map = new kakao.maps.Map(mapContainer, mapOption);
    var geocoder = new kakao.maps.services.Geocoder();
    geocoder.addressSearch(storeLocation, function(result, status) {
         if (status === kakao.maps.services.Status.OK) {
            var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
            var marker = new kakao.maps.Marker({
                map: map,
                position: coords
            });
            var infowindow = new kakao.maps.InfoWindow({
                content: '<div style="width:150px;text-align:center;padding:6px 0;">'+"[(${content.storeName})]"+'</div>'
            });
            infowindow.open(map, marker);
            map.setCenter(coords);
        }
    });
</script>
<script src="/js/content.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>
