/*
common.js에 관련 설명.

리스트 & 설명

swapImage(img)
- 이미지 바꾸기
: img - 경로가 포함된 이미지.

checkSize(data , maxSize, allowNull, fieldName, )
- 입력 필드에 들어온 데이타의 크기를 계산하는 Function
: data - 입력 필드에 들어온 데이타
: maxSize - 입력필드의 최대크기
: allowNull - null check여부 "Y"=null체크함, "N"=null체크안함.
: fieldName - alert메세지를 뿌려줄것인지 구분 메세지를 넣어주면 해당메세지와 함께 alert창이 뜨고
            - 메세지를 넣어주지않으면 alert창이 뜨지 않는다.

checkTextArea(data , maxSize, allowNull, fieldName)
- textarea 입력 필드에 들어온 데이타의 크기를 계산과 특수문자를 체크하는 Function
: data - textarea 입력 필드에 들어온 데이타
: maxSize - 입력필드의 최대크기
: allowNull - null check여부 "Y"=null체크함, "N"=null체크안함.
: fieldName - alert메세지를 뿌려줄것인지 구분 메세지를 넣어주면 해당메세지와 함께 alert창이 뜨고
            - 메세지를 넣어주지않으면 alert창이 뜨지 않는다.

checkNumber(num , fieldName)
- textarea 입력 필드에 들어온 데이타가 숫자면 true, 숫자가 아니라면 false를 리턴한다.
: num - 체크하고자하는 필드값
: fieldName - alert메세지를 뿌려줄것인지 구분 메세지를 넣어주면 해당메세지와 함께 alert창이 뜨고
            - 메세지를 넣어주지않으면 alert창이 뜨지 않는다.

checkDay(vDay, allowNull, fieldName)
- 일 체크 function
: vDay - 체크하고자 하는 일
: allowNull - null check여부 "Y"=null체크함, "N"=null체크안함.
: fieldName - alert메세지를 뿌려줄것인지 구분 메세지를 넣어주면 해당메세지와 함께 alert창이 뜨고
            - 메세지를 넣어주지않으면 alert창이 뜨지 않는다.

checkMonth(vMonth, allowNull, fieldName)
- 월 체크 function
: vMonth - 체크하고자 하는 월
: allowNull - null check여부 "Y"=null체크함, "N"=null체크안함.
: fieldName - alert메세지를 뿌려줄것인지 구분 메세지를 넣어주면 해당메세지와 함께 alert창이 뜨고
            - 메세지를 넣어주지않으면 alert창이 뜨지 않는다.

checkYear(year, allowNull, fieldName)
- 년  체크 function
: year - 체크하고자 하는 년도
: allowNull - null check여부 "Y"=null체크함, "N"=null체크안함.
: fieldName - alert메세지를 뿌려줄것인지 구분 메세지를 넣어주면 해당메세지와 함께 alert창이 뜨고
            - 메세지를 넣어주지않으면 alert창이 뜨지 않는다.

checkCalendar(year, month, day, allowNull, fieldName)
- 날짜 체크하는 Function(년월일을 한꺼번에 체크할때 사용)
: year - 체크하고자 하는 년도
: month - 체크하고자 하는 월
: day - 체크하고자 하는 일
: allowNull - null check여부 "Y"=null체크함, "N"=null체크안함.
: fieldName - alert메세지를 뿌려줄것인지 구분 메세지를 넣어주면 해당메세지와 함께 alert창이 뜨고
            - 메세지를 넣어주지않으면 alert창이 뜨지 않는다.

closeWindow(childwin)
- 자신의 자식윈도우 닫기
: childwin -

checkEmpty( arg, fieldName )
- 공백체크
: arg - 공백체크하려는 스트링
: fieldName - alert메세지를 뿌려줄것인지 구분 메세지를 넣어주면 해당메세지와 함께 alert창이 뜨고
            - 메세지를 넣어주지않으면 alert창이 뜨지 않는다.

checkEmpty2( obj, alert메시지 )
- 공백체크
: obj- 공백체크하려는 스트링
: alert메시지- 
: 공백이면 focus;

trim( arg )
- 문자열 앞뒤에있는 공백없에기
: arg - trim하려는 스트링.

checkSpecialChar( arg, allowNull, fieldName )
- 특수문자 체크
: arg - 체크하고자 하는 스트링
: allowNull - null check여부 "Y"=null체크함, "N"=null체크안함.
: fieldName - alert메세지를 뿌려줄것인지 구분 메세지를 넣어주면 해당메세지와 함께 alert창이 뜨고
            - 메세지를 넣어주지않으면 alert창이 뜨지 않는다.

jusoToLocalNo(xx,yy)
- 전화번호에서 지역번호 자동입력
: xx - xx는 시도코드
: yy - yy는 찍힐 객체

checkJMBeonHo( num1, num2, allowNull)
- 주민번호 체크하는 Function
: num1 - 주민번호 앞6자리
: num1 - 주민번호 뒤7자리
: allowNull - null check여부 "Y"=null체크함, "N"=null체크안함.

checkEnterCheckBox(xx)
- 체크박스에서 Enter값이 들어오면 체크상태를 반전시켜줌
: xx - 체크박스 객체

chkEnter()
- Enter를 체크하여 Enter 이면 true 아니면 false를 반환

moveNext(varControl, varNext)
- 입력창 자동이동 스크립트
: varControl - 입력이 이루어진 해당객체
: varNext - 다음으로 이동할객체

checkTab(xx)
- tab키를 눌렀을때 원하는곳에 focus를 가게 한다
: xx - 이동하길 원하는 객체

setStatusToStatusBar(vWorkGubun)
- 메세지를 상태창에 뿌리자
: vWorkGubun - 작업구분

setStatusInit()
- 메세지를 상태창에서 삭제하자.

toEnterValue
- 미작성

mergyPhoneNo(tel1,tel2,tel3,fieldName)
-3개의 지역번호,국번,번호를 ex)02-2334-3455 형태로 합침
 tel1는 지역번호
 tel2는 국번
 tel3는 번호
 fieldName은 error message를 보낼때의 객체명

getNonSpaceNumber(str)
-string을 입력받아 공백제거하고 순수 숫자열만 return
 문자일경우 false return
 str은 string


splitPhoneNo(telAll,tel1,tel2,tel3)
-02-2334-3455 형태로 합쳐저 있는 값을 3개의 지역번호,국번,번호로 분리
 tel1는 지역번호가 있는 textbox객체이름
 tel2는 국번번호가 있는 textbox객체이름
 tel3는 번호번호가 있는 textbox객체이름



phoneNoWithLocal(sido,telAll,tel1,tel2,tel3)
-02-2334-3455 형태로 합쳐저 있는 값을 3개의 지역번호,국번,번호로 분리
 sido는 시도코드
 telAll은 전체전화번호
 tel1는 지역번호가 있는 textbox객체이름
 tel2는 국번번호가 있는 textbox객체이름
 tel3는 번호번호가 있는 textbox객체이름


checkCalendarFromTo(year1, month1, day1, year2, month2, day2, allowNull, fieldName1,fieldName2)
- 기간을 체크
: year1  -시작기간의 년
: month1 -시작기간의 월
: day1   -시작기간의 일

: year2  -끝기간의 년
: month2 -끝기간의 월
: day2   -끝기간의 일

: allowNull  - null check여부 "Y"=null체크함, "N"=null체크안함.
: fieldName  - alert메세지를 뿌려줄것인지 구분 메세지를 넣어주면 해당메세지와 함께 alert창이 뜨고
             - 메세지를 넣어주지않으면 alert창이 뜨지 않는다.

: Return 값 - 시작기간과 끝기간이 빈값이 경우 true 반환
              시작기간과 끝기간이 들어가고 (시작기간 <= 끝기간) 이 경우 true 반환
              그외의 경우  false 반환

readingZeroToSpace(vOneObject, vTwoObject)
-변수의 0값을 공백으로 바꾼다. 바꾸길 원하는 대상은 숫자의 형태여야한다.
숫자,문자 체크안함.
00101 -> 101 으로 바뀜
vOneObject는 바뀌기전 객체(form.xx)
vTwoObject는 바뀐후에 값이들어가기를 원하는 객체(form.yy)

readingSpaceToZero(vOneObject, vTwoObject)
-변수의 공백을 0으로 바꾼다. 바꾸길 원하는 대상은 숫자의 형태여야한다.
숫자,문자 체크안함.
"  101" -> 00101 으로 바뀜
vOneObject는 바뀌기전 객체(form.xx)
vTwoObject는 바뀐후에 값이들어가기를 원하는 객체(form.yy)


onlyNumber(str,allownNull,fieldName)
-str의 값에 숫자와 소수점과 컴마와 부호식별값만 허용한다.
 allowNull  - null check여부 "Y"=null체크함, "N"=null체크안함.
 fieldName은 error message를 보낼때의 필드명

common_calendar(formname,obj)
 formnam - form name
 obj     - object name
 

///////////////////////////////////////////// end 설명 list /////////////////////////////////////////////
*/


