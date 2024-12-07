@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <h2>Пользователи</h2>
        <table class="table table-striped">
        @if(page.getUsers().isEmpty())
               <tr>
                   <td colspan="2">Нет пользователей для отображения</td>
               </tr>
           @else
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
           @endif
        </table>
    </div>
`
)