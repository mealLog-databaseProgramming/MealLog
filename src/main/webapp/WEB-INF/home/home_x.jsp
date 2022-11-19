<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
	.wrap {
		width: 900px;  /* 고정 */
		
		/* 디버그 */
		height: 2000px;
		background: white;
		
		color: black; font-size: 50px;
	}
</style>

<!DOCTYPE html><html><head><link href="https://fonts.googleapis.com/css?family=Inter&display=swap" rel="stylesheet" /></head>
<body>
<div class="bg">
<div class="v0_5">
<div class="v0_6"></div>
<input type="text" id="feed_insert" placeholder="오늘의 식사를 기록하세요">
<span class="v0_9">이미지 삽입</span>
<span class="v0_10">식사 추가</span>
<span class="v0_11">등록</span>
<div class="v0_12"></div>
<div class="v0_13"></div>
<span class="v0_14">포도</span>
<div class="v0_15"></div>
<span class="v0_16">김치볶음밥</span>
<div class="v0_17"></div>
<div class="v0_18"></div></div>
<div class="v0_19">
<span class="v0_20">류승연</span>
<div class="v0_21"></div>
<span class="v0_22">나도 먹고싶다</span>
<span class="v0_23">12초전</span></div>
<div class="v0_24"><span class="v0_25">허지예</span>
<div class="v0_26"></div>
<span class="v0_27">맛있겠다~~</span>
<span class="v0_28">40초전</span></div>
<div class="v0_29">
<div class="v0_30"></div>
<span class="v0_31">▼0</span><span class="v0_32">▲3</span>
<div class="v0_33"></div></div>
<div class="v0_34">
<img id="food1" src="resources/img/food.jpg">
<div class="v0_36"><iconify-icon icon="healthicons:ui-user-profile"></iconify-icon></div>
<span class="v0_37">전유영</span>
<span class="v0_38">오늘 먹은 저녁!!</span>
<span class="v0_39">토마토</span>
<div class="v0_40">
</div>
<span class="v0_41">샐러리</span>
<div class="v0_42"></div>
<div class="v0_43"><div class="v0_44"></div><div class="v0_45"></div><div class="v0_46"></div>
<span class="v0_47">300kcal</span>
<span class="v0_48">지방</span>
<span class="v0_49">단백질</span>
<span class="v0_50">탄수화물</span></div>
<span class="v0_51">3분전</span></div>
<div class="v0_52">
<img id="food2" src="resources/img/food.jpg">
<div class="v0_54"></div>
<span class="v0_55">전유영</span>
<span class="v0_56">오늘 먹은 저녁!!</span>
<span class="v0_57">토마토</span>
<div class="v0_58"></div>
<span class="v0_59">샐러리</span><div class="v0_60"></div>
<div class="v0_61">
<div class="v0_62"></div>
<div class="v0_63"></div>
<div class="v0_64">
</div><span class="v0_65">300kcal</span>
<span class="v0_66">지방</span>
<span class="v0_67">단백질</span>
<span class="v0_68">탄수화물</span></div>
<span class="v0_69">3분전</span></div>
<div class="v0_70">
<input type="text" id="comment_insert" placeholder="댓글을 입력하세요">
<div class="v0_72"></div>
<span class="v0_73">게시</span></div></div>

