<%@ include file="common/header.jspf" %>

<div class="container text-center mt-5">
    <h1>Welcome to iShopo</h1>
    <h2>Access to our services requires a login. If you don't have an account yet, please register.</h2>

    <div class="row justify-content-center">
        <div class="col-md-6">
            <form method="post" action="mainPage">
                <div class="form-group">
                    <label for="userName">Username:</label>
                    <input type="text" class="form-control" id="userName" name="userName">
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" class="form-control" id="password" name="password">
                </div>
                <button type="submit" class="btn btn-success">Login</button>
            </form>
        </div>
    </div>

    <div class="mt-3">
        <p>Don't have an account? <a href="register">Register here</a></p>
    </div>
</div>

<%@ include file="common/footer.jspf" %>