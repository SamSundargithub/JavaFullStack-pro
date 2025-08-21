<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Update Student</title>
</head>
<body>
  <h2>Update Student</h2>

  <%
    String msg = (String) session.getAttribute("msg");
    if (msg != null) {
  %>
      <p style="color:red;"><%= msg %></p>
  <%
      session.removeAttribute("msg");
    }
  %>

  <form method="post" action="<%= request.getContextPath() %>/students/update">
  
    <label>Id:
    <input type="number" name="id" value="<%= request.getParameter("id") %>"required>
    </label><br><br>

    <label>Name: 
      <input type="text" name="name" value="<%= request.getParameter("name") %>" required>
    </label><br><br>

    <label>Age: 
      <input type="number" name="age" value="<%= request.getParameter("age") %>" min="1" required>
    </label><br><br>

    <button type="submit">Update</button>
  </form>

  <a href="<%= request.getContextPath() %>/">Home</a>
</body>
</html>