/*
변수의 0값을 공백으로 바꾼다. 바꾸길 원하는 대상은 숫자의 형태여야한다.
숫자,문자 체크안함.
00101 -> 101 으로 바뀜
vOneObject는 바뀌기전 객체(form.xx)
vTwoObject는 바뀐후에 값이들어가기를 원하는 객체(form.yy)
*/
/****************************************************************************/
/*                                                                          */
/*   1. js_commaErase       :   Input Box에 들어 있는 값에 대하여 comma(,)  */
/*                              를 제거한 값을 return(ex:1,234->1234)       */
/*          js_commaErase("1")                                              */
/*          --> 1: Input Box object                                         */
/*   2. js_removeSpace      :   특정 문자열 중에서 스페이스를 제거하여      */
/*                              return                                      */
/*          js_removeSpace("1")                                             */
/*          --> 1: 문자열(String)                                           */
/*   3. js_checkDigits      :   Input Box에 들어 있는 값에 대하여 숫자이외의*/
/*                              문자가 있으면 에러메세지 보여주며, 이상없는 */
/*                              경우에는 comma(,)를 추가하여 return         */
/*                              (금액입력 필드의 onblur event에 사용할것)   */
/*          js_checkDigits("1")                                             */
/*          --> 1: Input Box object                                         */
/*   4. js_convert          :   특정 문자열 중에서 comma(,)를 제거하여      */
/*                              return(ex:1,234->1234)                      */
/*          js_convert("1")                                                 */
/*          --> 1: 문자열(String)                                           */
/*   5. js_validateCheck    :   숫자값에서 정수부분만 추출하여 15 자리수가  */
/*                              넘어가면 'false', 아니면 'true' return      */
/*          js_validateCheck("1")                                           */
/*          --> 1: Input Box object                                         */
/*   6. js_makeComma        :   숫자에 comma(,)를 부여한 값을 return        */
/*                              (ex:-12345.78->-12,345.78)                  */
/*          js_makeComma("1")                                               */
/*          --> 1: 문자열(String)                                           */
/*   7. js_yearCheck("1")   :   Input Box에 들어 있는 값에 대하여 2자리로   */
/*                              입력했는지,숫자이외의 문자가 있는지 체크하여*/
/*                              에러메세지 보여준다                         */
/*                              (고지번호,구매결의번호등의 년도 입력 필드의 */
/*                              onblur event에 사용할것)                    */
/*          js_yearCheck("1")                                               */
/*          --> 1: Input Box object                                         */
/*   8. js_numberCheck      :   문자열에 숫자만 있으면 true, 문자가 있으면  */
/*                              false return                                */
/*          js_numberCheck("1")                                             */
/*          --> 1: 문자열(String)                                           */
/*   9. js_tab_order        :   입력필드에 입력이 끝나면 자동으로 focus이동 */
/*                              (입력필드의 onkeyup event에 사용할것)       */
/*          js_tab_order("1","2","3")                                       */
/*          --> 1: Input Box object                                         */
/*              2: focus를 이동시킬 object name                             */
/*              3: focus 이동위해 1번 object에 입력되어야 할 자리수         */
/*  10. js_isFieldBlank     :   입력필드에 값이 입력되었는지 체크하여 입력  */
/*                              되지 않았으면 true,입력되었으면 false return*/
/*          js_isFieldBlank("1")                                            */
/*          --> 1: Input Box object                                         */
/*  11. js_isBlank          :   문자열에 값이 없거나 blank만 있으면 true,   */
/*                              그렇지 않으면 false return                  */
/*          js_isFieldBlank("1")                                            */
/*          --> 1: 문자열(String)                                           */
/*  12. js_removeChar       :   문자열중에서 특정 문자만 제거한 값 return   */
/*          js_removeChar("1","2")                                          */
/*          --> 1: 문자열(String)                                           */
/*              2: 제거할 문자                                              */
/*  13. js_removeChar2      :   InputBox에 입력된 값에서 '-'값 제거하여     */
/*                              return                                      */
/*                              (년월일 입력필드의 onfocus event에 사용할것)*/
/*          js_removeChar2("1")                                         */
/*          --> 1: Input Box object                                         */
/*  14. js_dateEditMask     :   YYYYMMDD 또는 YYYYMM형태의 문자열에 대하여  */
/*                              YYYY/MM/DD(YYYY.MM.DD) 또는 YYYY/MM(YYYY.MM)*/
/*                              의 형태로 변환하여 return                   */
/*          js_dateEditMask("1","2","3")                                    */
/*          --> 1: 문자열(String)                                           */
/*              2: 추가할 문자('/' 또는 '.')                                */
/*              3: flag('1': YYYYMMDD형태, '2':YYYYMM형태)                  */
/*  15. js_dateCheck        :   InputBox에 입력된 날짜가 유효한지 체크하여  */
/*                              유효하면 YYYY/MM/DD의 형태로 변환하여 return*/
/*                              하고, 유효하지 않으면 에러메세지 보여줌     */
/*                              (년월일 입력필드의 onblur event에 사용할것) */
/*          js_dateCheck("1")                                               */
/*          --> 1: Input Box object                                         */
/*  16. js_FieldCompare     :   FromDate와 ToDate를 비교하여 ToDate가 크면  */
/*                              true,FromDate가 크면 false return           */
/*          js_FieldCompare("1","2")                                        */
/*          --> 1: Input Box object(FromDate)                               */
/*              2: Input Box object(ToDate)                                 */
/*  17. js_Compare          :   FromDate와 ToDate를 비교하여 ToDate가 크면  */
/*                              true,FromDate가 크면 false return           */
/*          js_Compare("1","2")                                             */
/*          --> 1: 문자열(String;FromDate값)                                */
/*              2: 문자열(String;ToDate값)                                  */
/*  18. js_checkTime        :   InputBox에 입력된 시간(시+분)이 유효한지    */
/*                              체크하여 유효하면 hh24:mi의 형태로 변환하여 */
/*                              return하고, 유효하지 않으면 에러메세지를    */
/*                              보여줌(시간 입력필드의 onblur event에 사용) */
/*          js_checkTime("1")                                               */
/*          --> 1: Input Box object                                         */
/*  19. js_makeColon        :   시간값에 콜론(:)을 추가하여 return          */
/*          js_makeColon("1")                                               */
/*          --> 1: 문자열(String)                                           */
/*  20. js_colonErase       :   InputBox에 입력된 시간(시+분)값에서 콜론(:) */
/*                              을 제가하여 return(시간 입력필드의 onfocus  */
/*                              event에 사용)                               */
/*          js_colonErase("1")                                              */
/*          --> 1: Input Box object                                         */
/*                                                                          */
/*  21. js_checkQuot("1")	:	작은,큰 따옴표가 있는지 검사해줌.           */
/*          --> 1 : Input Box object										*/
/*                                                                          */
/*  22. js_removeQuot("1")	:	작은,큰 따옴표를 삭제해줌                   */
/*          --> 1 : Input Box object										*/
/*                                             								*/	
/*  23. js_numberCheck2("1") :  숫자이외의 문자가 오면 에러메세지			*/
/*			--> 1 :	Input Box object									    */
/*  23. js_numberCheck3("1") :  공백,-,숫자이외의 문자가 오면 에러메세지			*/
/*			--> 1 :	Input Box object									    */
/*	                           												*/	
/*  24.IsEmptyRtnMsg(obj,msg,len) : length 검사
/*
/*
/*  25. js_showMessageWindow("1","2","3") :  Modal 에러/기타 메세지 창 출력	*/
/*	                           												*/	
/*			showModalDialog 는 IE4 이상. Modal 다이알로그를 생성	        */
/*			 "1" : msgNo => Message Number									*/
/*			 "2" : comment => 사용자 메세지							        */
/*			 "3" : url => 닫기 창을 띄우고 돌아갈 페이지 URL		        */
/*                 "reload" 라고 쓰면 현재페이지 reload                     */
/*                 ""라고 하면 아무곳으로도 fowarding 안함.                 */
/*			  1: "중복된 자료입니다.";									    */
/*			  2: "해당 자료가 없습니다.";								    */
/*			  3: "자료가 등록 되었습니다.";								    */
/*			  4: "자료가 수정 되었습니다.";								    */
/*			  5: "자료가 삭제 되었습니다.";								    */
/*			  6: "수정되지 않았습니다.";									*/
/*			  7: "등록되지 않았습니다.";									*/
/*			  8: "삭제되지 않았습니다.";									*/
/*			  9: "수정이 취소 되었습니다.";					   				*/
/*			 10: "삭제된 자료입니다.";						   				*/
/* 																			*/
/****************************************************************************/

