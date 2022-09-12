class MyHeader extends HTMLElement {
    connectedCallback() {
        var loggedIn = `
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
                               <ul class="navbar-nav ml-auto navbar-right" >
                                   <li class="nav-item">
                                       <a class="nav-link" href=""> <!-- placeholder div, put profile pic in here--> <div style="background-color:red; border-radius:50%; height:30px; width:30px"></div></a>
                                   </li>
                               </ul>

                           </div>
                       </nav>
                       `
        var loggedOut = `
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
                               <ul class="navbar-nav ml-auto navbar-right" >
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
        var x = -1;
        if (x>0) {
            this.innerHTML = loggedIn;
        } else {
            this.innerHTML = loggedOut;
        }
    }
}



customElements.define('my-header', MyHeader)

class MyFooter extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `
            <footer class="footer mt-auto py-3 bg-dark align-items-end" style="position:absolute; bottom: 0; width: 100%">
                  <div class="container">
                    <span class="text-light">
                        C 2022 Lost and Found
                    </span>
                  </div>


            </footer>
        `
    }
}

customElements.define('my-footer', MyFooter)