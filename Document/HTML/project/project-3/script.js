// like버튼 클릭시 활성화
function like_toggle(){
    var target = document.getElementById('like-button');
    if(this.value === 'unlike') {
        target.style.backgroundImage =  "url('./assets/wishlist-icon_full.png')";
        this.value = 'like';
    }
    else {
        target.style.backgroundImage = "url('./assets/wishlist-icon.png')";
        this.value = 'unlike';
    }
    

   
};
