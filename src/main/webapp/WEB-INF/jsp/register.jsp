<%--
  Created by IntelliJ IDEA.
  User: fatha
  Date: 5. 9. 2023
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="common/header.jspf" %>

<div class="container">
    <form method="post">
        <div class="form-group">
            <label for="name">Username:</label>
            <input type="text" class="form-control" id="name" name="name" required="required">
        </div>
        <div class="form-group">
            <label for="town">Town:</label>
            <input type="text" class="form-control" id="town" name="town">
        </div>
        <div class="form-group">
            <label for="adress">Address:</label>
            <input type="text" class="form-control" id="adress" name="adress">
        </div>
        <div class="form-group">
            <label for="phone">Phone:</label>
            <input type="text" class="form-control" id="phone" name="phone">
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" name="password">
        </div>
        <button type="submit" class="btn btn-success">Submit</button>
    </form>
</div>

<%@ include file="common/footer.jspf" %>