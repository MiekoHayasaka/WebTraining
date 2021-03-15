<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>キレイなお家</title>
  <link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">
  <link rel="stylesheet" href="css/main.css"/>
</head>
<body>
  <div class="container">
  <div id="right">
		<a href="login.jsp">ログイン</a>
		<a href="signup.jsp">新規登録</a>
		</div>
    <header>
      <h1>キレイなお家</h1>
    </header>
    <nav>
        <a href="index.jsp">つかい方</a>
        <a href="/CleanUp/Create">おそうじ登録</a>
        <a href="/CleanUp/Read">一覧表示</a>
        <a href="">完了・編集</a>
        <a href="">過去の記録</a>
    </nav>
    <div role="main">
      <section id="information">

        <div id="infoBox">
          <section class="info">
            <h3>１．おそうじ場所の登録</h3>
            <p>先ずは掃除する場所の登録をします。<br>
            【例】<br>リビングルーム、ベッドルーム、キッチン、バスルーム、玄関など。</p>
          </section>
          <section class="info">
            <h3>２．タスクの登録</h3>
            <p>１.で登録した各場所で行うタスクの登録をし、掃除の頻度を設定します。<br>
           【タスク例】<br>バスルーム ⇒ バスタブ、フロア、洗面台、トイレ、ミラー、バスマット交換<br>
           【頻度例】<br>バスマット交換 ⇒ 1か月毎、バスタブ⇒２日毎</p>
          </section>
          <section class="info">
            <h3>３．登録場所・タスクの一覧表示＋削除</h3>
            <p>登録した場所やタスクの一覧表示と削除を行います。次回掃除までの日数も表示されます。</p>
          </section>
          <section class="info">
            <h3>４．タスクの完了・編集</h3>
            <p>登録したタスクの完了・編集を行います。</p>
          </section>
          <section class="info">
            <h3>５．過去の記録</h3>
            <p>カレンダーで過去の記録を見てみましょう。</p>
          </section>
        </div>
      </section>

    </div>
    <footer>
      &copy;CleanUpProject
    </footer>
  </div>
</body>
</html>
