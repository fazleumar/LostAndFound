//----------------- GENERAL HEADER  -----------------
class MyHeader extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `
            <header>
                <ul class="nav navbar-dark bg-dark justify-content-center">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/login">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/register">Register</a>
                    </li>
                </ul>
            </header>
        `
    }
}

customElements.define('my-header', MyHeader)


//----------------- HEADER FOR SUCCESSFUL LOGIN PAGE -----------------
class LoggedInHeader extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `
            <header>
                <ul class="nav navbar-dark bg-dark justify-content-center">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/profile">Profile</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/login">Log out</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/items">Items</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/items/add">Add new item</a>
                    </li>
                </ul>
            </header>
        `
    }
}

customElements.define('login-header', LoggedInHeader)


//----------------- FOOTER ELEMENT -----------------
class MyFooter extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `
            <footer>


            </footer>
        `
    }
}

customElements.define('my-footer', MyFooter)