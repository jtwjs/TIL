var res, count, image, frames;

window.onload = function () {
    //변수를 선언한다.
   
    window.onload = function() {
        var count = 0;
        var image = document.getElementById('image');
        var frames = [
                    './assets/0.png', './assets/1.png', './assets/2.png', './assets/3.png', './assets/4.png',
                    './assets/5.png', './assets/6.png', './assets/7.png', './assets/8.png', './assets/9.png',
                    './assets/10.png', './assets/11.png', './assets/12.png', './assets/13.png', './assets/14.png',
                        ];
                   
    };


    function start() {
        res = setInterval(function () {
            image.src = frames[count % frames.length];
            count = count + 1;
        }, 1000 / 20);

    }

    function stop() {
        res = clearInterval(res);
    }

    
}



// $(document).ready(function () {
//     var res;
//     //변수를 선언
//     var count = 0;
//     var image = document.getElementById('image');
//     var frames = [ './assets/0.png', './assets/1.png', './assets/2.png', './assets/3.png', './assets/4.png',
//                     './assets/5.png', './assets/6.png', './assets/7.png', './assets/8.png', './assets/9.png',
//                     './assets/10.png', './assets/11.png', './assets/12.png', './assets/13.png', './assets/14.png',
//                     ];
//                     //타이머 반복 시작

//                     $('#play').on('click',function() {
//                         res = setInterval(function () {
//                             images.src = fraems[count % frames.length];
//                             count = count + 1;
//                         }, 1000 / 20)
//                     });

//                     $('#stop').on('click',function() {
//                         clearInterval(res);
//                     });
// });

    
//                 //타이머의 반복을 시작
//                let play =this.setInterval(function () {
//                     image.src = frames[count % frames.length];
//                     count = count +1;
//                 }, 639 / 20);
//                 $('.stop').click(function () {
//                     clearInterval(play);     
//                 });
//                 $('.play').click(function () {
//                     play.setInterval;
//                 });
                
        
// }


