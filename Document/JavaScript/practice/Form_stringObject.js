
    // [form1] 대문자 변환
    function trans(trans_id) 
    {
        let txt;
        txt = trans_id.value;
        txt = txt.toUpperCase();
        trans_id.value = txt;

    }
    // function trans()
// {
//     let txt;
//     txt = document.form1.id.value;
//     txt = txt.toUpperCase();
//     document.form1.id.value = txt;
// }

// function trans(trans_form)  [매개값을 받아 폼 양식으로 접근]
// {&nbsp;&nbsp;
//     let txt;
//     txt = trans_form.id.value;
//     txt = txt.toUpperCase();
//     trans_id.value = txt;
// }


    // [form2] 이메일 양식 Check
    function check2() {
        let email, id, n ;
        email = document.form2.email.value;
        n = email.indexOf("@"); //@ 값 위치 
        alert(n);
        if( n > 0 ) {
            document.form2.id.value = email.substr(0,n);
        }  else {
            alert("정확한 이메일 주소를 입력하세요!");
        }
    }

    // [form3] 주민번호 성별판독
    function check3(app) {
        switch(app.value.substring(0,1)) {
            //substr (위치,갯수)
            //substring(위치.위치)
            case "1" : document.form3.sex[0].checked=true; break;
            case "2" : document.form3.sex[1].checked=true; break;
            case "3" : document.form3.sex[0].checked=true; break;
            case "4" : document.form3.sex[1].checked=true; break;
        }
    }

    // [form4] submit 확인창 확인 & 취소 
    function check4() {
        if(confirm("submit2로 이동합니다.")) {
            //document.form4.submit();
            return true;
        }else {
            
            return false; // defulat 이벤트 수행취소
        }

    }

    //[form5] button 확인창 확인 & 취소 
    function check5() {
        if(confirm("submit2로 이동합니다.")) {
            document.form4.submit();
            // return true;
        }else {
            
            return false; // defulat 이벤트 수행취소
                        //  defulat 이벤트 수행취소하는 또다른 방법
                        // event.preventDefault();
        }

    }

    // [form6] password 입력란 password확인 입력란 비교 
    function check6() {
        if(document.form6.pw.value != document.form6.pw1.value) {
            alert("password가 일치하지 않습니다.");
        }
    }

    // [form7] 선택한 option의 index에 따라 값 출력
    function select() {
        alert(document.form7.fruit.options[
            document.form7.fruit.selectedIndex].value + 
            "를 선택하셨습니다.");
    }

    // [form8] 선택1창 선택값에 따라 선택2창 목록바뀜
    let seoul = new Array("강남구", "서초구", "종로구", "중구", "노원구");
    let kyunggi = new Array("수원시", "성남시", "고양시", "안성시", "용인시");
    function select_city(form8) {
        if(form8.city.selectedIndex == 1) {
            for(let i=0;i<5;i++) {
                form8.gu.options[i].text = seoul[i];
            }
        }
        else if(form8.city.selectedIndex ==2 ){
            for(let i=0;i<5;i++) {
                form8.gu.options[i].text = kyunggi[i];
            }
        }
    }

    // [form9] checkbox 선택값 출력
    function check9(form) {
        let prt = "";
        for(let i=0; i<form9.hobby.length;i++){
            if(form9.hobby[i].checked == true) {
                prt = prt + form9.hobby[i].value + "\n";
            }
        }
        alert(prt);
    }