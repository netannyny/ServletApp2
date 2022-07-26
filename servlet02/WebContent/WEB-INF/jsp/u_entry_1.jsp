<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>
</head>
<body>
   <h3>新規登録</h3>
   <form  action="/servlet01/u_entry_1.java" method="post">
       ログインID&emsp;：<input type="text" name="id" required><br>
       パスワード&nbsp;：<input type="text" name="pass" required><br>
       名前　　　&emsp;：<input type="text" name="name" required><br>
       <input type="submit" value="確認">
   </form>
</body>
</html>
</body>
</html>