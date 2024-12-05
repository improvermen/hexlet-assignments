@template.layout.page(
    content = @`
        <a href="/users">Пользователи</a>
    `
)


<form action="/users" method="get">
    <input type="search" name="term" value="${usersPage.term}" />
    <input type="submit" value="Search" />
</form>