<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <script src="./js/jquery-3.6.3.min.js"></script>
    <style>
      .popup {
        position: fixed;
        left: 100px;
        top: 100px;
        border: 1px solid #000;
        box-shadow: 10px 10px 10px rgba(0, 0, 0, 0.1);
        width: 400px;
      }
      .popup h2 {
        padding: 20px;
        background-color: #111;
        color: #fff;
        margin: 0;
      }
      .popup .contents {
        padding: 20px;
        background-color: #fff;
      }
    </style>
  </head>
  <body>
    <!-- prettier-ignore -->
    <% String popupMode="on"; %>
    <% if(popupMode.equals("on")) { %>
    <div class="popup">
      <h2>공지사항</h2>
      <div class="contents">
        <p>공지사항입니다.</p>
        <p>공지사항입니다.</p>
        <p>공지사항입니다.</p>
        <p>공지사항입니다.</p>
        <p>공지사항입니다.</p>
      </div>
      <div>
        <form action="" method="GET">
          <input type="checkbox" name="oneday" value="1" /> 오늘 하루 이창을 열지 않기
          <button class="btn oneday">닫기</button>
        </form>
      </div>
    </div>
    <% } %>
    <script>
      const sendData = { ondeday: 1 };
      $(".oneday").on("click", function () {
        $(".popup").hide();
        $.ajax({
          url: "popupModeProcess.jsp",
          type: "GET",
          data: sendData,
          success: function (response) {
            console.log(response);
          },
        });
        return false;
      });
    </script>
  </body>
</html>
