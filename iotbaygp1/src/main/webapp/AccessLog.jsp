<%@ page import="model.AccessLog" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iot Bay</title>

    <%-- Style overloading --%>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Sriracha&display=swap" rel="stylesheet">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="css/AccessLog.css">
    <link rel="stylesheet" href="css/Header.css">
</head>
<body>
    <%@ include file="/Header.jsp" %>
    <div class="AccessLog">
    <form method="get" action="AccessLog.jsp">
        <label for="filterDate">Select Date:</label>
        <input type="date" id="filterDate" name="filterDate" value="<%= request.getParameter("filterDate") != null ? request.getParameter("filterDate") : "" %>">
        <input type="submit" value="Filter">
    </form>
        <table>
            <thead>
                <tr>
                    <th>Record</th>
                    <th>User ID</th>
                    <th>Login Time</th>
                    <th>Logout Time</th>
                </tr>
            </thead>
            <tbody>
                <%
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

                    ArrayList<AccessLog> accessLogSet = (ArrayList<AccessLog>) session.getAttribute("accessLogSet");
                    String filterDate = request.getParameter("filterDate");

                    if (accessLogSet != null && !accessLogSet.isEmpty()) {
                        int count = 1;
                        for (AccessLog a : accessLogSet) {
                            String loginDate = a.getLoginTime().toLocalDate().toString();

                            if (filterDate == null || filterDate.isEmpty() || loginDate.equals(filterDate)) {
                %>
                <tr>
                    <td><%= count++ %></td>
                    <td><%= a.getUserEmail() %></td>
                    <td><%= a.getLoginTime().format(formatter) %></td>
                    <td><%= a.getLogoutTime() != null ? a.getLogoutTime().format(formatter) : "Still logged in" %></td>
                </tr>
                <%
                            }
                        }
                    }
                %>
            </tbody>
        </table>
    </div>
</body>