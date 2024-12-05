@import exercise.dto.users.UserPage
@param UserPage page

<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
    <title>User ${page.getUser().getId()}</title>
</head>
<body>
<div class="mx-auto p-4 py-md-5">
    <main>
        <h2>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h2>
        <p>id: ${page.getUser().getId()}</p>
        <p>email: ${page.getUser().getEmail()}</p>
    </main>
</div>
</body>
</html>