</body>
</html> <br/><br/>

 <style>* {
  box-sizing: border-box;
}
body {
  font-size: 14px;
}
.bg {
  width: 100%;
  height: 2000px;
  background: rgba(255,255,255,1);
  opacity: 1;
  position: relative;
  top: 0px;
  left: 0px;
  border-top-left-radius: 25px;
  border-top-right-radius: 25px;
  border-bottom-left-radius: 25px;
  border-bottom-right-radius: 25px;
  overflow: hidden;
}
.v0_5 {
  width: 600px;
  height: 155px;
  background: url("../images/v0_5.png");
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
  opacity: 1;
  position: absolute;
  top: 36px;
  left: 0px;
  overflow: hidden;
}
.v0_6 {
  width: 65px;
  height: 25px;
  background: rgba(129,180,79,1);
  background-position: center center;
  opacity: 1;
  position: absolute;
  top: 122px;
  left: 450px;
  border-top-left-radius: 90px;
  border-top-right-radius: 90px;
  border-bottom-left-radius: 90px;
  border-bottom-right-radius: 90px;
  overflow: hidden;
}
.v0_7 {
  width: 130px;
  color: rgba(0,0,0,1);
  position: absolute;
  top: 65px;
  left: 107px;
  font-family: Inter;
  font-weight: Regular;
  font-size: 12px;
  opacity: 1;
  text-align: center;
}
input[id="feed_insert"] {
  width: 400px;
  height: 50px;
  color: rgba(0,0,0,1);
  position: absolute;
  left: 105px;	
  top: 60px;
  font-family: Inter;
  font-weight: Regular;
  font-size: 12px;
  text-align: left;
  vertical-align: top;
  border:none;
  border-bottom: 1px solid rgba(201,201,201,1);
}
.v0_8 {
  width: 400px;
  height: 50px;
  background: url("../images/v0_8.png");
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
  opacity: 1;
  position: absolute;
  top: 61px;
  left: 100px;
  border: 1px solid rgba(201,201,201,1);
  overflow: hidden;
}
.v0_9 {
  width: 49px;
  color: rgba(0,0,0,1);
  position: absolute;
  top: 123px;
  left: 134px;
  font-family: Inter;
  font-weight: Regular;
  font-size: 10px;
  opacity: 1;
  text-align: center;
}
.v0_10 {
  width: 40px;
  color: rgba(0,0,0,1);
  position: absolute;
  top: 123px;
  left: 211px;
  font-family: Inter;
  font-weight: Regular;
  font-size: 10px;
  opacity: 1;
  text-align: center;
}
.v0_11 {
  width: 23px;
  color: rgba(255,255,255,1);
  position: absolute;
  top: 127px;
  left: 472px;
  font-family: Inter;
  font-weight: Regular;
  font-size: 12px;
  opacity: 1;
  text-align: center;
}
.v0_12 {
  width: 15px;
  height: 15px;
  background: url("../images/v0_12.png");
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
  opacity: 1;
  position: absolute;
  top: 122px;
  left: 193px;
  overflow: hidden;
}
.v0_13 {
  width: 15px;
  height: 15px;
  background: url("../images/v0_13.png");
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
  opacity: 1;
  position: absolute;
  top: 122px;
  left: 116px;
  overflow: hidden;
}
.v0_14 {
  width: 23px;
  color: rgba(0,0,0,1);
  position: absolute;
  top: 26px;
  left: 203px;
  font-family: Inter;
  font-weight: Regular;
  font-size: 12px;
  opacity: 1;
  text-align: center;
}
.v0_15 {
  width: 70px;
  height: 22px;
  background: url("../images/v0_15.png");
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
  opacity: 1;
  position: absolute;
  top: 22px;
  left: 180px;
  border: 1px solid rgba(129,179,78,1);
  border-top-left-radius: 90px;
  border-top-right-radius: 90px;
  border-bottom-left-radius: 90px;
  border-bottom-right-radius: 90px;
  overflow: hidden;
}
.v0_16 {
  width: 56px;
  color: rgba(0,0,0,1);
  position: absolute;
  top: 26px;
  left: 107px;
  font-family: Inter;
  font-weight: Regular;
  font-size: 12px;
  opacity: 1;
  text-align: center;
}
.v0_17 {
  width: 70px;
  height: 22px;
  background: url("../images/v0_17.png");
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
  opacity: 1;
  position: absolute;
  top: 22px;
  left: 100px;
  border: 1px solid rgba(129,179,78,1);
  border-top-left-radius: 90px;
  border-top-right-radius: 90px;
  border-bottom-left-radius: 90px;
  border-bottom-right-radius: 90px;
  overflow: hidden;
}
.v0_18 {
  width: 25px;
  height: 25px;
  background: url("../images/v0_18.png");
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
  opacity: 1;
  position: absolute;
  top: 22px;
  left: 66px;
  border-top-left-radius: 90px;
  border-top-right-radius: 90px;
  border-bottom-left-radius: 90px;
  border-bottom-right-radius: 90px;
  overflow: hidden;
}
.v0_19 {
  width: 400px;
  height: 40px;
  background: url("../images/v0_19.png");
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
  opacity: 1;
  position: absolute;
  top: 807px;
  left: 100px;
  overflow: hidden;
}
.v0_20 {
  width: 34px;
  color: rgba(0,0,0,1);
  position: absolute;
  top: 5px;
  left: 35px;
  font-family: Inter;
  font-weight: Bold;
  font-size: 12px;
  opacity: 1;
  text-align: left;
}
.v0_21 {
  width: 25px;
  height: 25px;
  background: url("../images/v0_21.png");
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
  opacity: 1;
  position: absolute;
  top: 7px;
  left: 0px;
  border-top-left-radius: 90px;
  border-top-right-radius: 90px;
  border-bottom-left-radius: 90px;
  border-bottom-right-radius: 90px;
  overflow: hidden;
}
.v0_22 {
  width: 70px;
  color: rgba(0,0,0,1);
  position: absolute;
  top: 20px;
  left: 35px;
  font-family: Inter;
  font-weight: Regular;
  font-size: 12px;
  opacity: 1;
  text-align: left;
}
.v0_23 {
  width: 30px;
  color: rgba(147,147,147,1);
  position: absolute;
  top: 1px;
  left: 360px;
  font-family: Inter;
  font-weight: Regular;
  font-size: 10px;
  opacity: 1;
  text-align: right;
}
.v0_24 {
  width: 400px;
  height: 40px;
  background: url("../images/v0_24.png");
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
  opacity: 1;
  position: absolute;
  top: 762px;
  left: 100px;
  overflow: hidden;
}
.v0_25 {
  width: 34px;
  color: rgba(0,0,0,1);
  position: absolute;
  top: 5px;
  left: 35px;
  font-family: Inter;
  font-weight: Bold;
  font-size: 12px;
  opacity: 1;
  text-align: left;
}
.v0_26 {
  width: 25px;
  height: 25px;
  background: url("../images/v0_26.png");
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
  opacity: 1;
  position: absolute;
  top: 7px;
  left: 0px;
  border-top-left-radius: 90px;
  border-top-right-radius: 90px;
  border-bottom-left-radius: 90px;
  border-bottom-right-radius: 90px;
  overflow: hidden;
}
.v0_27 {
  width: 60px;
  color: rgba(0,0,0,1);
  position: absolute;
  top: 20px;
  left: 35px;
  font-family: Inter;
  font-weight: Regular;
  font-size: 12px;
  opacity: 1;
  text-align: left;
}
.v0_28 {
  width: 32px;
  color: rgba(147,147,147,1);
  position: absolute;
  top: 5px;
  left: 360px;
  font-family: Inter;
  font-weight: Regular;
  font-size: 10px;
  opacity: 1;
  text-align: right;
}
.v0_29 {
  width: 100%;
  height: 25px;
  
  color: rgba(147,147,147,1);
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
  opacity: 1;
  position: absolute;
  top: 732px;
  left: 99px;
  overflow: hidden;
}
.v0_30 {
  width: 15px;
  height: 15px;
  background: url("../images/v0_30.png");
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
  opacity: 1;
  position: absolute;
  top: 5px;
  left: 4px;
  overflow: hidden;
}
.v0_31 {
  width: 7px;
  color: rgba(0,0,0,1);
  position: absolute;
  top: 7px;
  left: 57px;
  font-family: Inter;
  font-weight: Regular;
  font-size: 10px;
  opacity: 1;
  text-align: center;
}
.v0_32 {
  width: 7px;
  color: rgba(0,0,0,1);
  position: absolute;
  top: 7px;
  left: 22px;
  font-family: Inter;
  font-weight: Regular;
  font-size: 10px;
  opacity: 1;
  text-align: center;
}
.v0_33 {
  width: 22px;
  height: 22px;
  background: url("../images/v0_33.png");
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
  opacity: 1;
  position: absolute;
  top: 2px;
  left: 35px;
  overflow: hidden;
}
.v0_34 {
  width: 100%;
  height: 6000px;
  background: url("../images/v0_34.png");
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
  opacity: 1;
  position: absolute;
  top: 191px;
  left: 56px;
  overflow: hidden;
}
img[id="food1"] {
  width: 400px;
  height: 400px;
  background-position: center center;
  margin-left:50px;
  margin-top: 130px;
}
.v0_36 {
  width: 25px;
  height: 25px;
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
  opacity: 1;
  position: absolute;
  top: 20px;
  left: 10px;
  border-top-left-radius: 90px;
  border-top-right-radius: 90px;
  border-bottom-left-radius: 90px;
  border-bottom-right-radius: 90px;
  overflow: hidden;
}
.v0_37 {
  width: 34px;
  color: rgba(0,0,0,1);
  position: absolute;
  top: 17px;
  left: 50px;
  font-family: Inter;
  font-weight: Bold;
  font-size: 12px;
  opacity: 1;
  text-align: left;
}
.v0_38 {
  width: 80px;
  color: rgba(0,0,0,1);
  position: absolute;
  top: 39px;
  left: 50px;
  font-family: Inter;
  font-weight: Regular;
  font-size: 12px;
  opacity: 1;
  text-align: left;
}
.v0_39 {
  width: 34px;
  color: rgba(0,0,0,1);
  position: absolute;
  top: 72px;
  left: 68px;
  font-family: Inter;
  font-weight: Regular;
  font-size: 12px;
  opacity: 1;
  text-align: center;
}
.v0_40 {
  width: 70px;
  height: 22px;
  background: url("../images/v0_40.png");
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
  opacity: 1;
  position: absolute;
  top: 68px;
  left: 50px;
  border: 1px solid rgba(129,179,78,1);
  border-top-left-radius: 90px;
  border-top-right-radius: 90px;
  border-bottom-left-radius: 90px;
  border-bottom-right-radius: 90px;
  overflow: hidden;
}
.v0_41 {
  width: 34px;
  color: rgba(0,0,0,1);
  position: absolute;
  top: 72px;
  left: 152px;
  font-family: Inter;
  font-weight: Regular;
  font-size: 12px;
  opacity: 1;
  text-align: center;
}
.v0_42 {
  width: 70px;
  height: 22px;
  background: url("../images/v0_42.png");
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
  opacity: 1;
  position: absolute;
  top: 68px;
  left: 134px;
  border: 1px solid rgba(129,179,78,1);
  border-top-left-radius: 90px;
  border-top-right-radius: 90px;
  border-bottom-left-radius: 90px;
  border-bottom-right-radius: 90px;
  overflow: hidden;
}
.v0_43 {
  width: 400px;
  height: 25px;
  background: rgba(201,201,201,1);
  opacity: 1;
  position: absolute;
  top: 98px;
  left: 44px;
  border-top-left-radius: 90px;
  border-top-right-radius: 90px;
  border-bottom-left-radius: 90px;
  border-bottom-right-radius: 90px;
  overflow: hidden;
}
.v0_44 {
  width: 40px;
  height: 25px;
  background: rgba(193,235,151,1);
  opacity: 1;
  position: absolute;
  top: 0px;
  left: 275px;
  overflow: hidden;
}
.v0_45 {
  width: 180px;
  height: 25px;
  background: rgba(156,208,104,1);
  opacity: 1;
  position: absolute;
  top: 0px;
  left: 100px;
  overflow: hidden;
}
.v0_46 {
  width: 100px;
  height: 25px;
  background: rgba(129,179,78,1);
  opacity: 1;
  position: relative;
  top: 0px;
  left: 0px;
  overflow: hidden;
}
.v0_47 {
  width: 46px;
  color: rgba(255,255,255,1);
  position: absolute;
  top: 5px;
  left: 330px;
  font-family: Inter;
  font-weight: Regular;
  font-size: 12px;
  opacity: 1;
  text-align: center;
}
.v0_48 {
  width: 23px;
  color: rgba(255,255,255,1);
  position: absolute;
  top: 5px;
  left: 285px;
  font-family: Inter;
  font-weight: Regular;
  font-size: 12px;
  opacity: 1;
  text-align: center;
}
.v0_49 {
  width: 34px;
  color: rgba(255,255,255,1);
  position: absolute;
  top: 5px;
  left: 173px;
  font-family: Inter;
  font-weight: Regular;
  font-size: 12px;
  opacity: 1;
  text-align: center;
}
.v0_50 {
  width: 45px;
  color: rgba(255,255,255,1);
  position: absolute;
  top: 5px;
  left: 28px;
  font-family: Inter;
  font-weight: Regular;
  font-size: 12px;
  opacity: 1;
  text-align: center;
}
.v0_51 {
  width: 25px;
  color: rgba(147,147,147,1);
  position: absolute;
  top: 18px;
  left: 420px;
  font-family: Inter;
  font-weight: Regular;
  font-size: 10px;
  opacity: 1;
  text-align: left;
}
.v0_52 {
  width: 487px;
  height: 570px;
  background: url("../images/v0_52.png");
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
  opacity: 1;
  position: absolute;
  top: 937px;
  left: 56px;
  overflow: hidden;
}
img[id="food2"] {
  width: 400px;
  height: 400px;
  top: 0px;
  left: 43px;
}
.v0_54 {
  width: 25px;
  height: 25px;
  background: url("../images/v0_54.png");
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
  opacity: 1;
  position: absolute;
  top: 22px;
  left: 10px;
  border-top-left-radius: 90px;
  border-top-right-radius: 90px;
  border-bottom-left-radius: 90px;
  border-bottom-right-radius: 90px;
  overflow: hidden;
}
.v0_55 {
  width: 34px;
  color: rgba(0,0,0,1);
  position: absolute;
  top: 17px;
  left: 50px;
  font-family: Inter;
  font-weight: Bold;
  font-size: 12px;
  opacity: 1;
  text-align: left;
}
.v0_56 {
  width: 80px;
  color: rgba(0,0,0,1);
  position: absolute;
  top: 39px;
  left: 50px;
  font-family: Inter;
  font-weight: Regular;
  font-size: 12px;
  opacity: 1;
  text-align: left;
}
.v0_57 {
  width: 34px;
  color: rgba(0,0,0,1);
  position: absolute;
  top: 72px;
  left: 68px;
  font-family: Inter;
  font-weight: Regular;
  font-size: 12px;
  opacity: 1;
  text-align: center;
}
.v0_58 {
  width: 70px;
  height: 22px;
  background: url("../images/v0_58.png");
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
  opacity: 1;
  position: absolute;
  top: 68px;
  left: 50px;
  border: 1px solid rgba(129,179,78,1);
  border-top-left-radius: 90px;
  border-top-right-radius: 90px;
  border-bottom-left-radius: 90px;
  border-bottom-right-radius: 90px;
  overflow: hidden;
}
.v0_59 {
  width: 34px;
  color: rgba(0,0,0,1);
  position: absolute;
  top: 72px;
  left: 152px;
  font-family: Inter;
  font-weight: Regular;
  font-size: 12px;
  opacity: 1;
  text-align: center;
}
.v0_60 {
  width: 70px;
  height: 22px;
  background: url("../images/v0_60.png");
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
  opacity: 1;
  position: absolute;
  top: 68px;
  left: 134px;
  border: 1px solid rgba(129,179,78,1);
  border-top-left-radius: 90px;
  border-top-right-radius: 90px;
  border-bottom-left-radius: 90px;
  border-bottom-right-radius: 90px;
  overflow: hidden;
}
.v0_61 {
  width: 400px;
  height: 25px;
  background: rgba(201,201,201,1);
  opacity: 1;
  position: absolute;
  top: 98px;
  left: 44px;
  border-top-left-radius: 90px;
  border-top-right-radius: 90px;
  border-bottom-left-radius: 90px;
  border-bottom-right-radius: 90px;
  overflow: hidden;
}
.v0_62 {
  width: 60px;
  height: 25px;
  background: rgba(193,235,151,1);
  opacity: 1;
  position: absolute;
  top: 0px;
  left: 280px;
  overflow: hidden;
}
.v0_63 {
  width: 180px;
  height: 25px;
  background: rgba(156,208,104,1);
  opacity: 1;
  position: absolute;
  top: 0px;
  left: 100px;
  overflow: hidden;
}
.v0_64 {
  width: 100px;
  height: 25px;
  background: rgba(129,179,78,1);
  opacity: 1;
  position: absolute;
  top: 0px;
  left: 0px;
  overflow: hidden;
}
.v0_65 {
  width: 46px;
  color: rgba(255,255,255,1);
  position: absolute;
  top: 5px;
  left: 343px;
  font-family: Inter;
  font-weight: Regular;
  font-size: 12px;
  opacity: 1;
  text-align: center;
}
.v0_66 {
  width: 23px;
  color: rgba(255,255,255,1);
  position: absolute;
  top: 5px;
  left: 298px;
  font-family: Inter;
  font-weight: Regular;
  font-size: 12px;
  opacity: 1;
  text-align: center;
}
.v0_67 {
  width: 34px;
  color: rgba(255,255,255,1);
  position: absolute;
  top: 5px;
  left: 173px;
  font-family: Inter;
  font-weight: Regular;
  font-size: 12px;
  opacity: 1;
  text-align: center;
}
.v0_68 {
  width: 45px;
  color: rgba(255,255,255,1);
  position: absolute;
  top: 5px;
  left: 28px;
  font-family: Inter;
  font-weight: Regular;
  font-size: 12px;
  opacity: 1;
  text-align: center;
}
.v0_69 {
  width: 25px;
  color: rgba(147,147,147,1);
  position: absolute;
  top: 17px;
  left: 70px;
  font-family: Inter;
  font-weight: Regular;
  font-size: 10px;
  opacity: 1;
  text-align: left;
}
.v0_70 {
  width: 392px;
  height: 39px;
  background: url("../images/v0_70.png");
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
  opacity: 1;
  position: absolute;
  top: 852px;
  left: 103px;
  overflow: hidden;
}
input[id="comment_insert"] {
  width: 365px;
  height: 37px;
  background: url("../images/v0_71.png");
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
  opacity: 1;
  position: absolute;
    font-size: 12px;
  text-align: left;
  vertical-align: top;
  border:none;
  border-bottom: 1px solid rgba(201,201,201,1);
  top: 2px;
  left: 30px;
  overflow: hidden;
}
.v0_72 {
  width: 65px;
  height: 25px;
  background: rgba(129,179,78,1);
  opacity: 1;
  position: absolute;
  top: 10px;
  left: 325px;
  border-top-left-radius: 90px;
  border-top-right-radius: 90px;
  border-bottom-left-radius: 90px;
  border-bottom-right-radius: 90px;
  overflow: hidden;
}
.v0_73 {
  width: 23px;
  color: rgba(255,255,255,1);
  position: absolute;
  top: 14px;
  left: 347px;
  font-family: Inter;
  font-weight: Regular;
  font-size: 12px;
  opacity: 1;
  text-align: center;
}
</style>