//  사용방법
//  <input type=text name='aa' size='19' maxlength='21' onblur='js_checkDigits(this)' onfocus='js_commaErase(this)'>
//  <input type=text name='aa' size='2' maxlength='2' onblur='js_yearCheck(this)'>
//  <input type=text name='aa' size='2' maxlength='2' onkeyup='js_tab_order(this,document.goji_search.gve_goji_gubun,2)'>
//  <input type=text name='aa' size='10' maxlength='10' onblur='js_dateCheck(this)' onfocus='js_removeChar2(this)'>

function readingZeroToSpace(vOneObject, vTwoObject)
{
   vTwoObject.value = parseInt(vOneObject.value, 10);
}


/*
변수의 공백을 0으로 바꾼다. 바꾸길 원하는 대상은 숫자의 형태여야한다.
숫자,문자 체크안함.
"  101" -> 00101 으로 바뀜
vOneObject는 바뀌기전 객체(form.xx)
vTwoObject는 바뀐후에 값이들어가기를 원하는 객체(form.yy)
*/
function readingSpaceToZero(vOneObject, vTwoObject)
{
   vTwoObject.value = vOneObject.value.replace(/ /g, 0);
}

/*
3개의 지역번호,국번,번호를 ex)02-2334-3455 형태로 합침
tel1는 지역번호
tel2는 국번
tel3는 번호
fieldName은 error message를 보낼때의 객체명
*/
function mergyPhoneNo(tel1,tel2,tel3,fieldName)
{
   var telAll = ""                                                                      // 전화번호전체를 받을 변수 선언
   var errorMsg = "정확한" + fieldName + "값을 입력해 주세요";  //fieldName이 있을때의 error Message 변수를 생성
   //세개의 번호를 for문으로 숫자,공백체크하는 function으로 체크후 telAll으로 합침
   for(i=1;i<4;i++)
   {
      var tel = eval("tel"+i);                      //tel1,tel2,tel3를 한꺼번에 체크하기 위해 i와 조합
      tel = getNonSpaceNumber(tel);        //숫자,공백체크한후 tel이라는 변수에 다시 넣어줌

      //공백체크한 값이 있으면 telAll에 3개의 번호를 합쳐줌.
      if(tel)
      {
      //둘째 전화번호, 즉 국 부터 -를 붙이기 위해
         if (i==1)
         {
            telAll = tel
         }
         else
         {
            telAll = telAll + "-" + tel ;
         }
      }
      //공백체크한 값이 없으면 fieldName이 있는경우 message 보여주고 return false 시킴
      else
      {
         if("undefined" == typeof(fieldName))
         {
         }
         else
         {
            alert(errorMsg);
         }
         return false;
      }
   }
   alert (telAll);
}

/*
function checkCalendarFromTo(date1, date2, fieldName1, fieldName2)
- 기간을 체크
date1 :  첫번째 일자값
date2 :  두번째 일자값
fieldName1 : 첫번째 일자값의 이름
fieldName2 : en번째 일자값의 이름
*/
function checkCalendarFromTo(date1, date2, fieldName1, fieldName2)
{
   if (date1== false || date2 == false )
   {
      return false;
   }

   var gap =eval(date2) - eval(date1);  // 받아온 날짜값을 숫자로 바꾼후 계산한다

   // 종료일자에서 시작일자를 뺀값이 0보다 적다면(시작일자가 크다면)
   if(gap < 0 )
   {
      alert(fieldName1+"의 날짜는 " +fieldName2 + "의 날짜보다 이전이거나 동일하여야 합니다");
      return false;
   }

   return true;

}

/*
string을 입력받아 공백제거하고 순수 숫자열만 return
문자일경우 false return
str은 string
*/
function getNonSpaceNumber(str)
{
   var i     = 0;              // looping을 돌기위해 필요한 임시변수
   var returnStr  = "";     // 반환값을 저장시킬 변수
   var len = str.length;   // 파라메터의 문자열 길이를 담아주는 변수
   //string을 한글자씩 비교하는 while문
   while (i<len)
   {
      var sub   = str.substring(i,i+1)    //한글자를 잘라옴
      var code =  sub.charCodeAt(0)  //잘라온 글자의 아스키코드를 담아주는 변수
      //한글자씩 잘라온 것이 공백인지를 검사하는 if문
      if (code==32)
      {
      }
      else
      {
         var returnStr = returnStr +  sub;
         // 전화번호 값이 문자인 경우 return false 시킴
         if (code < 48  || code > 58)
         {
            return false;
         }
      }
      i++;
   }
   return returnStr;
}

/*
02-2334-3455 형태로 합쳐저 있는 값을 3개의 지역번호,국번,번호로 분리
tel1는 지역번호가 있는 textbox객체이름
tel2는 국번번호가 있는 textbox객체이름
tel3는 번호번호가 있는 textbox객체이름
*/
function splitPhoneNo(telAll,tel1,tel2,tel3)
{
   var tel = telAll.split("-");

   for (i=0;i<tel.length;i++)
   {
      //분리된 전화번호를 객체변수로 받음
      var telName = eval("tel"+(i+1));

      //입력받은 전화번호 textbox객체에 값을 세팅
      telName.value = ""
      telName.value =  tel[i];
   }
}



/*
02-2334-3455 형태로 합쳐저 있는 값을 3개의 지역번호,국번,번호로 분리
sido는 시도코드
telAll은 전체전화번호
tel1는 지역번호가 있는 textbox객체이름
tel2는 국번번호가 있는 textbox객체이름
tel3는 번호번호가 있는 textbox객체이름

*/
function phoneNoWithLocal(sido,telAll,tel1,tel2,tel3)
{
   var tel = telAll.split("-");           // 전화번호분리

   //시도코드 존재여부 확인
   if ( tel[0] == "" )
   {
      //시도코드로 지역번호 찾기
      jusoToLocalNo(sido,tel1);
   }
   else
   {
      //체크된 전화번호 textbox 객체에 값을 세팅
      tel1.value =  "";
      tel1.value =  tel[0];
   }

   //체크된 전화번호 객체에 값을 세팅
   tel2.value =  "";
   tel3.value =  "";
   tel2.value =  tel[1];
   tel3.value =  tel[2];
}

//입력된 값이 숫자인지를 체크.
function checkNumber(num , fieldName)
{

   var num_temp = Number(num);
   var errorMesg = fieldName+" 값을 숫자로 입력하십시요";
   var nullMesg = fieldName+" 값을 입력하십시요";

   //값이 있다면
   if(num != "")
   {
      //숫자면 false반환 - if는 문자라면
      if(isNaN(num_temp))
      {
         if("undefined" == typeof(fieldName)){}
         else
         {
            alert(errorMesg);
         }
         return false;
      }
      else  //숫자라면.
      {
         return true;
      }
   }
   else
   {
      if("undefined" == typeof(fieldName)){}
      else
      {
         alert(nullMesg);
      }
      return false;
   }
}



//메세지를 상태창에 뿌리자
function setStatusToStatusBar(vWorkGubun)
{
   if("insert" == vWorkGubun)
   {
      window.status = "입력이 완료되었습니다.";
      setTimeout("setStatusInit()", 3000);
   }
   else if("set" == vWorkGubun)
   {
      window.status = "수정이 완료되었습니다.";
      setTimeout("setStatusInit()", 3000);
   }
   else if("delete" == vWorkGubun)
   {
      window.status = "삭제가 완료되었습니다.";
      setTimeout("setStatusInit()", 3000);
   }
   else if("select" == vWorkGubun)
   {
      window.status = "조회가 완료되었습니다.";
      setTimeout("setStatusInit()", 3000);
   }
   else
   {
      setStatusInit();
   }

}

//메세지를 상태창에서 삭제하자.
function setStatusInit()
{
   window.status = "";

}

/*
이미지 바꾸기..
이벤트가 발생한 객체의 src를 넣어준 img로 세팅해준다.

*/
function swapImage(img)
{
   window.event.srcElement.src = img;
}


