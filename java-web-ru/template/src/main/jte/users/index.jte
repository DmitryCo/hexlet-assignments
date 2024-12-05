@import exercise.dto.users.UsersPage
@param UsersPage page

<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
    <title>Users</title>
</head>
<body>
<div class="mx-auto p-4 py-md-5">
    <main>
        <table>
            <tr>
                @for(int i = 0; i < 10; i++)
                    <td>
                        <h2>
                            <a href="/users/${page.getUsers().get(i).getId()}">
                                ${page.getUsers().get(i).getFirstName()} ${page.getUsers().get(i).getLastName()}
                            </a>
                        </h2>
                    </td>
                @endfor
            </tr>
            <tr>
                @for(int i = 10; i < 20; i++)
                    <td>
                        <h2>
                            <a href="/users/${page.getUsers().get(i).getId()}">
                                ${page.getUsers().get(i).getFirstName()} ${page.getUsers().get(i).getLastName()}
                            </a>
                        </h2>
                    </td>
                @endfor
            </tr>
            <tr>
                @for(int i = 20; i < 30; i++)
                    <td>
                        <h2>
                            <a href="/users/${page.getUsers().get(i).getId()}">
                                ${page.getUsers().get(i).getFirstName()} ${page.getUsers().get(i).getLastName()}
                            </a>
                        </h2>
                    </td>
                @endfor
            </tr>
        </table>
    </main>
</div>
</body>
</html>