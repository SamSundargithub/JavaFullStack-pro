<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Student App</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
  <center>
  <h2>Student App</h2>
<p><b>This is a website make crud operation using java and java server page.</b></p>
<br>
<div class="buttons">
<button type="button" id="btnJs">View</button>
<button type="button" id="btnJsadd">Add</button>
<button type="button" id="btnJsdel">Delete</button>
<button type="button" id="btnJsupd">Update</button>
</center>
</div>
  <script>
    document.getElementById('btnJs').addEventListener('click', function () {
      window.location.href = '<%= request.getContextPath() %>/students';
    });

    document.getElementById('btnJsadd').addEventListener('click', function () {
      window.location.href = '<%= request.getContextPath() %>/addStudent.jsp';
    });

     document.getElementById('btnJsdel').addEventListener('click', function () {
      window.location.href = '<%= request.getContextPath() %>/delStudent.jsp';
    });

     document.getElementById('btnJsupd').addEventListener('click', function () {
      window.location.href = '<%= request.getContextPath() %>/update.jsp';
    });
  </script>
</body>
</html>