/* 입력 필드에 들어온 데이타의 크기를 계산하는 Function */
function checkSize(data , maxSize, allowNull, fieldName)
{
   var size = 0;
   var fieldSize = "";
   var errorMesg = fieldName + "의 값이 크기를 초과합니다";
   var errorMesg1 = fieldName + "에 특수문자가 존재합니다";

   if( trim(data) == "" )
   {
      if( allowNull == "N" || allowNull == "n" )
      {
         return true;
      }

      if("undefined" == typeof(fieldName)){}
      else
      {
		 alert(fieldName + "을(를) 반드시 입력 또는 선택하여야 합니다.");
      }
      return false;
   }

   fieldSize = data.length;

   for(i=0; i<fieldSize; i++)
   {
      //특수 문자 체크  ",&,$
      if( data.charCodeAt(i) == 34 || data.charCodeAt(i) == 38 || data.charCodeAt(i) == 36 || data.charCodeAt(i) == 39)
      {
        	if("undefined" == typeof(fieldName)){}
        	else
        	{
            alert(errorMesg1);
        	}
            return false;
      }
      //한글이 들어오면 255보다 크다
      if( data.charCodeAt(i) > 255 )
      {
         size += 2;
      }
      else
      {
         size += 1;
      }
   }

   if( maxSize < size )
   {
     if("undefined" == typeof(fieldName)){}
     else
     {
        alert(errorMesg);
     }
        return false;
   }
   else
   {
      return true;
   }

  return true;
}

/*
체크박스에서 Enter값이 들어오면 체크상태를 반전시켜줌

*/
function checkEnterCheckBox(xx)
{
	var yy =	chkEnter();
	if(yy)
	{
		if(xx.checked)
		{
			xx.checked = false;
		}
		else if(! xx.checked)
		{
			xx.checked = true;
		}
	}
}

/*
Enter를 체크하여 Enter 이면 true 아니면 false를 반환
*/
function chkEnter()
{
	var ok = true;
	var no = false;
  	if(event.keyCode == 13)
  	{
		return ok;
  	}
  	else
  	{
  		return no;
  	}
}

/*
입력창 자동이동 스크립트
*/
function moveNext(varControl, varNext)
{
	if(event.keyCode == 9 || event.keyCode == 16)
	{
		return;
	}
	else
	{
   	if(varControl.value.length == varControl.maxLength)
   	{
      	varNext.focus();
   	}
   }
}

/*
tab키를 눌렀을때 원하는곳에 focus를 가게 한다
*/
function checkTab(xx)
{
  	if(event.keyCode == 0)
  	{
		xx.focus();
  	}
}

/*
textarea 입력 필드에 들어온 데이타의 크기를 계산과 특수문자를 체크하는 Function
*/
function checkTextArea(data , maxSize, allowNull, fieldName)
{
   var size = 0;
   var fieldSize = "";
   var errorMesg = fieldName + "의 값이 크기를 초과합니다";
//   var checkSpecialCharerrorMesg = data + "중에 특수문자가 있습니다!";

   if( trim(data) == "" )
   {
      if( allowNull == "N" || allowNull == "n" )
      {
         return true;
      }

      if("undefined" == typeof(fieldName)){}
      else
      {
		 alert(fieldName + "을(를) 반드시 입력 또는 선택하여야 합니다.");
      }
      return false;
   }

   fieldSize = data.length;


   if( checkSpecialChar(data, allowNull, fieldName ) ) // 특수문자가 없을때는 true를 리턴함.
   {
      fieldSize = data.length;

      for(i=0; i<fieldSize; i++)
      {
         //한글이 들어오면 255보다 크다
         if( data.charCodeAt(i) > 255 )
         {
            size += 2;
         }
         else
         {
            size += 1;
         }
      }

      if( maxSize < size )
      {
         //메세지가 없으면 alert을 뿌려주지 않겠다.
         if("undefined" == typeof(fieldName)){}
         else
         {
           alert(errorMesg);
         }
         return false;
      }
      else
      {
         return true;
      }

   } // if checkSpecialChar(data) == true end
   else
   {
     //메세지가 없으면 alert을 뿌려주지 않겠다.
         if("undefined" == typeof(fieldName)){}
         else
         {
//         alert(checkSpecialCharerrorMesg);
         }
         return false;

   }// if checkSpecialChar(data) == false end

   return true;
}

/*
일 체크 function
*/
function checkDay(vDay, allowNull, fieldName)
{
   if( trim(vDay) == "" )
   {
      if( allowNull == "N" || allowNull == "n" )
      {
         return true;
      }

      if("undefined" == typeof(fieldName)){}
      else
      {
		 alert(fieldName + "을(를) 반드시 입력 또는 선택하여야 합니다.");
      }
      return false;
   }

	if(isNaN(vDay) || vDay > 31 || vDay == 0)
	{
		if("undefined" == typeof(fieldName)){}
		else
		{
			alert(fieldName+" 필드는 1-31값만 허용합니다.");
		}
		return false;
	}

	if(vDay.length == 1)
		return "0"+vDay;

	return vDay;
}

/*
월 체크 function
*/
function checkMonth(vMonth, allowNull, fieldName)
{
   if( trim(vMonth) == "" )
   {
      if( allowNull == "N" || allowNull == "n" )
      {
         return true;
      }

      if("undefined" == typeof(fieldName)){}
      else
      {
		 alert(fieldName + "을(를) 반드시 입력 또는 선택하여야 합니다.");
      }
      return false;
   }

	if(isNaN(vMonth) || vMonth > 12 || vMonth == 0)
	{
		if("undefined" == typeof(fieldName)){}
		else
		{
			alert(fieldName+" 필드는 1-12값만 허용합니다.");
		}
		return false;
	}
	if(vMonth.length == 1)
		return "0"+vMonth;
	return vMonth;
}

/*
년 체크
*/
function checkYear(year, allowNull, fieldName)
{
   var year_temp  = Number(year);
   var errorMesg = fieldName + "값을 숫자로 입력하십시오";
   var isYearMsg = "년도 4 자리를 입력하십시오";

   if( trim(year) == "" )
   {
      if( allowNull == "N" || allowNull == "n" )
      {
         return true;
      }
      if("undefined" == typeof(fieldName)){}
      else
      {
		 alert(fieldName + "을(를) 반드시 입력 또는 선택하여야 합니다.");
      }
      return false;
   }


   if(isNaN(year_temp))
   {
      if("undefined" == typeof(fieldName)){}
      else
      {
         alert(errorMesg);
      }
      return false;
   }
   else if(year.length != 4)
   {
      if("undefined" == typeof(fieldName)){}
      else
      {
         alert(isYearMsg);
      }
      return false;
   }
   else
   {
      return year;
   }
}

/* 년월일을 합해주는 함수
월,일이 두자리가 아닐경우 0을붙혀 두자리로 만듬
*/
function sumCalender(year, month, day)
{
   //월이 두자리가 아닐경우 앞에 "0"을 붙여서 두자리로  만듬"
   if(month.length != 0 &&  month < 10 && month.indexOf(0) == -1 )
   {
      month = "0" + month;
   }

   //일이 두자리가 아닐경우 앞에 "0"을 붙여서 두자리로 만듬"
   if(day.length != 0 &&  day < 10 && day.indexOf(0) == -1 )
   {
      day = "0" + day;
   }

   return year+month+day;
}


