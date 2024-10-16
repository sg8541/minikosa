


// to get current year
function getYear() {
    var currentDate = new Date();
    var currentYear = currentDate.getFullYear();
    document.querySelector("#displayYear").innerHTML = currentYear;
}

getYear();


// isotope js
$(window).on('load', function () {
    $('.filters_menu li').click(function () {
        $('.filters_menu li').removeClass('active');
        $(this).addClass('active');

        var data = $(this).attr('data-filter');
        $grid.isotope({
            filter: data
        })
    });

    var $grid = $(".grid").isotope({
        itemSelector: ".all",
        percentPosition: false,
        masonry: {
            columnWidth: ".all"
        }
    })
});

// 화면 메인 이미지 전환 js

document.addEventListener('DOMContentLoaded', function () {
    let currentSlide = 0;
    const slides = document.querySelectorAll('#mySlider .slide');
    const dots = document.querySelectorAll('.dot');
    let slideInterval;

    // 첫 번째 슬라이드를 기본으로 활성화
    showSlide(currentSlide);

    // 각 점을 클릭했을 때 해당 슬라이드로 이동
    dots.forEach((dot, index) => {
        dot.addEventListener('click', function () {
            showSlide(index);
            resetSlideInterval(); // 슬라이드 인터벌 재설정
        });
    });

    // 슬라이드를 자동으로 변경하는 함수
    function autoSlide() {
        currentSlide = (currentSlide + 1) % slides.length; // 다음 슬라이드로 이동
        showSlide(currentSlide);
    }

    // 자동 슬라이드 설정 (3초마다 변경)
    function startSlideInterval() {
        slideInterval = setInterval(autoSlide, 2500); // 3000ms = 3초
    }

    // 슬라이드 인터벌 초기화
    function resetSlideInterval() {
        clearInterval(slideInterval); // 기존 인터벌 클리어
        startSlideInterval(); // 새 인터벌 시작
    }

    function showSlide(index) {
        slides.forEach(slide => slide.classList.remove('active'));
        dots.forEach(dot => dot.classList.remove('active'));

        slides[index].classList.add('active');
        dots[index].classList.add('active');

        currentSlide = index;
    }

    startSlideInterval(); // 자동 슬라이드 시작
});


// Select all links that should trigger the scrolling
    const links = document.querySelectorAll('a[data-category]');

    // Add click event listener to each link
    links.forEach(link => {
        link.addEventListener('click', function(event) {
            // Prevent the default anchor behavior
            event.preventDefault();
            
            // Scroll to the food section smoothly
            document.getElementById('foodSection').scrollIntoView({
                behavior: 'smooth' // Enables smooth scrolling
            });
        });
    });

