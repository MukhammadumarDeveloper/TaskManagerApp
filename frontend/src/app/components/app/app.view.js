export class AppView {
    selector = "app"

    constructor() {
        this.render()
    }

    render() {
        document.getElementById(this.selector).innerHTML = `
            <header id="header"></header>
            <div id="pagination"></div>
            <main id="main"></main>
        `
    }
}