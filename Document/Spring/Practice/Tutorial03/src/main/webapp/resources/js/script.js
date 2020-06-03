// like버튼 클릭시 활성화
function like_toggle(){
    var target = document.getElementById('like-button');
    if(this.value === 'unlike') {
        target.style.backgroundImage =  "url('../assets/wishlist-icon_full.png')";
        this.value = 'like';
    }
    else {
        target.style.backgroundImage = "url('../assets/wishlist-icon.png')";
        this.value = 'unlike';
    }
       
};

function check_toggle(){
    var target = document.getElementById('check-box');
    if(this.value === 'uncheck'){
        target.style.backgroundImage = "url(../assets/checkbox-icon.png)";
        this.value = 'check';
    }
    else {
        target.style.backgroundImage = "url()";
        this.value = 'uncheck';
        }
}

    const openButton = document.getElementById("open");
    const modal = document.querySelector(".signUp-modal");
    const closeButton = modal.querySelector(".close-icon");
    //동작함수
    const openModal = () => {
        modal.classList.remove("hidden");
    }
    const closeModal = () => {
        modal.classList.add("hidden");
    }
    //클릭 이벤트
    openButton.addEventListener("click", openModal);
    closeButton.addEventListener("click", closeModal);

