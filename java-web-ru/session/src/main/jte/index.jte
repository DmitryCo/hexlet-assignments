@import exercise.dto.MainPage
@import exercise.util.NamedRoutes

@param MainPage page

@template.layout.page(
content = @`
    <main>
        @if(page.getName() != null)
            Добро пожаловать, ${page.getName().toString()}.
            <form action="${NamedRoutes.logoutPath()}" method="post">
                <input type="submit" class="btn btn-primary" value="Выйти" />
            </form>
        @else
            <a href="${NamedRoutes.buildSessionPath()}">Войти</a>
        @endif
    </main>
`
)