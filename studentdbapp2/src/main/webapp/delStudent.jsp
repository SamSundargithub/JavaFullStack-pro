<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Delete Student</title>
</head>
<body>
  <h2>Delete Student</h2>

  <%
    String msg = (String) session.getAttribute("msg");
    if (msg != null) {
  %>
      <p style="color:red;"><%= msg %></p>
  <%
      session.removeAttribute("msg");
    }
  %>

<form method="post" action="<%= request.getContextPath() %>/students/del">
    <label>Id: <input type="number" name="id" min="0" required></label><br><br>
    <button type="submit">Delete</button>
  </form>

<a href="<%= request.getContextPath() %>/">Home</a>
</body>
</html>