/*
날짜 체크하는 Function NOT NULL
구분 : N - null체크 안함
*/
function checkCalendar(year, month, day, allowNull, fieldName)
{
   // 날짜가 8자인지 체크
   var date = "";
   var errorMesg  = fieldName + "의 년도가 틀립니다 예) 2001/01/31";
   var errorMesg1 = fieldName + "의 년도가 틀립니다 예) 2001/01/31";
   var errorMesg2 = fieldName + "의 월이 틀립니다 예) 2001/01/31";
   var errorMesg3 = fieldName + "의 일자가 틀립니다 예) 2001/01/31";
   year  = trim(year) ;
   month = trim(month) ;
   day   = trim(day) ;

   date = year+month+day;

   if (( date.length == 0 ) && ( allowNull == "N" || allowNull == "n" ))
   {
      return true;
   }

   //년도의 4자리수 체크
   if( year.length != 4 )
   {
      if("undefined" == typeof(fieldName)){}
      else
      {
         alert(errorMesg1);
      }
      return false;
   }

   if ( month.length == 0 )
   {
      alert(errorMesg2);
      return false;
   }


   if ( day.length == 0 )
   {
      alert(errorMesg3);
      return false;
   }


   //월이 두자리가 아닐경우 앞에 "0"을 붙여서 두자리로  만듬"
   if(month.length != 0 &&  month < 10 && month.indexOf(0) == -1 )
   {
      month = "0" + month;
   }

   //일이 두자리가 아닐경우 앞에 "0"을 붙여서 두자리로 만듬"
   if(day.length != 0 &&  day < 10 && day.indexOf(0) == -1 )
   {
      day = "0" + day;
   }

   date = year+month+day;

   if( date.length != 8  )
   {

      if("undefined" == typeof(fieldName)){}
      else
      {
		 alert(fieldName + "을(를) 반드시 입력 또는 선택하여야 합니다.");
      }
      return false;
   }


   //날짜가 숫자인지 체크
   if( !checkNumber(date, "일자") )
   {
     return false;
   }

   // 월이 12 보다 큰 수가 있는지 체크
   if(month > 12 || month == 0)
   {
      if("undefined" == typeof(fieldName)){}
      else
      {
         alert(errorMesg2);
      }
      return false;
   }

   // 일 체크
   if(month == 01)
   {
      if(day > 31 || day == 0)
      {
         if("undefined" == typeof(fieldName)){}
         else
         {
            alert(errorMesg3);
         }
         return false
      }
   }
   else if(month == 02)
   {
      //윤년 조사
      if(((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))
      {
         if(day > 29 || day == 0)
         {
            if("undefined" == typeof(fieldName)){}
            else
            {
               alert(errorMesg3);
            }
            return false;
         }
      }
      else
      {
         if(day > 28 || day == 0)
         {
            if("undefined" == typeof(fieldName)){}
            else
            {
               alert(errorMesg3);
            }
            return false
         }
      }
   }
   else if(month == 03)
   {
      if(day > 31 || day == 0)
      {
         if("undefined" == typeof(fieldName)){}
         else
         {
            alert(errorMesg3);
         }
         return false
      }
   }
   else if(month == 04)
   {
      if(day > 30 || day == 0)
      {
         if("undefined" == typeof(fieldName)){}
         else
         {
            alert(errorMesg3);
         }
         return false
      }
   }

   else if(month == 05)
   {
      if(day > 31 || day == 0)
      {
         if("undefined" == typeof(fieldName)){}
         else
         {
            alert(errorMesg3);
         }
         return false
      }
   }

   else if(month == 06)
   {
      if(day > 30 || day == 0)
      {
         if("undefined" == typeof(fieldName)){}
         else
         {
            alert(errorMesg3);
         }
         return false
      }
   }

   else if(month == 07)
   {
      if(day > 31 || day == 0)
      {
         if("undefined" == typeof(fieldName)){}
         else
         {
            alert(errorMesg3);
         }
         return false
      }
   }

   else if(month == 08)
   {
      if(day > 31 || day == 0)
      {
         if("undefined" == typeof(fieldName)){}
         else
         {
            alert(errorMesg3);
         }
         return false
      }
   }

   else if(month == 09)
   {
      if(day > 30 || day == 0)
      {
         if("undefined" == typeof(fieldName)){}
         else
         {
            alert(errorMesg3);
         }
         return false
      }
   }

   else if(month == 10)
   {
      if(day > 31 || day == 0)
      {
         if("undefined" == typeof(fieldName)){}
         else
         {
            alert(errorMesg3);
         }
         return false
      }
   }

   else if(month == 11)
   {
      if(day > 30 || day == 0)
      {
         if("undefined" == typeof(fieldName)){}
         else
         {
            alert(errorMesg3);
         }
         return false
      }
   }

   else if(month == 12)
   {
      if(day > 31 || day == 0)
      {
         if("undefined" == typeof(fieldName)){}
         else
         {
            alert(errorMesg3);
         }
         return false
      }
   }
   return date
}



//숫자가 들어가야할 필드에 숫자가 들어있는지 체크하는 Function2
   function checkNumber(num , fieldName)
   {

      var num_temp = Number(num);
      var errorMesg = fieldName+" 값을 숫자로 입력하십시요";
      var nullMesg = fieldName+" 값을 입력하십시요";

      if(num != "")
      {
         if(isNaN(num_temp))
         {
            alert(errorMesg);
            return false;
         }
         else
         {
            return true;
         }
      }
      else
      {
         alert(nullMesg);
         return false;
      }
   }


/*
자신의 자식윈도우 닫기
*/
function closeWindow(childwin)
{
   for(i=0; i<childwin.length; i++)
   {
      if("undefined" != typeof(childwin[i]))
      {
         childwin[i].close();
      }
   }
}



/*
공백체크
*/
function checkEmpty( arg, fieldName )
{
   var errorMesg = fieldName+"은(는) 반드시 존재하여야 합니다";

   if( trim(arg) == "" )
   {
      if("undefined" == typeof(fieldName)){}
      else
      {
         alert(errorMesg);
      }
      return false;
   }
   return true;   // 공백이 아니라면
}
/*
공백체크
*/
function checkEmpty2(obj, alertString ){
   var errorMesg =  alertString ;
   if(trim(obj.value) == "" ) {
		alert(errorMesg);
		obj.focus();
		return false;
   } else {
		return true;   
   }	
}

/*
문자열 앞뒤에있는 공백없에기
*/
function trim( arg )
{
   var st = 0;
   var len = arg.length;

   //문자열앞에 공백문자가 들어 있는 Index 추출
   while( (st < len) && (arg.charCodeAt(st) == 32) )
   {
      st++;
   }
   //문자열뒤에 공백문자가 들어 있는 Index 추출
   while( (st < len) && (arg.charCodeAt(len-1) == 32) )
   {
      len--;
   }
   return ((st > 0) || (len < arg.length)) ? arg.substring(st, len) : arg;
}

/*
특수문자 체크
*/
function checkSpecialChar( arg, allowNull, fieldName )
{
   var fieldSize = arg.length;
   var errorMesg = fieldName + "에 특수문자( 예)\",\' )가 존재합니다";

   if( trim(arg) == "" )
   {
      if( allowNull == "N" || allowNull == "n" )
      {
         return true;
      }

      if("undefined" == typeof(fieldName)){}
      else
      {
		 alert(fieldName + "을(를) 반드시 입력 또는 선택하여야 합니다.");
      }
      return false;
   }

   for(i=0; i<fieldSize; i++)
   {
      if( arg.charCodeAt(i) == 34 || arg.charCodeAt(i) == 39 ) // " ' 문자인지체크
      {
         if("undefined" == typeof(fieldName)){}
         else
         {
           alert(errorMesg);
         }
         return false;
      }
   }

   return true;
}

/*
전화번호에서 지역번호 자동입력
xx는 시도코드
yy는 찍힐 객체
*/
function jusoToLocalNo(xx,yy)
{
	switch(xx)
	{
		case "11" : yy.value = "02";//서울
						break;
		case "41" : yy.value = "031";//경기
						break;
		case "28" : yy.value = "032";//인천
						break;
		case "42" : yy.value = "033";//강원
						break;
		case "44" : yy.value = "041";//충남
						break;
		case "30" : yy.value = "042";//대전
						break;
		case "43" : yy.value = "043";//충북
						break;
		case "26" : yy.value = "051";//부산
						break;
		case "31" : yy.value = "052";//울산
						break;
		case "27" : yy.value = "053";//대구
						break;
		case "47" : yy.value = "054";//경북
						break;
		case "48" : yy.value = "055";//경남
						break;
		case "46" : yy.value = "061";//전남
						break;
		case "29" : yy.value = "062";//광주
						break;
		case "45" : yy.value = "063";//전북
						break;
		case "49" : yy.value = "064";//제주
						break;
	}
}

/*
주민번호 체크하는 Function
*/
function checkJMBeonHo( num1, num2, allowNull)
{
   var number = num1 + num2;
   var errorMesg = "주민등록번호를 입력 하셔야 합니다";
   var errorMesg1 = "주민등록번호의 생년월일 오류입니다";

   if( trim(number) == "" )
   {
      if( allowNull == "N" || allowNull == "n" )
      {
         return true;
      }

      alert("주민번호를 반드시 입력 또는 선택하여야 합니다.");
      return false;
   }


   if( 13 != number.length && 14 != number.length )
   {
      alert(errorMesg);
      return false;
   }
   else
   {
      var Year = num1.substring(0,2);
      if( "3" == num2.substring(0,1) || "4" == num2.substring(0,1) )
      {
         Year = "20" + Year;
      }
      else
      {
         Year = "19" + Year;
      }

      var Month = num1.substring(2,4);
      var Day = num1.substring(4,6);

      if( checkCalendar(Year, Month, Day, "") )
      {
         return true;
      }
      else
      {
         alert(errorMesg1);
         return false;
      }
   }
}


/* Programmed by Song chi-wook
Role : Retacgular box in table 
*/
function defaultStatus()
{
	var lec = document.all.lecture;
	for (var i=0;i<lec.length;i++)
	{
		document.all.lecture[i].style.border = "1 solid #EFEFEF";
		document.all.lecture[i].style.backgroundColor = "";
	}
}

function mouseOnTD(obj)
{
	obj.style.border = "1 solid gray";
	obj.style.backgroundColor = "white";
	obj.style.cursor = "hand";
}


/*
  컴마로 구분된 숫자를 컴마를 제거하고 리턴해준다.
*/
function onlyNumber(str,allowNull,fieldName)
{
   if( trim(str) == "" )
   {
      if( allowNull == "N" || allowNull == "n" )
      {
         return true;
      }

      if("undefined" == typeof(fieldName)){}
      else
      {
		 alert(fieldName + "을(를) 반드시 입력 또는 선택하여야 합니다.");
       return false;
      }
   }

   var src = new String(str);
   var rtn_value = '';

	for (var i=0; i< src.length; i++) 
	{
      var ch = src.charAt(i);
		
      if(i==0)
      {
         if( !(ch>='0' && ch<='9') )
         {
            if(ch!='-')
            {
               alert(fieldName + "의 시작은 숫자 또는 -기호만 허용합니다."+ch);
               return false;
            }
         }
      }
      else
		{
		   if ( !((ch>='0' && ch<='9') || ch!=',' || ch!='.') )
			{ 
            alert(fieldName + "은 숫자 또는 , 또는 .만 허용합니다.");
            return false;
			}
		}
    }

    for (var i=0; i<src.length; i++)
    {
        var ch = src.charAt(i);
        if( (ch >= '0' && '9' >= ch) || ch == '-' || ch == '.')
        {
            rtn_value = rtn_value + ch;
        }
    }

    return rtn_value;
} 

//--날짜 입력시 YYYY-MM-DD 형식으로 바꿔주는 Function--//
function inputDate(F)
{
	if ((event.keyCode==9)||(event.keyCode==16)){}
	else
	{
		if(!(((event.keyCode>=35)&&(event.keyCode<=40))||(event.keyCode==8)))
		{
			em = event.srcElement;
			va = em.value ;
			sp = va.split(F);
			sj = sp.join("");
			switch(sj.length)
			{
				case 4:
					em.value=sj+F;
					break;
				case 6:
					sj=sj.substring(0,4)+F+sj.substring(4,6)+F;
					em.value=sj;
					break;
				case 8: case 9: case 10:
					sj=sj.substring(0,4)+F+sj.substring(4,6)+F+sj.substring(6,8);
					em.value=sj;
					break;
			}
		}
	}
}

//--숫자 입력시 999,999,999 형식으로 바꿔주는 Function--//
function inputMoney(F)
{
	if ((event.keyCode==9)||(event.keyCode==16)){}
	else
	{
		if(!(((event.keyCode>=35)&&(event.keyCode<=40))||(event.keyCode==8)))
		{
			em = event.srcElement;
			va = em.value ;
			sp = va.split(F);
			sj = sp.join("");
			switch(sj.length)
			{
				case 4:
					sj=sj.substring(0,1)+F+sj.substring(1,4);
					em.value=sj;
					break;
				case 5:
					sj=sj.substring(0,2)+F+sj.substring(2,5);
					em.value=sj;
					break;
				case 6:
					sj=sj.substring(0,3)+F+sj.substring(3,6);
					em.value=sj;
					break;
				case 7: 
					sj=sj.substring(0,1)+F+sj.substring(1,4)+F+sj.substring(4,7);
					em.value=sj;
					break;
				case 8: 
					sj=sj.substring(0,2)+F+sj.substring(2,5)+F+sj.substring(5,8);
					em.value=sj;
					break;
				case 9: 
					sj=sj.substring(0,3)+F+sj.substring(3,6)+F+sj.substring(6,9);
					em.value=sj;
					break;
				case 10: 
					sj=sj.substring(0,1)+F+sj.substring(1,4)+F+sj.substring(4,7)+F+sj.substring(7,10);
					em.value=sj;
					break;
				case 11: 
					sj=sj.substring(0,2)+F+sj.substring(2,5)+F+sj.substring(5,8)+F+sj.substring(8,11);
					em.value=sj;
					break;
				case 12: 
					sj=sj.substring(0,3)+F+sj.substring(3,6)+F+sj.substring(6,9)+F+sj.substring(9,12);
					em.value=sj;
					break;
				case 13: 
					sj=sj.substring(0,1)+F+sj.substring(1,4)+F+sj.substring(4,7)+F+sj.substring(7,10)+F+sj.substring(10,13);
					em.value=sj;
					break;
				case 14: 
					sj=sj.substring(0,2)+F+sj.substring(2,5)+F+sj.substring(5,8)+F+sj.substring(8,11)+F+sj.substring(11,14);
					em.value=sj;
					break;
				case 15: 
					sj=sj.substring(0,3)+F+sj.substring(3,6)+F+sj.substring(6,9)+F+sj.substring(8,12)+F+sj.substring(12,15);
					em.value=sj;
					break;
				case 16: 
					sj=sj.substring(0,1)+F+sj.substring(1,4)+F+sj.substring(4,7)+F+sj.substring(7,10)+F+sj.substring(10,13)+F+sj.substring(13,16);
					em.value=sj;
					break;
				case 17: 
					sj=sj.substring(0,2)+F+sj.substring(2,5)+F+sj.substring(5,8)+F+sj.substring(8,11)+F+sj.substring(11,14)+F+sj.substring(14,17);
					em.value=sj;
					break;
				case 18: 
					sj=sj.substring(0,3)+F+sj.substring(3,6)+F+sj.substring(6,9)+F+sj.substring(9,12)+F+sj.substring(12,15)+F+sj.substring(15,18);
					em.value=sj;
					break;
				case 19: 
					sj=sj.substring(0,1)+F+sj.substring(1,4)+F+sj.substring(4,7)+F+sj.substring(7,10)+F+sj.substring(10,13)+F+sj.substring(13,17)+F+sj.substring(17,20);
					em.value=sj;
					break;
			}
		}
	}
}

//--날짜 입력시 YYYY-MM-DD 형식으로 바꿔주는 Function--//
function inputInt(F)
{
	if ((event.keyCode==9)||(event.keyCode==16)){}
	else
	{
		if(!(((event.keyCode>=35)&&(event.keyCode<=40))||(event.keyCode==8)))
		{
			em = event.srcElement;
			va = em.value ;
			sp = va.split(F);
			sj = sp.join("");
			switch(sj.length)
			{
				case 3:
					em.value=sj+F;
					break;
				case 6:
					sj=sj.substring(0,3)+F+sj.substring(3,6)+F;
					em.value=sj;
					break;
				case 9: 
					sj=sj.substring(0,3)+F+sj.substring(3,6)+F+sj.substring(6,9);
					em.value=sj;
					break;
			}
		}
	}
}

//--숫자만 입력되게 하는 Function--//

/*
function inputNum()
{	
	em = event.srcElement;
	if(event.keyCode == 109 && em.length == 1)
		return;
	if((event.keyCode <48)||(event.keyCode >57))
		event.returnValue=false;
}	
*/
function onlyNumber(event){
	event = event || window.event;
	var keyID = (event.which) ? event.which : event.keyCode;
	if ( (keyID >= 48 && keyID <= 57) || (keyID >= 96 && keyID <= 105) || keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 ) 
		return;
	else
		return false;
}

//--유효한 날짜인지 체크하는 Function--//
function goodDate(date)
{
	date=date.replace(".","").replace(".","").replace("/","").replace("/","");
	for(i=0;i<date.length;i++)
	{
		ck=date.charAt(i);
		if (!(ck>="0" && ck<="9"))
		{
			return false;
			break;
		}
	}
	if(date.length!=8)
	{
		return false;
	}
	else
	{
		year = date.substring(0, 4);
		month = date.substring(4, 6);
		day = date.substring(6, 8);
		if(month < 1 || month > 12)
			return false;
		if(day < 1 || day > 31)
			return false;
		if(year < 0 || year > 9999)
			return false;
		if(month == 4 || month == 6 || month == 9 || month == 11)
		{
			if (day == 31)
				return false;
		}
		if(month == 2)
		{
			if (isNaN(parseInt(year/4)))
				return false;
			if (day > 29)
				return false;
			if (day == 29 && ((year/4) != parseInt(year/4)))
				return false;
		}
	}
	return true;
}

//--시작일과 종료일 유효성 체크하는 Function--//
function compDate(fDate, tDate)
{
	fDate=fDate.replace(".","").replace(".","").replace("/","").replace("/","");
	tDate=tDate.replace(".","").replace(".","").replace("/","").replace("/","");
	if (fDate < tDate)
	{
		return true;
	}
	return false;
}



/*달력입력창을 띄운다*/
function calendaropen(form,obj)
{
  var obj_v = "document."+form+"."+obj+".value";
  var obj_value=eval(obj_v);
  
  var today = new Date();
  var monthName = "010203040506070809101112";
  var dayName = "01020304050607080910111213141516171819202122232425262728293031";
  
  var seldate;	
  var year;	
  var month;	
  var day;	

  if (obj_value=="") {
		year = today.getFullYear();
       	month = monthName.substring(today.getMonth()*2, (today.getMonth() + 1) * 2);
       	day = dayName.substring((today.getDate()-1)*2, today.getDate()*2);
		seldate = year+"-"+month+"-"+day;
  }else{	
		year=obj_value.substring(0,4);
		month=obj_value.substring(5,7);
		seldate=obj_value;
  }
  
  window.open("/common/calendar.jsp?seldate="+seldate+"&year="+year+"&month="+month+"&formname="+form+"&targetname="+obj,"calendar",'scrollbars=no,width=230,height=210');
}


/*달력입력창을 띄운다     --오늘이후날만 선택하게*/
function calendaropen2(form,obj)
{
  var obj_v = "document."+form+"."+obj+".value";
  var obj_value=eval(obj_v);
  
  var today = new Date();
  var monthName = "010203040506070809101112";
  var dayName = "01020304050607080910111213141516171819202122232425262728293031";
  
  var seldate;	
  var year;	
  var month;	
  var day;	

  if (obj_value=="")
  {
	year = today.getFullYear();
       	month = monthName.substring(today.getMonth()*2, (today.getMonth() + 1) * 2);
       	day = dayName.substring((today.getDate()-1)*2, today.getDate()*2);
	seldate = year+"-"+month+"-"+day;
  }else{	
	year=obj_value.substring(0,4);
	month=obj_value.substring(5,7);
	seldate=obj_value;
  }
  window.open("/common/calendar2.jsp?seldate="+seldate+"&year="+year+"&month="+month+"&formname="+form+"&targetname="+obj,"calendar",'scrollbars=no,width=230,height=210');
}

/*
========================================================================================================
*/





function js_commaErase(obj) {
    var rtn_value = '';
    for (var i=0; i< obj.value.length; i++) {
        var ch = obj.value.charAt(i);
        if( ch != ',') {
            rtn_value = rtn_value + ch;
        }
    }
    obj.value = rtn_value;
    obj.select();
    return;
} 

function js_commaErase2(num) {
    var rtn_value = '';
    for (var i=0; i< num.length; i++) {
        var ch = num.charAt(i);
        if( ch != ',') {
            rtn_value = rtn_value + ch;
        }
    }
    return rtn_value;
} 

function js_removeSpace(str) {
	var src = new String(str);
	var tar = new String();
	var i, len=src.length;
	for (i=0; i < len; i++) {
		if (src.charAt(i) == ' ')
            tar += '';
        else
            tar += src.charAt(i);
    }
    return tar;
}

function js_checkDigits(obj) {
    var err_status = '';
    var src = new String(obj.value);
    var tar = new String();
    var ch2 = new String();
    var ch3 = 0;
    tar = js_removeSpace(src);
    if (tar == '') return;
    if (js_validateCheck(obj) == 'false') {
        alert('금액은 15자리 이하로 입력하세요.');
        obj.focus();
    }
    for (var i=0; i< tar.length; i++) {
        var ch = tar.charAt(i);
        if (ch >= '0' && ch <='9') ch2 += tar.charAt(i);
        if ((ch < '0' || '9' < ch) && ch != ',' && ch != '-' && ch != '.')         err_status = '1';
        if ((i != 0 && ch == '-') || (tar.length == 1 && ch == '-'))  err_status = '1';
    }
    ch3 = parseInt(ch2);
    if(ch3 == 0) tar = '0';
    if( err_status != '1')
        obj.value = js_makeComma(js_convert(tar));
    else {
        alert('숫자만 입력이 가능합니다.');
		  obj.value="";
        obj.focus();
    }
    return;
}       

function js_convert(str) {
    var src = new String(str);
    var rtn_value = '';
    for (var i=0; i<src.length; i++) {
        var ch = src.charAt(i);
        if( (ch >= '0' && '9' >= ch) || ch == '-' || ch == '.') {
            rtn_value = rtn_value + ch;
        }
    }
    if( rtn_value.length = 0) {
        rtn_value = 0;
    }
    return rtn_value;
} 

function js_validateCheck(obj) {
    var src = new String(obj.value);
    var split1 = '';     // Sign '-' 부호 저장
    var split2 = '';     // 정수부분 저장
    var split3 = '';     // 소숫점 이하자리 저장
    if (src.charAt(0) == '-') {
        split1 = '-';
        src = src.substr(1);
    }
    if (src.indexOf('.') >= 0) {
        split2 = src.substring(0,src.indexOf('.'));
        split3 = src.substr(src.indexOf('.'));
    }
    else{
        split2 = src;
        split3 = '';    
    }
    if(split2.length > 15) return 'false';
    else return 'true';
}

function js_makeComma(str) {
    var src = new String(str);
    var len;
    var i = 0;
    var pos = 0;
    var split1 = '';     // Sign '-' 부호 저장
    var split2 = '';     // 정수부분 저장
    var split3 = '';     // 소숫점 이하자리 저장
    var rtn_value = '';
    if (src.charAt(0) == '-') {
        split1 = '-';
        src = src.substr(1);
    }
    if (src.indexOf('.') >= 0) {
        split2 = src.substring(0,src.indexOf('.'));
        split3 = src.substr(src.indexOf('.'));
    }
    else{
        split2 = src;
        split3 = '';    
    }
    len = split2.length;
    //  Comma ',' 추가 루틴
    for(var i = 0; i < len; i++) {
        pos  = len - i;
        rtn_value = rtn_value + split2.charAt(i);
        if(pos != 1 && pos % 3 == 1) {
            rtn_value = rtn_value + ',';
        }
    }
    return split1+rtn_value+split3;
}

function js_yearCheck(obj) {
    var arg = obj.value;
    if (arg.length != 2) {
        alert('년도는 YY의 형태로 입력하세요.');
        obj.focus();
        obj.select();
    }
    if(js_numberCheck(arg)) {
        alert('문자가 포함될수 없습니다.!!!');
        obj.focus();
        obj.select();
    }
    return;
}

function js_numberCheck(str) {
    var src = new String(str);
    var tar = true;
    var i, len=src.length;
    for (i=0; i < len; i++) {
        if ((src.charAt(i) < '0') | (src.charAt(i) > '9'))
            return false;
    }
    return true;
}

function js_numberCheck3(obj) {
    var str = obj.value;
    var src = new String(str);
    var tar = true;
    var i, len=src.length;
    for (i=0; i < len; i++) {
        if((src.charAt(i) != '-') & (src.charAt(i) != ' ')){
            if ((src.charAt(i) < '0') | (src.charAt(i) > '9')){
                tar = false;
            }    
        }
    }
    if(tar == false){
        alert('문자가 포함될수 없습니다....');
        obj.focus();
        obj.select();
    } 
}

function js_tab_order(arg,nextname,len) {
    if (arg.value.length == len) {
        nextname.focus() ;
        return;
    }
}

function js_isFieldBlank(obj) { 
    var str = obj.value;
	return (str == '' || str.charAt(0) == ' ') ? true : false;
}

function js_isBlank(str) { 
	return (str == '' || str.charAt(0) == ' ') ? true : false;
}

function js_removeChar(str, chr) {
    var src = new String(str);
    var tar = new String();
    var i, len=src.length;
    for (i=0; i < len; i++) {
        if (src.charAt(i) == chr)
            tar += '';
        else
            tar += src.charAt(i);
    }
    return tar;
}

function js_removeChar2(obj) {
    var src = new String(obj.value);
    var tar = new String();
    var i, len=src.length;
    for (i=0; i < len; i++) {
        if (src.charAt(i) == '-')
            tar += '';
        else
            tar += src.charAt(i);
    }
    obj.value = tar;
}

function js_dateEditMask(str, chr, flag) {
    var src = new String(str);
    var tar = new String();
    var yea = src.substring(0, 4); // year
    var mon = src.substring(4, 6); // month
    if(flag == '2') return tar = yea + chr + mon;
    else {
        var da  = src.substring(6, 8); // day
        return tar = yea + chr + mon + chr + da;
    }
}

function js_dateCheck(obj) {
    var err  = 0;
    var chartest = obj.value;
    ival  = obj.value;
    if (ival == '') return;
    chartest = js_removeChar(chartest,'-');
    if(chartest.length != 8) {
        alert('YYYYMMDD의 형식으로 입력하십시요.');
		obj.value="";
        obj.focus();
        return;
    }
    cen = chartest.substring(0, 2); // century
    if (cen > 19) {
        yea = chartest.substring(0, 4); // year
    } else {
        yea = chartest.substring(2, 4); // year
    }
    mon = chartest.substring(4, 6); // month
    da  = chartest.substring(6, 8); // day
    //들어온 값 검색 - 문자인지..
    if(!js_numberCheck(chartest)) {
        alert('문자가 입력될수 없습니다.11');
		obj.value="";
        obj.focus();
        return;
    }
    //기본적인 일, 월, 년 에러 검색
    if(mon < 1 || mon > 12) err = 1;
    if(da  < 1 || da  > 31) err = 1;
    if (cen < 20) {
        if(yea < 0 || yea > 99) err = 1;
    }
    if(cen < 19) err = 1;
    if(err == 1) {
        alert('날짜 형식에 맞지 않습니다.11');
		obj.value="";
        obj.focus();
        return;
    }
    d = new Date(yea, mon - 1, da);
    if(yea != d.getFullYear() || mon != (d.getMonth() + 1)) {
        alert('날짜 형식에 맞지 않습니다.22');
		obj.value="";
        obj.focus();
        return;
    }
    else{
         if (cen > 19) {
             obj.value = yea + '-' + mon + '-' + da;
         } else {
             obj.value = cen + yea + '-' + mon + '-' + da;
         }
    }
}

function js_FieldCompare(FromField, ToField) { 
    str1 = FromField.value;
    str2 = ToField.value;
    return str1 > str2 ? false : true;
}

function js_Compare(FromDate, ToDate) { 
    return FromDate > ToDate ? false : true;
}

function js_checkTime(obj) {
    var err_status = '';
    var src = new String(obj.value);
    var tar = new String();
    var ch2 = new String();
    var ch3 = 0;
    tar = js_removeSpace(src);
    if (tar == '') return;
    for (var i=0; i< tar.length; i++) {
        var ch = tar.charAt(i);
        if (ch >= '0' && ch <='9') ch2 += tar.charAt(i);
        if ((ch < '0' || '9' < ch) && ch != ':') err_status = '1';
        if ((i != 2 && ch == ':') || (tar.length == 1 && ch == ':')) err_status = '1';
    }
    if(ch2.length != 4) err_status = '2';
    ch3 = parseInt(ch2);
    if ((ch3 < 0) || (ch3 > 2359)) err_status = '2';
    if( err_status == '1') {
        alert('숫자( : 포함)만 입력이 가능합니다.');
        obj.focus();
    } else if(err_status == '2') {
        alert('시간형식에 맞지 않습니다.');
        obj.focus();
    } else {
        obj.value = js_makeColon(ch2);
    }
    return;
}

function js_makeColon(str) {
    var src = new String(str);
    var split1 = '';     // 시간 저장
    var split2 = '';     // 분 저장
    split1 = src.substring(0,2);
    split2 = src.substring(2);
    return split1+':'+split2;
}

function js_colonErase(obj) {
    var tar = js_removeChar(obj.value,':');
    obj.value = tar;
    return;
}

function js_removeQuot(obj) {
	if ( ( obj.value.indexOf("'") != -1 ) || ( obj.value.indexOf("\"") != -1 ) ) {
		alert('작은 따옴표와 큰 따옴표는 입력을 허용하지 않습니다.');

		while ( obj.value.indexOf("'") != -1) {
			obj.value = obj.value.replace("'", " ");
		}

		while ( obj.value.indexOf("\"") != -1) {
			obj.value = obj.value.replace("\"", " ");
		}

		obj.focus();
		obj.select();
	}
	return ;
}

function title_js_removeQuot(obj) {
	if ( ( obj.value.indexOf("'") != -1 ) || ( obj.value.indexOf("\"") != -1 ) ) {
		alert('제안 제목에는 작은 따옴표와 큰 따옴표의 입력을 허용하지 않습니다.');

		while ( obj.value.indexOf("'") != -1) {
			obj.value = obj.value.replace("'", " ");
		}

		while ( obj.value.indexOf("\"") != -1) {
			obj.value = obj.value.replace("\"", " ");
		}

		obj.focus();
		obj.select();
	}
	return ;
}


function js_checkQuot(obj) {
	if ( ( obj.value.indexOf("'") != -1 ) || ( obj.value.indexOf("\"") != -1 ) ) {
		alert('작은 따옴표와 큰 따옴표는 입력을 허용하지 않습니다.');

		obj.focus();
		obj.select();
	}
	return ;
}

function js_numberCheck2(obj) {
    var arg = obj.value;
    
    if(js_numberCheck(arg) == false) {
        alert('문자가 포함될수 없습니다...');
		  obj.value="";
        obj.focus();
        obj.select();
    }
    return;
}

function js_showMessageWindow(msgNo, comment, url) {
	reURL = self.showModalDialog("/SislErrorMsg.jsp?msgNo=" + msgNo + "&comment=" + comment, url,
								 "title:no;status:no;center:yes;help:no;minimize:no;maximize:no;border:thin;statusbar:no;dialogWidth:400px;dialogHeight:325px");

	if (reURL == "reload") {
		location.reload();
	}
	else if (reURL != "") location.href = reURL;
	return ;
}

/////////////////textarea length값 체크/////////////////////////////////
function IsEmptyRtnMsg(obj,msg,len) {
	var toCheck = obj.value;
	var chkstr = toCheck + "";
	var is_Space = true;

	if (len != null) {
		if (StrLeng(obj.value) > len)   {
    		alert(msg + " 한글 " + len/2 + ",영문 "+len+"자 이내로 입력하십시오.");
        	obj.focus();
        	obj.select();
        	return true;
    	} else {
    	return false;
    	}
	}else return false;
}

// 한글 입력길이와 체크
function StrLeng(strIn)	{
	var strOut = 0;
	var agr = navigator.userAgent;
	var isIE4 = agr.indexOf("MSIE 4");
	var isIE5 = agr.indexOf("MSIE 5");
	if((isIE4 != -1) || (isIE5 != -1) ){
		for ( t = 0 ; t < strIn.length ; t++){
   			ch = strIn.charAt(t);
   			if ((ch == "\n") || ((ch >= "ㅏ") &&  (ch <= "히")) || ((ch >="ㄱ") &&  (ch <="ㅎ")))
       			strOut += 2;
   			else
       			strOut += 1;
		}
	}else {
		strOut = strIn.length ;
	}
	return (strOut);
}



function defaultStatus(){
	var lec = document.all.lecture;
	for (var i=0;i<lec.length;i++){
		document.all.lecture[i].style.border = "1 solid #EFEFEF";
		document.all.lecture[i].style.backgroundColor = "";
	}
}

function mouseOnTD(obj)
{
	obj.style.border = "1 solid #6188CA";
	obj.style.backgroundColor = "white";
	obj.style.cursor = "hand";
}

// 제목줄 상세설명 풍선도움말  
Xoffset=5;
Yoffset=15;
var navok,navno,ie=(document.all),posY=-800;
if(navigator.appName=='Netscape'){
  (document.layers)?navok=true:navno=true;
}

function popit(msg,fcolor,body){
  content='<table width=400 height=30 bgcolor=black border=0 bordercolor=black cellpadding=0 cellspacing=1 ><td align=center class='+body+'><font color='+fcolor+'>'+msg+
    '</font></td></table>';
  if(navno){
    alert(msg);
    return;
  } else {
    posY=Yoffset;
    if(navok){
      ply.document.write(content);
      ply.document.close();
      ply.visibility='visible'
    }
    if(ie){
      document.all('msgbox').innerHTML=content;
      ply.visibility='visible'
    }
  }
}
function get_mouse(e){
  var x=(navok)?e.pageX:event.x+document.body.scrollLeft;
  ply.left=x+Xoffset;
  var y=(navok)?e.pageY:event.y+document.body.scrollTop;
  ply.top=y+posY;
}

function hideit(){
  if(!navno){
    posY=-800;
    ply.visibility='hidden';
  }
} 

// 제목줄 상세설명 풍선도움말 끝