@template.layout.page(
content = @`
    <h1>Создание пользователя</h1>

    <form action="/users" method="post">
        <div>
            <label>
                Firstname
                <input type="text" class="form-control rounded" placeholder="Input is your firstname" required name="firstName" />
            </label>
        </div>
        <div>
            <label>
                Lastname
                <input type="text" class="form-control rounded" placeholder="Input is your lastname" required name="lastName" />
            </label>
        </div>
        <div>
            <label>
                Email
                <input type="email" class="form-control rounded" placeholder="Input is your email" required name="email" />
            </label>
        </div>
        <div>
            <label>
                Password
                <input type="password" class="form-control rounded" placeholder="Input is your password" required name="password" />
            </label>
        </div>
        <input type="submit" class="btn btn-outline-primary" value="Register on the website" />
    </form>
`
)