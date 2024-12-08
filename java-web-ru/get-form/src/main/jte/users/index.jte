@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    <h1>Пользователи</h1>
    <div>
        <form class="form-inline" action="/users">
            <input type="search" name="term" value="${page.getTerm()}">
            <input type="submit" value="Искать">
        </form>
    </div>
    <table class="table table-striped">
        @for(var user : page.getUsers())
            <tr>
                <td>
                    ${user.getId()}
                </td>
                <td>
                    <a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a>
                </td>
            </tr>
        @endfor
    </table>
`
)
