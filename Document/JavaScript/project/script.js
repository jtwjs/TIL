
//ID 입력창
function idCheck() {
    let id,n;
    let boolean = false;
    id = document.form.id.value;
    n = id.length;
  
    for(let i = 0; i < n; i++){
        if(!(id.charCodeAt(i)>=48 && id.charCodeAt(i)<=57 ||
        id.charCodeAt(i)>=65 && id.charCodeAt(i)<=90 ||
        id.charCodeAt(i)>=97 && id.charCodeAt(i)<=122)){
              boolean= true;
        }
    }

    if(boolean ||( n !=0  &&( n > 10 || n<6 ) )) {
        alert("ID 조건에 맞춰 다시 입력합시다~! \n"+"조건: ("+
        document.form.id.getAttribute('placeholder')+")");
        document.form.id.value = '';
        document.form.id.focus();
    }
}

//PW 입력창

function pwCheck() {
    let pw,n;
    let boolean = false;
    pw = document.form.pw.value;
    n = pw.length;

    for(let i = 0; i < n; i++){
        if(!(pw.charCodeAt(i)>=48 && pw.charCodeAt(i)<=57 ||
        pw.charCodeAt(i)>=65 && pw.charCodeAt(i)<=90 ||
        pw.charCodeAt(i)>=97 && pw.charCodeAt(i)<=122)){
              boolean= true;
        }
    }

    if(boolean ||( n !=0  &&( n > 10 || n<6 ) )) {
        alert("패스워드 조건에 맞춰 다시 입력합시다~! \n"+"조건: ("+
        document.form.pw.getAttribute('placeholder')+")");
        document.form.pw.value = '';
        document.form.pw.focus();
    }
}

// PW 입력값과 PW확인 입력값이 같은지 비교
    function equalCheck() {
        let pw = document.form.pw2.value;
        let n = pw.length;
        if((document.form.pw.value != document.form.pw2.value )&& n !=0){
            alert("입력하신 패스워드와 일치하지않습니다 ㅡㅡㅋ!!");
            document.form.pw2.value = '';
            document.form.pw2.focus();
        }
     
    }


// 주민번호 생년월일 검사(앞 입력창)
function birthCheck(){
    let n = document.form.rrn1.value;

    if(n.length !=6 && n.length != 0 ||n.substring(2,4)>12 ||
     n.substring(2,4)<0 ||n.substring(4,6)>31 || n.substring(4,6)<0){
        alert("생년월일 똑바로 적어;; ex:) 950307 " );   
        document.form.rrn1.value = '';
        document.form.rrn1.focus();    

    }
}


// 주민번호 오류검증
    function rrnCheck() {
        let rrn1 = document.form.rrn1.value;
        let rrn2 = document.form.rrn2.value;
        let str = rrn1 + rrn2;
        let hab = 0;
        let x = 2;
        if(rrn2.length !=7 && rrn2.length !=0){
            alert("생년월일 똑바로 적어;; ex:) 950307 " );   
          document.form.rrn2.value = '';
           document.form.rrn2.focus(); 
        }
        else {
            for(let i=0; i<str.length-1; i++){
                if(x==10){
                    x=2;
                }
                hab+=str.substring(i,i+1)*x;
                x++;
            }
            let result = 11-hab%11;
            if(result == 10) result =0;
             else if(result == 11) result =1;
            if( (result != str.substring(str.length-1,str.length )&& rrn2.length !=0)){
                alert("(주민번호 오류) 다시 입력해주세요~ ");
                document.form.rrn1.value='';
                document.form.rrn2.value='';
                document.form.rrn1.focus();
            }
        }
    }

    // 핸드폰번호 자릿수 판별
    function telCheck(tel) {
        let tel2 = tel.value;
        if(tel2.length != 4 &&  tel2.length !=0){
            alert("번호 다시 입력해주세요~ ");
            tel.value = '';
            tel.focus();  
        }
        else {
            for(let i=0; i<tel2.length; i++){
                if(!(tel2.charCodeAt(i)>=48 && id.charCodeAt(i)<=57)){
                    alert("숫자로만 입력해주세요~~ ");
                    tel.value = '';
                   tel.focus();  
                }
            }
        }
    }

    // 이메일
    function mailCheck() {
        let mail = document.form.emailId.value;
        for(let i=0; i<mail.length; i++){
            if(!(
            (mail.charCodeAt(i)>=48 && mail.charCodeAt(i)<=57)||
            (mail.charCodeAt(i)>=65 && mail.charCodeAt(i)<=90)||
            (mail.charCodeAt(i)>=97 && mail.charCodeAt(i)<=122)
            )
            &&mail.length != 0){
                alert("메일ID 다시 입력해주세요~~ ");
                document.form.emailId.value = '';
                document.form.emailId.focus();
            }
    }
}

    function print() {
        //체크박스 체크된 것들 다시 찾아보자
        let msg;
        if (document.form.hobby.checked)
        msg +=document.form.hobby.value + " ";
         

   alert(msg);


      let print ="ID: "+document.form.id.value+
      "\n Pw: "+document.form.pw.value+
      "\n 주민번호: "+ document.form.rrn1.value+"-"+document.form.rrn2.value+
      "\n 성별: " +document.form.gender.value+
      "\n 전화번호: "+document.form.tel1.value+"-"+document.form.tel2.value+"-"+document.form.tel3.value+
      "\n E-mail: "+document.form.emailId.value+"@"+document.form.mailAddr.value+
      "\n 취미: "+msg+
      "\n 자기소개: "+document.form.self.value;

      alert("---------------------------------\n"
      +print+"\n-----------------------------------------------------\n");
        
    }