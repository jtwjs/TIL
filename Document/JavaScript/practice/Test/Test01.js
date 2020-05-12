// 앞 숫자 6개 판별 & 뒤 숫자 7개 판별
function check(){
    let n,m;

    // 앞 입력창 검사
    n = document.form1.rrnInput1.value;
    if(n.length !=6 && n.length != 0 ||n.substring(2,4)>12 || n.substring(2,4)<0 ||n.substring(4,6)>31 || n.substring(4,6)<0){
        alert("생년월일 똑바로 적어;; ex:) 950307 ")   
        document.form1.rrnInput1.value = '';
        document.form1.rrnInput1.focus();    

    }
    
    
    

    // 뒤 입력창 검사
    m = document.form1.rrnInput2.value;
    if(m.length !=7 && m.length != 0 || m.substring(0,1) !=  ||{
        alert("뒷번호 똑바로 적어;; 7자리채워  ")   
        document.form1.rrnInput2.value = '';
        document.form1.rrnInput2.focus();    
        
    }

    
    
}