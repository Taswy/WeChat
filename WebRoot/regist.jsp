<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
    <head>
        <meta charset="utf-8">
        <title></title>
		<meta name="keywords" content="��վģ��,�ֻ���վģ��,�ֻ���¼ҳ��,��¼ҳ��HTML,�����վģ������" />
		<meta name="description" content="JS�������ṩ�������ֻ���վģ������" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel="stylesheet" href="assets/css/reset.css">
        <link rel="stylesheet" href="assets/css/supersized.css">
        <link rel="stylesheet" href="assets/css/style.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

    </head>

    <body>

        <div class="page-container">
            <h1>ע��</h1>
            <form action="regist" method="post">
                <input type="text" name="username" class="username" placeholder="�û���">
                <input type="password" name="pwd" class="password" placeholder="����">
                <input type="text" style="display:none" name="openid" onFocus="this.value=''" value=<%=session.getAttribute("openid") %>>
                <button type="submit">�ύ</button>
                <div class="error"><span>+</span></div>
            </form>
        
        </div>
        <!-- Javascript -->
        <script src="assets/js/jquery-1.8.2.min.js"></script>
        <script src="assets/js/supersized.3.2.7.min.js"></script>
        <script src="assets/js/supersized-init.js"></script>
        <script src="assets/js/scripts.js"></script>

    </body>
</html>




