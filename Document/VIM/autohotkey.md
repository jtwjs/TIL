# autohotkey 프로그램 이용법

1. https://autohotkey.com/ 에서 AutoHotkey 설치 프로그램 다운로드
2. setup 파일을 실행한다. (실행은 별도의 진행막대 없이 진행된다.)
3. 설치가 완료되면, 바탕화면 우클릭 - 새로만들기 - AutoHotkey Script 클릭
4. 생성된 ahk 파일의 이름을 정해준다. 
5. 생성된 ahk 파일 위에서 우클릭 - Edit script 클릭
6. 메모장에서 내용을 모두 지우고 다음 내용 입력
esc ->한영변환 바꿔주는 예시 
```
$Esc::
    if(IME_CHECK("A"))
        Send, {VK15}    ;영문이라면 한영전환 키를 입력해준다.
    return

/*
  IME check 
*/
IME_CHECK(WinTitle) {
  WinGet,hWnd,ID,%WinTitle%
  Return Send_ImeControl(ImmGetDefaultIMEWnd(hWnd),0x005,"")
}
Send_ImeControl(DefaultIMEWnd, wParam, lParam) {
  DetectSave := A_DetectHiddenWindows
  DetectHiddenWindows,ON
   SendMessage 0x283, wParam,lParam,,ahk_id %DefaultIMEWnd%
  if (DetectSave <> A_DetectHiddenWindows)
      DetectHiddenWindows,%DetectSave%
  return ErrorLevel
}
ImmGetDefaultIMEWnd(hWnd) {
  return DllCall("imm32\ImmGetDefaultIMEWnd", Uint,hWnd, Uint)
}
```
7. 저장 후 ahk 파일을  우클릭 - Compile Script 하여 exe파일 생성
8. 만들어진 파일을 관리자 권한으로 실행 
9. 한영 전환이 Ctrl + Space 로 적용되는지 확인한다. (전환이 되지 않으면 재부팅을 한다.)