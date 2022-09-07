class MyHeader extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `
            <nav class="navbar nav-fill w-100 navbar-expand-lg navbar-dark bg-dark container-fluid">

                <div class="collapse navbar-collapse " id="navbarNav">
                    <ul class="navbar-nav navbar-left">
                        <li class="nav-item">
                            <a class="nav-link" href="/">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/items">Items</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/map">Map</a>
                        </li>
                    </ul>
                    <ul class="navbar-nav ml-auto" >
                        <li class="nav-item ">
                            <a class="nav-link" href="/login">Login</a>
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link" href="/register">Register</a>
                        </li>
                    </ul>
                </div>
            </nav>
        `
    }
}

customElements.define('my-header', MyHeader)

class MyFooter extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `
            <footer>
                    C 2022 Lost and Found
            </footer>
        `
    }
}

customElements.define('my-footer', MyFooter)